package com.leandro.lawyer.services;

import java.util.Collection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Component;

import com.leandro.lawyer.model.Owner;
import com.leandro.lawyer.repository.OwnerRepo;

@Component
public class AuthProviderService implements AuthenticationProvider {

	@Autowired
	private OwnerRepo ownerRepo;

	@Override
	public Authentication authenticate(Authentication auth) throws AuthenticationException {
		String login = auth.getName();
		String senha = auth.getCredentials().toString();

		Owner owner = new Owner();
		// Defina suas regras para realizar a autenticação

		if (owner != null) {
			if (owner.getIsActive()) {
				Collection<? extends GrantedAuthority> authorities = owner.getRoles();
				return new UsernamePasswordAuthenticationToken(login, senha, authorities);
			} else {
				throw new BadCredentialsException("Este usuário está desativado.");
			}
		}

		throw new UsernameNotFoundException("Login e/ou Senha inválidos.");
	}

	@Override
	public boolean supports(Class<?> auth) {
		return auth.equals(UsernamePasswordAuthenticationToken.class);
	}
}