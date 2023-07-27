package mx.com.gm.servicio;

import java.util.List;
import mx.com.gm.domain.Perifericos;

public interface PerifericosService {

    public List<Perifericos> listarPerifericos();

    public void guardar(Perifericos perifericos);

    public void eliminar(Perifericos perifericos);

    public Perifericos obtenerPerifericosPorId(Long id);
    
}
