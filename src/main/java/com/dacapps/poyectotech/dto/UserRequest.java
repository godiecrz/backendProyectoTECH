package com.dacapps.poyectotech.dto;

import java.io.Serializable;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;


@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class UserRequest implements Serializable{
	

    private String nameUser;
    private String emailUser;
    private String passUser;
    private Long userRol;    
	
}
