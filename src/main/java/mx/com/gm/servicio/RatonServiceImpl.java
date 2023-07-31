package mx.com.gm.servicio;

import java.util.List;
import mx.com.gm.dao.RatonDao;
import mx.com.gm.domain.Raton;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class RatonServiceImpl implements RatonService {

    @Autowired
    private RatonDao ratonDao;

    @Override
    @Transactional(readOnly = true)
    public List<Raton> listarRatones() {
        return (List<Raton>) ratonDao.findAll();
    }

    @Override
    @Transactional
    public void guardar(Raton raton) {
        ratonDao.save(raton);
    }

    @Override
    @Transactional
    public void eliminar(Raton raton) {
        ratonDao.delete(raton);
    }

    @Override
    @Transactional(readOnly = true)
    public Raton obtenerRatonPorId(Long id) {
        return ratonDao.findById(id).orElse(null);
    }

    @Override
    public void actualizar(Raton raton) {
        // Obtén el monitor existente por su ID
        Raton ratonExistente = ratonDao.findById(raton.getIdraton()).orElse(null);

        if (ratonExistente != null) {
            // Actualiza los campos necesarios del raton existente
            ratonExistente.setSerieraton(raton.getSerieraton());
            ratonExistente.setMarcaraton(raton.getMarcaraton());
            ratonExistente.setModeloraton(raton.getModeloraton());
            // Guarda los cambios en el monitor existente
            ratonDao.save(ratonExistente);
        }

    }

    @Override
    @Transactional(readOnly = true)
    public Raton obtenerRatonPorSerie(String serieraton) {
        return ratonDao.findBySerieraton(serieraton);
    }
}
