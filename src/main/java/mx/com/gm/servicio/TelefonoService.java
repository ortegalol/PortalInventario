package mx.com.gm.servicio;

import java.util.List;
import mx.com.gm.domain.Telefono;

public interface TelefonoService {

    public List<Telefono> listarTelefonos();

    public void guardar(Telefono telefono);

    public void eliminar(Telefono telefono);

    public Telefono obtenerTelefonoPorId(Long id);

    public void actualizar(Telefono telefono);
    
    public Telefono obtenerTelefonoPorSerie(String serie);
}
