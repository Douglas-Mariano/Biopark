package br.com.bioparkRest.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import br.com.bioparkRest.model.Edificio;

@Repository
public interface EdificioRepository extends JpaRepository<Edificio, Long> {
	
	@Query(value = "select e from Edificio e where upper(trim(e.nome)) like %?1%")
	List<Edificio> buscarPorNome(String name);

}
