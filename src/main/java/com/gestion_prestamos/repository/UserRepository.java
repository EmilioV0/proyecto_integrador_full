package com.gestion_prestamos.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.Repository;

import com.gestion_prestamos.dto.UserAuthenticationDTO;
import com.gestion_prestamos.dto.UserList;
import com.gestion_prestamos.entity.Enlace;
import com.gestion_prestamos.entity.User;

public interface UserRepository extends Repository<User, Integer> {
	
	Optional<User> findById(int id);
	@Query(value = """
			SELECT new com.gestion_prestamos.dto.UserList(
				u.id,
				u.DNI,
				u.nombre,
				u.apellido,
				u.rol.name as role,
				u.telefono,
				u.login as username
			)
			from User u WHERE u.idGrupo = :id
			AND u.id <> :id
			""")
	List<UserList> findByIdGrupo(int id);
	
	@Query(value = """
			SELECT new com.gestion_prestamos.dto.UserAuthenticationDTO(
				r.name as rol,
				u.password
			) FROM User u INNER JOIN u.rol r WHERE u.login = :username 
			""")
	Optional<UserAuthenticationDTO> findByLogin(String username);
	User save(User user);
	
	@Query("select p from RolEnlace rp join rp.enlace p where rp.rol.name=:desRol")
	public List<Enlace> traerEnlacesDelUsuario(String desRol);
}
