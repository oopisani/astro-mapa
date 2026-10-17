package br.com.oopisani.astro_mapa.repository;

import br.com.oopisani.astro_mapa.model.Pin;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PinRepository extends JpaRepository<Pin, Long> {
}
