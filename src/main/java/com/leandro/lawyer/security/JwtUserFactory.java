package com.leandro.lawyer.security;

import java.util.List;

import java.util.stream.Collectors;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;

import com.leandro.lawyer.model.User;

public final class JwtUserFactory {

    private JwtUserFactory() {
    }

    public static JwtUser create(User profile) {
        return new JwtUser(
        		profile.getId(),
        		profile.getUsername(),
        		profile.getFirstname(),
        		profile.getLastname(),
        		profile.getEmail(),
        		profile.getPassword(),
                mapToGrantedAuthorities(profile.getPermissions()),
                profile.getEnabled(),
                profile.getLastPasswordResetDate()
        );
    }

    private static List<GrantedAuthority> mapToGrantedAuthorities(List<Authority> authorities) {
        return authorities.stream()
                .map(authority -> new SimpleGrantedAuthority(authority.getName().name()))
                .collect(Collectors.toList());
    }
}
