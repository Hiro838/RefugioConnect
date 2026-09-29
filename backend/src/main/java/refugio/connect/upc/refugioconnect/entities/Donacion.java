package refugio.connect.upc.refugioconnect.entities;

import jakarta.persistence.*;

import java.math.BigDecimal;
import java.time.LocalDateTime;

@Entity
@Table(name = "donaciones")
public class Donacion {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_donacion")
    private Long idDonacion;

    @Column(name = "id_usuario")
    private Long idUsuario;

    @Column(name = "tipo_donacion", nullable = false, length = 50)
    private String tipoDonacion;

    @Column(name = "monto", precision = 10, scale = 2)
    private BigDecimal monto;

    @Column(name = "descripcion_items", columnDefinition = "TEXT")
    private String descripcionItems;

    @Column(name = "fecha_donacion")
    private LocalDateTime fechaDonacion;

    public Donacion() {
    }

    public Donacion(Long idDonacion,
                    Long idUsuario,
                    String tipoDonacion,
                    BigDecimal monto,
                    String descripcionItems,
                    LocalDateTime fechaDonacion) {

        this.idDonacion = idDonacion;
        this.idUsuario = idUsuario;
        this.tipoDonacion = tipoDonacion;
        this.monto = monto;
        this.descripcionItems = descripcionItems;
        this.fechaDonacion = fechaDonacion;
    }

    public Long getIdDonacion() {
        return idDonacion;
    }

    public void setIdDonacion(Long idDonacion) {
        this.idDonacion = idDonacion;
    }

    public Long getIdUsuario() {
        return idUsuario;
    }

    public void setIdUsuario(Long idUsuario) {
        this.idUsuario = idUsuario;
    }

    public String getTipoDonacion() {
        return tipoDonacion;
    }

    public void setTipoDonacion(String tipoDonacion) {
        this.tipoDonacion = tipoDonacion;
    }

    public BigDecimal getMonto() {
        return monto;
    }

    public void setMonto(BigDecimal monto) {
        this.monto = monto;
    }

    public String getDescripcionItems() {
        return descripcionItems;
    }

    public void setDescripcionItems(String descripcionItems) {
        this.descripcionItems = descripcionItems;
    }

    public LocalDateTime getFechaDonacion() {
        return fechaDonacion;
    }

    public void setFechaDonacion(LocalDateTime fechaDonacion) {
        this.fechaDonacion = fechaDonacion;
    }
}