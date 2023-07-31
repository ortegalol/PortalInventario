package mx.com.gm.servicio;

import java.util.List;
import mx.com.gm.dao.ImpresoraDao;
import mx.com.gm.domain.Impresora;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class ImpresoraServiceImpl implements ImpresoraService {

    @Autowired
    private ImpresoraDao impresoraDao;

    @Override
    @Transactional(readOnly = true)
    public List<Impresora> listarImpresoras() {
        return (List<Impresora>) impresoraDao.findAll();
    }

    @Override
    @Transactional
    public void guardar(Impresora impresora) {
        impresoraDao.save(impresora);
    }

    @Override
    @Transactional
    public void eliminar(Impresora impresora) {
        impresoraDao.delete(impresora);
    }

    @Override
    @Transactional(readOnly = true)
    public Impresora obtenerImpresoraPorId(Long id) {
        return impresoraDao.findById(id).orElse(null);
    }

    @Override
    public void actualizar(Impresora impresora) {
        // Obtén el impresora existente por su ID
        Impresora impresoraExistente = impresoraDao.findById(impresora.getIdimpresora()).orElse(null);

        if (impresoraExistente != null) {
            // Actualiza los campos necesarios del impresora existente
            impresoraExistente.setSerieimpresora(impresora.getSerieimpresora());
            impresoraExistente.setMarcaimpresora(impresora.getMarcaimpresora());
            impresoraExistente.setModeloimpresora(impresora.getModeloimpresora());
            // Guarda los cambios en el impresora existente
            impresoraDao.save(impresoraExistente);
        }

    }

    @Override
    @Transactional(readOnly = true)
    public Impresora obtenerImpresorasPorSerie(String serieimpresora) {
        return impresoraDao.findBySerieimpresora(serieimpresora);
    }
}
