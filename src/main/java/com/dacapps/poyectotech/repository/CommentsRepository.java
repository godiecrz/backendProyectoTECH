package com.dacapps.poyectotech.repository;

import java.util.Optional;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.dacapps.poyectotech.dto.CommentsDTO;
import com.dacapps.poyectotech.entities.Comments;


@Repository
public interface CommentsRepository extends CrudRepository<Comments, Integer>{
	
	@Transactional(readOnly = true)
	Iterable<Comments> findBycommentArticle(int idComment); 
	
}
