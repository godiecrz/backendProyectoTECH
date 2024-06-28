package com.dacapps.poyectotech.controllers;

import java.io.IOException;

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
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.dacapps.poyectotech.dto.ArticleRequest;
import com.dacapps.poyectotech.services.interfaces.IArticlesService;
import com.dacapps.poyectotech.utils.exceptions.ApiUnprocessableEntity;
import com.dacapps.poyectotech.utils.helpers.Util;


@CrossOrigin("*") //permite conexiones desde diferentes accesos
@RestController
@RequestMapping("/articles") //paquete principal para acceder a esta aplicacion
public class ApiArticlesController {
	@Autowired
	private IArticlesService articlesService;


	@GetMapping(value = "/all", produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Object> index(){
		return ResponseEntity.ok(this.articlesService.findAll());
	}


	@GetMapping(value = "/find/{idarticle}", produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Object> findByIdArticle(@PathVariable("idarticle") int idarticle){
		return ResponseEntity.ok(this.articlesService.findByIdarticle(idarticle));
	}


	@PostMapping(value = "/save")
	public ResponseEntity<Object> saveArticle(
			@RequestParam("titleArticle") String titleArt,
			@RequestParam("descShortArticle") String desSmallArt,
			@RequestParam("descLongArticle") String desLongArt,
			@RequestParam("imageArticle") MultipartFile picture,
			@RequestParam("userArticle") String artUser) throws ApiUnprocessableEntity, IOException{

		ArticleRequest artRequest = new ArticleRequest();		
		artRequest.setTituloArticulo(titleArt);
		artRequest.setDescripcionCortaArticulo(desSmallArt);
		artRequest.setDescripcionLargaArticulo(desLongArt);
		artRequest.setImagenArticulo(Util.compressLib(picture.getBytes()));
		artRequest.setArticuloUsuario(Long.parseLong(artUser));

		this.articlesService.save(artRequest);
		return ResponseEntity.ok(Boolean.TRUE);
	}


	@DeleteMapping(value = "/delete/{idArticle}")
	public ResponseEntity<Object> deleteArticle(@PathVariable int idArticle){
		this.articlesService.deleteById(idArticle);
		return ResponseEntity.ok(Boolean.TRUE);
	}


	@PutMapping(value = "/update/{idArticle}")
	public ResponseEntity<Object> updateUser(
			@RequestParam("titleArticle") String titleArt,
			@RequestParam("descShortArticle") String desSmallArt,
			@RequestParam("descLongArticle") String desLongArt,
			@RequestParam(value = "imageArticle", required = false) MultipartFile picture,
			@PathVariable int idArticle) throws IOException{

		ArticleRequest artRequest = new ArticleRequest();
		artRequest.setTituloArticulo(titleArt);
		artRequest.setDescripcionCortaArticulo(desSmallArt);
		artRequest.setDescripcionLargaArticulo(desLongArt);
		if (picture != null && !picture.isEmpty()) {
	        artRequest.setImagenArticulo(Util.compressLib(picture.getBytes()));    
	    }

		this.articlesService.update(artRequest, idArticle);
		return ResponseEntity.ok(Boolean.TRUE);
	}

}
