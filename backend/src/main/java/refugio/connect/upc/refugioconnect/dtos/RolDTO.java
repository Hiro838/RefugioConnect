package refugio.connect.upc.refugioconnect.dtos;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

public class RolDTO {
    private Long idRol;
    @NotBlank(message = "Nombre de rol obligatorio.")
    private String nombreRol;
    @NotNull(message = "El ID del usuario es obligatorio.")
    private Long idUsuario;

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

    public Long getIdUsuario() {
        return idUsuario;
    }

    public void setIdUsuario(Long idUsuario) {
        this.idUsuario = idUsuario;
    }
}
