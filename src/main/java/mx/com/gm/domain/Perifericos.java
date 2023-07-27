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
@Table(name = "perifericos")
public class Perifericos implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idper;

    private String teclado;
    
    private String raton;
    
    private String multifuncional;
    
    private String scanner;
    
    private String impresora;
    
    private String cenefas;
    
    private String miniprinter;
    
    private String proyector;
    
    private String camara;
    
    private String telefono;

}
