package mx.com.gm.dao;

import mx.com.gm.domain.Ups;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UpsDao extends JpaRepository<Ups, Long> {
    Ups findBySerieups(String serieups);
}
