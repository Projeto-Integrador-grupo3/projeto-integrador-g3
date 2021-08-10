package com.projetointegradorgrupo3.ProjetoReintegrar.seguranca;

import java.util.Collection;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import com.projetointegradorgrupo3.ProjetoReintegrar.model.Usuario;

public class UserDetailsImpl implements UserDetails {
	
private static final long serialVersionUID = 1L ;
	
	private String userEmail ;
	private String password ;
	
	
	

	public UserDetailsImpl(Usuario user) {
		this.userEmail = user.getEmail();
		this.password = user.getSenha();
	}
	
	public UserDetailsImpl() {}
	
	
	@Override
	public Collection<? extends GrantedAuthority> getAuthorities() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String getPassword() {
		// TODO Auto-generated method stub
		return password;
	}

	@Override
	public String getUsername() {
		// TODO Auto-generated method stub
		return userEmail;
	}

	@Override
	public boolean isAccountNonExpired() {
		// TODO Auto-generated method stub
		return true;
	}

	@Override
	public boolean isAccountNonLocked() {
		// TODO Auto-generated method stub
		return true;
	}

	@Override
	public boolean isCredentialsNonExpired() {
		// TODO Auto-generated method stub
		return true;
	}

	@Override
	public boolean isEnabled() {
		// TODO Auto-generated method stub
		return true;
	}
}
