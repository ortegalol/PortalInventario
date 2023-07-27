package mx.com.gm.servicio;

import java.util.List;
import mx.com.gm.dao.PerifericosDao;
import mx.com.gm.domain.Perifericos;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class PerifericosServiceImpl implements PerifericosService {

    @Autowired
    private PerifericosDao perifericosDao;

    @Override
    @Transactional(readOnly = true)
    public List<Perifericos> listarPerifericos() {
        return (List<Perifericos>) perifericosDao.findAll();
    }

    @Override
    @Transactional
    public void guardar(Perifericos perifericos) {
        perifericosDao.save(perifericos);
    }

    @Override
    @Transactional
    public void eliminar(Perifericos perifericos) {
        perifericosDao.delete(perifericos);
    }

    @Override
    @Transactional(readOnly = true)
    public Perifericos obtenerPerifericosPorId(Long id) {
        return perifericosDao.findById(id).orElse(null);
    }

}
