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
@Table(name = "monitor")
public class Monitor implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idmoni;

    private String serie;

    private String marca;

    private String modelo;
    
    private String origen;
    
    private String estado;

    private boolean status;
}
