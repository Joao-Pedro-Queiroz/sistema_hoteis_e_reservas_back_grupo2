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
        reserva.setNumero_diarias(dto.numero_diarias());
        reserva.setValor_total(dto.valor_total());
        reserva.setId_hotel(dto.id_hotel());

        reserva = reservaRepository.save(reserva);
        return new RetornarReservaDTO(reserva.getId(), reserva.getNumero_diarias(), reserva.getValor_total(), reserva.getId_hotel(), reserva.getUsuario());
    }

    public Page<Reserva> listarReservas(String idHotel, Pageable pageable) {
        if (idHotel != null) {
            return reservaRepository.findById_hotel(idHotel, pageable); // Correção para usar findById_hotel
        }
        return reservaRepository.findAll(pageable);
    }

    public Reserva buscarReserva(String id) {
        return reservaRepository.findById(id)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Reserva não encontrada"));
    }

    public List<Reserva> buscarReservasPorUsuario(String idUsuario) {
        Usuario usuario = usuarioService.buscarUsuario(dto.usuario().getId());
        List<Reserva> reservas = reservaRepository.findByUsuario(usuario);
        if (reservas.isEmpty()) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Nenhuma reserva encontrada para o usuário");
        }
        return reservas;
    }

    public List<Reserva> buscarReservasPorHotel(String idHotel) {
        List<Reserva> reservas = reservaRepository.findById_hotel(idHotel, Pageable.unpaged()).getContent(); // Correção para usar findById_hotel
        if (reservas.isEmpty()) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Nenhuma reserva encontrada para o hotel com ID: " + idHotel);
        }
        return reservas;
    }

    public void excluirReserva(String id) {
        Reserva reserva = buscarReserva(id);
        reservaRepository.delete(reserva);
    }
}
