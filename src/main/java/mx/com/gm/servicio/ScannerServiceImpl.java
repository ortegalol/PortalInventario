package mx.com.gm.servicio;

import java.util.List;
import mx.com.gm.dao.ScannerDao;
import mx.com.gm.domain.Scanner;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class ScannerServiceImpl implements ScannerService {

    @Autowired
    private ScannerDao scannerDao;

    @Override
    @Transactional(readOnly = true)
    public List<Scanner> listarScanneres() {
        return (List<Scanner>) scannerDao.findAll();
    }

    @Override
    @Transactional
    public void guardar(Scanner scanner) {
        scannerDao.save(scanner);
    }

    @Override
    @Transactional
    public void eliminar(Scanner scanner) {
        scannerDao.delete(scanner);
    }

    @Override
    @Transactional(readOnly = true)
    public Scanner obtenerScannerPorId(Long id) {
        return scannerDao.findById(id).orElse(null);
    }

    @Override
    public void actualizar(Scanner scanner) {
        // Obtén el scanner existente por su ID
        Scanner scannerExistente = scannerDao.findById(scanner.getIdscanner()).orElse(null);

        if (scannerExistente != null) {
            // Actualiza los campos necesarios del scanner existente
            scannerExistente.setSeriescanner(scanner.getSeriescanner());
            scannerExistente.setMarcascanner(scanner.getMarcascanner());
            scannerExistente.setModeloscanner(scanner.getModeloscanner());
            // Guarda los cambios en el scanner existente
            scannerDao.save(scannerExistente);
        }

    }

    @Override
    @Transactional(readOnly = true)
    public Scanner obtenerScannerPorSerie(String seriescanner) {
        return scannerDao.findBySeriescanner(seriescanner);
    }
}
