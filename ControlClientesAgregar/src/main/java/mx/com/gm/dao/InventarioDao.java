package mx.com.gm.dao;

import mx.com.gm.domain.Inventario;
import org.springframework.data.jpa.repository.JpaRepository;

public interface InventarioDao extends JpaRepository<Inventario, Long>{ 
    
}
