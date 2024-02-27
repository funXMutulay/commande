package com.growhubsn.ghlink.controller;

import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.growhubsn.ghlink.dto.ParagrapheReception;
import com.growhubsn.ghlink.dto.ParagrapheRequest;
import com.growhubsn.ghlink.model.ERole;
import com.growhubsn.ghlink.model.Role;
import com.growhubsn.ghlink.model.User;
import com.growhubsn.ghlink.payload.request.LoginRequest;
import com.growhubsn.ghlink.payload.request.SignUpRequest;
import com.growhubsn.ghlink.payload.response.JwtResponse;
import com.growhubsn.ghlink.payload.response.MessageResponse;
import com.growhubsn.ghlink.repository.RoleRepository;
import com.growhubsn.ghlink.repository.UserRepository;
import com.growhubsn.ghlink.security.jwt.JwtUtils;
import com.growhubsn.ghlink.security.services.UserDetailsImpl;
import com.growhubsn.ghlink.service.ParagrapheService;

import jakarta.validation.Valid;


@CrossOrigin(origins="*",maxAge= 3600)
@RestController
@RequestMapping("/api/auth")
public class AuthController {
    
    @Autowired
    AuthenticationManager authenticationManager;

    @Autowired
    UserRepository userRepository;

    @Autowired
    RoleRepository roleRepository;

    @Autowired
    PasswordEncoder encoder;

    @Autowired
    JwtUtils jwtUtils;

    @Autowired
    ParagrapheService service;

    @PostMapping("/signin")
    public ResponseEntity<?> authenticateUser(@Valid @RequestBody LoginRequest loginRequest){

        Authentication authentication = authenticationManager.authenticate(
           new UsernamePasswordAuthenticationToken(loginRequest.getUsername() , loginRequest.getPassword()) 
        );

        SecurityContextHolder.getContext().setAuthentication(authentication);
        String jwt = jwtUtils.generateJwtToken(authentication);

        UserDetailsImpl userDetails = (UserDetailsImpl) authentication.getPrincipal();
        List<String> roles = userDetails.getAuthorities().stream()
                                        .map(item ->item.getAuthority())
                                        .collect(Collectors.toList());

        return ResponseEntity.ok(new JwtResponse(jwt,
                                userDetails.getId(),
                                userDetails.getUsername(),
                                userDetails.getEmail(),
                                roles ));                    
    }

    @PostMapping("/signup")
    public ResponseEntity<?> registerUser(@Valid @RequestBody SignUpRequest signUpRequest){
        if (userRepository.existsByUsername(signUpRequest.getUsername())){
            return ResponseEntity
                    .badRequest()
                    .body(new MessageResponse("Error: Username is already taken !"));
        }

        if(userRepository.existsByEmail(signUpRequest.getEmail())){
            return ResponseEntity
            .badRequest()
            .body(new MessageResponse("Error : Email is already in use "));
        }

        //Create newuser's account
        User user = new User(signUpRequest.getUsername(),
                              signUpRequest.getEmail(),
                              encoder.encode(signUpRequest.getPassword()));

        Set<String> strRoles = signUpRequest.getRole();
        Set <Role> roles= new HashSet<>();

        if (strRoles == null){
            Role userRole= roleRepository.findByName(ERole.ROLE_USER)
                .orElseThrow(() -> new RuntimeException("Error: Role Not found"));
            roles.add(userRole);
        }else{
            strRoles.forEach(role ->{
                switch(role){
                    case "admin" :
                Role adminRole = roleRepository.findByName(ERole.ROLE_ADMIN)
                .orElseThrow(() -> new RuntimeException("Error: Role Not found"));
                
                roles.add(adminRole);
                break;

                case "mod":
                Role modRole = roleRepository.findByName(ERole.ROLE_MODERATOR)
                .orElseThrow(() -> new RuntimeException("Role not found"));
                roles.add(modRole);
                break;
                default:
                Role userRole = roleRepository.findByName(ERole.ROLE_USER)
                .orElseThrow(() -> new RuntimeException("Role not found "));
                roles.add(userRole);
                }
            });
        }

            user.setRoles(roles);
            userRepository.save(user);

            return ResponseEntity.ok(new MessageResponse("Inscription Utilisateur Reussie!"));

    }

    @PostMapping("/paragraphe")
    public ParagrapheReception paragrapheSection(@RequestBody  ParagrapheRequest request){
        return service.getParagraphe(request);
    }

}
