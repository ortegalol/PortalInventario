package mx.com.gm.dao;

import mx.com.gm.domain.Telefono;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TelefonoDao extends JpaRepository<Telefono, Long> {
    Telefono findBySerietelefono(String serietelefono);
}
