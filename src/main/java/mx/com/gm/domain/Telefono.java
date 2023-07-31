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
@Table(name = "telefono")
public class Telefono implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idtelefono;

    private String serietelefono;

    private String marcatelefono;

    private String modelotelefono;
    
    private boolean status;
    
    private Date fechatelefono;
}
