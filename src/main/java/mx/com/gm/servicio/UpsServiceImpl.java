package mx.com.gm.servicio;

import java.util.List;
import mx.com.gm.dao.UpsDao;
import mx.com.gm.domain.Ups;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class UpsServiceImpl implements UpsService {

    @Autowired
    private UpsDao upsDao;

    @Override
    @Transactional(readOnly = true)
    public List<Ups> listarUps() {
        return (List<Ups>) upsDao.findAll();
    }

    @Override
    @Transactional
    public void guardar(Ups ups) {
        upsDao.save(ups);
    }

    @Override
    @Transactional
    public void eliminar(Ups ups) {
        upsDao.delete(ups);
    }

    @Override
    @Transactional(readOnly = true)
    public Ups obtenerUpsPorId(Long id) {
        return upsDao.findById(id).orElse(null);
    }

    @Override
    public void actualizar(Ups ups) {
        // Obtén el ups existente por su ID
        Ups upsExistente = upsDao.findById(ups.getIdups()).orElse(null);

        if (upsExistente != null) {
            // Actualiza los campos necesarios del ups existente
            upsExistente.setSerieups(ups.getSerieups());
            upsExistente.setMarcaups(ups.getMarcaups());
            upsExistente.setModeloups(ups.getModeloups());
            // Guarda los cambios en el ups existente
            upsDao.save(upsExistente);
        }

    }

    @Override
    @Transactional(readOnly = true)
    public Ups obtenerUpsPorSerie(String serieups) {
        return upsDao.findBySerieups(serieups);
    }
}
