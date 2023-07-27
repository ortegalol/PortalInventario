package mx.com.gm.dao;

import mx.com.gm.domain.Monitor;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MonitorDao extends JpaRepository<Monitor, Long> {
    Monitor findBySerie(String serie);
}
