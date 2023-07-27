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
@Table(name = "impresora")
public class Impresora implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idimpresora;

    private String serieimpresora;

    private String marcaimpresora;

    private String modeloimpresora;
    
    private String tipoimpresora;
    
    private boolean status;
}
