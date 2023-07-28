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
@Table(name = "asignacion")
public class Asignacion implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idasignacion;

    private Integer idempleado;

    private Integer idpc;

    private Integer idmoni;

    private Integer idteclado;

    private Integer idraton;

    private Integer idups;
    
    private Integer idimpresora;
    
    private Integer idscanner;
    
    private Integer idtelefono;
    
    private Integer idpinpad;
    
    private Date fechaasignacion;

}
