package mx.com.gm.web;

import java.util.List;
import java.util.stream.Collectors;
import lombok.extern.slf4j.Slf4j;
import lombok.var;
import mx.com.gm.domain.Asignacion;
import mx.com.gm.domain.Empleado;
import mx.com.gm.domain.Monitor;
import mx.com.gm.domain.Pc;
import mx.com.gm.domain.Perifericos;
import mx.com.gm.domain.Raton;
import mx.com.gm.domain.Teclado;
import mx.com.gm.domain.Ups;
import mx.com.gm.servicio.AsignacionService;
import mx.com.gm.servicio.AsignacioncomService;
import mx.com.gm.servicio.EmpleadoService;
import mx.com.gm.servicio.ImpresoraService;
import mx.com.gm.servicio.MonitorService;
import mx.com.gm.servicio.PcService;
import mx.com.gm.servicio.PinpadService;
import mx.com.gm.servicio.RatonService;
import mx.com.gm.servicio.ScannerService;
import mx.com.gm.servicio.TecladoService;
import mx.com.gm.servicio.TelefonoService;
import mx.com.gm.servicio.UpsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.core.userdetails.User;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@Slf4j
public class ControladorInicio {

    @Autowired
    private EmpleadoService empleadoService;

    @Autowired
    private PcService pcService;
    @Autowired
    private MonitorService monitorService;
    @Autowired
    private TecladoService tecladoService;
    @Autowired
    private RatonService ratonService;
    @Autowired
    private UpsService upsService;
    @Autowired
    private ImpresoraService impresoraService;
    @Autowired
    private ScannerService scannerService;
    @Autowired
    private TelefonoService telefonoService;
    @Autowired
    private PinpadService pinpadService;

    @Autowired
    private AsignacionService asignacionService;
    @Autowired
    private AsignacioncomService asignacioncomService;

//  --------------------- Pagina inicial ---------------------
    @GetMapping("/")
    public String inicio() {
        return "home";
    }

//  --------------------- Tablas ---------------------
    @GetMapping("/empleados")
    public String empleados(Model model, @AuthenticationPrincipal User user) {
        var empleado = empleadoService.listarEmpleados();
        model.addAttribute("empleados", empleado);
        return "empleados";
    }

    @GetMapping("/pcs")
    public String pcs(Model model, @AuthenticationPrincipal User user) {
        var pc = pcService.listarPcs();
        model.addAttribute("pcs", pc);
        return "pcs";
    }

    @GetMapping("/monitores")
    public String monitores(Model model, @AuthenticationPrincipal User user) {
        var monitor = monitorService.listarMonitores();
        model.addAttribute("monitores", monitor);
        return "monitores";
    }

    @GetMapping("/asignaciones")
    public String asignaciones(Model model, @AuthenticationPrincipal User user) {
        var asignacioncom = asignacioncomService.listarAsignaciones();
        model.addAttribute("asignaciones", asignacioncom);
        return "asignaciones";
    }

