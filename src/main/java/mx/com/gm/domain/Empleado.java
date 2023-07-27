package mx.com.gm.domain;

import java.io.Serializable;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotEmpty;
import lombok.Data;

@Entity
@Table(name = "empleado")
@Data
public class Empleado implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idempleado;

    @NotEmpty
    private String nombre;

    @NotEmpty
    private Integer numempleado;

    private String rfc;

    private String curp;

    private String departamento;

    private String puesto;

    private String email;

}
