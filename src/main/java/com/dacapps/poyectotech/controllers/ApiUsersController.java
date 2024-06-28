package com.dacapps.poyectotech.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.dacapps.poyectotech.configuration.security.AuthService;
import com.dacapps.poyectotech.dto.UserRequest;
import com.dacapps.poyectotech.services.interfaces.IUsersService;
import com.dacapps.poyectotech.utils.exceptions.ApiUnprocessableEntity;

import lombok.RequiredArgsConstructor;


@CrossOrigin(origins = {"http://localhost:4200"}) //permite conexiones desde diferentes accesos
@RestController
@RequestMapping("/users") //paquete principal para acceder a esta aplicacion
@RequiredArgsConstructor
public class ApiUsersController {
	
	private final IUsersService usersService;
	
	
	@GetMapping(value = "/all", produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Object> index(){
		return ResponseEntity.ok(this.usersService.findAll());
	}
	
	
	@GetMapping(value = "/find/{iduser}", produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Object> findByIduser(@PathVariable("iduser") int iduser){
		return ResponseEntity.ok(this.usersService.findByIduser(iduser));
	}
	
	
	@DeleteMapping(value = "/delete/{idUser}")
	public ResponseEntity<Object> deleteUser(@PathVariable int idUser){
		this.usersService.deleteById(idUser);
		return ResponseEntity.ok(Boolean.TRUE);
	}
	
	
	@PutMapping(value = "/update/{idUser}")
	public ResponseEntity<Object> updateUser(@RequestBody UserRequest request, @PathVariable int idUser){
		this.usersService.update(request, idUser);
		return ResponseEntity.ok(Boolean.TRUE);
	}

}
