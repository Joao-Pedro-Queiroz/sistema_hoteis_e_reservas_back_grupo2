package projeto1_grupo2.sistema_reserva_hoteis.reserva;

import org.springframework.data.annotation.Id;
import projeto1_grupo2.sistema_reserva_hoteis.usuario.Usuario;

import java.time.LocalDateTime;

public class Reserva {
    @Id
    private String id;
    private Integer numeroDiaria;
    private Double valorTotal;
    private LocalDateTime data;
    private String idHotel;
    private Usuario usuario;

    public String getId() { return id; }

    public void setId(String id) { this.id = id; }

    public Integer getNumeroDiaria() { return numeroDiaria; }

    public void setNumeroDiaria(Integer numeroDiaria) { this.numeroDiaria = numeroDiaria; }

    public Double getValorTotal() { return valorTotal; }

    public void setValorTotal(Double valorTotal) { this.valorTotal = valorTotal; }

    public LocalDateTime getData() { return data; }

    public void setData(LocalDateTime data) { this.data = data; }

    public String getIdHotel() { return idHotel; }

    public void setIdHotel(String idHotel) { this.idHotel = idHotel; }

    public Usuario getUsuario() { return usuario; }

    public void setUsuario(Usuario usuario) { this.usuario = usuario; }
}
