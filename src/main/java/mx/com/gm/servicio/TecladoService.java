package mx.com.gm.servicio;

import java.util.List;
import mx.com.gm.domain.Teclado;

public interface TecladoService {

    public List<Teclado> listarTeclados();

    public void guardar(Teclado teclado);

    public void eliminar(Teclado teclado);

    public Teclado obtenerTecladoPorId(Long id);

    public void actualizar(Teclado teclado);
    
    public Teclado obtenerTecladoPorSerie(String serieteclado);
}