    @GetMapping("/teclados")
    public String teclados(Model model, @AuthenticationPrincipal User user) {
        var teclado = tecladoService.listarTeclados();
        model.addAttribute("teclados", teclado);
        return "teclados";
    }
//
//    @GetMapping("/ratones")
//    public String ratones(Model model, @AuthenticationPrincipal User user) {
//        var raton = ratonService.listarRatones();
//        model.addAttribute("ratones", raton);
//        return "ratones";
//    }
//    
//    @GetMapping("/ups")
//    public String ups(Model model, @AuthenticationPrincipal User user) {
//        var ups = upsService.listarUps();
//        model.addAttribute("ups", ups);
//        return "ups";
//    }
//
//    @GetMapping("/impresoras")
//    public String impresoras(Model model, @AuthenticationPrincipal User user) {
//        var impresora = impresoraService.listarImpresoras();
//        model.addAttribute("impresoras", impresora);
//        return "impresoras";
//    }
//
//    @GetMapping("/scanneres")
//    public String Scanneres(Model model, @AuthenticationPrincipal User user) {
//        var scanner = scannerService.listarScanneres();
//        model.addAttribute("scanneres", scanner);
//        return "scanneres";
//    }
//
//    @GetMapping("/telefonos")
//    public String Telefonos(Model model, @AuthenticationPrincipal User user) {
//        var telefono = telefonoService.listarTelefonos();
//        model.addAttribute("telefonos", telefono);
//        return "telefonos";
//    }
//
//    @GetMapping("/pinpads")
//    public String Pinpads(Model model, @AuthenticationPrincipal User user) {
//        var pinpad = Service.listarPinpads();
//        model.addAttribute("pinpads", pinpad);
//        return "pinpads";
//    }    

//  --------------------- Formularios ---------------------
//    @GetMapping("/alta_asignacion")
//    public String alta_asignacion(Model model) {
//        List<Empleado> empleados = empleadoService.listarEmpleados();
//
//        List<Pc> pcs = pcService.listarPcs().stream().filter(pc -> !pc.isStatus()).collect(Collectors.toList());
//
//        model.addAttribute("empleados", empleados);
//        model.addAttribute("pcs", pcs);
//        return "alta_asignacion";
//    }
    @GetMapping("/alta_asignacion")
    public String alta_asignacion(Model model) {
        List<Empleado> empleados = empleadoService.listarEmpleados();

        List<Pc> pcs = pcService.listarPcs().stream().filter(pc -> !pc.isStatus()).collect(Collectors.toList());

        List<Monitor> monitores = monitorService.listarMonitores().stream().filter(monitor -> !monitor.isStatus()).collect(Collectors.toList());

        model.addAttribute("empleados", empleados);
        model.addAttribute("monitores", monitores);
        model.addAttribute("pcs", pcs);
        return "alta_asignacion";
    }

    @GetMapping("/altas")
    public String altas(Model model) {

        Empleado empleado = new Empleado();

        Pc pc = new Pc();
        Monitor monitor = new Monitor();
        Perifericos perifericos = new Perifericos();

        model.addAttribute("empleado", empleado);

        model.addAttribute("pc", pc);
        model.addAttribute("monitor", monitor);
        model.addAttribute("perifericos", perifericos);

        return "altas";
    }

//  --------------------- Funciones Formulario ---------------------
    @PostMapping("/guardarEmpleado")
    public String guardarEmpleado(@ModelAttribute Empleado empleado) {
        empleadoService.guardar(empleado);
        return "redirect:/empleados";
    }

    @PostMapping("/guardarMonitor")
    public String guardarMonitor(@ModelAttribute Monitor monitor) {
        monitorService.guardar(monitor);
        return "redirect:/monitores";
    }

    @PostMapping("/guardarPc")
    public String guardarPc(@ModelAttribute Pc pc) {
        pcService.guardar(pc);
        return "redirect:/pcs";
    }

    @PostMapping("/guardarTeclado")
    public String guardarTeclado(@ModelAttribute Teclado teclado) {
        tecladoService.guardar(teclado);
        return "redirect:/teclados";
    }

//    @PostMapping("/guardarRaton")
//    public String guardarRaton(@ModelAttribute Raton raton) {
//        ratonService.guardar(raton);
//        return "redirect:/ratones";
//    }
//    @PostMapping("/guardarUps")
//    public String guardarUps(@ModelAttribute Ups ups) {
//        upsService.guardar(ups);
//        return "redirect:/ups";
//    }
//    @PostMapping("/guardarImpresora")
//    public String guardarImpresora(@ModelAttribute Impresora impresora) {
//        impresoraService.guardar(impresora);
//        return "redirect:/impresoras";
//    }
//    @PostMapping("/guardarScanner")
//    public String guardarScanner(@ModelAttribute Scanner scanner) {
//        scannerService.guardar(scanner);
//        return "redirect:/scanneres";
//    }
//    @PostMapping("/guardarTelefono")
//    public String guardarTelefono(@ModelAttribute Telefono telefono) {
//        telefonoService.guardar(telefono);
//        return "redirect:/telefonos";
//    }
//    @PostMapping("/guardarPinpad")
//    public String guardarPinpad(@ModelAttribute Pinpad pinpad) {
//        pinpadService.guardar(pinpad);
//        return "redirect:/pinpads";
//    }
//  --------------------- Eliminacion Tablas ---------------------    
    @GetMapping("/eliminarempl")
    public String eliminarEmpleado(@RequestParam("idEmpleado") Long idEmpleado) {
        Empleado empleado = empleadoService.obtenerEmpleadoPorId(idEmpleado);
        empleadoService.eliminar(empleado);
        return "redirect:/empleados";
    }

