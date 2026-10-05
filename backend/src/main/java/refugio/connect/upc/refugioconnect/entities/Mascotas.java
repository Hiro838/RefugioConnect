package refugio.connect.upc.refugioconnect.entities;

import jakarta.persistence.*;

import java.time.LocalDateTime;

@Entity
@Table(name = "mascotas")
public class Mascotas {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "idMascota")
    private Long idMascotas;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "idRaza", nullable = false)
    private Razas raza;

    @Column(name = "nombre", nullable = false, length = 100)
    private String nombre;

    @Column(name = "edadMeses")
    private Integer edadMeses;

    @Column(name = "tamano", nullable = false, length = 20)
    private String tamano;

    @Column(name = "estado", nullable = false, length = 30)
    private Boolean estado ;

    @Column(name = "descripcion", nullable = false, length = 30)
    private String descripcion;

    @Column(name = "fechaIngreso", nullable = false)
    private LocalDateTime fechaIngreso;

    public Mascotas() {
    }

    public Mascotas(Long idMascotas, Razas raza, String nombre, Integer edadMeses,
                    String tamano, Boolean estado, String descripcion,
                    LocalDateTime fechaIngreso) {
        this.idMascotas = idMascotas;
        this.raza = raza;
        this.nombre = nombre;
        this.edadMeses = edadMeses;
        this.tamano = tamano;
        this.estado = estado;
        this.descripcion = descripcion;
        this.fechaIngreso = fechaIngreso;
    }

    public Long getIdMascotas() {
        return idMascotas;
    }

    public void setIdMascotas(Long idMascotas) {
        this.idMascotas = idMascotas;
    }

    public Razas getRaza() {
        return raza;
    }

    public void setRaza(Razas raza) {
        this.raza = raza;
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

    public Boolean getEstado() {
        return estado;
    }

    public void setEstado(Boolean estado) {
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
}
