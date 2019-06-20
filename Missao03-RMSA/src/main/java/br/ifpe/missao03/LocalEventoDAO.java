package br.ifpe.missao03;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface LocalEventoDAO extends JpaRepository<LocalEvento, Integer> {

}
