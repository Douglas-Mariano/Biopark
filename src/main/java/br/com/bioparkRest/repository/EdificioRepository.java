package br.com.bioparkRest.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.com.bioparkRest.model.Edificio;

@Repository
public interface EdificioRepository extends JpaRepository<Edificio, Long> {

}
