package mx.com.gm.web.entity;

import javax.persistence.*;

@Entity
@Table(name = "rol")
public class Rol {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id_rol;
    private String nombre;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_usuario")
    private Usuario usuario;

    // Getters y setters para los campos nombre y usuario
    public Integer getId_rol() {
        return id_rol;
    }

    public void setId_rol(Integer id_rol) {
        this.id_rol = id_rol;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public Usuario getUsuario() {
        return usuario;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }

    // Otros métodos
}
