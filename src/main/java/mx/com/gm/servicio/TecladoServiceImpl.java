package mx.com.gm.servicio;

import java.util.List;
import mx.com.gm.dao.TecladoDao;
import mx.com.gm.domain.Teclado;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class TecladoServiceImpl implements TecladoService {

    @Autowired
    private TecladoDao tecladoDao;

    @Override
    @Transactional(readOnly = true)
    public List<Teclado> listarTeclados() {
        return (List<Teclado>) tecladoDao.findAll();
    }

    @Override
    @Transactional
    public void guardar(Teclado teclado) {
        tecladoDao.save(teclado);
    }

    @Override
    @Transactional
    public void eliminar(Teclado teclado) {
        tecladoDao.delete(teclado);
    }

    @Override
    @Transactional(readOnly = true)
    public Teclado obtenerTecladoPorId(Long id) {
        return tecladoDao.findById(id).orElse(null);
    }

    @Override
    public void actualizar(Teclado teclado) {
        // Obtén el monitor existente por su ID
        Teclado tecladoExistente = tecladoDao.findById(teclado.getIdteclado()).orElse(null);

        if (tecladoExistente != null) {
            // Actualiza los campos necesarios del monitor existente
            tecladoExistente.setSerieteclado(teclado.getSerieteclado());
            tecladoExistente.setMarcateclado(teclado.getMarcateclado());
            tecladoExistente.setModeloteclado(teclado.getModeloteclado());
            // Guarda los cambios en el monitor existente
            tecladoDao.save(tecladoExistente);
        }

    }

    @Override
    @Transactional(readOnly = true)
    public Teclado obtenerTecladoPorSerie(String serieteclado) {
        return tecladoDao.findBySerieteclado(serieteclado);
    }
}
