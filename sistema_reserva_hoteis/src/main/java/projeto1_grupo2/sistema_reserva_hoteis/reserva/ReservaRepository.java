package projeto1_grupo2.sistema_reserva_hoteis.reserva;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.mongodb.repository.MongoRepository;
import projeto1_grupo2.sistema_reserva_hoteis.usuario.Usuario;

import java.util.List;

public interface ReservaRepository extends MongoRepository<Reserva, String> {
    Page<Reserva> findById_hotel(String id_hotel, Pageable pageable);
    List<Reserva> findByUsuario(Usuario usuario);
}
