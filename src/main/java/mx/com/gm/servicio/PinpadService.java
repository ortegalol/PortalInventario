package mx.com.gm.servicio;

import java.util.List;
import mx.com.gm.domain.Pinpad;

public interface PinpadService {

    public List<Pinpad> listarPinpad();

    public void guardar(Pinpad pinpad);

    public void eliminar(Pinpad pinpad);

    public Pinpad obtenerPinpadPorId(Long id);

    public void actualizar(Pinpad pinpad);
    
    public Pinpad obtenerPinpadPorSerie(String seriepinpad);
}
