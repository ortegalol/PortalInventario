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
@Table(name = "teclado")
public class Teclado implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idteclado;

    private String serieteclado;

    private String marcateclado;

    private String modeloteclado;
    
    private boolean status;
    
    private java.sql.Date fechateclado;
}
