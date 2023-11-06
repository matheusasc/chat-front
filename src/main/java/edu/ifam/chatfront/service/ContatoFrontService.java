package edu.ifam.chatfront.service;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import edu.ifam.chatfront.model.Contato;

@Service
public class ContatoFrontService {
	
	private final String url = "http://localhost:8080/contato"; 

	public List<Contato> getContatos(){
		RestTemplate restTemplate = new RestTemplate();
		
		ResponseEntity<Contato[]> response =  restTemplate.getForEntity(
			url , Contato[].class);
		return new ArrayList<Contato>(Arrays.asList(response.getBody()));
	}
	
	public Contato postContato(Contato contato) {
		
		RestTemplate restTemplate = new RestTemplate();
		
		HttpHeaders headers = new HttpHeaders();
		headers.add("Accept", MediaType.APPLICATION_JSON_VALUE);
		headers.setContentType(MediaType.APPLICATION_JSON);
		
		HttpEntity<Contato> requestBody = new HttpEntity<>(contato, headers);
		
		ResponseEntity<Contato> response = restTemplate.postForEntity(
				url,
				requestBody, Contato.class);
		
		return response.getBody();
	}
	
	public Contato putContato(Contato contato, long id) {
		RestTemplate restTemplate = new RestTemplate();
		
		HttpHeaders headers = new HttpHeaders();
		headers.add("Accept", MediaType.APPLICATION_JSON_VALUE);
		headers.setContentType(MediaType.APPLICATION_JSON);
		
		HttpEntity<Contato> requestBody = new HttpEntity<>(contato, headers);

		String urlPut = url + "/" + Long.toString(id);
		ResponseEntity<Contato> response =
				restTemplate.exchange(urlPut,
						HttpMethod.PUT,
						requestBody,
						Contato.class);
		return response.getBody();
	}
	
	public void deleteContato(long id) {
		
	}
	
}