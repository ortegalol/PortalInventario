//  --------------------- Ubicación ---------------------
package mx.com.gm.web;

//  --------------------- Imports ---------------------
import java.util.List;
import java.util.stream.Collectors;
import lombok.extern.slf4j.Slf4j;
import lombok.var;
import mx.com.gm.domain.Asignacion;
import mx.com.gm.domain.Empleado;
import mx.com.gm.domain.Impresora;
import mx.com.gm.domain.Monitor;
import mx.com.gm.domain.Pc;
import mx.com.gm.domain.Pinpad;
import mx.com.gm.domain.Raton;
import mx.com.gm.domain.Scanner;
import mx.com.gm.domain.Teclado;
import mx.com.gm.domain.Telefono;
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
        return "inicio/home";
    }
    
    @GetMapping("/prueba")
    public String prueba() {
        return "prueba";
    }

//  --------------------- Tablas ---------------------
    @GetMapping("/empleados")
    public String empleados(Model model, @AuthenticationPrincipal User user) {
        var empleado = empleadoService.listarEmpleados();
        model.addAttribute("empleados", empleado);
        return "consultas/empleados";
    }

    @GetMapping("/pcs")
    public String pcs(Model model, @AuthenticationPrincipal User user) {
        var pc = pcService.listarPcs();
        model.addAttribute("pcs", pc);
        return "consultas/pcs";
    }

    @GetMapping("/monitores")
    public String monitores(Model model, @AuthenticationPrincipal User user) {
        var monitor = monitorService.listarMonitores();
        model.addAttribute("monitores", monitor);
        return "consultas/monitores";
    }

    @GetMapping("/asignaciones")
    public String asignaciones(Model model, @AuthenticationPrincipal User user) {
        var asignacioncom = asignacioncomService.listarAsignaciones();
        model.addAttribute("asignaciones", asignacioncom);
        return "consultas/asignaciones";
    }

    @GetMapping("/teclados")
    public String teclados(Model model, @AuthenticationPrincipal User user) {
        var teclado = tecladoService.listarTeclados();
        model.addAttribute("teclados", teclado);
        return "consultas/teclados";
    }

    @GetMapping("/ratones")
    public String ratones(Model model, @AuthenticationPrincipal User user) {
        var raton = ratonService.listarRatones();
        model.addAttribute("ratones", raton);
        return "consultas/ratones";
    }

    @GetMapping("/ups")
    public String ups(Model model, @AuthenticationPrincipal User user) {
        var ups = upsService.listarUps();
        model.addAttribute("ups", ups);
        return "consultas/ups";
    }

    @GetMapping("/impresoras")
    public String impresoras(Model model, @AuthenticationPrincipal User user) {
        var impresora = impresoraService.listarImpresoras();
        model.addAttribute("impresoras", impresora);
        return "consultas/impresoras";
    }

    @GetMapping("/scanneres")
    public String Scanneres(Model model, @AuthenticationPrincipal User user) {
        var scanner = scannerService.listarScanneres();
        model.addAttribute("scanneres", scanner);
        return "consultas/scanneres";
    }

    @GetMapping("/telefonos")
    public String Telefonos(Model model, @AuthenticationPrincipal User user) {
        var telefono = telefonoService.listarTelefonos();
        model.addAttribute("telefonos", telefono);
        return "consultas/telefonos";
    }

    @GetMapping("/pinpads")
    public String Pinpads(Model model, @AuthenticationPrincipal User user) {
        var pinpad = pinpadService.listarPinpad();
        model.addAttribute("pinpads", pinpad);
        return "consultas/pinpads";
    }

