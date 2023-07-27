package mx.com.gm.servicio;

import java.util.List;
import mx.com.gm.dao.AsignacionComDao;
import mx.com.gm.domain.Asignacioncom;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class AsignacioncomServiceImpl implements AsignacioncomService {

    @Autowired
    private AsignacionComDao asignacionComDao;

    @Override
    @Transactional(readOnly = true)
    public List<Asignacioncom> listarAsignaciones() {
        return (List<Asignacioncom>) asignacionComDao.findAll();
    }

    @Override
    @Transactional
    public void guardar(Asignacioncom asignacioncom) {
        asignacionComDao.save(asignacioncom);
    }

    @Override
    @Transactional
    public void eliminar(Asignacioncom asignacioncom) {
        asignacionComDao.delete(asignacioncom);
    }

    @Override
    public void saveAll(List<Asignacioncom> asignacioncom) {
        asignacionComDao.saveAll(asignacioncom);
    }

    @Override
    public Asignacioncom obtenerAsignacionPorId(Long id) {
        return asignacionComDao.findById(id).orElse(null);
    }

    @Override
    @Transactional
    public void actualizar(Asignacioncom asignacioncom) {
        asignacionComDao.save(asignacioncom);
    }
}
