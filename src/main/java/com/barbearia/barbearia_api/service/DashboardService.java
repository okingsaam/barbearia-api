package com.barbearia.barbearia_api.service;

import com.barbearia.barbearia_api.infrastructure.entity.Agendamento;
import com.barbearia.barbearia_api.infrastructure.repository.AgendamentoRepository;
import com.barbearia.barbearia_api.infrastructure.repository.ClienteRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

@Service
@RequiredArgsConstructor
public class DashboardService {

    private final AgendamentoRepository agendamentoRepository;
    private final ClienteRepository clienteRepository;

    public Map<String, Object> getDashboard() {
        LocalDateTime inicioDia = LocalDate.now().atStartOfDay();
        LocalDateTime fimDia = inicioDia.plusDays(1);
        LocalDateTime inicioOntem = inicioDia.minusDays(1);
        LocalDateTime inicioMes = LocalDate.now().withDayOfMonth(1).atStartOfDay();
        LocalDateTime inicioMesAnterior = inicioMes.minusMonths(1);

        List<Agendamento> agendamentosHoje = agendamentoRepository.findByDataHoraBetween(inicioDia, fimDia);
        List<Agendamento> agendamentosOntem = agendamentoRepository.findByDataHoraBetween(inicioOntem, inicioDia);

        Double faturamentoHoje = agendamentoRepository.faturamentoPorPeriodo(inicioDia, fimDia);
        Double faturamentoOntem = agendamentoRepository.faturamentoPorPeriodo(inicioOntem, inicioDia);

        Long clientesMes = agendamentoRepository.clientesAtendidosPorPeriodo(inicioMes, fimDia);
        Long clientesMesAnterior = agendamentoRepository.clientesAtendidosPorPeriodo(inicioMesAnterior, inicioMes);

        double ticketMedio = agendamentosHoje.isEmpty() ? 0 : faturamentoHoje / agendamentosHoje.size();

        Map<String, Object> faturamento7dias = new LinkedHashMap<>();
        for (int i = 6; i >= 0; i--) {
            LocalDateTime ini = LocalDate.now().minusDays(i).atStartOfDay();
            LocalDateTime fim = ini.plusDays(1);
            Double valor = agendamentoRepository.faturamentoPorPeriodo(ini, fim);
            faturamento7dias.put(LocalDate.now().minusDays(i).toString(), valor);
        }

        Map<String, Object> resultado = new LinkedHashMap<>();
        resultado.put("agendamentosHoje", agendamentosHoje.size());
        resultado.put("agendamentosOntem", agendamentosOntem.size());
        resultado.put("faturamentoHoje", faturamentoHoje);
        resultado.put("faturamentoOntem", faturamentoOntem);
        resultado.put("clientesMes", clientesMes);
        resultado.put("clientesMesAnterior", clientesMesAnterior);
        resultado.put("ticketMedio", ticketMedio);
        resultado.put("faturamento7dias", faturamento7dias);
        resultado.put("agendamentosDoDia", agendamentosHoje);

        return resultado;
    }
}