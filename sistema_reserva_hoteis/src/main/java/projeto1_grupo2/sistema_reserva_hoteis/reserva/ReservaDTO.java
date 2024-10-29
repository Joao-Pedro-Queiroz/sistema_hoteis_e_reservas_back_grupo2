package projeto1_grupo2.sistema_reserva_hoteis.reserva;

// DTO para retornar os dados de uma reserva
record RetornarReservaDTO(String usuarioId, Integer numero_diarias, Double valor_total, String id_hotel) {}

// DTO para cadastrar uma nova reserva
record CadastrarReservaDTO(String usuarioId, Integer numero_diarias, Double valor_total, String id_hotel) {}

// DTO para editar uma reserva existente
record EditarReservaDTO(String usuarioId, Integer numero_diarias, Double valor_total, String id_hotel) {}
