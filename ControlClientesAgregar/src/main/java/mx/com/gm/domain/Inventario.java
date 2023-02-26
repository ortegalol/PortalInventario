package mx.com.gm.domain;

import java.io.Serializable;
import javax.persistence.*;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;
import lombok.Data;

@Data
@Entity
@Table(name = "inventario")
public class Inventario implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idInventario;

    @NotEmpty
    private String nombre;

    @NotEmpty
    private Integer numEmpleado;

    @NotEmpty
    private String rfcEmpleado;

    @NotEmpty
    private String curpEmpleado;

    @NotEmpty
    private String departamento;

    @NotEmpty
    private String puesto;

    @NotEmpty
    @Email
    private String email;

    private String marcaCpu;

    private String modeloCpu;

    private String serieCpu;

    private String marcaMonitor;

    private String modeloMonitor;

    private String serieMonitor;


}
