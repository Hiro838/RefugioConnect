package refugio.connect.upc.refugioconnect.entities;

import jakarta.persistence.*;
@Entity
@Table(name = "razas")
public class Raza {
    @Id
    @GeneratedValue (strategy = jakarta.persistence.GenerationType.IDENTITY)
    private Long idRaza;
    @Column(name = "nombre_raza", nullable = false, length = 100)
    private String nombreRaza;
    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "id_especie", nullable = false)
    private Especie especie;

    public Raza() {
    }

    public Raza(Long idRaza, String nombreRaza, Especie especie) {
        this.idRaza = idRaza;
        this.nombreRaza = nombreRaza;
        this.especie = especie;
    }

    public Long getIdRaza() {
        return idRaza;
    }

    public void setIdRaza(Long idRaza) {
        this.idRaza = idRaza;
    }

    public String getNombreRaza() {
        return nombreRaza;
    }

    public void setNombreRaza(String nombreRaza) {
        this.nombreRaza = nombreRaza;
    }

    public Especie getEspecie() {
        return especie;
    }

    public void setEspecie(Especie especie) {
        this.especie = especie;
    }
}
