package mx.com.gm.servicio;

import java.util.List;
import mx.com.gm.dao.EmpleadoDao;
import mx.com.gm.domain.Empleado;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class EmpleadoServiceImpl implements EmpleadoService {

    @Autowired
    private EmpleadoDao empleadoDao;

    @Override
    @Transactional(readOnly = true)
    public List<Empleado> listarEmpleados() {
        return (List<Empleado>) empleadoDao.findAll();
    }

    @Override
    @Transactional
    public void guardar(Empleado empleado) {
        empleadoDao.save(empleado);
    }

    @Override
    @Transactional
    public void eliminar(Empleado empleado) {
        empleadoDao.delete(empleado);
    }

    @Override
    @Transactional(readOnly = true)
    public Empleado encontrarEmpleado(Empleado empleado) {
        return empleadoDao.findById(empleado.getIdempleado()).orElse(null);
    }

    @Override
    public void saveAll(List<Empleado> empleado) {
        empleadoDao.saveAll(empleado);
    }

    @Override
    @Transactional(readOnly = true)
    public Empleado obtenerEmpleadoPorId(Long id) {
        return empleadoDao.findById(id).orElse(null);
    }

    @Override
    public void actualizar(Empleado empleado) {
        // Obtén el empleado existente por su ID
        Empleado empleadoExistente = empleadoDao.findById(empleado.getIdempleado()).orElse(null);

        if (empleadoExistente != null) {
            // Actualiza los campos necesarios del empleado existente
            empleadoExistente.setNombre(empleado.getNombre());
            empleadoExistente.setNumempleado(empleado.getNumempleado());
            empleadoExistente.setRfc(empleado.getRfc());
            empleadoExistente.setCurp(empleado.getCurp());
            empleadoExistente.setDepartamento(empleado.getDepartamento());
            empleadoExistente.setPuesto(empleado.getPuesto());
            empleadoExistente.setEmail(empleado.getEmail());
            empleadoExistente.setExt(empleado.getExt());
            
            // Guarda los cambios en el empleado existente
            empleadoDao.save(empleadoExistente);
        }
    }

    @Override
    @Transactional(readOnly = true)
    public Empleado obtenerEmpleadoPorNumero(Integer numempleado) {
        return empleadoDao.findByNumempleado(numempleado);
    }

}
