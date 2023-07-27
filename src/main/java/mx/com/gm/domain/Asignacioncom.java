package mx.com.gm.domain;

import java.io.Serializable;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import lombok.Data;

@Data
@Entity
@Table(name = "vista_asignacion_completa")
public class Asignacioncom implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idasignacion;

    private String nombre_empleado;
    private Integer numempleado;
    private String rfc;
    private String curp;
    private String departamento;
    private String puesto;
    private String email;
    private String seriepc;
    private String marcapc;
    private String modelopc;
    private String procesador;
    private String velocidad;
    private String memoriaram;
    private String almacenamiento;
    private String origen_pc;
    private String estado_pc;
    private String serie_monitor;
    private String marca_monitor;
    private String modelo_monitor;
    private String origen_monitor;
    private String estado_monitor;

}
