package projeto1_grupo2.sistema_reserva_hoteis.reserva;

import projeto1_grupo2.sistema_reserva_hoteis.usuario.Usuario;

// DTO para retornar os dados de uma reserva
record RetornarReservaDTO(String id, Integer numero_diarias, Double valor_total, String id_hotel, Usuario usuario) {}

// DTO para cadastrar uma nova reserva
record CadastrarReservaDTO(Integer numero_diarias, Double valor_total, String id_hotel, Usuario usuario) {}

// DTO para editar uma reserva existente
record EditarReservaDTO(Integer numero_diarias, Double valor_total, String id_hotel, Usuario usuario) {}
