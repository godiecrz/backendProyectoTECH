package com.dacapps.poyectotech.entities;

import java.io.Serializable;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;

@Data
@Entity
@Table(name = "roles")
public class Roles implements Serializable{

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id_rol")
	private Long idRole;

	@Column(name = "descripcion_rol")
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
