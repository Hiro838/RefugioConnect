package refugio.connect.upc.refugioconnect.dtos;

import refugio.connect.upc.refugioconnect.entities.Especie;

public class RazasDTO {
    private Long idRaza;
    private String nombreRaza;
    private Long idEspecie;

    public Long getIdRaza() {
        return idRaza;
    }

    public void setIdRaza(Long idRaza) {
        this.idRaza = idRaza;
    }

    public String getNombreRaza() {
        return nombreRaza;
    }

    public void setNombreRaza(String nombreRaza) {
        this.nombreRaza = nombreRaza;
    }

    public Long getIdEspecie() {
        return idEspecie;
    }

    public void setIdEspecie(Long idEspecie) {
        this.idEspecie = idEspecie;
    }
}
