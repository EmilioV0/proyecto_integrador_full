package com.gestion_prestamos.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import com.gestion_prestamos.dto.UserCreate;
import com.gestion_prestamos.dto.UserList;
import com.gestion_prestamos.entity.Enlace;
import com.gestion_prestamos.entity.User;
import com.gestion_prestamos.mapper.UserMapper;
import com.gestion_prestamos.repository.UserRepository;

@Service
public class UserServiceImp implements UserService {
	
	private final UserRepository userRepository;
	private final BCryptPasswordEncoder encriptador;
	
	@Autowired
	public UserServiceImp(UserRepository userRepository, BCryptPasswordEncoder encriptador) {
		this.encriptador = encriptador;
		this.userRepository = userRepository;
	}

	@Override
	public List<UserList> findByIdGrupo(int idUser) {
		List<UserList> users = userRepository.findByIdGrupo(idUser);
		return users;
	}

	@Override
	public void save(UserCreate newUser, int id) {
		User user = UserMapper.toUser(newUser);
		
		if ( id != 0 ) {
			user.setId(id);
		}
		
		user.setPassword( encriptador.encode( user.getPassword() ) );
		
		try {
			userRepository.save(user);			
		} catch(Exception e) {
			System.out.println("El username ya está en uso");
			System.out.println(e);
		}
	}

	@Override
	public User findById(int id) {
		String message = "No se encuentra el Usuario con id: " + id;
		return userRepository.findById(id)
				.orElseThrow(() -> new IllegalArgumentException(message));
	}

	@Override
	public List<Enlace> traerEnlacesDelUsuario(String desRol) {
		return userRepository.traerEnlacesDelUsuario(desRol);
	}
}
