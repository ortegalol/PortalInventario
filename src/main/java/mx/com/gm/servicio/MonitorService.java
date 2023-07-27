package mx.com.gm.servicio;

import java.util.List;
import mx.com.gm.domain.Monitor;

public interface MonitorService {

    public List<Monitor> listarMonitores();

    public void guardar(Monitor monitor);

    public void eliminar(Monitor monitor);

    public Monitor obtenerMonitorPorId(Long id);

    public void actualizar(Monitor monitor);
    
    public Monitor obtenerMoniPorSerie(String serie);
}
