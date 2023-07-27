package mx.com.gm.dao;

import mx.com.gm.domain.Pc;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PcDao extends JpaRepository<Pc, Long> {

    Pc findBySeriepc(String seriepc);
}
