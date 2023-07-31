package mx.com.gm.servicio;

import java.util.List;
import mx.com.gm.dao.PinpadDao;
import mx.com.gm.domain.Pinpad;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class PinpadServiceImpl implements PinpadService {

    @Autowired
    private PinpadDao pinpadDao;

    @Override
    @Transactional(readOnly = true)
    public List<Pinpad> listarPinpad() {
        return (List<Pinpad>) pinpadDao.findAll();
    }

    @Override
    @Transactional
    public void guardar(Pinpad pinpad) {
        pinpadDao.save(pinpad);
    }

    @Override
    @Transactional
    public void eliminar(Pinpad pinpad) {
        pinpadDao.delete(pinpad);
    }

    @Override
    @Transactional(readOnly = true)
    public Pinpad obtenerPinpadPorId(Long id) {
        return pinpadDao.findById(id).orElse(null);
    }

    @Override
    public void actualizar(Pinpad pinpad) {
        // Obtén el pinpad existente por su ID
        Pinpad pinpadExistente = pinpadDao.findById(pinpad.getIdpinpad()).orElse(null);

        if (pinpadExistente != null) {
            // Actualiza los campos necesarios del pinpad existente
            pinpadExistente.setSeriepinpad(pinpad.getSeriepinpad());
            pinpadExistente.setMarcapinpad(pinpad.getMarcapinpad());
            pinpadExistente.setModelopinpad(pinpad.getModelopinpad());
            // Guarda los cambios en el pinpad existente
            pinpadDao.save(pinpadExistente);
        }

    }

    @Override
    @Transactional(readOnly = true)
    public Pinpad obtenerPinpadPorSerie(String seriepinpad) {
        return pinpadDao.findBySeriepinpad(seriepinpad);
    }
}
