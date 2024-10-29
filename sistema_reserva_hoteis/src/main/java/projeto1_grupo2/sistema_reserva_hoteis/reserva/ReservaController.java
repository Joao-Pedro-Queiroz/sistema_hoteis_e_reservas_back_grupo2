package projeto1_grupo2.sistema_reserva_hoteis.reserva;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import projeto1_grupo2.sistema_reserva_hoteis.usuario.Usuario;

import java.util.List;

@RestController
@RequestMapping("/api/v1/reservas")
public class ReservaController {

    @Autowired
    private ReservaService reservaService;

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public RetornarReservaDTO cadastrarReserva(@RequestBody CadastrarReservaDTO reserva) {
        return reservaService.cadastrarReserva(reserva);
    }

    @GetMapping
    public Page<Reserva> listarReservas(@RequestParam(required = false) String idUsuario, Pageable pageable) {
        return reservaService.listarReservas(idUsuario, pageable);
    }

    // buscar reservas por usuario
    @GetMapping("/usuario/{id}")
    public List<Reserva> listarReservasPorUsuario(@PathVariable Usuario usuario) {
        return reservaService.buscarReservasPorUsuario(usuario);
    }

    // buscar reservas por hotel
    @GetMapping("/hotel/{id}")
    public List<Reserva> listarReservasPorHotel(@PathVariable String id) {
        return reservaService.buscarReservasPorHotel(id);
    }
}