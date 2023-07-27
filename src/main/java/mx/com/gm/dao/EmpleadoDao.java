package mx.com.gm.dao;

import mx.com.gm.domain.Empleado;
import org.springframework.data.repository.CrudRepository;

public interface EmpleadoDao extends CrudRepository<Empleado, Long> {

    Empleado findByNumempleado(Integer numempleado);

}
