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
public class ArticleRequest implements Serializable{
	
	private String tituloArticulo;
	private String descripcionCortaArticulo;
	private String descripcionLargaArticulo;
	private Date fechaArticulo;
	private byte[] imagenArticulo;
	private Long articuloUsuario;


	public byte[] getImagenArticulo() {
        if (imagenArticulo == null) {
            return new byte[0]; // Devuelve un array vacío si imagenArticulo es null
        }
        return imagenArticulo;
    }


}
