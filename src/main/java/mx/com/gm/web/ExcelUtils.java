package mx.com.gm.web;

import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;
import mx.com.gm.domain.Empleado;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

public class ExcelUtils {

    public static List<Empleado> parseExcelFile(InputStream inputStream) throws IOException {
        List<Empleado> empleados = new ArrayList<>();
        try ( Workbook workbook = WorkbookFactory.create(inputStream)) {
            Sheet sheet = workbook.getSheetAt(0);
            for (Row row : sheet) {
                if (row.getRowNum() == 0) {
                    continue; 
                }

                Empleado empleado = new Empleado();
                empleado.setNombre(row.getCell(0).getStringCellValue());
                empleado.setNumempleado((int) row.getCell(1).getNumericCellValue());
                empleado.setRfc(row.getCell(2).getStringCellValue());
                empleado.setCurp(row.getCell(3).getStringCellValue());
                empleado.setDepartamento(row.getCell(4).getStringCellValue());
                empleado.setPuesto(row.getCell(5).getStringCellValue());
                empleado.setEmail(row.getCell(6).getStringCellValue());
                empleado.setExt((int) row.getCell(7).getNumericCellValue());

                empleados.add(empleado);
            }
        }
        return empleados;
    }
}
