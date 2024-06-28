package com.dacapps.poyectotech.dto;

import java.io.Serializable;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

//esta clase se usa para indicar que informacion de la entidad se quiere exponer al servicio
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class UsersDTO implements Serializable{
	
	private Long idUser;
    private String nameUser;
    private String emailUser;
    private Long userRol;

}
