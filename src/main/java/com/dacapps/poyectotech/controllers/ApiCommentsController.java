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

import com.dacapps.poyectotech.dto.CommentRequest;
import com.dacapps.poyectotech.dto.UserRequest;
import com.dacapps.poyectotech.services.interfaces.ICommentsService;
import com.dacapps.poyectotech.services.interfaces.IUsersService;
import com.dacapps.poyectotech.utils.exceptions.ApiUnprocessableEntity;

import jakarta.persistence.PostUpdate;


@CrossOrigin("*") //permite conexiones desde diferentes accesos
@RestController
@RequestMapping("/comments") //paquete principal para acceder a esta aplicacion
public class ApiCommentsController {
	@Autowired
	private ICommentsService commentsService;

	
	
	@GetMapping(value = "/all", produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Object> index(){
		return ResponseEntity.ok(this.commentsService.findAll());
	}
	
	
	@GetMapping(value = "/findId/{idcomment}", produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Object> findByIdcomment(@PathVariable("idcomment") int idcomment){
		return ResponseEntity.ok(this.commentsService.findByIdcomment(idcomment));
	}
	
	
	@GetMapping(value = "/findArticle/{idarticle}", produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Object> findByIdarticle(@PathVariable int idarticle){
		return ResponseEntity.ok(this.commentsService.findByIdarticle(idarticle));
	}
	
	
	@PostMapping(value = "/save", consumes = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Object> saveComment(@RequestBody CommentRequest request) throws ApiUnprocessableEntity{
		this.commentsService.save(request);
		return ResponseEntity.ok(Boolean.TRUE);
	}
	
	
	@DeleteMapping(value = "/delete/{idComment}")
	public ResponseEntity<Object> deleteUser(@PathVariable int idComment){
		this.commentsService.deleteById(idComment);
		return ResponseEntity.ok(Boolean.TRUE);
	}
	
	
	@PutMapping(value = "/update/{idComment}")
	public ResponseEntity<Object> updateUser(@RequestBody CommentRequest request, @PathVariable int idComment){
		this.commentsService.update(request, idComment);
		return ResponseEntity.ok(Boolean.TRUE);
	}

}
