package mx.com.gm.servicio;

import java.util.List;
import mx.com.gm.dao.PcDao;
import mx.com.gm.domain.Pc;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class PcServiceImpl implements PcService {

    @Autowired
    private PcDao pcDao;

    @Override
    @Transactional(readOnly = true)
    public List<Pc> listarPcs() {
        return (List<Pc>) pcDao.findAll();
    }

    @Override
    @Transactional
    public void guardar(Pc pc) {
        pcDao.save(pc);
    }

    @Override
    @Transactional
    public void eliminar(Pc pc) {
        pcDao.delete(pc);
    }

    @Override
    @Transactional(readOnly = true)
    public Pc obtenerPcPorId(Long id) {
        return pcDao.findById(id).orElse(null);
    }

    @Override
    public void actualizar(Pc pc) {
        // Obtén el pc existente por su ID
        Pc pcExistente = pcDao.findById(pc.getIdpc()).orElse(null);

        if (pcExistente != null) {
            // Actualiza los campos necesarios del pc existente
            pcExistente.setSeriepc(pc.getSeriepc());
            pcExistente.setMarcapc(pc.getMarcapc());
            pcExistente.setModelopc(pc.getModelopc());
            pcExistente.setProcesador(pc.getProcesador());
            pcExistente.setVelocidad(pc.getVelocidad());
            pcExistente.setMemoriaram(pc.getMemoriaram());
            pcExistente.setAlmacenamiento(pc.getAlmacenamiento());
            pcExistente.setOrigen(pc.getOrigen());
            pcExistente.setEstado(pc.getEstado());

            // Guarda los cambios en el pc existente
            pcDao.save(pcExistente);
        }
    }

    @Override
    @Transactional(readOnly = true)
    public Pc obtenerPcPorSerie(String seriepc) {
        return pcDao.findBySeriepc(seriepc);
    }
}
