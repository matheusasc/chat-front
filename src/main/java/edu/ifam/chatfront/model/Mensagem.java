package edu.ifam.chatfront.model;

import java.util.Calendar;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;

public class Mensagem {
	
	private Long id;
	
	@NotBlank
	private Calendar dataHora;
	@Email
	@NotBlank
	private String conteudo;
	
	
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public Calendar getDataHora() {
		return dataHora;
	}
	public void setDataHora(Calendar dataHora) {
		this.dataHora = dataHora;
	}
	public String getConteudo() {
		return conteudo;
	}
	public void setConteudo(String conteudo) {
		this.conteudo = conteudo;
	}
	
	

}
