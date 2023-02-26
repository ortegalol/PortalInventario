package mx.com.gm.servicio;

import java.util.List;
import mx.com.gm.dao.InventarioDao;
import mx.com.gm.domain.Inventario;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class InventarioServiceImpl implements InventarioService {

    @Autowired
    private InventarioDao inventarioDao;

    @Override
    @Transactional(readOnly = true)
    public List<Inventario> listarInventarios() {
        return (List<Inventario>) inventarioDao.findAll();
    }

    @Override
    @Transactional
    public void guardar(Inventario inventario) {
        inventarioDao.save(inventario);
    }

    @Override
    @Transactional
    public void eliminar(Inventario inventario) {
        inventarioDao.delete(inventario);
    }

    @Override
    @Transactional(readOnly = true)
    public Inventario encontrarInventario(Inventario inventario) {
        return inventarioDao.findById(inventario.getIdInventario()).orElse(null);
    }

    @Override
    public void saveAll(List<Inventario> inventarios) {
        inventarioDao.saveAll(inventarios);
    }


}
