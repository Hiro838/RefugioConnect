package refugio.connect.upc.refugioconnect.entities;

import jakarta.persistence.*;

import java.io.Serializable;

@Entity
@Table(
        name = "users",
        uniqueConstraints = {
                @UniqueConstraint(columnNames = "username")
        })
public class Usuario implements Serializable {
    @Id
    @GeneratedValue (strategy = GenerationType.IDENTITY)
    private Long idUsuario;

    @Column(name = "nombre_usuario", length = 100, nullable = false)
    private String nombreUsuario;


    private String email;
}
