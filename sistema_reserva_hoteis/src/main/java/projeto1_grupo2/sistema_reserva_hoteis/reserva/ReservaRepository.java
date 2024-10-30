package projeto1_grupo2.sistema_reserva_hoteis.reserva;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;
import projeto1_grupo2.sistema_reserva_hoteis.usuario.Usuario;

import java.util.List;

@Repository
public interface ReservaRepository extends MongoRepository<Reserva, String> {
    Page<Reserva> findByIdHotel(String id_hotel, Pageable pageable);
    List<Reserva> findByUsuario(Usuario usuario);
}
