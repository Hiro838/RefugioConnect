package refugio.connect.upc.refugioconnect.dtos;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

import java.time.LocalDate;
import java.time.LocalTime;

public class TurnosVoluntariadosDTO {

    private Long idTurnoVoluntariado;

    @NotNull(message = "La fecha del turno es obligatoria")
    private LocalDate fechaTurno;

    @NotNull(message = "La hora de inicio es obligatoria")
    private LocalTime horaInicio;

    @NotNull(message = "La hora de fin es obligatoria")
    private LocalTime horaFin;

    @NotBlank(message = "El estado del turno es obligatorio")
    private String estadoTurno;

    private String descripcion;

    @NotNull(message = "El ID del usuario/voluntario es obligatorio")
    private Long idUsuario;

    public Long getIdTurnoVoluntariado() {
        return idTurnoVoluntariado;
    }

    public void setIdTurnoVoluntariado(Long idTurnoVoluntariado) {
        this.idTurnoVoluntariado = idTurnoVoluntariado;
    }

    public LocalDate getFechaTurno() {
        return fechaTurno;
    }

    public void setFechaTurno(LocalDate fechaTurno) {
        this.fechaTurno = fechaTurno;
    }

    public LocalTime getHoraInicio() {
        return horaInicio;
    }

    public void setHoraInicio(LocalTime horaInicio) {
        this.horaInicio = horaInicio;
    }

    public LocalTime getHoraFin() {
        return horaFin;
    }

    public void setHoraFin(LocalTime horaFin) {
        this.horaFin = horaFin;
    }

    public String getEstadoTurno() {
        return estadoTurno;
    }

    public void setEstadoTurno(String estadoTurno) {
        this.estadoTurno = estadoTurno;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public Long getIdUsuario() {
        return idUsuario;
    }

    public void setIdUsuario(Long idUsuario) {
        this.idUsuario = idUsuario;
    }
}