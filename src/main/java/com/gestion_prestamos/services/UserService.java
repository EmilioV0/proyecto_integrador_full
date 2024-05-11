package com.gestion_prestamos.services;

import java.util.List;

import com.gestion_prestamos.dto.UserCreate;
import com.gestion_prestamos.dto.UserList;
import com.gestion_prestamos.entity.Enlace;
import com.gestion_prestamos.entity.User;

public interface UserService {
	List<UserList> findByIdGrupo(int idUser);
	void save(UserCreate newUser, int id);
	User findById(int id);
	List<Enlace> traerEnlacesDelUsuario(String desRol);
}




