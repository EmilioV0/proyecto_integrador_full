package com.gestion_prestamos.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.gestion_prestamos.dto.UserCreate;
import com.gestion_prestamos.dto.UserList;
import com.gestion_prestamos.entity.User;
import com.gestion_prestamos.entity.Zona;
import com.gestion_prestamos.services.UserService;
import com.gestion_prestamos.services.ZonaService;

import jakarta.servlet.http.HttpSession;

@Controller
@RequestMapping("/users")
public class UserController {

	private final UserService userService;
	private final ZonaService zonaService;
	private static User userLoguedo;


	@Autowired
	public UserController(UserService userService, ZonaService zonaService) {
		this.userService = userService;
		this.zonaService = zonaService;
	}

	@GetMapping
	public String getUsers(HttpSession session, Model model) {
		UserController.userLoguedo = (User) session.getAttribute("userSession");
		List<UserList> users = userService.findByIdGrupo(userLoguedo.getId());
		List<Zona> zonas = zonaService.findAll();

		model.addAttribute("users", users);
		model.addAttribute("zonas", zonas);
		
		boolean esPrestamista = UserController.userLoguedo.getIdRol() == 3;
		String page = esPrestamista ? "prestamista" : "menuPrincipal";

		return page;
	}

	@PostMapping
	public String save(
		@RequestParam("codigo") int id,
		@RequestParam("dni")String dni,
		@RequestParam("nombre")String nombre,
		@RequestParam("apellido")String apellido,
		@RequestParam("login")String login,
		@RequestParam("password")String password,
		@RequestParam("telefono")String telefono,
		@RequestParam("correo")String email,
		@RequestParam("zona")int idZona,
		RedirectAttributes redirect
	) {
		UserCreate newUser = new UserCreate(
			dni, nombre, apellido, login, password, email,telefono, idZona,
			UserController.userLoguedo.getId(), UserController.userLoguedo.getIdRol()
		);

		userService.save(newUser, id);

		return "redirect:/users";
	}

	@GetMapping("/{id}")
	@ResponseBody
	public User getUserById(@PathVariable int id) {
		User user = userService.findById(id);
		System.out.println(user);
		return user;
	}
}
