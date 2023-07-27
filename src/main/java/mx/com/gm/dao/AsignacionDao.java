package mx.com.gm.dao;

import mx.com.gm.domain.Asignacion;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AsignacionDao extends JpaRepository<Asignacion, Long> {
    
}
