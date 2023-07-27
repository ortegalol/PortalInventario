package mx.com.gm.servicio;

import java.util.List;
import mx.com.gm.domain.Asignacioncom;

public interface AsignacioncomService {
 
    public List<Asignacioncom> listarAsignaciones();

    public void guardar(Asignacioncom asignacioncom);

    public void eliminar(Asignacioncom asignacioncom);

    public void saveAll(List<Asignacioncom> asignacioncom);

    public Asignacioncom obtenerAsignacionPorId(Long id);
    
    public void actualizar(Asignacioncom asignacioncom);
}
