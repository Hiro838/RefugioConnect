package refugio.connect.upc.refugioconnect.dtos;

import jakarta.persistence.Column;
import jakarta.validation.constraints.NotBlank;

public class RolDTO {
    private Long idRol;
    @NotBlank(message = "Nombre de rol obligatorio.")
    private String nombreRol;

    public Long getIdRol() {
        return idRol;
    }

    public void setIdRol(Long idRol) {
        this.idRol = idRol;
    }

    public String getNombreRol() {
        return nombreRol;
    }

    public void setNombreRol(String nombreRol) {
        this.nombreRol = nombreRol;
    }
}
