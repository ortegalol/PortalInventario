package mx.com.gm.domain;

import java.io.Serializable;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import lombok.Data;

@Data
@Entity
@Table(name = "vista_asignacion_completa")
public class Asignacioncom implements Serializable {

    @Id
    private Long idasignacion;

    private String nombre_empleado;
    private Integer numempleado;
    private String rfc;
    private String curp;
    private String departamento;
    private String puesto;
    private String email;
    private String ext;
    private String seriepc;
    private String marcapc;
    private String modelopc;
    private String procesador;
    private String velocidad;
    private String memoriaram;
    private String almacenamiento;
    private String origen_pc;
    private String estado_pc;
    private Boolean status_pc;
    private String usuario;
    private String hostname;
    private String ip;
    private String macaddress;
    private String so;
    private String arch;
    private String tipo;
    private java.sql.Date fechapc;
    private String serie_monitor;
    private String marca_monitor;
    private String modelo_monitor;
    private String origen_monitor;
    private String estado_monitor;
    private Boolean status_monitor;
    private java.sql.Date fechamonitor;
    private Long idteclado;
    private String serieteclado;
    private String marcateclado;
    private String modeloteclado;
    private Boolean status_teclado;
    private java.sql.Date fechateclado;
    private Long idraton;
    private String serieraton;
    private String marcaraton;
    private String modeloraton;
    private Boolean status_raton;
    private java.sql.Date fecharaton;
    private Long idimpresora;
    private String serieimpresora;
    private String marcaimpresora;
    private String modeloimpresora;
    private String tipoimpresora;
    private Boolean status_impresora;
    private java.sql.Date fechaimpresora;
    private Long idups;
    private String serieups;
    private String marcaups;
    private String modeloups;
    private Boolean status_ups;
    private java.sql.Date fechaups;
    private Long idpinpad;
    private String seriepinpad;
    private String marcapinpad;
    private String modelopinpad;
    private Boolean status_pinpad;
    private java.sql.Date fechapinpad;
    private Long idscanner;
    private String seriescanner;
    private String marcascanner;
    private String modeloscanner;
    private String tiposcanner;
    private Boolean status_scanner;
    private java.sql.Date fechascanner;
    private Long idtelefono;
    private String serietelefono;
    private String marcatelefono;
    private String modelotelefono;
    private Boolean status_telefono;
    private java.sql.Date fechatelefono;
    private java.sql.Date fechaasignacion;
}
