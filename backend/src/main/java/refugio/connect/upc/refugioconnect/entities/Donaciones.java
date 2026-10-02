package refugio.connect.upc.refugioconnect.entities;

import jakarta.persistence.*;

import java.io.Serializable;
import java.time.LocalDate;

@Entity
@Table(name = "donaciones")
public class Donaciones implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idDonacion;

    @Column(name = "monto", nullable = false)
    private double monto;

    @Column(name = "tipo_donacion", length = 50, nullable = false)
    private String tipoDonacion; // Ej. "MONETARIA", "ALIMENTO", "MEDICINA"

    @Column(name = "fecha_donacion", nullable = false)
    private LocalDate fechaDonacion;

    @Column(name = "metodo_pago", length = 50)
    private String metodoPago; // Ej. "TARJETA", "YAPE", "PLIN", "TRANSFERENCIA"

    @Column(name = "observacion", length = 200)
    private String observacion;

    @ManyToOne
    @JoinColumn(name = "id_usuario", nullable = false)
    private Usuario usuario;

    public Donaciones() {
    }

    public Donaciones(Long idDonacion, double monto, String tipoDonacion, LocalDate fechaDonacion, String metodoPago, String observacion, Usuario usuario) {
        this.idDonacion = idDonacion;
        this.monto = monto;
        this.tipoDonacion = tipoDonacion;
        this.fechaDonacion = fechaDonacion;
        this.metodoPago = metodoPago;
        this.observacion = observacion;
        this.usuario = usuario;
    }

    public Long getIdDonacion() {
        return idDonacion;
    }

    public void setIdDonacion(Long idDonacion) {
        this.idDonacion = idDonacion;
    }

    public double getMonto() {
        return monto;
    }

    public void setMonto(double monto) {
        this.monto = monto;
    }

    public String getTipoDonacion() {
        return tipoDonacion;
    }

    public void setTipoDonacion(String tipoDonacion) {
        this.tipoDonacion = tipoDonacion;
    }

    public LocalDate getFechaDonacion() {
        return fechaDonacion;
    }

    public void setFechaDonacion(LocalDate fechaDonacion) {
        this.fechaDonacion = fechaDonacion;
    }

    public String getMetodoPago() {
        return metodoPago;
    }

    public void setMetodoPago(String metodoPago) {
        this.metodoPago = metodoPago;
    }

    public String getObservacion() {
        return observacion;
    }

    public void setObservacion(String observacion) {
        this.observacion = observacion;
    }

    public Usuario getUsuario() {
        return usuario;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }
}