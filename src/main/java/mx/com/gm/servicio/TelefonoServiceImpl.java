package mx.com.gm.servicio;

import java.util.List;
import mx.com.gm.dao.TelefonoDao;
import mx.com.gm.domain.Telefono;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class TelefonoServiceImpl implements TelefonoService {

    @Autowired
    private TelefonoDao telefonoDao;

    @Override
    @Transactional(readOnly = true)
    public List<Telefono> listarTelefonos() {
        return (List<Telefono>) telefonoDao.findAll();
    }

    @Override
    @Transactional
    public void guardar(Telefono telefono) {
        telefonoDao.save(telefono);
    }

    @Override
    @Transactional
    public void eliminar(Telefono telefono) {
        telefonoDao.delete(telefono);
    }

    @Override
    @Transactional(readOnly = true)
    public Telefono obtenerTelefonoPorId(Long id) {
        return telefonoDao.findById(id).orElse(null);
    }

    @Override
    public void actualizar(Telefono telefono) {
        // Obtén el telefono existente por su ID
        Telefono telefonoExistente = telefonoDao.findById(telefono.getIdtelefono()).orElse(null);

        if (telefonoExistente != null) {
            // Actualiza los campos necesarios del telefono existente
            telefonoExistente.setSerietelefono(telefono.getSerietelefono());
            telefonoExistente.setMarcatelefono(telefono.getMarcatelefono());
            telefonoExistente.setModelotelefono(telefono.getModelotelefono());
            // Guarda los cambios en el telefono existente
            telefonoDao.save(telefonoExistente);
        }

    }

    @Override
    @Transactional(readOnly = true)
    public Telefono obtenerTelefonoPorSerie(String serietelefono) {
        return telefonoDao.findBySerietelefono(serietelefono);
    }
}
