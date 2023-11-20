package edu.ifam.chatfront.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.client.HttpClientErrorException;
import org.springframework.web.client.RestTemplate;

import edu.ifam.chatfront.model.Contato;
import edu.ifam.chatfront.model.Mensagem;

@Controller
@RequestMapping("/mensagens")
public class MensagemFrontController {
	
	   private final String apiUrl = "http://localhost:8080/mensagem"; 

	   @GetMapping("/nova/{id}")
	   public String exibirFormularioEnvio(@PathVariable Long id, Model model) {
	       model.addAttribute("mensagem", new Mensagem());
	       model.addAttribute("contatoId", id);
	       return "enviarMensagem";
	   }



	   @PostMapping("/mensagem/enviar")
	   public String enviarMensagem(@ModelAttribute Mensagem mensagem, BindingResult result, Model model) {
	       try {

	           Contato emissor = new Contato();
	           emissor.setId(1L); 

	           Contato receptor = new Contato();
	           receptor.setId(2L); 

	           mensagem.setEmissor(emissor);
	           mensagem.setReceptor(receptor);

	           RestTemplate restTemplate = new RestTemplate();
	           ResponseEntity<Mensagem> response = restTemplate.postForEntity(apiUrl + "/mensagem/enviar", mensagem, Mensagem.class);

	           if (response.getStatusCode() == HttpStatus.OK) {
	               Mensagem mensagemEnviada = response.getBody();
	               model.addAttribute("mensagemEnviada", mensagemEnviada);
	           } else {

	               model.addAttribute("ErroEnvio", true);
	           }
	       } catch (HttpClientErrorException e) {
	           model.addAttribute("ErroEnvio", true);
	       }
	       return "enviarMensagem";
	   }





	    @GetMapping("/listar/{id}")
	    public String listarMensagens(@PathVariable Long id, Model model) {
	        try {
	            RestTemplate restTemplate = new RestTemplate();
	            Mensagem[] mensagens = restTemplate.getForObject(apiUrl + "/mensagem/{idReceptor}", Mensagem[].class, id);
	            
	            Mensagem mensagemEnviada = recuperarMensagemEnviada(mensagens, id);
	            
	            model.addAttribute("mensagens", mensagens);
	            model.addAttribute("mensagemEnviada", mensagemEnviada);
	        } catch (HttpClientErrorException e) {
	            model.addAttribute("erroListagem", true);
	        }
	        model.addAttribute("contatoId", id);
	        return "listarMensagens";
	    }


	    private Mensagem recuperarMensagemEnviada(Mensagem[] mensagens, Long id) {
	        for (Mensagem mensagem : mensagens) {
	            if (mensagem.getReceptor().getId().equals(id)) {
	                return mensagem;
	            }
	        }
	        return null;
	    }


}
