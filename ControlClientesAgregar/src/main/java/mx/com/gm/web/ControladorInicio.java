package mx.com.gm.web;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import lombok.extern.slf4j.Slf4j;
import lombok.var;
import mx.com.gm.domain.Inventario;

import mx.com.gm.servicio.InventarioService;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.core.userdetails.User;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

@Controller
@Slf4j
public class ControladorInicio {

    @Autowired
    private InventarioService inventarioService;

    @GetMapping("/")
    public String inicio(Model model, @AuthenticationPrincipal User user) {
        var inventario = inventarioService.listarInventarios();
        log.info("ejecutando el controlador Spring MVC");
        log.info("usuario que hizo login:" + user);
        model.addAttribute("personas", inventario);
        return "index";
    }

    @GetMapping("/agregar")
    public String agregar(Inventario inventario) {
        return "modificar";
    }

    @PostMapping("/guardar")
    public String guardar(Inventario inventario) {
        inventarioService.guardar(inventario);
        return "redirect:/";
    }

    @GetMapping("/editar/{idInventario}")
    public String editar(Inventario inventario, Model model) {
        inventario = inventarioService.encontrarInventario(inventario);
        model.addAttribute("inventario", inventario);
        return "modificar";
    }

    @GetMapping("/eliminar")
    public String eliminar(Inventario inventario) {
        inventarioService.eliminar(inventario);
        return "redirect:/";
    }

    @PostMapping("/import")
    public void mapReapExcelDatatoDB(@RequestParam("file") MultipartFile reapExcelDataFile) throws IOException {

        List<Inventario> tempInventarioList = new ArrayList<Inventario>();
        XSSFWorkbook workbook = new XSSFWorkbook(reapExcelDataFile.getInputStream());
        XSSFSheet worksheet = workbook.getSheetAt(0);

        for (int i = 1; i < worksheet.getPhysicalNumberOfRows(); i++) {
            Inventario tempInventario = new Inventario();

            XSSFRow row = worksheet.getRow(i);

            tempInventario.setNombre(row.getCell(0).getStringCellValue());
            tempInventario.setNumEmpleado((int) row.getCell(1).getNumericCellValue());
            tempInventario.setRfcEmpleado(row.getCell(2).getStringCellValue());
            tempInventario.setCurpEmpleado(row.getCell(3).getStringCellValue());
            tempInventario.setDepartamento(row.getCell(4).getStringCellValue());
            tempInventario.setPuesto(row.getCell(5).getStringCellValue());
            tempInventario.setEmail(row.getCell(6).getStringCellValue());
            tempInventario.setMarcaCpu(row.getCell(7).getStringCellValue());
            tempInventario.setModeloCpu(row.getCell(8).getStringCellValue());
            tempInventario.setSerieCpu(row.getCell(9).getStringCellValue());
            tempInventario.setMarcaMonitor(row.getCell(10).getStringCellValue());
            tempInventario.setModeloMonitor(row.getCell(11).getStringCellValue());
            tempInventario.setSerieMonitor(row.getCell(12).getStringCellValue());

            tempInventarioList.add(tempInventario);

        }

    }


}
