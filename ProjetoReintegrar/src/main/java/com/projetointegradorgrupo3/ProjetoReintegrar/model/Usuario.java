package com.projetointegradorgrupo3.ProjetoReintegrar.model;

import java.time.LocalDate;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.Email;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.sun.istack.NotNull;

@Entity
@Table (name = "usuario")
public class Usuario {
	
	@Id
	@GeneratedValue (strategy = GenerationType.IDENTITY)
	private long id;
	
	@NotBlank
	@Size (min = 3, max = 50)
	private String nome;
	
	@Column(name = "tb_nascimento")
	@JsonFormat(pattern = "yyyy-MM-dd")
	private LocalDate dataNascimento ;
	
	@NotBlank
	@Size (min = 5, max = 20)
	private String genero;
	
	@NotBlank
	@Size (min = 5, max = 100)
	@Email // TODO testes
	private String email;
	
	//@Pattern TODO pesquisar depois
	private String telefone;
	
	@NotBlank
	@Size (min = 6)
	private String senha;
	
	@NotBlank
	@Size (min=5,max=100)
	private String periodo;
	
	@Min (0)
	private double pretensaoSalarial;

	
	@ManyToOne
	@JsonIgnoreProperties ("usuarios")
	private Categoria categoria;
	
	@OneToMany (mappedBy = "usuario", cascade = CascadeType.REMOVE)
	@JsonIgnoreProperties ("usuario")
	private List<Postagem> postagens;
	
	public Usuario (long id, String nome , LocalDate dataNascimento, String genero , String email
			, String telefone , String senha , String periodo , double pretensaoSalarial) {
		
		this.id = id;
		this.nome = nome;
		this.dataNascimento = dataNascimento;
		this.genero = genero;
		this.email = email;
		this.telefone = telefone;
		this.senha = senha;
		this.periodo = periodo;
		this.pretensaoSalarial = pretensaoSalarial;
	}
	
	public Usuario () {
		
	}
	
	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public Categoria getCategoria() {
		return categoria;
	}

	public void setCategoria(Categoria categoria) {
		this.categoria = categoria;
	}

	public List<Postagem> getPostagens() {
		return postagens;
	}

	public void setPostagens(List<Postagem> postagens) {
		this.postagens = postagens;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getGenero() {
		return genero;
	}

	public void setGenero(String genero) {
		this.genero = genero;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getTelefone() {
		return telefone;
	}

	public void setTelefone(String telefone) {
		this.telefone = telefone;
	}

	public String getSenha() {
		return senha;
	}

	public void setSenha(String senha) {
		this.senha = senha;
	}

	public String getPeriodo() {
		return periodo;
	}

	public void setPeriodo(String periodo) {
		this.periodo = periodo;
	}

	public double getPretensaoSalarial() {
		return pretensaoSalarial;
	}

	public void setPretensaoSalarial(double pretensaoSalarial) {
		this.pretensaoSalarial = pretensaoSalarial;
	}

	public LocalDate getDataNascimento() {
		return dataNascimento;
	}

	public void setDataNascimento(LocalDate dataNascimento) {
		this.dataNascimento = dataNascimento;
	}
	
	
}