    @GetMapping("/eliminarpc")
    public String eliminarPc(@RequestParam("idpc") Long idpc) {
        Pc pc = pcService.obtenerPcPorId(idpc);
        pcService.eliminar(pc);
        return "redirect:/pcs";
    }

    @GetMapping("/eliminarmoni")
    public String eliminarMonitor(@RequestParam("idMoni") Long idMoni) {
        Monitor monitor = monitorService.obtenerMonitorPorId(idMoni);
        monitorService.eliminar(monitor);
        return "redirect:/monitores";
    }

    //  --------------------- Edicion Tablas ---------------------  
    @GetMapping("/editarempl/{idEmpleado}")
    public String editarEmpleado(@PathVariable("idEmpleado") Long idEmpleado, Model model) {
        Empleado empleado = empleadoService.obtenerEmpleadoPorId(idEmpleado);
        model.addAttribute("empleado", empleado);
        return "editempleado";
    }

    @GetMapping("/editarpc/{idPc}")
    public String editarPc(@PathVariable("idPc") Long idPc, Model model) {
        Pc pc = pcService.obtenerPcPorId(idPc);
        model.addAttribute("pc", pc);
        return "editpc";
    }

    @GetMapping("/editarmonitor/{idMoni}")
    public String editarMonitor(@PathVariable("idMoni") Long idMoni, Model model) {
        Monitor monitor = monitorService.obtenerMonitorPorId(idMoni);
        model.addAttribute("monitor", monitor);
        return "editmonitor";
    }

    //  --------------------- Edicion Funcion ---------------------  
    @PostMapping("/actualizarEmpleado/{idempleado}")
    public String actualizarEmpleado(@PathVariable("idempleado") Long idempleado, @ModelAttribute Empleado empleado) {
        empleado.setIdempleado(idempleado);
        empleadoService.actualizar(empleado);
        return "redirect:/empleados";
    }

    @PostMapping("/actualizarPc/{idpc}")
    public String actualizarPc(@PathVariable("idpc") Long idpc, @ModelAttribute Pc pc) {
        pc.setIdpc(idpc);
        pcService.actualizar(pc);
        return "redirect:/pcs";
    }

    @PostMapping("/actualizarMonitor/{idmoni}")
    public String actualizarMonitor(@PathVariable("idmoni") Long idmoni, @ModelAttribute Monitor monitor) {
        monitor.setIdmoni(idmoni);
        monitorService.actualizar(monitor);
        return "redirect:/monitores";
    }

    //  --------------------- Llenado Asignacion ---------------------  
    @GetMapping("/empleado/{numempleado}")
    @ResponseBody
    public Empleado obtenerEmpleadoPorNumero(@PathVariable Integer numempleado) {
        return empleadoService.obtenerEmpleadoPorNumero(numempleado);
    }

    @GetMapping("/pc/{seriepc}")
    @ResponseBody
    public Pc obtenerPcPorSerie(@PathVariable String seriepc) {
        return pcService.obtenerPcPorSerie(seriepc);
    }

    @GetMapping("/monitor/{serie}")
    @ResponseBody
    public Monitor obtenerMoniPorSerie(@PathVariable String serie) {
        return monitorService.obtenerMoniPorSerie(serie);
    }

    //  --------------------- Asignacion Funcion ---------------------  
    @PostMapping("/asignarEmpleado")
    public String asignarEmpleado(@RequestParam("idempleado") Integer idEmpleado,
            @RequestParam(value = "idpc", required = false) Integer idPc,
            @RequestParam(value = "idmoni", required = false) Integer idMoni) {

        Asignacion asignacion = new Asignacion();
        asignacion.setIdempleado(idEmpleado);
        asignacion.setIdpc(idPc);
        asignacion.setIdmoni(idMoni);

        asignacionService.guardar(asignacion);

        return "redirect:/";
    }

}
