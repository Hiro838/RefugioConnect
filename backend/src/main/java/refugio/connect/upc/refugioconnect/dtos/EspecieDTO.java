package refugio.connect.upc.refugioconnect.dtos;

import jakarta.validation.constraints.NotBlank;

public class EspecieDTO {
    private Long idEspecie;
    @NotBlank(message = "Nombre de especie obligatorio.")
    private String nombreEspecie;

    public Long getIdEspecie() {
        return idEspecie;
    }

    public void setIdEspecie(Long idEspecie) {
        this.idEspecie = idEspecie;
    }

    public String getNombreEspecie() {
        return nombreEspecie;
    }

    public void setNombreEspecie(String nombreEspecie) {
        this.nombreEspecie = nombreEspecie;
    }
}
