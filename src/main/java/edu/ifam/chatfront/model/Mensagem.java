package edu.ifam.chatfront.model;

import java.util.Calendar;

import org.springframework.format.annotation.DateTimeFormat;

import com.fasterxml.jackson.annotation.JsonFormat;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

public class Mensagem {
	
	private Long id;
	
	@NotNull
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	private Calendar dataHora;
	@NotBlank
	private String conteudo;
	@NotNull
	private Long emissor;
	@NotNull
	private Long receptor;

	
	
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
	public Long getEmissor() {
		return emissor;
	}
	public void setEmissor(Long emissor) {
		this.emissor = emissor;
	}
	public Long getReceptor() {
		return receptor;
	}
	public void setReceptor(Long receptor) {
		this.receptor = receptor;
	}
	
	

}
