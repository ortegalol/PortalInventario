package mx.com.gm.domain;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import lombok.Data;

@Data
@Entity
@Table(name = "pc")
public class Pc implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idpc;

    private String seriepc;

    private String marcapc;

    private String modelopc;

    private String procesador;

    private String velocidad;

    private String memoriaram;

    private String almacenamiento;

    private String origen;

    private String estado;

    private boolean status;
    
    private java.sql.Date fechapc;

}
