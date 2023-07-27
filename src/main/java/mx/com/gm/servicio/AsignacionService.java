package mx.com.gm.servicio;

import java.util.List;
import mx.com.gm.domain.Asignacion;

public interface AsignacionService {
 
    public List<Asignacion> listarAsignaciones();

    public void guardar(Asignacion asignacion);

    public void eliminar(Asignacion asignacion);

    public void saveAll(List<Asignacion> asignacion);

    public Asignacion obtenerAsignacionPorId(Long id);
    
    public void actualizar(Asignacion asignacion);
}
