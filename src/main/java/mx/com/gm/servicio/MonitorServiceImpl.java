package mx.com.gm.servicio;

import java.util.List;
import mx.com.gm.dao.MonitorDao;
import mx.com.gm.domain.Monitor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class MonitorServiceImpl implements MonitorService {

    @Autowired
    private MonitorDao monitorDao;

    @Override
    @Transactional(readOnly = true)
    public List<Monitor> listarMonitores() {
        return (List<Monitor>) monitorDao.findAll();
    }

    @Override
    @Transactional
    public void guardar(Monitor monitor) {
        monitorDao.save(monitor);
    }

    @Override
    @Transactional
    public void eliminar(Monitor monitor) {
        monitorDao.delete(monitor);
    }

    @Override
    @Transactional(readOnly = true)
    public Monitor obtenerMonitorPorId(Long id) {
        return monitorDao.findById(id).orElse(null);
    }

    @Override
    public void actualizar(Monitor monitor) {
        // Obtén el monitor existente por su ID
        Monitor monitorExistente = monitorDao.findById(monitor.getIdmoni()).orElse(null);

        if (monitorExistente != null) {
            // Actualiza los campos necesarios del monitor existente
            monitorExistente.setSerie(monitor.getSerie());
            monitorExistente.setMarca(monitor.getMarca());
            monitorExistente.setModelo(monitor.getModelo());
            // Guarda los cambios en el monitor existente
            monitorDao.save(monitorExistente);
        }

    }

    @Override
    @Transactional(readOnly = true)
    public Monitor obtenerMoniPorSerie(String serie) {
        return monitorDao.findBySerie(serie);
    }
}
