package projeto1_grupo2.sistema_reserva_hoteis.usuario;

import org.springframework.data.annotation.Id;

public class Usuario {
    @Id
    private String id;
    private String nome;
    private String endereco;
    private String email;
    private String telefone;

    public String getId() { return id; }

    public void setId(String id) { this.id = id; }

    public String getTelefone() { return telefone; }

    public void setTelefone(String telefone) { this.telefone = telefone; }

    public String getEmail() { return email; }

    public void setEmail(String email) { this.email = email; }

    public String getEndereco() { return endereco; }

    public void setEndereco(String endereco) { this.endereco = endereco; }

    public String getNome() { return nome; }

    public void setNome(String nome) { this.nome = nome; }
}
