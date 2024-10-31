package projeto1_grupo2.sistema_reserva_hoteis.reserva;

import java.util.List;

public class ReservaUsuario {
    private String nomeUsuario;
    private Integer totalReservas;
    private List<Reserva> reservas;

    public String getNomeUsuario() { return nomeUsuario; }

    public void setNomeUsuario(String nomeUsuario) { this.nomeUsuario = nomeUsuario; }

    public Integer getTotalReservas() { return totalReservas; }

    public void setTotalReservas(Integer totalReservas) { this.totalReservas = totalReservas; }

    public List<Reserva> getReservas() { return reservas; }

    public void setReservas(List<Reserva> reservas) { this.reservas = reservas; }
}
