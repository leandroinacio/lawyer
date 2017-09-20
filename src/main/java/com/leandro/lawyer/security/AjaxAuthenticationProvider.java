package com.leandro.lawyer.security;

import java.util.Arrays;
import java.util.Collections;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Component;

import com.leandro.lawyer.model.Profile;
import com.leandro.lawyer.repository.OwnerRepo;

import io.jsonwebtoken.lang.Assert;

@Component
public class AjaxAuthenticationProvider implements AuthenticationProvider {  
    private final OwnerRepo ownerRepo;

    @Autowired
    public AjaxAuthenticationProvider(final OwnerRepo ownerRepo) {
        this.ownerRepo = ownerRepo;
    }

    @Override
    public Authentication authenticate(Authentication authentication) throws AuthenticationException {
        Assert.notNull(authentication, "No authentication data provided");

        String username = (String) authentication.getPrincipal();
        String password = (String) authentication.getCredentials();

        Profile owner = ownerRepo.findByLogin(username);
		if (owner == null) {
			new UsernameNotFoundException("User not found: " + username);
		}

        if (password.equals(owner.getPassword())) {
            throw new BadCredentialsException("Authentication Failed. Username or Password not valid.");
        }

        return new UsernamePasswordAuthenticationToken(owner.getLogin(), owner.getRole(), Collections.emptyList());
    }

    @Override
    public boolean supports(Class<?> authentication) {
        return (UsernamePasswordAuthenticationToken.class.isAssignableFrom(authentication));
    }
}
