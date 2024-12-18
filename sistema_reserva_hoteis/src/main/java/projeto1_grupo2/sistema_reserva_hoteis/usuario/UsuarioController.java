package projeto1_grupo2.sistema_reserva_hoteis.usuario;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/usuario")
public class UsuarioController {

    @Autowired
    private UsuarioService usuarioService;

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public RetornarUsuarioDTO cadastrarUsuario(@RequestBody CadastrarUsuarioDTO usuario) {
        return usuarioService.cadastrarUsuario(usuario);
    }

    @GetMapping
    public Page<Usuario> listarUsuario(@RequestParam(required = false) String nome
            , Pageable pageable) {
        return usuarioService.listarUsuarios(nome, pageable);
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void excluirUsuario(@PathVariable String id) {
        usuarioService.excluirUsuario(id);
    }
}