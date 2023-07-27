package mx.com.gm.dao;

import mx.com.gm.domain.Raton;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RatonDao extends JpaRepository<Raton, Long> {
    Raton findBySerieraton(String serieraton);
}
