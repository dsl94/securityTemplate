package com.homeservices.homeservices.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.*;

/**
 * Created by neman on 09/10/2017.
 */
@Configuration
@EnableWebMvc
public class WebConfig extends WebMvcConfigurerAdapter
{

	@Override
	public void addCorsMappings(CorsRegistry registry) {
		registry.addMapping("/**");
	}
}