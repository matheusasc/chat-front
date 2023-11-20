package edu.ifam.chatfront.model;

import java.util.Calendar;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;

public class Mensagem {
	
	private Long id;
	
	@NotBlank
	private Calendar dataHora;
	@NotBlank
	private String conteudo;
	@NotBlank
	private Contato emissor;
	@NotBlank
	private Contato receptor;

	
	
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
	public Contato getEmissor() {
		return emissor;
	}
	public void setEmissor(Contato emissor) {
		this.emissor = emissor;
	}
	public Contato getReceptor() {
		return receptor;
	}
	public void setReceptor(Contato receptor) {
		this.receptor = receptor;
	}
	
	

}
