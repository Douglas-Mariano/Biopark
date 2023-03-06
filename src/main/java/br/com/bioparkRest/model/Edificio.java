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
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@SequenceGenerator(name = "seq_edificio", sequenceName = "seq_edificio", allocationSize = 1, initialValue = 1)
@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class Edificio implements Serializable{

	private static final long serialVersionUID = 1L;
	
	 @Id
	 @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "seq_edificio")
	 private Long id;

	 private String nome;
	 
	 private String endereco;
	 
	 private String proprietario;

	 @OneToMany(mappedBy = "edificio", cascade = CascadeType.ALL, orphanRemoval = true)
	 private List<Apartamento> apartamentos = new ArrayList<>();
	
	
}