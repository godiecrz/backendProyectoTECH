package com.dacapps.poyectotech.services.interfaces;

import java.util.List;

import org.springframework.stereotype.Service;

import com.dacapps.poyectotech.dto.CommentRequest;
import com.dacapps.poyectotech.dto.CommentsDTO;
import com.dacapps.poyectotech.dto.UserRequest;


@Service
public interface ICommentsService {

	List<CommentsDTO> findAll();
	
	CommentsDTO findByIdcomment(int idComment);
	
	List<CommentsDTO> findByIdarticle(int idArticle);
	
	void save(CommentRequest comment);
	
	void saveAll(List<CommentRequest> comments);
	
	void update(CommentRequest comment, int idComment);
	
	void deleteById(int idComment);

}
