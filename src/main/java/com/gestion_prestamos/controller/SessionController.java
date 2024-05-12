package com.gestion_prestamos.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import org.springframework.http.MediaType;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;

import org.springframework.http.ResponseEntity;

import com.gestion_prestamos.entity.User;
import com.gestion_prestamos.entity.Zona;
import com.gestion_prestamos.services.UserService;
import com.gestion_prestamos.services.ZonaService;

@Controller
@RequestMapping(value = "/session")
public class SessionController {
	
	private final UserService userService;
	private final ZonaService zonaService;
	private static User userLoguedo;
	

    @Autowired
    public SessionController(UserService userService, ZonaService zonaService) {
    	this.userService = userService;
    	this.zonaService = zonaService;
    }
	
    /*
	@GetMapping(value = "/login")
	public String login() {
		return "login";
	} */

	
	@GetMapping(value = "/login")
    public String login(Model model) {
        List<Zona> zonas = zonaService.findAll();
        model.addAttribute("zonas", zonas);
        return "login";
    }
	
	/*
	@PostMapping("/login")
    public String login() {
        // Lógica para el inicio de sesión
    } */

	/*
	@PostMapping
	public String register(
		//@RequestParam("codigo") int id,
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
			SessionController.userLoguedo.getId(), SessionController.userLoguedo.getIdRol()
		);

		userService.register(newUser);

		return "redirect:/session/login";
	}
	*/
	
	@GetMapping(value = "/login", produces = "application/javascript")
    public ResponseEntity<String> getJavaScript() {
        // Aquí se devuelve el contenido del script JavaScript
        return ResponseEntity.ok().body("console.log('Hola mundo');");
    }
	
	
	
}