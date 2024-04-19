package com.gestion_prestamos.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
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
	
	@Autowired
	public UserServiceImp(UserRepository userRepository) {
		this.userRepository = userRepository;
	}

	@Override
	public List<UserList> findByIdGrupo(int idUser) {
		List<UserList> users = userRepository.findByIdGrupo(idUser);
		return users;
	}

	@Override
	public void save(UserCreate newUser) {
		User user = UserMapper.toUser(newUser);
		userRepository.save(user);
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
