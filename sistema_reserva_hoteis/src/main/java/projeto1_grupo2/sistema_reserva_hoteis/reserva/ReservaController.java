package projeto1_grupo2.sistema_reserva_hoteis.reserva;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import projeto1_grupo2.sistema_reserva_hoteis.usuario.Usuario;

import java.util.List;
import java.util.HashMap;

@RestController
@RequestMapping("/api/v1/reserva")
public class ReservaController {

    @Autowired
    private ReservaService reservaService;

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public RetornarReservaDTO cadastrarReserva(@RequestBody CadastrarReservaDTO reserva) {
        return reservaService.cadastrarReserva(reserva);
    }

    @GetMapping
    public Page<Reserva> listarReservas(@RequestParam(required = false) String idHotel, Pageable pageable) {
        return reservaService.listarReservas(idHotel, pageable);
    }

    @GetMapping("/usuario/{idUsuario}")
    public ReservaUsuario relatorioReservas(@PathVariable String idUsuario) {
        return reservaService.relatorioReservas(idUsuario);
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void excluirUsuario(@PathVariable String id) {
        reservaService.excluirReserva(id);
    }
}