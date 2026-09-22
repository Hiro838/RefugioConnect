package refugio.connect.upc.refugioconnect.dtos;

import java.time.LocalDateTime;

public class MascotasDTO {
    private Long idMascotas;
    private String nombre;
    private Integer edadMeses;
    private String tamano;
    private String estado;
    private String descripcion;
    private LocalDateTime fechaIngreso;
    private Long idRaza;

    public Long getIdMascotas() {
        return idMascotas;
    }

    public void setIdMascotas(Long idMascotas) {
        this.idMascotas = idMascotas;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public Integer getEdadMeses() {
        return edadMeses;
    }

    public void setEdadMeses(Integer edadMeses) {
        this.edadMeses = edadMeses;
    }

    public String getTamano() {
        return tamano;
    }

    public void setTamano(String tamano) {
        this.tamano = tamano;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public LocalDateTime getFechaIngreso() {
        return fechaIngreso;
    }

    public void setFechaIngreso(LocalDateTime fechaIngreso) {
        this.fechaIngreso = fechaIngreso;
    }

    public Long getIdRaza() {
        return idRaza;
    }

    public void setIdRaza(Long idRaza) {
        this.idRaza = idRaza;
    }
}
