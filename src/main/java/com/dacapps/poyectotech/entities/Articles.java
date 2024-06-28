package com.dacapps.poyectotech.entities;

import java.io.Serializable;
import java.util.Date;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Lob;
import jakarta.persistence.PrePersist;
import jakarta.persistence.Table;
import jakarta.persistence.Temporal;
import jakarta.persistence.TemporalType;
import lombok.Data;


@Data
@Entity
@Table(name = "articulos")
public class Articles implements Serializable{

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id_articulo")
	private Long idArticulo;
	
	@Column(name = "titulo_articulo")
    private String tituloArticulo;
	
	@Column(name = "descripcion_corta_articulo")
    private String descripcionCortaArticulo;
	
	@Column(name = "descripcion_articulo")
    private String descripcionLargaArticulo;
    
    @Temporal(TemporalType.TIMESTAMP)
    private Date fechaArticulo;
    
    @Lob
    @Column(name = "imagen_articulo", columnDefinition = "longblob")
    private byte[] imagenArticulo;
    
    @Column(name = "articulo_usuario")
    private Long articuloUsuario;
    
    @PrePersist 
    public void prePersist() {
    	this.fechaArticulo = new Date();
    }

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
