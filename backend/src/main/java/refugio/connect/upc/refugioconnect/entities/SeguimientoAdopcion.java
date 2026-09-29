package refugio.connect.upc.refugioconnect.entities;

import jakarta.persistence.*;

import java.time.LocalDate;

@Entity
@Table(name = "seguimientos_adopcion")
public class SeguimientoAdopcion {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_seguimiento")
    private Long idSeguimiento;

    @ManyToOne
    @JoinColumn(name = "id_solicitud")
    private SolicitudAdopcion solicitudAdopcion;

    @Column(name = "id_voluntario_asignado")
    private Long idVoluntarioAsignado;

    @Column(name = "fecha_contacto")
    private LocalDate fechaContacto;

    @Column(name = "estado_mascota", length = 50)
    private String estadoMascota;

    @Column(name = "observaciones", columnDefinition = "TEXT")
    private String observaciones;

    public SeguimientoAdopcion() {
    }

    public SeguimientoAdopcion(
            Long idSeguimiento,
            SolicitudAdopcion solicitudAdopcion,
            Long idVoluntarioAsignado,
            LocalDate fechaContacto,
            String estadoMascota,
            String observaciones) {

        this.idSeguimiento = idSeguimiento;
        this.solicitudAdopcion = solicitudAdopcion;
        this.idVoluntarioAsignado = idVoluntarioAsignado;
        this.fechaContacto = fechaContacto;
        this.estadoMascota = estadoMascota;
        this.observaciones = observaciones;
    }

    public Long getIdSeguimiento() {
        return idSeguimiento;
    }

    public void setIdSeguimiento(Long idSeguimiento) {
        this.idSeguimiento = idSeguimiento;
    }

    public SolicitudAdopcion getSolicitudAdopcion() {
        return solicitudAdopcion;
    }

    public void setSolicitudAdopcion(SolicitudAdopcion solicitudAdopcion) {
        this.solicitudAdopcion = solicitudAdopcion;
    }

    public Long getIdVoluntarioAsignado() {
        return idVoluntarioAsignado;
    }

    public void setIdVoluntarioAsignado(Long idVoluntarioAsignado) {
        this.idVoluntarioAsignado = idVoluntarioAsignado;
    }

    public LocalDate getFechaContacto() {
        return fechaContacto;
    }

    public void setFechaContacto(LocalDate fechaContacto) {
        this.fechaContacto = fechaContacto;
    }

    public String getEstadoMascota() {
        return estadoMascota;
    }

    public void setEstadoMascota(String estadoMascota) {
        this.estadoMascota = estadoMascota;
    }

    public String getObservaciones() {
        return observaciones;
    }

    public void setObservaciones(String observaciones) {
        this.observaciones = observaciones;
    }
}