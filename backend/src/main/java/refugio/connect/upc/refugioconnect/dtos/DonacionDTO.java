package refugio.connect.upc.refugioconnect.dtos;

import jakarta.validation.constraints.NotBlank;

import java.math.BigDecimal;
import java.time.LocalDateTime;

public class DonacionDTO {

    private Long idDonacion;

    private Long idUsuario;

    @NotBlank(message = "El tipo de donación es obligatorio.")
    private String tipoDonacion;

    private BigDecimal monto;

    private String descripcionItems;

    private LocalDateTime fechaDonacion;

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