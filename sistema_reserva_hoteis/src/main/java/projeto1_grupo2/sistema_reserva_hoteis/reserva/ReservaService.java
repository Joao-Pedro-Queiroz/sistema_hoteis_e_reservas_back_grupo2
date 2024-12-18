package projeto1_grupo2.sistema_reserva_hoteis.reserva;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;
import projeto1_grupo2.sistema_reserva_hoteis.usuario.Usuario;
import projeto1_grupo2.sistema_reserva_hoteis.usuario.UsuarioRepository;
import projeto1_grupo2.sistema_reserva_hoteis.usuario.UsuarioService;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

@Service
public class ReservaService {

    @Autowired
    private ReservaRepository reservaRepository;

    @Autowired
    private UsuarioService usuarioService;

    public RetornarReservaDTO cadastrarReserva(CadastrarReservaDTO dto) {

        Usuario usuario = usuarioService.buscarUsuario(dto.usuario().getId());
        Reserva reserva = new Reserva();
        reserva.setUsuario(usuario);
        reserva.setNumeroDiaria(dto.numeroDiaria());
        reserva.setValorTotal(dto.valorTotal());
        reserva.setData(dto.data());
        reserva.setIdHotel(dto.idHotel());

        reserva = reservaRepository.save(reserva);
        return new RetornarReservaDTO(reserva.getId(), reserva.getNumeroDiaria(), reserva.getValorTotal(), reserva.getData(), reserva.getIdHotel(), reserva.getUsuario());
    }

    public Page<Reserva> listarReservas(String idHotel, Pageable pageable) {
        if (idHotel != null) {
            return reservaRepository.findByIdHotel(idHotel, pageable); // Correção para usar findById_hotel
        }
        return reservaRepository.findAll(pageable);
    }

    public Reserva buscarReserva(String id) {
        return reservaRepository.findById(id)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Reserva não encontrada"));
    }

    public List<Reserva> buscarReservasPorUsuario(Usuario usuario) {
        return reservaRepository.findByUsuario(usuario);
    }

    public ReservaUsuario relatorioReservas(String idUsuario) {
        Usuario usuario = usuarioService.buscarUsuario(idUsuario);
        ReservaUsuario reservaUsuario = new ReservaUsuario();

        List<Reserva> reservas = buscarReservasPorUsuario(usuario);
        int totalReservas = reservas.size();

        reservaUsuario.setNomeUsuario(usuario.getNome());
        reservaUsuario.setTotalReservas(totalReservas);
        reservaUsuario.setReservas(reservas);

        return reservaUsuario;
    }

    public void excluirReserva(String id) {
        Reserva reserva = buscarReserva(id);
        reservaRepository.delete(reserva);
    }
}
