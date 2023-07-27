package mx.com.gm.dao;

import mx.com.gm.domain.Teclado;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TecladoDao extends JpaRepository<Teclado, Long> {
    Teclado findBySerieteclado(String serieteclado);
}
