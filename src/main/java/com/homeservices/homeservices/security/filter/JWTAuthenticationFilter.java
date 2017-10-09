package com.homeservices.homeservices.security.filter;

import com.homeservices.homeservices.repository.UserRepository;
import com.homeservices.homeservices.security.TokenAuthenticationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.filter.GenericFilterBean;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import java.io.IOException;

/**
 * Created by nemanja on 9/30/2017.
 */
public class JWTAuthenticationFilter extends GenericFilterBean {

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain)
            throws IOException, ServletException {

        Authentication authentication = TokenAuthenticationService.getAuthentication((HttpServletRequest) servletRequest);

        SecurityContextHolder.getContext()
                .setAuthentication(authentication);
        filterChain.doFilter(servletRequest,servletResponse);
    }
}
