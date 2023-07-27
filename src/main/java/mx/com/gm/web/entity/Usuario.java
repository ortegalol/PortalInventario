package mx.com.gm.web.entity;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

@Entity
@Table(name = "usuario")
public class Usuario implements UserDetails {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id_usuario;
    private String usuario;
    private String password;

    @OneToMany(fetch = FetchType.EAGER)
    @JoinColumn(name = "id_usuario")
    private List<Rol> roles;

    // Getters, setters y otros métodos

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        List<GrantedAuthority> authorities = new ArrayList<>();

        for (Rol rol : roles) {
            authorities.add(new SimpleGrantedAuthority(rol.getNombre()));
        }

        return authorities;
    }

    @Override
    public String getUsername() {
        return usuario;
    }

    // Implementa los siguientes métodos según tus necesidades
    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    @Override
    public boolean isAccountNonLocked() {
        return true;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    @Override
    public boolean isEnabled() {
        return true;
    }
    @Override
    public String getPassword() {
        return password;
    }
    
}