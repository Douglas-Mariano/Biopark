package br.com.bioparkRest.model;

import java.io.Serializable;
import java.math.BigDecimal;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.SequenceGenerator;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;


@Entity
@SequenceGenerator(name = "seq_apartamento", sequenceName = "seq_apartamento", allocationSize = 1, initialValue = 1)
@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class Apartamento implements Serializable{
	
	private static final long serialVersionUID = 1L;

	@Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "seq_apartamento")
    private Long id;
	
	private String numeroAp;
	
	private int andarAp;

    private BigDecimal valorAluguel;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "edificio_id", referencedColumnName = "id")
    private Edificio edificio;

    @OneToOne(mappedBy = "apartamento")
    private Locatario locatario;

}
