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
@Table(name = "scanner")
public class Scanner implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idscanner;

    private String seriescanner;

    private String marcascanner;

    private String modeloscanner;

    private String tiposcanner;

    private boolean status;
    
    private Date fechascanner;
}
