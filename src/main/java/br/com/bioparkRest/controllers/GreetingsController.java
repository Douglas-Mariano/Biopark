package br.com.bioparkRest.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import br.com.bioparkRest.model.Edificio;
import br.com.bioparkRest.repository.ApartamentoRepository;
import br.com.bioparkRest.repository.EdificioRepository;
import br.com.bioparkRest.repository.LocatarioRepository;

/**
 *
 * A sample greetings controller to return greeting text
 */
@RestController
public class GreetingsController {	
	
    /**
     *
     * @param name the name to greet
     * @return greeting text
     */
    @RequestMapping(value = "/{name}", method = RequestMethod.GET)
    @ResponseStatus(HttpStatus.OK)
    public String greetingText(@PathVariable String name) {
    	
    	Edificio edificio = new Edificio();
    	edificio.setNome(name);

		edificioRepository.save(edificio);
    	
        return "Hello " + name + "!";
    }
    

    //Controlador Edifício
    
    @Autowired
	private EdificioRepository edificioRepository;
    
//Método para listar os edifícios
    
    @GetMapping(value = "listaedificios")
    @ResponseBody
    public ResponseEntity<List<Edificio>> listaEdificio() {
            
    	List<Edificio> edificio = edificioRepository.findAll();

    	return new ResponseEntity<List<Edificio>>(edificio, HttpStatus.OK);
        }
    
  //Método para salvar os edifícios
    
    @PostMapping(value = "salvaredificios")
    @ResponseBody
    public ResponseEntity<Edificio> salvarEdificio(@RequestBody Edificio edificio) {
            
    	Edificio edificiosalvo = edificioRepository.save(edificio);

    	return new ResponseEntity<Edificio>(edificiosalvo, HttpStatus.CREATED);
        }
    
//Método para atualizar os edifícios
    
    @PutMapping(value = "atualizaredificios")
    @ResponseBody
    public ResponseEntity<?> atualizaredificios(@RequestBody Edificio edificio) {
    	
    	if(edificio.getId() == null) {
    		return new ResponseEntity<String>("Código não informado", HttpStatus.OK);
    	}
            
    	Edificio edificioatualizado = edificioRepository.saveAndFlush(edificio);

    	return new ResponseEntity<Edificio>(edificioatualizado, HttpStatus.OK);
        }
    
//Método para deletar os edifícios
    
    @DeleteMapping(value = "deletaredificios")
    @ResponseBody
    public ResponseEntity<String> deletarEdificio(@RequestParam Long idEdificio) {
            
    	edificioRepository.deleteById(idEdificio);

    	return new ResponseEntity<String>("Edifício deletado", HttpStatus.OK);
        }
    
//Método para buscar edifício por id
    
    @GetMapping(value = "buscaredificioid")
    @ResponseBody
    public ResponseEntity<Edificio> buscaredificioid(@RequestParam(name = "idEdificio") Long idEdificio) {
            
    	Edificio edificio = edificioRepository.findById(idEdificio).get();

    	return new ResponseEntity<Edificio>(edificio, HttpStatus.OK);
        }
    
//Método para buscar edifício por nome
    
    @GetMapping(value = "buscaredificionome")
    @ResponseBody
    public ResponseEntity<List<Edificio>> buscaredificionome(@RequestParam(name = "nome") String nomeEdificio) {
            
    	List<Edificio> edificio = edificioRepository.buscarPorNome(nomeEdificio.trim().toUpperCase());

    	return new ResponseEntity<List<Edificio>>(edificio, HttpStatus.OK);
        }
    
    //Controlador Apartamento
    
    @Autowired
	private ApartamentoRepository apartamentoRepository;
    
    //Controlador Locatario
    
    @Autowired
	private LocatarioRepository locatarioRepository;
    
}