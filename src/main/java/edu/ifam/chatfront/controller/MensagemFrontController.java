package edu.ifam.chatfront.controller;

import org.springframework.beans.factory.annotation.Autowired;
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
import edu.ifam.chatfront.service.ContatoFrontService;
import edu.ifam.chatfront.service.MensagemFrontService;

@Controller
@RequestMapping("/mensagens")
public class MensagemFrontController {
	
	@Autowired
	MensagemFrontService mensagemFrontService;
	
	   private final String apiUrl = "http://localhost:8081/mensagem"; 

	   @GetMapping("/nova/{id}")
	   public String exibirFormularioEnvio(@PathVariable Long id, Model model) {
	       model.addAttribute("mensagem", new Mensagem());
	       model.addAttribute("contatoId", id);
	       return "enviarMensagem";
	   }


	   @PostMapping("/nova")
	   public String enviarMensagem(Long idReceptor) {
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
