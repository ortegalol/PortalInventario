package mx.com.gm.dao;

import mx.com.gm.domain.Impresora;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ImpresoraDao extends JpaRepository<Impresora, Long> {
    Impresora findBySerieimpresora(String serieimpresora);
}
