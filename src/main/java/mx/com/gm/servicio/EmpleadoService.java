package mx.com.gm.servicio;

import java.util.List;
import mx.com.gm.domain.Empleado;

public interface EmpleadoService {

    public List<Empleado> listarEmpleados();

    public void guardar(Empleado empleado);

    public void eliminar(Empleado empleado);

    public Empleado encontrarEmpleado(Empleado empleado);

    public void saveAll(List<Empleado> empleado);

    public Empleado obtenerEmpleadoPorId(Long id);

    public void actualizar(Empleado empleado);

    public Empleado obtenerEmpleadoPorNumero(Integer numempleado);

}
