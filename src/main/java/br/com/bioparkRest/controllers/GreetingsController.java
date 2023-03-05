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

import br.com.bioparkRest.model.Apartamento;
import br.com.bioparkRest.model.Edificio;
import br.com.bioparkRest.model.Locatario;
import br.com.bioparkRest.repository.ApartamentoRepository;
import br.com.bioparkRest.repository.EdificioRepository;
import br.com.bioparkRest.repository.LocatarioRepository;

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
		
		Apartamento apartamento = new Apartamento();
		apartamento.setNumeroAp(name);
		
		apartamentoRepository.save(apartamento);
		
		Locatario locatario = new Locatario();
		locatario.setNome(name);
		
		locatarioRepository.save(locatario);
    	
        return "Hello " + name + "!";
    }
    

    //Controlador Edifício
    
    @Autowired
	private EdificioRepository edificioRepository;
        
  //Método para salvar os edifícios
    
    @PostMapping(value = "salvaredificios")
    @ResponseBody
    public ResponseEntity<Edificio> salvarEdificio(@RequestBody Edificio edificio) {
            
    	Edificio edificiosalvo = edificioRepository.save(edificio);

    	return new ResponseEntity<Edificio>(edificiosalvo, HttpStatus.CREATED);
        }
    
//Método para listar os edifícios
    
    @GetMapping(value = "listaedificios")
    @ResponseBody
    public ResponseEntity<List<Edificio>> listaEdificio() {
            
    	List<Edificio> edificio = edificioRepository.findAll();

    	return new ResponseEntity<List<Edificio>>(edificio, HttpStatus.OK);
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
    
//Método para listar os Apartamentos
    
    @GetMapping(value = "listaAp")
    @ResponseBody
    public ResponseEntity<List<Apartamento>> listaAp() {
            
    	List<Apartamento> apartamento = apartamentoRepository.findAll();

    	return new ResponseEntity<List<Apartamento>>(apartamento, HttpStatus.OK);
        }
    
//Método para salvar os apartamentos
    
    @PostMapping(value = "salvarAps")
    @ResponseBody
    public ResponseEntity<Apartamento> salvarAps(@RequestBody Apartamento apartamento) {
            
    	Apartamento apsalvo = apartamentoRepository.save(apartamento);

    	return new ResponseEntity<Apartamento>(apsalvo, HttpStatus.CREATED);
        }

//Método para atualizar os Apartamentos
    
    @PutMapping(value = "atualizarAps")
    @ResponseBody
    public ResponseEntity<?> atualizarAps(@RequestBody Apartamento apartamento) {
    	
    	if(apartamento.getId() == null) {
    		return new ResponseEntity<String>("Código não informado", HttpStatus.OK);
    	}
            
    	Apartamento apartamentoatualizado = apartamentoRepository.saveAndFlush(apartamento);

    	return new ResponseEntity<Apartamento>(apartamentoatualizado, HttpStatus.OK);
        }
    
//Método para deletar os Apartamentos
    
    @DeleteMapping(value = "deletarAp")
    @ResponseBody
    public ResponseEntity<String> deletarAp(@RequestParam Long idApartamento) {
            
    	apartamentoRepository.deleteById(idApartamento);

    	return new ResponseEntity<String>("Apartamento deletado", HttpStatus.OK);
        }
    
//Método para buscar Apartamento por id
    
    @GetMapping(value = "buscarApId")
    @ResponseBody
    public ResponseEntity<Apartamento> buscarApId(@RequestParam(name = "idApartamento") Long idApartamento) {
            
    	Apartamento apartamento = apartamentoRepository.findById(idApartamento).get();

    	return new ResponseEntity<Apartamento>(apartamento, HttpStatus.OK);
        }
    
//Método para buscar apartamento pelo Nº Ap
    
    @GetMapping(value = "buscarApPorNumAp")
    @ResponseBody
    public ResponseEntity<List<Apartamento>> buscarApPorNumAp(@RequestParam(name = "nome") String numAp) {
            
    	List<Apartamento> apartamento = apartamentoRepository.buscarApPorNumAp(numAp.trim().toUpperCase());

    	return new ResponseEntity<List<Apartamento>>(apartamento, HttpStatus.OK);
        }
    
    //Controlador Locatario
    
    @Autowired
	private LocatarioRepository locatarioRepository;
    
//Método para salvar os Locatarios
    
    @PostMapping(value = "salvarlocatario")
    @ResponseBody
    public ResponseEntity<Locatario> salvarlocatario(@RequestBody Locatario locatario) {
            
    	Locatario locatariosalvo = locatarioRepository.save(locatario);

    	return new ResponseEntity<Locatario>(locatariosalvo, HttpStatus.CREATED);
        }
    
//Método para listar os Locatarios
    
    @GetMapping(value = "listlocatario")
    @ResponseBody
    public ResponseEntity<List<Locatario>> listlocatario() {
            
    	List<Locatario> locatario = locatarioRepository.findAll();

    	return new ResponseEntity<List<Locatario>>(locatario, HttpStatus.OK);
        }
   
//Método para atualizar os Locatarios
    
    @PutMapping(value = "atualizarlocatario")
    @ResponseBody
    public ResponseEntity<?> atualizarlocatario(@RequestBody Locatario locatario) {
    	
    	if(locatario.getId() == null) {
    		return new ResponseEntity<String>("Código não informado", HttpStatus.OK);
    	}
            
    	Locatario locatarioatualizado = locatarioRepository.saveAndFlush(locatario);

    	return new ResponseEntity<Locatario>(locatarioatualizado, HttpStatus.OK);
        }
    
//Método para deletar os Locatarios
    
    @DeleteMapping(value = "deletarlocatario")
    @ResponseBody
    public ResponseEntity<String> deletarlocatario(@RequestParam Long idLocatario) {
            
    	locatarioRepository.deleteById(idLocatario);

    	return new ResponseEntity<String>("Locatario deletado", HttpStatus.OK);
        }
    
//Método para buscar Locatario por id
    
    @GetMapping(value = "buscarlocatarioid")
    @ResponseBody
    public ResponseEntity<Locatario> buscarlocatarioid(@RequestParam(name = "idLocatario") Long idLocatario) {
            
    	Locatario locatario = locatarioRepository.findById(idLocatario).get();

    	return new ResponseEntity<Locatario>(locatario, HttpStatus.OK);
        }
    
//Método para buscar Locatario por nome
    
    @GetMapping(value = "buscarlocatarionome")
    @ResponseBody
    public ResponseEntity<List<Locatario>> buscarlocatarionome(@RequestParam(name = "nome") String nomeLocatario) {
            
    	List<Locatario> locatario = locatarioRepository.buscarLocatarioPorNome(nomeLocatario.trim().toUpperCase());

    	return new ResponseEntity<List<Locatario>>(locatario, HttpStatus.OK);
        }    
}