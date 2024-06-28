package com.dacapps.poyectotech.services.implementation;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.dacapps.poyectotech.dto.ArticleRequest;
import com.dacapps.poyectotech.dto.ArticlesDTO;
import com.dacapps.poyectotech.entities.Articles;
import com.dacapps.poyectotech.repository.ArticlesRepository;
import com.dacapps.poyectotech.services.interfaces.IArticlesService;
import com.dacapps.poyectotech.utils.helpers.MHelpers;
import com.dacapps.poyectotech.utils.helpers.Util;


@Component //permite crear injecciones de dependencias en otras partes del proyecto
public class ArticlesImpl implements IArticlesService{

	//Injeccion de la dependencia del repositorio	
	@Autowired
	private ArticlesRepository articlesRepository;


	@Override
	public List<ArticlesDTO> findAll() {	
		List<ArticlesDTO> dto = new ArrayList<>();
		Iterable<Articles> articles = this.articlesRepository.findAll();
		
		for(Articles article : articles) {
			article.setImagenArticulo(Util.decompressLib(article.getImagenArticulo()));
			ArticlesDTO articlesDTO = MHelpers.modelMapper().map(article, ArticlesDTO.class);
			dto.add(articlesDTO);
		}
		return dto;
	}
	

	@Override
	public ArticlesDTO findByIdarticle(int idArticle) {
		Optional<Articles> articles = this.articlesRepository.findById(idArticle);

		if(!articles.isPresent()) {
			return null;
		}
		
		articles.get().setImagenArticulo(Util.decompressLib(articles.get().getImagenArticulo()));

		return MHelpers.modelMapper().map(articles.get(), ArticlesDTO.class);
	}

	
	@Override
	public void save(ArticleRequest article) {
		Articles articles = MHelpers.modelMapper().map(article, Articles.class);
		this.articlesRepository.save(articles);
	}


	@Override
	public void deleteById(int idArticle) {
		this.articlesRepository.deleteById(idArticle);
	}


	@Override
	public void update(ArticleRequest request, int idarticle) {
		Optional<Articles> article = this.articlesRepository.findById(idarticle);
		Articles a = article.get();
		a.setDescripcionCortaArticulo(request.getDescripcionCortaArticulo());
		a.setDescripcionLargaArticulo(request.getDescripcionLargaArticulo());
		a.setTituloArticulo(request.getTituloArticulo());
		if(!(request.getImagenArticulo().length == 0)) {
			a.setImagenArticulo(request.getImagenArticulo());
		}
		
		this.articlesRepository.save(a);
	}

}
