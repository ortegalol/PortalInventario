package mx.com.gm.servicio;

import java.util.List;
import mx.com.gm.dao.AsignacionDao;
import mx.com.gm.domain.Asignacion;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class AsignacionServiceImpl implements AsignacionService {

    @Autowired
    private AsignacionDao asignacionDao;

    @Override
    @Transactional(readOnly = true)
    public List<Asignacion> listarAsignaciones() {
        return (List<Asignacion>) asignacionDao.findAll();
    }

    @Override
    @Transactional
    public void guardar(Asignacion asignacion) {
        asignacionDao.save(asignacion);
    }

    @Override
    @Transactional
    public void eliminar(Asignacion asignacion) {
        asignacionDao.delete(asignacion);
    }

    @Override
    public void saveAll(List<Asignacion> asignacion) {
        asignacionDao.saveAll(asignacion);
    }

    @Override
    public Asignacion obtenerAsignacionPorId(Long id) {
        return asignacionDao.findById(id).orElse(null);
    }

    @Override
    @Transactional
    public void actualizar(Asignacion asignacion) {
        asignacionDao.save(asignacion);
    }
}
