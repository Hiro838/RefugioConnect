package refugio.connect.upc.refugioconnect.entities;

import jakarta.persistence.*;

import java.time.LocalDate;

@Entity
@Table(name = "solicitudes_adopcion")
public class SolicitudAdopcion {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idSolicitudAdopcion;

    @Column(name = "estado_solicitud", length = 50, nullable = false)
    private String estadoSolicitud;

    @Column (name = "fecha_solicitud", nullable = false)
    private LocalDate fechaSolicitud;

    @ManyToOne
    @JoinColumn (name = "id_mascota", nullable = false)
    private Mascota mascota;

    @ManyToOne
    @JoinColumn (name = "id_usuario", nullable = false)
    private Usuario usuario;

    public SolicitudAdopcion() {
    }

    public SolicitudAdopcion(Long idSolicitudAdopcion, String estadoSolicitud, LocalDate fechaSolicitud, Mascota mascota, Usuario usuario) {
        this.idSolicitudAdopcion = idSolicitudAdopcion;
        this.estadoSolicitud = estadoSolicitud;
        this.fechaSolicitud = fechaSolicitud;
        this.mascota = mascota;
        this.usuario = usuario;
    }

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

    public Mascota getMascota() {
        return mascota;
    }

    public void setMascota(Mascota mascota) {
        this.mascota = mascota;
    }

    public Usuario getUsuario() {
        return usuario;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }
}
