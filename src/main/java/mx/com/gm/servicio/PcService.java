package mx.com.gm.servicio;

import java.util.List;
import mx.com.gm.domain.Pc;

public interface PcService {

    public List<Pc> listarPcs();

    public void guardar(Pc pc);

    public void eliminar(Pc pc);

    public Pc obtenerPcPorId(Long id);

    public void actualizar(Pc pc);

    public Pc obtenerPcPorSerie(String seriepc);

}
