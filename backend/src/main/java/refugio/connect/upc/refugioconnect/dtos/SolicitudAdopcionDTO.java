package refugio.connect.upc.refugioconnect.dtos;

import jakarta.validation.constraints.NotNull;

import java.time.LocalDateTime;

public class SolicitudAdopcionDTO {

    private Long idSolicitud;

    @NotNull(message = "El usuario es obligatorio.")
    private Long idUsuario;

    @NotNull(message = "La mascota es obligatoria.")
    private Long idMascota;

    private String estadoSolicitud;

    private String cuestionarioJson;

    private LocalDateTime fechaSolicitud;

    public Long getIdSolicitud() {
        return idSolicitud;
    }

    public void setIdSolicitud(Long idSolicitud) {
        this.idSolicitud = idSolicitud;
    }

    public Long getIdUsuario() {
        return idUsuario;
    }

    public void setIdUsuario(Long idUsuario) {
        this.idUsuario = idUsuario;
    }

    public Long getIdMascota() {
        return idMascota;
    }

    public void setIdMascota(Long idMascota) {
        this.idMascota = idMascota;
    }

    public String getEstadoSolicitud() {
        return estadoSolicitud;
    }

    public void setEstadoSolicitud(String estadoSolicitud) {
        this.estadoSolicitud = estadoSolicitud;
    }

    public String getCuestionarioJson() {
        return cuestionarioJson;
    }

    public void setCuestionarioJson(String cuestionarioJson) {
        this.cuestionarioJson = cuestionarioJson;
    }

    public LocalDateTime getFechaSolicitud() {
        return fechaSolicitud;
    }

    public void setFechaSolicitud(LocalDateTime fechaSolicitud) {
        this.fechaSolicitud = fechaSolicitud;
    }
}