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
@Table(name = "ups")
public class Ups implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idups;

    private String serieups;

    private String marcaups;

    private String modeloups;
    
    private boolean status;
    
    private java.sql.Date fechaups;
}
