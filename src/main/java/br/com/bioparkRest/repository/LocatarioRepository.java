package br.com.bioparkRest.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import br.com.bioparkRest.model.Locatario;


@Repository
public interface LocatarioRepository extends JpaRepository<Locatario, Long> {

	@Query(value = "select l from Locatario l where upper(trim(l.nome)) like %?1%")
	List<Locatario> buscarLocatarioPorNome(String name);
}
