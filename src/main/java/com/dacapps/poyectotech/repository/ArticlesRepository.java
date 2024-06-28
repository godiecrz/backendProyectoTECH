package com.dacapps.poyectotech.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.dacapps.poyectotech.entities.Articles;



@Repository
public interface ArticlesRepository extends CrudRepository<Articles, Integer>{
	
	
}
