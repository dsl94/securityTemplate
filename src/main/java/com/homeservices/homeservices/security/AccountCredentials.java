package com.homeservices.homeservices.security;

import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * Created by nemanja on 9/30/2017.
 */
@Data
@NoArgsConstructor
public class AccountCredentials {

    private String username;
    private String password;

}
