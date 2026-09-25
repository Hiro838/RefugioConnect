package refugio.connect.upc.refugioconnect.entities;

import jakarta.persistence.*;

import java.time.LocalDateTime;

@Entity
@Table(name = "historiales_medicos")
public class HistorialMedico {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idHistorialMedico;

    @Column (name = "tipo_tratamiento", length = 100, nullable = false)
    private String tipoTratamiento;

    @Column (name = "descripcion", length = 255, nullable = false)
    private String descripcion;

    @Column (name = "fecha_tratamiento", nullable = false)
    private LocalDateTime fechaTratamiento;

    @ManyToOne
    @JoinColumn (name = "id_mascota", nullable = false)
    private Mascota mascota;

    public HistorialMedico() {
    }

    public HistorialMedico(Long idHistorialMedico, String tipoTratamiento, String descripcion, LocalDateTime fechaTratamiento, Mascota mascota) {
        this.idHistorialMedico = idHistorialMedico;
        this.tipoTratamiento = tipoTratamiento;
        this.descripcion = descripcion;
        this.fechaTratamiento = fechaTratamiento;
        this.mascota = mascota;
    }

    public Long getIdHistorialMedico() {
        return idHistorialMedico;
    }

    public void setIdHistorialMedico(Long idHistorialMedico) {
        this.idHistorialMedico = idHistorialMedico;
    }

    public String getTipoTratamiento() {
        return tipoTratamiento;
    }

    public void setTipoTratamiento(String tipoTratamiento) {
        this.tipoTratamiento = tipoTratamiento;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public LocalDateTime getFechaTratamiento() {
        return fechaTratamiento;
    }

    public void setFechaTratamiento(LocalDateTime fechaTratamiento) {
        this.fechaTratamiento = fechaTratamiento;
    }

    public Mascota getMascota() {
        return mascota;
    }

    public void setMascota(Mascota mascota) {
        this.mascota = mascota;
    }
}
