package mx.com.gm.servicio;

import java.util.List;
import mx.com.gm.domain.Inventario;

public interface InventarioService {

    public List<Inventario> listarInventarios();

    public void guardar(Inventario inventario);

    public void eliminar(Inventario inventario);

    public Inventario encontrarInventario(Inventario inventario);

    public void saveAll(List<Inventario> inventarios);
    
}
