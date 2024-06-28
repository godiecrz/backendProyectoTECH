package com.dacapps.poyectotech.dto;

import java.io.Serializable;

import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.Data;


@Data
public class RoleRequest implements Serializable{
	
	@JsonProperty("descriptionrole")
	private String descriptionRole;

	public String getDescriptionRole() {
		return descriptionRole;
	}

	public void setDescriptionRole(String descriptionRole) {
		this.descriptionRole = descriptionRole;
	}	

}
