package mx.com.gm.servicio;

import java.util.List;
import mx.com.gm.domain.Raton;

public interface RatonService {

    public List<Raton> listarRatones();

    public void guardar(Raton raton);

    public void eliminar(Raton raton);

    public Raton obtenerRatonPorId(Long id);

    public void actualizar(Raton raton);
    
    public Raton obtenerRatonPorSerie(String serieraton);
}
