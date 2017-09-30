package com.homeservices.homeservices.rest.dto.user;

/**
 * Created by nemanja on 9/30/2017.
 */
public class UserResponseDTO {

    private Long id;
    private String username;

    public UserResponseDTO() {
    }

    public UserResponseDTO(Long id, String username) {
        this.id = id;
        this.username = username;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }
}
