package com.projetointegradorgrupo3.ProjetoReintegrar.model;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.Size;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.sun.istack.NotNull;

@Entity
@Table(name = "tb_postagem")
public class Postagem {
		
		@Id
		@GeneratedValue(strategy = GenerationType.IDENTITY)
		private long id;
		
		@Size(min=0, max= 100)
		private String titulo;
		
		@NotNull
		@Size(min=0,max=700)
		private String corpo;
		
		@Temporal(TemporalType.TIMESTAMP)
		private Date data = new java.sql.Date(System.currentTimeMillis());
		
		
		@ManyToOne
		@JsonIgnoreProperties ("postagens")
		private Usuario usuario;

		public long getId() {
			return id;
		}

		public Date getData() {
			return data;
		}

		public void setData(Date data) {
			this.data = data;
		}

		public Usuario getUsuario() {
			return usuario;
		}

		public void setUsuario(Usuario usuario) {
			this.usuario = usuario;
		}

		public void setId(long id) {
			this.id = id;
		}

		public String getTitulo() {
			return titulo;
		}

		public void setTitulo(String titulo) {
			this.titulo = titulo;
		}

		public String getCorpo() {
			return corpo;
		}

		public void setCorpo(String corpo) {
			this.corpo = corpo;
		}

		public Date getDate() {
			return data;
		}

		public void setDate(Date date) {
			this.data = date;
		}
		
}
