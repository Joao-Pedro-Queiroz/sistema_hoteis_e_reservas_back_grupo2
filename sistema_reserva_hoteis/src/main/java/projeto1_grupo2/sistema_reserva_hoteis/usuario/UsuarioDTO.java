package projeto1_grupo2.sistema_reserva_hoteis.usuario;

// DTO para retornar os dados do usuário
record RetornaUsuarioDTO(String id, String nome, String endereco, String email, String telefone) {}

// DTO para cadastro de um novo usuário
record CadastraUsuarioDTO(String nome, String endereco, String email, String telefone) {}

// DTO para editar os dados do usuário (atualização parcial ou completa)
record EditaUsuarioDTO(String nome, String endereco, String email, String telefone) {}