package com.dacapps.poyectotech.controllers;

import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.dacapps.poyectotech.configuration.security.AuthResponse;
import com.dacapps.poyectotech.configuration.security.AuthService;
import com.dacapps.poyectotech.dto.LoginRequest;
import com.dacapps.poyectotech.dto.UserRequest;

import lombok.RequiredArgsConstructor;


@RestController
@CrossOrigin(origins = {"http://localhost:4200"})
@RequestMapping("/auth")
@RequiredArgsConstructor
public class ApiAuthController {
	
	private  final AuthService authService;

	@PostMapping(value = "login")
	public ResponseEntity<AuthResponse> login(@RequestBody LoginRequest request) {
		return ResponseEntity.ok(authService.login(request));
	}
	
	
	@PostMapping(value = "save", consumes = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Object> saveUser(@RequestBody UserRequest request){
		return ResponseEntity.ok(authService.register(request));
	}
	
}
