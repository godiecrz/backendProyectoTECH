package com.dacapps.poyectotech.dto;

import java.io.Serializable;
import java.util.Date;

import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;


@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class CommentRequest implements Serializable{
	
	private String descriptionComment;
	private Long commentUser;
	private Long commentArticle;
}
