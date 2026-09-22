package refugio.connect.upc.refugioconnect.entities;

import jakarta.persistence.*;
import java.time.LocalDate;

@Entity
@Table(name = "historial_medico")
public class HistorialMedico {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idHistorialMedico;

    @Column(name = "tipo_tratamiento", nullable = false, length = 50) // VARCHAR(50) N-N[cite: 5]
    private String tipoTratamiento;

    @Column(name = "descripcion", nullable = false, columnDefinition = "TEXT") // TEXT N-N[cite: 5]
    private String descripcion;

    @Column(name = "fechaTratamiento", nullable = false) // DATE N-N[cite: 5]
    private LocalDate fechaTratamiento;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "idMascota", nullable = false) // BIGINT N-N[cite: 5]
    private Mascotas mascotas;


    public HistorialMedico(){

    }

    public HistorialMedico(Long idHistorialMedico, String tipoTratamiento, String descripcion, LocalDate fechaTratamiento, Mascotas mascotas) {
        this.idHistorialMedico = idHistorialMedico;
        this.tipoTratamiento = tipoTratamiento;
        this.descripcion = descripcion;
        this.fechaTratamiento = fechaTratamiento;
        this.mascotas = mascotas;
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

    public LocalDate getFechaTratamiento() {
        return fechaTratamiento;
    }

    public void setFechaTratamiento(LocalDate fechaTratamiento) {
        this.fechaTratamiento = fechaTratamiento;
    }

    public Mascotas getMascotas() {
        return mascotas;
    }

    public void setMascotas(Mascotas mascotas) {
        this.mascotas = mascotas;
    }
}
