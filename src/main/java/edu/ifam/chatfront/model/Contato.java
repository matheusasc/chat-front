package edu.ifam.chatfront.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import edu.ifam.dra.chatfront.Value;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@JsonIgnoreProperties(ignoreUnknown = true)
public record Contato(Long id, String nome, String email,String telefone, String endereco, String bairro, String cidade, String estado ) {
	
	

}
