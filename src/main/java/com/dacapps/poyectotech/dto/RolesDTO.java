package com.dacapps.poyectotech.dto;

import java.io.Serializable;

import lombok.Data;

@Data
public class RolesDTO implements Serializable{
	
	private Long idRole;
	private String descriptionRole;
	
	
	public Long getIdRole() {
		return idRole;
	}
	public void setIdRole(Long idRole) {
		this.idRole = idRole;
	}
	public String getDescriptionRole() {
		return descriptionRole;
	}
	public void setDescriptionRole(String descriptionRole) {
		this.descriptionRole = descriptionRole;
	}
	

}