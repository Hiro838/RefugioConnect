package refugio.connect.upc.refugioconnect.dtos;

import jakarta.persistence.Column;
import jakarta.persistence.FetchType;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import refugio.connect.upc.refugioconnect.entities.Mascotas;

import java.time.LocalDate;

public class HistorialMedicoDTO {
    private Long idHistorialMedico;
    private String tipoTratamiento;
    private String descripcion;
    private LocalDate fechaTratamiento;
    private Long idMascotas;

    public Long getIdHistorialMedico() {
        return idHistorialMedico;
    }

    public void setIdHistorialMedico(Long idHistorialMedico) {
        this.idHistorialMedico = idHistorialMedico;
    }

    public String getTipoTratamiento() {
        return tipoTratamiento;
    }

    public void setTipoTratamiento(String tipoTratamiento) {
        this.tipoTratamiento = tipoTratamiento;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public LocalDate getFechaTratamiento() {
        return fechaTratamiento;
    }

    public void setFechaTratamiento(LocalDate fechaTratamiento) {
        this.fechaTratamiento = fechaTratamiento;
    }

    public Long getIdMascotas() {
        return idMascotas;
    }

    public void setIdMascotas(Long idMascotas) {
        this.idMascotas = idMascotas;
    }
}
