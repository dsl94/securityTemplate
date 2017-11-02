package com.homeservices.homeservices.rest.dto.user;

import javax.validation.constraints.NotNull;
import java.math.BigDecimal;
import lombok.*;

/**
 * Created by nemanja on 9/30/2017.
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class UserRequestDTO {

    @NotNull
    private String username;

    @NotNull
    private String firstName;

    @NotNull
    private String lastName;

    @NotNull
    private String email;

    @NotNull
    private String password;

    @NotNull
    private String city;

    private BigDecimal pricePerHour;
}
