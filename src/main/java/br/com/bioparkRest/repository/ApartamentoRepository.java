package br.com.bioparkRest.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.com.bioparkRest.model.Apartamento;

@Repository
public interface ApartamentoRepository extends JpaRepository<Apartamento, Long> {

}
