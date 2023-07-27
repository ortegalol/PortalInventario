package mx.com.gm.servicio;

import java.util.List;
import mx.com.gm.domain.Ups;

public interface UpsService {

    public List<Ups> listarUps();

    public void guardar(Ups ups);

    public void eliminar(Ups ups);

    public Ups obtenerUpsPorId(Long id);

    public void actualizar(Ups ups);
    
    public Ups obtenerUpsPorSerie(String serieups);
}
