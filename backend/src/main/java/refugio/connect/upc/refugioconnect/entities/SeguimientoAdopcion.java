package refugio.connect.upc.refugioconnect.entities;

import jakarta.persistence.*;

import java.io.Serializable;
import java.time.LocalDate;

@Entity
@Table(name = "seguimiento_adopcion")
public class SeguimientoAdopcion implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idSeguimientoAdopcion;

    @Column(name = "fecha_seguimiento", nullable = false)
    private LocalDate fechaSeguimiento;

    @Column(name = "comentarios", length = 300, nullable = false)
    private String comentarios;

    @Column(name = "estado_mascota", length = 50, nullable = false)
    private String estadoMascota; // Ej. "EXCELENTE", "EN_ADAPTACION", "REQUIERE_VISITA"

    @Column(name = "url_foto_evidencia", length = 200)
    private String urlFotoEvidencia;

    @ManyToOne
    @JoinColumn(name = "id_solicitud_adopcion", nullable = false)
    private SolicitudAdopcion solicitudAdopcion;

    public SeguimientoAdopcion() {
    }

    public SeguimientoAdopcion(Long idSeguimientoAdopcion, LocalDate fechaSeguimiento, String comentarios, String estadoMascota, String urlFotoEvidencia, SolicitudAdopcion solicitudAdopcion) {
        this.idSeguimientoAdopcion = idSeguimientoAdopcion;
        this.fechaSeguimiento = fechaSeguimiento;
        this.comentarios = comentarios;
        this.estadoMascota = estadoMascota;
        this.urlFotoEvidencia = urlFotoEvidencia;
        this.solicitudAdopcion = solicitudAdopcion;
    }

    public Long getIdSeguimientoAdopcion() {
        return idSeguimientoAdopcion;
    }

    public void setIdSeguimientoAdopcion(Long idSeguimientoAdopcion) {
        this.idSeguimientoAdopcion = idSeguimientoAdopcion;
    }

    public LocalDate getFechaSeguimiento() {
        return fechaSeguimiento;
    }

    public void setFechaSeguimiento(LocalDate fechaSeguimiento) {
        this.fechaSeguimiento = fechaSeguimiento;
    }

    public String getComentarios() {
        return comentarios;
    }

    public void setComentarios(String comentarios) {
        this.comentarios = comentarios;
    }

    public String getEstadoMascota() {
        return estadoMascota;
    }

    public void setEstadoMascota(String estadoMascota) {
        this.estadoMascota = estadoMascota;
    }

    public String getUrlFotoEvidencia() {
        return urlFotoEvidencia;
    }

    public void setUrlFotoEvidencia(String urlFotoEvidencia) {
        this.urlFotoEvidencia = urlFotoEvidencia;
    }

    public SolicitudAdopcion getSolicitudAdopcion() {
        return solicitudAdopcion;
    }

    public void setSolicitudAdopcion(SolicitudAdopcion solicitudAdopcion) {
        this.solicitudAdopcion = solicitudAdopcion;
    }
}