package refugio.connect.upc.refugioconnect.entities;

import jakarta.persistence.*;

import java.io.Serializable;
import java.time.LocalDate;
import java.time.LocalTime;

@Entity
@Table(name = "turnos_voluntariados")
public class TurnosVoluntariados implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idTurnoVoluntariado;

    @Column(name = "fecha_turno", nullable = false)
    private LocalDate fechaTurno;

    @Column(name = "hora_inicio", nullable = false)
    private LocalTime horaInicio;

    @Column(name = "hora_fin", nullable = false)
    private LocalTime horaFin;

    @Column(name = "estado_turno", length = 50, nullable = false)
    private String estadoTurno;

    @Column(name = "descripcion", length = 200)
    private String descripcion;

    @ManyToOne
    @JoinColumn(name = "id_usuario", nullable = false)
    private Usuario usuario;

    public TurnosVoluntariados() {
    }

    public TurnosVoluntariados(Long idTurnoVoluntariado, LocalDate fechaTurno, LocalTime horaInicio, LocalTime horaFin, String estadoTurno, String descripcion, Usuario usuario) {
        this.idTurnoVoluntariado = idTurnoVoluntariado;
        this.fechaTurno = fechaTurno;
        this.horaInicio = horaInicio;
        this.horaFin = horaFin;
        this.estadoTurno = estadoTurno;
        this.descripcion = descripcion;
        this.usuario = usuario;
    }

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

    public Usuario getUsuario() {
        return usuario;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }
}