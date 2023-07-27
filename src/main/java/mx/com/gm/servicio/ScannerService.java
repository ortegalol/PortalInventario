package mx.com.gm.servicio;

import java.util.List;
import mx.com.gm.domain.Scanner;

public interface ScannerService {

    public List<Scanner> listarScanneres();

    public void guardar(Scanner scanner);

    public void eliminar(Scanner scanner);

    public Scanner obtenerScannerPorId(Long id);

    public void actualizar(Scanner scanner);
    
    public Scanner obtenerScannerPorSerie(String seriescanner);
}
