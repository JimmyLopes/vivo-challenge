package br.com.vivo.challenge.backend.repository;

import br.com.vivo.challenge.backend.domain.Volta;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface VoltaRepository extends CrudRepository<Volta, Integer> {
}
