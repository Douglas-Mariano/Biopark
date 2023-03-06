package br.com.bioparkRest.model;

import java.io.Serializable;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.SequenceGenerator;
import javax.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;


@Entity
@SequenceGenerator(name = "seq_locatario", sequenceName = "seq_locatario", allocationSize = 1, initialValue = 1)
@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class Locatario implements Serializable{

	private static final long serialVersionUID = 1L;
	
	@Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "seq_locatario")
    private Long id;
 
    private String nome;
 
    private int cpf;
    
    private int telefone;
    
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "apartamento_id")
    private Apartamento apartamento;

}
