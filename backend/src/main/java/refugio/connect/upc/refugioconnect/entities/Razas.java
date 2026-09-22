package refugio.connect.upc.refugioconnect.entities;

import jakarta.persistence.*;

@Entity
@Table(name = "razas")
public class Razas {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idRaza;

    @Column(name = "nombreRaza", nullable = false, length = 100)
    private String nombreRaza;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "idEspecie", nullable = false)
    private Especie especie;

    public Razas(){

    }

    public Razas(Long idRaza, String nombreRaza, Especie especie){
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