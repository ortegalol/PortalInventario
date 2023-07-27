package mx.com.gm.servicio;

import java.util.List;
import mx.com.gm.domain.Impresora;

public interface ImpresoraService {

    public List<Impresora> listarImpresoras();

    public void guardar(Impresora impresora);

    public void eliminar(Impresora impresora);

    public Impresora obtenerImpresoraPorId(Long id);

    public void actualizar(Impresora impresora);
    
    public Impresora obtenerImpresorasPorSerie(String serieimpresora);
}
