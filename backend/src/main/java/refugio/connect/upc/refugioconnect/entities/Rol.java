package refugio.connect.upc.refugioconnect.entities;


import jakarta.persistence.*;

@Entity
@Table(
        name = "roles",
        uniqueConstraints = {
                @UniqueConstraint(columnNames = {"user_id", "nombre_rol"})
        }
)
public class Rol{

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idRol;

    @Column(name = "nombre_rol", nullable = false, length = 50)
    private String nombreRol;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "user_id", nullable = false)
    private Usuario user;

    public Rol(Long idRol, String nombreRol) {
        this.idRol = idRol;
        this.nombreRol = nombreRol;
    }
    public Rol(){
    }

    public Long getIdRol() {
        return idRol;
    }

    public void setIdRol(Long idRol) {
        this.idRol = idRol;
    }

    public String getNombreRol() {
        return nombreRol;
    }

    public void setNombreRol(String nombreRol) {
        this.nombreRol = nombreRol;
    }

    public Usuario getUser() {
        return user;
    }

    public void setUser(Usuario user) {
        this.user = user;
    }
}