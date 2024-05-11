package com.gestion_prestamos.mapper;

import com.gestion_prestamos.dto.UserCreate;
import com.gestion_prestamos.entity.User;

public class UserMapper {

	private UserMapper() {}

	public static User toUser(UserCreate newUser) {
		User user = new User();

		user.setDNI( newUser.getDNI() );
		user.setNombre( newUser.getNombre() );
		user.setApellido( newUser.getApellido() );
		user.setLogin( newUser.getLogin() );
		user.setPassword( newUser.getPassword() );
		user.setEmail( newUser.getEmail() );
		user.setTelefono( newUser.getTelefono() );
		user.setIdZona( newUser.getIdZona() );
		user.setIdGrupo( newUser.getBossId() );
		user.setIdRol( newUser.getBossRolId() + 1);

		return user;
	}

}
