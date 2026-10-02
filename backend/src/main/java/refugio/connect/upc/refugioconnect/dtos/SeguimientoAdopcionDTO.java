package refugio.connect.upc.refugioconnect.dtos;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

import java.time.LocalDate;

public class SeguimientoAdopcionDTO {

    private Long idSeguimientoAdopcion;

    @NotNull(message = "La fecha de seguimiento es obligatoria")
    private LocalDate fechaSeguimiento;

    @NotBlank(message = "Los comentarios son obligatorios")
    private String comentarios;

    @NotBlank(message = "El estado de la mascota es obligatorio")
    private String estadoMascota;

    private String urlFotoEvidencia;

    @NotNull(message = "El ID de la solicitud de adopción es obligatorio")
    private Long idSolicitudAdopcion;

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

    public Long getIdSolicitudAdopcion() {
        return idSolicitudAdopcion;
    }

    public void setIdSolicitudAdopcion(Long idSolicitudAdopcion) {
        this.idSolicitudAdopcion = idSolicitudAdopcion;
    }
}