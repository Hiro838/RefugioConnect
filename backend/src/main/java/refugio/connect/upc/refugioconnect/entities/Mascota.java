package refugio.connect.upc.refugioconnect.entities;
import jakarta.persistence.*;
import java.io.Serializable;
import java.time.LocalDateTime;

@Entity
@Table(name = "mascotas")
public class Mascota implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_mascota")
    private Long idMascota;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "id_raza", nullable = false)
    private Raza raza;

    @Column(name = "nombre", nullable = false, length = 100)
    private String nombre;

    @Column(name = "edad_meses")
    private int edadMeses;

    @Column(name = "tamano", nullable = false, length = 20)
    private String tamano;

    @Column(name = "estado", length = 30)
    private String estado;

    @Column(name = "descripcion", columnDefinition = "TEXT")
    private String descripcion;

    @Column(name = "fecha_ingreso", updatable = false)
    private LocalDateTime fechaIngreso;

    public Mascota() {
    }

    public Mascota(Long idMascota, Raza raza, String nombre, int edadMeses, String tamano, String estado, String descripcion, LocalDateTime fechaIngreso) {
        this.idMascota = idMascota;
        this.raza = raza;
        this.nombre = nombre;
        this.edadMeses = edadMeses;
        this.tamano = tamano;
        this.estado = estado;
        this.descripcion = descripcion;
        this.fechaIngreso = fechaIngreso;
    }

    public Long getIdMascota() {
        return idMascota;
    }

    public void setIdMascota(Long idMascota) {
        this.idMascota = idMascota;
    }

    public Raza getRaza() {
        return raza;
    }

    public void setRaza(Raza raza) {
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
}
