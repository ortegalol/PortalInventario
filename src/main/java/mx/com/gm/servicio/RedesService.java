package mx.com.gm.servicio;

import java.util.List;
import mx.com.gm.domain.Redes;

public interface RedesService {

    public List<Redes> listarRedes();

    public void guardar(Redes redes);

    public void eliminar(Redes redes);

    public Redes obtenerRedesPorId(Long id);

}
