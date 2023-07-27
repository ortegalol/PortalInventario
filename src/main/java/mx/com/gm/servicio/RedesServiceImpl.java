package mx.com.gm.servicio;

import java.util.List;
import mx.com.gm.dao.RedesDao;
import mx.com.gm.domain.Redes;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class RedesServiceImpl implements RedesService {
    
    @Autowired
    private RedesDao redesDao;

    @Override
    @Transactional(readOnly = true)
    public List<Redes> listarRedes() {
        return (List<Redes>) redesDao.findAll();
    }

    @Override
    @Transactional
    public void guardar(Redes redes) {
        redesDao.save(redes);
    }

    @Override
    @Transactional
    public void eliminar(Redes redes) {
        redesDao.delete(redes);
    }

    @Override
    @Transactional(readOnly = true)
    public Redes obtenerRedesPorId(Long id) {
        return redesDao.findById(id).orElse(null);
    }

}
