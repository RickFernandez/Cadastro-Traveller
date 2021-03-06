package com.traveller.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

import org.hibernate.annotations.GenericGenerator;

@Entity //Representa uma entidade dentro do Bando de Dados
public class NovoLocal {
	@Id //Faz com que o elemento seja único dentro do BD
	
	//CÓDIGO PARA O BD MYSQL
	//@GeneratedValue(strategy = GenerationType.IDENTITY) //Faz com que o valor do ID seja alterado automaticamente a cada novo cadastro
	
	//CÓDIGO PARA O BD POSTGREE
	@GeneratedValue(generator = "increment")
	@GenericGenerator(name = "increment", strategy = "increment")
	
	private Long id;
	private String nome;
	private String acessibilidade;
	private String cidade;
	private String estado;
	private String pais;
	private String endereco;
	private String latitude;
	private String longitude;
	private String numContato;
	private String email;
	private String site;
	private String tipo;
	private String descricao;
	
	
	public String getAcessibilidade() {
		return acessibilidade;
	}
	public void setAcessibilidade(String acessibilidade) {
		this.acessibilidade = acessibilidade;
	}
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public String getCidade() {
		return cidade;
	}
	public void setCidade(String cidade) {
		this.cidade = cidade;
	}
	public String getEstado() {
		return estado;
	}
	public void setEstado(String estado) {
		this.estado = estado;
	}
	public String getPais() {
		return pais;
	}
	public void setPais(String pais) {
		this.pais = pais;
	}
	public String getEndereco() {
		return endereco;
	}
	public void setEndereco(String endereco) {
		this.endereco = endereco;
	}
	public String getLatitude() {
		return latitude;
	}
	public void setLatitude(String latitude) {
		this.latitude = latitude;
	}
	public String getLongitude() {
		return longitude;
	}
	public void setLongitude(String longitude) {
		this.longitude = longitude;
	}
	public String getNumContato() {
		return numContato;
	}
	public void setNumContato(String numContato) {
		this.numContato = numContato;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getSite() {
		return site;
	}
	public void setSite(String site) {
		this.site = site;
	}
	public String getTipo() {
		return tipo;
	}
	public void setTipo(String tipo) {
		this.tipo = tipo;
	}
	public String getDescricao() {
		return descricao;
	}
	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}
	
	
}
