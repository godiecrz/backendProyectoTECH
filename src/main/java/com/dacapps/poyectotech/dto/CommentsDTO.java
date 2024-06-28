package com.dacapps.poyectotech.dto;

import java.io.Serializable;
import java.util.Date;

import lombok.Data;

@Data
public class CommentsDTO implements Serializable{

	private Long idComment;
	private String descriptionComment;
	private Date dateComment;
	private Long commentUser;
	private Long commentArticle;
	
	
	public Long getIdComment() {
		return idComment;
	}
	public void setIdComment(Long idComment) {
		this.idComment = idComment;
	}
	public String getDescriptionComment() {
		return descriptionComment;
	}
	public void setDescriptionComment(String descriptionComment) {
		this.descriptionComment = descriptionComment;
	}
	public Date getDateComment() {
		return dateComment;
	}
	public void setDateComment(Date dateComment) {
		this.dateComment = dateComment;
	}
	public Long getCommentUser() {
		return commentUser;
	}
	public void setCommentUser(Long commentUser) {
		this.commentUser = commentUser;
	}
	public Long getCommentArticle() {
		return commentArticle;
	}
	public void setCommentArticle(Long commentArticle) {
		this.commentArticle = commentArticle;
	}
	

}