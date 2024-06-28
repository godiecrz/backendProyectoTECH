package com.dacapps.poyectotech.dto;

import java.io.Serializable;
import java.util.Date;

import lombok.Data;

//esta clase se usa para indicar que informacion de la entidad se quiere exponer al servicio
@Data
public class ArticlesDTO implements Serializable{
	
	private Long idArticulo;
	private String tituloArticulo;
	private String descripcionCortaArticulo;
	private String descripcionLargaArticulo;
	private Date fechaArticulo;
	private byte[] imagenArticulo;
	private Long articuloUsuario;
	
	
	public Long getIdArticulo() {
		return idArticulo;
	}
	public void setIdArticulo(Long idArticulo) {
		this.idArticulo = idArticulo;
	}
	public String getTituloArticulo() {
		return tituloArticulo;
	}
	public void setTituloArticulo(String tituloArticulo) {
		this.tituloArticulo = tituloArticulo;
	}
	public String getDescripcionCortaArticulo() {
		return descripcionCortaArticulo;
	}
	public void setDescripcionCortaArticulo(String descripcionCortaArticulo) {
		this.descripcionCortaArticulo = descripcionCortaArticulo;
	}
	public String getDescripcionLargaArticulo() {
		return descripcionLargaArticulo;
	}
	public void setDescripcionLargaArticulo(String descripcionLargaArticulo) {
		this.descripcionLargaArticulo = descripcionLargaArticulo;
	}
	public Date getFechaArticulo() {
		return fechaArticulo;
	}
	public void setFechaArticulo(Date fechaArticulo) {
		this.fechaArticulo = fechaArticulo;
	}
	public byte[] getImagenArticulo() {
		return imagenArticulo;
	}
	public void setImagenArticulo(byte[] imagenArticulo) {
		this.imagenArticulo = imagenArticulo;
	}
	public Long getArticuloUsuario() {
		return articuloUsuario;
	}
	public void setArticuloUsuario(Long articuloUsuario) {
		this.articuloUsuario = articuloUsuario;
	}
    
	
}
