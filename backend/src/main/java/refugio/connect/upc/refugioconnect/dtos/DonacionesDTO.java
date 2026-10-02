package refugio.connect.upc.refugioconnect.dtos;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;

import java.time.LocalDate;

public class DonacionesDTO {

    private Long idDonacion;

    @Positive(message = "El monto debe ser un valor positivo")
    private double monto;

    @NotBlank(message = "El tipo de donación es obligatorio")
    private String tipoDonacion;

    @NotNull(message = "La fecha de la donación es obligatoria")
    private LocalDate fechaDonacion;

    private String metodoPago;

    private String observacion;

    @NotNull(message = "El ID del usuario es obligatorio")
    private Long idUsuario;

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

    public Long getIdUsuario() {
        return idUsuario;
    }

    public void setIdUsuario(Long idUsuario) {
        this.idUsuario = idUsuario;
    }
}