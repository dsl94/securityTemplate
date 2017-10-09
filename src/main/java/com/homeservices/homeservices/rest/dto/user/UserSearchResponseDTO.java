package com.homeservices.homeservices.rest.dto.user;

import java.math.BigDecimal;

/**
 * Created by neman on 09/10/2017.
 */
public class UserSearchResponseDTO {

	private String username;
	private String firstName;
	private String lastName;
	private String city;
	private BigDecimal pricePerHour;

	public UserSearchResponseDTO(String username, String firstName, String lastName, String city, BigDecimal pricePerHour)
	{
		this.username = username;
		this.firstName = firstName;
		this.lastName = lastName;
		this.city = city;
		this.pricePerHour = pricePerHour;
	}

	public UserSearchResponseDTO()
	{
	}

	public String getUsername()
	{
		return username;
	}

	public void setUsername(String username)
	{
		this.username = username;
	}

	public String getFirstName()
	{
		return firstName;
	}

	public void setFirstName(String firstName)
	{
		this.firstName = firstName;
	}

	public String getLastName()
	{
		return lastName;
	}

	public void setLastName(String lastName)
	{
		this.lastName = lastName;
	}

	public String getCity()
	{
		return city;
	}

	public void setCity(String city)
	{
		this.city = city;
	}

	public BigDecimal getPricePerHour()
	{
		return pricePerHour;
	}

	public void setPricePerHour(BigDecimal pricePerHour)
	{
		this.pricePerHour = pricePerHour;
	}
}
