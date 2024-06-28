package com.dacapps.poyectotech.services.implementation;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.dacapps.poyectotech.dto.CommentRequest;
import com.dacapps.poyectotech.dto.CommentsDTO;
import com.dacapps.poyectotech.entities.Comments;
import com.dacapps.poyectotech.repository.CommentsRepository;
import com.dacapps.poyectotech.services.interfaces.ICommentsService;
import com.dacapps.poyectotech.utils.helpers.MHelpers;


@Component //permite crear injecciones de dependencias en otras partes del proyecto
public class CommentsImpl implements ICommentsService{

	//Injeccion de la dependencia del repositorio	
	@Autowired
	private CommentsRepository commentsRepository;


	@Override
	public List<CommentsDTO> findAll() {	
		List<CommentsDTO> dto = new ArrayList<>();
		Iterable<Comments> comments = this.commentsRepository.findAll();

		for(Comments comment : comments) {
			CommentsDTO commentsDTO = MHelpers.modelMapper().map(comment, CommentsDTO.class);
			dto.add(commentsDTO);
		}
		return dto;
	}


	@Override
	public CommentsDTO findByIdcomment(int idComment) {
		Optional<Comments> comments = this.commentsRepository.findById(idComment);

		if(!comments.isPresent()) {
			return null;
		}

		return MHelpers.modelMapper().map(comments.get(), CommentsDTO.class);
	}


	@Override
	public List<CommentsDTO> findByIdarticle(int idArticle) {
		List<CommentsDTO> dto = new ArrayList<>();
		Iterable<Comments> comments = this.commentsRepository.findBycommentArticle(idArticle);

		for(Comments comment : comments) {
			CommentsDTO commentsDTO = MHelpers.modelMapper().map(comment, CommentsDTO.class);
			dto.add(commentsDTO);	
		}
		if(dto.size() == 0) {
			return null;
		}
		return dto;
	}


	@Override
	public void save(CommentRequest comment) {
		Comments comments = MHelpers.modelMapper().map(comment, Comments.class);
		this.commentsRepository.save(comments);
	}


	@Override
	public void saveAll(List<CommentRequest> comments) {

		List<Comments> c = new ArrayList<>();
		for(CommentRequest comment: comments) {
			Comments co = MHelpers.modelMapper().map(comment, Comments.class);
			c.add(co);
		}
		this.commentsRepository.saveAll(c);

	}

	@Override
	public void deleteById(int idComment) {
		this.commentsRepository.deleteById(idComment);
	}


	@Override
	public void update(CommentRequest request, int idComment) {
		Optional<Comments> comment = this.commentsRepository.findById(idComment);
		Comments c = comment.get();
		c.setDescriptionComment(request.getDescriptionComment());
		this.commentsRepository.save(c);
	}


}
