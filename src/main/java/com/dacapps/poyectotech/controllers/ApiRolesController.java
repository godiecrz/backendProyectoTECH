package com.dacapps.poyectotech.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.dacapps.poyectotech.dto.RoleRequest;
import com.dacapps.poyectotech.services.interfaces.IRolesService;
import com.dacapps.poyectotech.utils.exceptions.ApiUnprocessableEntity;


@CrossOrigin("*") //permite conexiones desde diferentes accesos
@RestController
@RequestMapping("/roles") //paquete principal para acceder a esta aplicacion
public class ApiRolesController {
	@Autowired
	private IRolesService rolesService;
	
	@GetMapping(value = "/all", produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Object> index(){
		return ResponseEntity.ok(this.rolesService.findAll());
	}
	
	
	@GetMapping(value = "/findId/{idrole}", produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Object> findByIdrole(@PathVariable("idrole") int idrole){
		return ResponseEntity.ok(this.rolesService.findByIdrole(idrole));
	}
	
	
	@PostMapping(value = "/save", consumes = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Object> saveComment(@RequestBody RoleRequest request) throws ApiUnprocessableEntity{
		this.rolesService.save(request);
		return ResponseEntity.ok(Boolean.TRUE);
	}

	@DeleteMapping(value = "/delete/{idRole}")
	public ResponseEntity<Object> deleteUser(@PathVariable int idRole){
		this.rolesService.deleteById(idRole);
		return ResponseEntity.ok(Boolean.TRUE);
	}
	
	
	@PutMapping(value = "/update/{idRole}")
	public ResponseEntity<Object> updateUser(@RequestBody RoleRequest request, @PathVariable int idRole){
		this.rolesService.update(request, idRole);
		return ResponseEntity.ok(Boolean.TRUE);
	}
}
