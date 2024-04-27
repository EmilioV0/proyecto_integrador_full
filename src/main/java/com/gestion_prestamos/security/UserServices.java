package com.gestion_prestamos.security;

import java.util.HashSet;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import com.gestion_prestamos.dto.UserAuthenticationDTO;
import com.gestion_prestamos.entity.User;
import com.gestion_prestamos.repository.UserRepository;
import com.gestion_prestamos.services.UserService;

import jakarta.servlet.http.HttpSession;
import jakarta.transaction.Transactional;


public class UserServices implements UserDetailsService {
	@Autowired
	private UserRepository userRepo;
	
	@Override
	@Transactional
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		UserDetails bean = null;
		
		User usu = userRepo.findByLogin(username).orElseThrow( () -> new IllegalAccessError() );
		
		Set<GrantedAuthority> rol = new HashSet<GrantedAuthority>();
		rol.add(new SimpleGrantedAuthority(usu.getRol().getName()));
		
		bean = new org.springframework.security.core.userdetails.User(username, 
				usu.getPassword(), rol);
		
		ServletRequestAttributes atrr = (ServletRequestAttributes) RequestContextHolder.currentRequestAttributes();
		HttpSession session = atrr.getRequest().getSession(true);
		session.setAttribute("userSession", usu);
		
		
		return bean;
	}


}

