package com.dacapps.poyectotech.entities;

import java.io.Serializable;
import java.util.Date;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.PrePersist;
import jakarta.persistence.Table;
import jakarta.persistence.Temporal;
import jakarta.persistence.TemporalType;
import lombok.Data;

@Data
@Entity
@Table(name = "comentarios")
public class Comments implements Serializable{

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id_comentario")
	private Long idComment;
	
	@Column(name = "descripcion_comentario")
	private String descriptionComment;
	
	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "fecha_comentario")
	private Date dateComment;
	
	@Column(name = "comentario_usuario")
	private Long commentUser;
	
	@Column(name = "comentario_articulo")
	private Long commentArticle;
	
	@PrePersist 
    public void prePersist() {
    	this.dateComment = new Date();
    }
    

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
