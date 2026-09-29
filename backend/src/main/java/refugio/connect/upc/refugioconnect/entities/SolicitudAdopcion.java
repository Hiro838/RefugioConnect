package refugio.connect.upc.refugioconnect.entities;

import jakarta.persistence.*;
import org.hibernate.annotations.JdbcTypeCode;
import org.hibernate.type.SqlTypes;

import java.time.LocalDateTime;

@Entity
@Table(name = "solicitudes_adopcion")
public class SolicitudAdopcion {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_solicitud")
    private Long idSolicitud;

    @Column(name = "id_usuario")
    private Long idUsuario;

    @Column(name = "id_mascota")
    private Long idMascota;

    @Column(name = "estado_solicitud", length = 30)
    private String estadoSolicitud;

    @JdbcTypeCode(SqlTypes.JSON)
    @Column(name = "cuestionario_json", columnDefinition = "jsonb")
    private String cuestionarioJson;

    @Column(name = "fecha_solicitud")
    private LocalDateTime fechaSolicitud;

    public SolicitudAdopcion() {
    }

    public SolicitudAdopcion(Long idSolicitud,
                             Long idUsuario,
                             Long idMascota,
                             String estadoSolicitud,
                             String cuestionarioJson,
                             LocalDateTime fechaSolicitud) {
        this.idSolicitud = idSolicitud;
        this.idUsuario = idUsuario;
        this.idMascota = idMascota;
        this.estadoSolicitud = estadoSolicitud;
        this.cuestionarioJson = cuestionarioJson;
        this.fechaSolicitud = fechaSolicitud;
    }

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