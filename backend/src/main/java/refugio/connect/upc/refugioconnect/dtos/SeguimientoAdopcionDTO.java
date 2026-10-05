package refugio.connect.upc.refugioconnect.dtos;

import jakarta.validation.constraints.NotNull;

import java.time.LocalDate;

public class SeguimientoAdopcionDTO {

    private Long idSeguimiento;

    @NotNull(message = "La solicitud de adopción es obligatoria.")
    private Long idSolicitud;

    @NotNull(message = "El voluntario asignado es obligatorio.")
    private Long idVoluntarioAsignado;

    private LocalDate fechaContacto;

    private String estadoMascota;

    private String observaciones;

    public Long getIdSeguimiento() {
        return idSeguimiento;
    }

    public void setIdSeguimiento(Long idSeguimiento) {
        this.idSeguimiento = idSeguimiento;
    }

    public Long getIdSolicitud() {
        return idSolicitud;
    }

    public void setIdSolicitud(Long idSolicitud) {
        this.idSolicitud = idSolicitud;
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