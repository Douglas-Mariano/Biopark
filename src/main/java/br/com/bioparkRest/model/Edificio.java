package br.com.bioparkRest.model;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.SequenceGenerator;
import javax.validation.constraints.NotBlank;

import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.Data;

@Entity
@SequenceGenerator(name = "seq_edificio", sequenceName = "seq_edificio", allocationSize = 1, initialValue = 1)
@Data
public class Edificio implements Serializable{

	private static final long serialVersionUID = 1L;
	
	 @Id
	 @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "seq_edificio")
	 private Long id;

	 @NotBlank(message = "O nome é obrigatório")
	 private String nome;
	 
	 @NotBlank (message = "O endereço é obrigatório")
	 private String endereco;
	 
	 @NotBlank(message = "O proprietário é obrigatório")
	 private String proprietario;

	 //@JsonIgnore
	 @OneToMany(mappedBy = "edificio", cascade = CascadeType.ALL, orphanRemoval = true)
	 private List<Apartamento> apartamentos = new ArrayList<>();
	
	
}