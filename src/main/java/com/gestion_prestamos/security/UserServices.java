package com.gestion_prestamos.security;

import java.util.HashSet;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

import com.gestion_prestamos.dto.UserAuthenticationDTO;
import com.gestion_prestamos.entity.User;
import com.gestion_prestamos.repository.UserRepository;
import com.gestion_prestamos.services.UserService;

import jakarta.transaction.Transactional;


public class UserServices implements UserDetailsService {
	@Autowired
	private UserRepository userRepo;
	
	@Override
	@Transactional
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		//declarar
		UserDetails bean=null;
		//validar inicio de sesión
		UserAuthenticationDTO usu= userRepo.findByLogin(username).orElseThrow( () -> new IllegalAccessError() );
		//rol
		Set<GrantedAuthority> rol=new HashSet<GrantedAuthority>();
		//adicionar
		rol.add(new SimpleGrantedAuthority(usu.rol()));
		//crear objeto bean
		bean=new org.springframework.security.core.userdetails.User(username, 
				usu.password(), rol);
		
		return bean;
	}
	

}
