package mx.com.gm.dao;

import mx.com.gm.domain.Pinpad;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PinpadDao extends JpaRepository<Pinpad, Long> {
    Pinpad findBySeriepinpad(String seriepinpad);
}

