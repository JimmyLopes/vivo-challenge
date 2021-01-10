package br.com.vivo.challenge.backend.repository;

import br.com.vivo.challenge.backend.domain.Heroi;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface HeroiRepository extends CrudRepository<Heroi, Integer> {
}
