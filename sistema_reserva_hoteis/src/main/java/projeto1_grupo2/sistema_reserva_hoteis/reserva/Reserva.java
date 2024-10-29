package projeto1_grupo2.sistema_reserva_hoteis.reserva;

import org.springframework.data.annotation.Id;
import projeto1_grupo2.sistema_reserva_hoteis.usuario.Usuario;

public class Reserva {
    @Id
    private String id;
    private Usuario usuario;
    private Integer numero_diarias;
    private Double valor_total;
    private String id_hotel;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getId_hotel() {
        return id_hotel;
    }

    public void setId_hotel(String id_hotel) {
        this.id_hotel = id_hotel;
    }

    public Usuario getUsuario() {
        return usuario;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }

    public Integer getNumero_diarias() {
        return numero_diarias;
    }

    public void setNumero_diarias(Integer numero_diarias) {
        this.numero_diarias = numero_diarias;
    }

    public Double getValor_total() {
        return valor_total;
    }

    public void setValor_total(Double valor_total) {
        this.valor_total = valor_total;
    }
}
