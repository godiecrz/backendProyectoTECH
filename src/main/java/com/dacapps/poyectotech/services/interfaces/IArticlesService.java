package com.dacapps.poyectotech.services.interfaces;

import java.util.List;
import org.springframework.stereotype.Service;

import com.dacapps.poyectotech.dto.ArticleRequest;
import com.dacapps.poyectotech.dto.ArticlesDTO;


@Service
public interface IArticlesService {

	List<ArticlesDTO> findAll();
	
	ArticlesDTO findByIdarticle(int idArticle);
	
	void save(ArticleRequest article);
	
	void update(ArticleRequest article, int idarticle);
	
	void deleteById(int idArticle);
}
