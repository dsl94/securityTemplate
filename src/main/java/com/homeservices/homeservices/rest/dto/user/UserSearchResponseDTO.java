package com.homeservices.homeservices.rest.dto.user;

import java.math.BigDecimal;
import lombok.*;

/**
 * Created by neman on 09/10/2017.
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class UserSearchResponseDTO {

	private String username;
	private String firstName;
	private String lastName;
	private String city;
	private BigDecimal pricePerHour;
}
