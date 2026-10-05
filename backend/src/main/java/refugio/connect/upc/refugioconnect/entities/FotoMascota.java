package refugio.connect.upc.refugioconnect.entities;

import jakarta.persistence.*;


@Entity
@Table(name = "fotos_mascotas")
public class FotoMascota {
    @Id
    @GeneratedValue (strategy = GenerationType.IDENTITY)
    private Long idFotoMascota;

    @Column(name = "urlfoto", length = 255, nullable = false)
    private String urlfoto;

    @Column(name = "es_principal", nullable = false)
    private boolean es_principal;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "id_mascota", nullable = false)
    private Mascota mascota;

    public FotoMascota() {
    }

    public FotoMascota(Long idFotoMascota, String urlfoto, boolean es_principal, Mascota mascota) {
        this.idFotoMascota = idFotoMascota;
        this.urlfoto = urlfoto;
        this.es_principal = es_principal;
        this.mascota = mascota;
    }

    public Long getIdFotoMascota() {
        return idFotoMascota;
    }

    public void setIdFotoMascota(Long idFotoMascota) {
        this.idFotoMascota = idFotoMascota;
    }

    public String getUrlfoto() {
        return urlfoto;
    }

    public void setUrlfoto(String urlfoto) {
        this.urlfoto = urlfoto;
    }

    public boolean isEs_principal() {
        return es_principal;
    }

    public void setEs_principal(boolean es_principal) {
        this.es_principal = es_principal;
    }

    public Mascota getMascota() {
        return mascota;
    }

    public void setMascota(Mascota mascota) {
        this.mascota = mascota;
    }
}
