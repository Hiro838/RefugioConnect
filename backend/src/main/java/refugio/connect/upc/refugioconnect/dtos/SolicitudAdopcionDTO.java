package refugio.connect.upc.refugioconnect.dtos;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

import java.time.LocalDate;

public class SolicitudAdopcionDTO {

    private Long idSolicitudAdopcion;

    @NotBlank(message = "El estado de la solicitud es obligatorio")
    private String estadoSolicitud;

    @NotNull(message = "La fecha de solicitud es obligatoria")
    private LocalDate fechaSolicitud;

    @NotNull(message = "El ID de la mascota es obligatorio")
    private Long idMascota;

    @NotNull(message = "El ID del usuario es obligatorio")
    private Long idUsuario;

    public Long getIdSolicitudAdopcion() {
        return idSolicitudAdopcion;
    }

    public void setIdSolicitudAdopcion(Long idSolicitudAdopcion) {
        this.idSolicitudAdopcion = idSolicitudAdopcion;
    }

    public String getEstadoSolicitud() {
        return estadoSolicitud;
    }

    public void setEstadoSolicitud(String estadoSolicitud) {
        this.estadoSolicitud = estadoSolicitud;
    }

    public LocalDate getFechaSolicitud() {
        return fechaSolicitud;
    }

    public void setFechaSolicitud(LocalDate fechaSolicitud) {
        this.fechaSolicitud = fechaSolicitud;
    }

    public Long getIdMascota() {
        return idMascota;
    }

    public void setIdMascota(Long idMascota) {
        this.idMascota = idMascota;
    }

    public Long getIdUsuario() {
        return idUsuario;
    }

    public void setIdUsuario(Long idUsuario) {
        this.idUsuario = idUsuario;
    }
}