package br.ifpe.missao03;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface EventoDAO extends JpaRepository<Evento, Integer> {

	
	public List<Evento> findByNomeEventoContainingIgnoreCase(String nomePesquisa);
}
