package br.com.bioparkRest.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.com.bioparkRest.model.Locatario;


@Repository
public interface LocatarioRepository extends JpaRepository<Locatario, Long> {

}
