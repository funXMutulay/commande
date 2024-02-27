package com.growhubsn.ghlink.payload.request;

import java.util.Set;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;



public class SignUpRequest {

    @NotBlank
    @Size(min=3,max=20)
    private String username;

    @NotBlank
    @Size(max=50)
    @Email
    private String email;

    private Set<String> role;

    @NotBlank
    @Size(min=6,max=40)
    private String password;

    
    

    /**
     * @return String return the username
     */
    public String getUsername() {
        return username;
    }

    /**
     * @param username the username to set
     */
    public void setUsername(String username) {
        this.username = username;
    }

    /**
     * @return String return the email
     */
    public String getEmail() {
        return email;
    }

    /**
     * @param email the email to set
     */
    public void setEmail(String email) {
        this.email = email;
    }

    /**
     * @return Set<String> return the role
     */
    public Set<String> getRole() {
        return role;
    }

    /**
     * @param role the role to set
     */
    public void setRole(Set<String> role) {
        this.role = role;
    }

    /**
     * @return String return the password
     */
    public String getPassword() {
        return password;
    }

    /**
     * @param password the password to set
     */
    public void setPassword(String password) {
        this.password = password;
    }

}
