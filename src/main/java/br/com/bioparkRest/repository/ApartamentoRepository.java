package br.com.bioparkRest.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import br.com.bioparkRest.model.Apartamento;

@Repository
public interface ApartamentoRepository extends JpaRepository<Apartamento, Long> {
	
	@Query(value = "select a from Apartamento a where upper(trim(a.numeroAp)) like %?1%")
	List<Apartamento> buscarApPorNumAp(String name);

}
