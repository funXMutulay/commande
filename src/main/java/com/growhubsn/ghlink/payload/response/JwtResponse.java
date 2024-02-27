package com.growhubsn.ghlink.payload.response;

import java.util.List;

public class JwtResponse {
    
    private String token;
    private String type = "Bearer";
    private Long id;
    private String username;
    private String email ;
    private List<String> roles;
    public JwtResponse(String accessToken, Long id, String username, String email, List<String> roles) {
        this.token = accessToken;
        this.id = id;
        this.username = username;
        this.email = email;
        this.roles = roles;
    } 

    
    

    /**
     * @return String return the token
     */
    public String getAccessToken() {
        return token;
    }

    /**
     * @param token the token to set
     */
    public void setAccessToken(String accessToken) {
        this.token = accessToken;
    }

    /**
     * @return String return the type
     */
    public String getTokenType() {
        return type;
    }

    /**
     * @param type the type to set
     */
    public void setTokenType(String tokenType) {
        this.type = tokenType;
    }

    /**
     * @return Long return the id
     */
    public Long getId() {
        return id;
    }

    /**
     * @param id the id to set
     */
    public void setId(Long id) {
        this.id = id;
    }

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
     * @return List<String> return the roles
     */
    public List<String> getRoles() {
        return roles;
    }

    /**
     * @param roles the roles to set
     */
    public void setRoles(List<String> roles) {
        this.roles = roles;
    }

}