//  --------------------- Formularios ---------------------
    @GetMapping("/alta_asignacion")
    public String alta_asignacion(Model model) {
        List<Empleado> empleados = empleadoService.listarEmpleados();

        List<Pc> pcs = pcService.listarPcs().stream().filter(pc -> !pc.isStatus()).collect(Collectors.toList());
        List<Monitor> monitores = monitorService.listarMonitores().stream().filter(monitor -> !monitor.isStatus()).collect(Collectors.toList());
        List<Teclado> teclados = tecladoService.listarTeclados().stream().filter(teclado -> !teclado.isStatus()).collect(Collectors.toList());
        List<Raton> ratones = ratonService.listarRatones().stream().filter(raton -> !raton.isStatus()).collect(Collectors.toList());
        List<Impresora> impresoras = impresoraService.listarImpresoras().stream().filter(impresora -> !impresora.isStatus()).collect(Collectors.toList());
        List<Ups> upss = upsService.listarUps().stream().filter(ups -> !ups.isStatus()).collect(Collectors.toList());
        List<Scanner> scanneres = scannerService.listarScanneres().stream().filter(scanner -> !scanner.isStatus()).collect(Collectors.toList());
        List<Pinpad> pinpads = pinpadService.listarPinpad().stream().filter(pinpad -> !pinpad.isStatus()).collect(Collectors.toList());
        List<Telefono> telefonos = telefonoService.listarTelefonos().stream().filter(telefono -> !telefono.isStatus()).collect(Collectors.toList());

        model.addAttribute("empleados", empleados);
        model.addAttribute("monitores", monitores);
        model.addAttribute("pcs", pcs);
        model.addAttribute("teclados", teclados);
        model.addAttribute("ratones", ratones);
        model.addAttribute("impresoras", impresoras);
        model.addAttribute("upss", upss);
        model.addAttribute("scanneres", scanneres);
        model.addAttribute("pinpads", pinpads);
        model.addAttribute("telefonos", telefonos);

        return "formularios/alta_asignacion";
    }

    @GetMapping("/altas")
    public String altas(Model model) {

        Empleado empleado = new Empleado();

        Pc pc = new Pc();
        Monitor monitor = new Monitor();
        Teclado teclado = new Teclado();
        Raton raton = new Raton();
        Impresora impresora = new Impresora();
        Ups ups = new Ups();
        Scanner scanner = new Scanner();
        Pinpad pinpad = new Pinpad();
        Telefono telefono = new Telefono();

        model.addAttribute("empleado", empleado);
        model.addAttribute("pc", pc);
        model.addAttribute("monitor", monitor);
        model.addAttribute("teclado", teclado);
        model.addAttribute("raton", raton);
        model.addAttribute("impresora", impresora);
        model.addAttribute("ups", ups);
        model.addAttribute("scanner", scanner);
        model.addAttribute("pinpad", pinpad);
        model.addAttribute("telefono", telefono);

        return "formularios/altas";
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

    @PostMapping("/guardarRaton")
    public String guardarRaton(@ModelAttribute Raton raton) {
        ratonService.guardar(raton);
        return "redirect:/ratones";
    }

    @PostMapping("/guardarUps")
    public String guardarUps(@ModelAttribute Ups ups) {
        upsService.guardar(ups);
        return "redirect:/ups";
    }

    @PostMapping("/guardarImpresora")
    public String guardarImpresora(@ModelAttribute Impresora impresora) {
        impresoraService.guardar(impresora);
        return "redirect:/impresoras";
    }

    @PostMapping("/guardarScanner")
    public String guardarScanner(@ModelAttribute Scanner scanner) {
        scannerService.guardar(scanner);
        return "redirect:/scanneres";
    }

    @PostMapping("/guardarTelefono")
    public String guardarTelefono(@ModelAttribute Telefono telefono) {
        telefonoService.guardar(telefono);
        return "redirect:/telefonos";
    }

    @PostMapping("/guardarPinpad")
    public String guardarPinpad(@ModelAttribute Pinpad pinpad) {
        pinpadService.guardar(pinpad);
        return "redirect:/pinpads";
    }
//  --------------------- Eliminacion Tablas ---------------------    

    @GetMapping("/eliminarempl")
    public String eliminarEmpleado(@RequestParam("idempleado") Long idempleado) {
        Empleado empleado = empleadoService.obtenerEmpleadoPorId(idempleado);
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
    public String eliminarMonitor(@RequestParam("idmoni") Long idmoni) {
        Monitor monitor = monitorService.obtenerMonitorPorId(idmoni);
        monitorService.eliminar(monitor);
        return "redirect:/monitores";
    }

    @GetMapping("/eliminarteclado")
    public String eliminarTeclado(@RequestParam("idteclado") Long idteclado) {
        Teclado teclado = tecladoService.obtenerTecladoPorId(idteclado);
        tecladoService.eliminar(teclado);
        return "redirect:/teclados";
    }

    @GetMapping("/eliminarraton")
    public String eliminarRaton(@RequestParam("idraton") Long idraton) {
        Raton raton = ratonService.obtenerRatonPorId(idraton);
        ratonService.eliminar(raton);
        return "redirect:/ratones";
    }

    @GetMapping("/eliminarimpresora")
    public String eliminarImpresora(@RequestParam("idimpresora") Long idimpresora) {
        Impresora impresora = impresoraService.obtenerImpresoraPorId(idimpresora);
        impresoraService.eliminar(impresora);
        return "redirect:/impresoras";
    }

    @GetMapping("/eliminarups")
    public String eliminarUps(@RequestParam("idups") Long idups) {
        Ups ups = upsService.obtenerUpsPorId(idups);
        upsService.eliminar(ups);
        return "redirect:/ups";
    }

    @GetMapping("/eliminarscanner")
    public String eliminarScanner(@RequestParam("idscanner") Long idscanner) {
        Scanner scanner = scannerService.obtenerScannerPorId(idscanner);
        scannerService.eliminar(scanner);
        return "redirect:/scanneres";
    }

    @GetMapping("/eliminarpinpad")
    public String eliminarPinpad(@RequestParam("idpinpad") Long idpinpad) {
        Pinpad pinpad = pinpadService.obtenerPinpadPorId(idpinpad);
        pinpadService.eliminar(pinpad);
        return "redirect:/pinpads";
    }

    @GetMapping("/eliminartelefono")
    public String eliminarTelefono(@RequestParam("idtelefono") Long idtelefono) {
        Telefono telefono = telefonoService.obtenerTelefonoPorId(idtelefono);
        telefonoService.eliminar(telefono);
        return "redirect:/telefonos";
    }

    //  --------------------- Edicion Tablas ---------------------  
    @GetMapping("/editarempl/{idempleado}")
    public String editarEmpleado(@PathVariable("idempleado") Long idempleado, Model model) {
        Empleado empleado = empleadoService.obtenerEmpleadoPorId(idempleado);
        model.addAttribute("empleado", empleado);
        return "editempleado";
    }

    @GetMapping("/editarpc/{idpc}")
    public String editarPc(@PathVariable("idpc") Long idpc, Model model) {
        Pc pc = pcService.obtenerPcPorId(idpc);
        model.addAttribute("pc", pc);
        return "editpc";
    }

    @GetMapping("/editarmonitor/{idmoni}")
    public String editarMonitor(@PathVariable("idmoni") Long idmoni, Model model) {
        Monitor monitor = monitorService.obtenerMonitorPorId(idmoni);
        model.addAttribute("monitor", monitor);
        return "editmonitor";
    }

    @GetMapping("/editarteclado/{idteclado}")
    public String editarTeclado(@PathVariable("idteclado") Long idteclado, Model model) {
        Teclado teclado = tecladoService.obtenerTecladoPorId(idteclado);
        model.addAttribute("teclado", teclado);
        return "editteclado";
    }

    @GetMapping("/editarraton/{idraton}")
    public String editarRaton(@PathVariable("idraton") Long idraton, Model model) {
        Raton raton = ratonService.obtenerRatonPorId(idraton);
        model.addAttribute("raton", raton);
        return "editraton";
    }

    @GetMapping("/editarimpresora/{idimpresora}")
    public String editarImpresora(@PathVariable("idimpresora") Long idimpresora, Model model) {
        Impresora impresora = impresoraService.obtenerImpresoraPorId(idimpresora);
        model.addAttribute("impresora", impresora);
        return "editimpresora";
    }

    @GetMapping("/editarups/{idups}")
    public String editarUps(@PathVariable("idups") Long idups, Model model) {
        Ups ups = upsService.obtenerUpsPorId(idups);
        model.addAttribute("ups", ups);
        return "editups";
    }

    @GetMapping("/editarscanner/{idscanner}")
    public String editarScanner(@PathVariable("idscanner") Long idscanner, Model model) {
        Scanner scanner = scannerService.obtenerScannerPorId(idscanner);
        model.addAttribute("scanner", scanner);
        return "editscanner";
    }

    @GetMapping("/editarpinpad/{idpinpad}")
    public String editarPinpad(@PathVariable("idpinpad") Long idpinpad, Model model) {
        Pinpad pinpad = pinpadService.obtenerPinpadPorId(idpinpad);
        model.addAttribute("pinpad", pinpad);
        return "editpinpad";
    }

    @GetMapping("/editartelefono/{idtelefono}")
    public String editarTelefono(@PathVariable("idtelefono") Long idtelefono, Model model) {
        Telefono telefono = telefonoService.obtenerTelefonoPorId(idtelefono);
        model.addAttribute("telefono", telefono);
        return "edittelefono";
    }

    //  --------------------- Edicion Funcion ---------------------  
    @PostMapping("/actualizarempleado/{idempleado}")
    public String actualizarEmpleado(@PathVariable("idempleado") Long idempleado, @ModelAttribute Empleado empleado) {
        empleado.setIdempleado(idempleado);
        empleadoService.actualizar(empleado);
        return "redirect:/empleados";
    }

    @PostMapping("/actualizarpc/{idpc}")
    public String actualizarPc(@PathVariable("idpc") Long idpc, @ModelAttribute Pc pc) {
        pc.setIdpc(idpc);
        pcService.actualizar(pc);
        return "redirect:/pcs";
    }

    @PostMapping("/actualizarmonitor/{idmoni}")
    public String actualizarMonitor(@PathVariable("idmoni") Long idmoni, @ModelAttribute Monitor monitor) {
        monitor.setIdmoni(idmoni);
        monitorService.actualizar(monitor);
        return "redirect:/monitores";
    }

    @PostMapping("/actualizarteclado/{idteclado}")
    public String actualizarTeclado(@PathVariable("idteclado") Long idteclado, @ModelAttribute Teclado teclado) {
        teclado.setIdteclado(idteclado);
        tecladoService.actualizar(teclado);
        return "redirect:/teclados";
    }

    @PostMapping("/actualizarraton/{idraton}")
    public String actualizarRaton(@PathVariable("idraton") Long idraton, @ModelAttribute Raton raton) {
        raton.setIdraton(idraton);
        ratonService.actualizar(raton);
        return "redirect:/ratones";
    }

    @PostMapping("/actualizarimpresora/{idimpresora}")
    public String actualizarImpresora(@PathVariable("idimpresora") Long idimpresora, @ModelAttribute Impresora impresora) {
        impresora.setIdimpresora(idimpresora);
        impresoraService.actualizar(impresora);
        return "redirect:/impresoras";
    }

    @PostMapping("/actualizarups/{idups}")
    public String actualizarUps(@PathVariable("idups") Long idups, @ModelAttribute Ups ups) {
        ups.setIdups(idups);
        upsService.actualizar(ups);
        return "redirect:/ups";
    }

    @PostMapping("/actualizarscanner/{idscanner}")
    public String actualizarScanner(@PathVariable("idscanner") Long idscanner, @ModelAttribute Scanner scanner) {
        scanner.setIdscanner(idscanner);
        scannerService.actualizar(scanner);
        return "redirect:/scanneres";
    }

    @PostMapping("/actualizarpinpad/{idpinpad}")
    public String actualizarPinpad(@PathVariable("idpinpad") Long idpinpad, @ModelAttribute Pinpad pinpad) {
        pinpad.setIdpinpad(idpinpad);
        pinpadService.actualizar(pinpad);
        return "redirect:/pinpads";
    }

    @PostMapping("/actualizartelefono/{idtelefono}")
    public String actualizarTelefono(@PathVariable("idtelefono") Long idtelefono, @ModelAttribute Telefono telefono) {
        telefono.setIdtelefono(idtelefono);
        telefonoService.actualizar(telefono);
        return "redirect:/telefonos";
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

    @GetMapping("/teclado/{serieteclado}")
    @ResponseBody
    public Teclado obtenerTecladoPorSerie(@PathVariable String serieteclado) {
        return tecladoService.obtenerTecladoPorSerie(serieteclado);
    }

    @GetMapping("/raton/{serieraton}")
    @ResponseBody
    public Raton obtenerRatonPorSerie(@PathVariable String serieraton) {
        return ratonService.obtenerRatonPorSerie(serieraton);
    }

    @GetMapping("/impresora/{serieimpresora}")
    @ResponseBody
    public Impresora obtenerImpresoraPorSerie(@PathVariable String serieimpresora) {
        return impresoraService.obtenerImpresorasPorSerie(serieimpresora);
    }

    @GetMapping("/ups/{serieups}")
    @ResponseBody
    public Ups obtenerUpsPorSerie(@PathVariable String serieups) {
        return upsService.obtenerUpsPorSerie(serieups);
    }

    @GetMapping("/scanner/{seriescanner}")
    @ResponseBody
    public Scanner obtenerScannerPorSerie(@PathVariable String seriescanner) {
        return scannerService.obtenerScannerPorSerie(seriescanner);
    }

    @GetMapping("/pinpad/{seriepinpad}")
    @ResponseBody
    public Pinpad obtenerPinpadPorSerie(@PathVariable String seriepinpad) {
        return pinpadService.obtenerPinpadPorSerie(seriepinpad);
    }

    @GetMapping("/telefono/{serietelefono}")
    @ResponseBody
    public Telefono obtenerTelefonoPorSerie(@PathVariable String serietelefono) {
        return telefonoService.obtenerTelefonoPorSerie(serietelefono);
    }

    //  --------------------- Asignacion Funcion ---------------------  
    @PostMapping("/asignarEmpleado")
    public String asignarEmpleado(@RequestParam("idempleado") Integer idempleado,
            @RequestParam(value = "idpc", required = false) Integer idpc,
            @RequestParam(value = "idmoni", required = false) Integer idmoni,
            @RequestParam(value = "idteclado", required = false) Integer idteclado,
            @RequestParam(value = "idraton", required = false) Integer idraton,
            @RequestParam(value = "idimpresora", required = false) Integer idimpresora,
            @RequestParam(value = "idups", required = false) Integer idups,
            @RequestParam(value = "idscanner", required = false) Integer idscanner,
            @RequestParam(value = "idpinpad", required = false) Integer idpinpad,
            @RequestParam(value = "idtelefono", required = false) Integer idtelefono) {

        Asignacion asignacion = new Asignacion();
        asignacion.setIdempleado(idempleado);
        asignacion.setIdpc(idpc);
        asignacion.setIdmoni(idmoni);
        asignacion.setIdteclado(idteclado);
        asignacion.setIdraton(idraton);
        asignacion.setIdimpresora(idimpresora);
        asignacion.setIdups(idups);
        asignacion.setIdscanner(idscanner);
        asignacion.setIdpinpad(idpinpad);
        asignacion.setIdtelefono(idtelefono);

        asignacionService.guardar(asignacion);

        return "redirect:/";
    }

}
