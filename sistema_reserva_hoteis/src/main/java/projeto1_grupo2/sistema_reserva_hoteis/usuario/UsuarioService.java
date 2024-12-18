package projeto1_grupo2.sistema_reserva_hoteis.usuario;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;
import projeto1_grupo2.sistema_reserva_hoteis.reserva.Reserva;
import projeto1_grupo2.sistema_reserva_hoteis.reserva.ReservaRepository;
import projeto1_grupo2.sistema_reserva_hoteis.reserva.ReservaService;

import java.util.List;

@Service
public class UsuarioService {

    @Autowired
    private UsuarioRepository usuarioRepository;

    @Autowired
    private ReservaRepository reservaRepository;

    public RetornarUsuarioDTO cadastrarUsuario(CadastrarUsuarioDTO dto) {

        Usuario usuario = new Usuario();
        usuario.setNome(dto.nome());
        usuario.setEndereco(dto.endereco());
        usuario.setEmail(dto.email());
        usuario.setTelefone(dto.telefone());

        usuario = usuarioRepository.save(usuario);
        return new RetornarUsuarioDTO(usuario.getId(), usuario.getNome(), usuario.getEndereco(), usuario.getEmail(), usuario.getTelefone());
    }

    public Page<Usuario> listarUsuarios(String nome, Pageable pageable) {
        if (nome != null) {
            return usuarioRepository.findByNome(nome, pageable);
        }
        return usuarioRepository.findAll(pageable);
    }

    public List<Usuario> listarTodosUsuarios() {
        return usuarioRepository.findAll();
    }

    public Usuario buscarUsuario(String id) {
        return usuarioRepository.findById(id)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND));
    }

    public List<Reserva> buscarReservasPorUsuario(Usuario usuario) {
        return reservaRepository.findByUsuario(usuario);
    }

    public void excluirUsuario(String id) {
        Usuario usuario = buscarUsuario(id);
        if (buscarReservasPorUsuario(usuario).isEmpty()) {
            usuarioRepository.delete(usuario);
        }
    }

}
