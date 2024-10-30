package projeto1_grupo2.sistema_reserva_hoteis.reserva;

import projeto1_grupo2.sistema_reserva_hoteis.usuario.Usuario;

import java.time.LocalDateTime;

// DTO para retornar os dados de uma reserva
record RetornarReservaDTO(String id, Integer numeroDiaria, Double valorTotal, LocalDateTime data, String idHotel, Usuario usuario) {}

// DTO para cadastrar uma nova reserva
record CadastrarReservaDTO(Integer numeroDiaria, Double valorTotal, LocalDateTime data, String idHotel, Usuario usuario) {}

// DTO para editar uma reserva existente
record EditarReservaDTO(Integer numeroDiaria, Double valorTotal, LocalDateTime data, String idHotel) {}
