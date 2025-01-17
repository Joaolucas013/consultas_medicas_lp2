package org.example.validacoes;

import org.example.medico.Medico;
import org.example.paciente.Paciente;

import java.time.LocalDateTime;
import java.util.Scanner;

public class ValidarConsulta {

    public void validarHorario(Paciente paciente, Medico medico) {
        var horarioPaciente = paciente.getConsulta();
        var horarioDescansoMedico = medico.getHorarioDescanso();

        if(horarioPaciente.equals(horarioDescansoMedico)){
            System.out.println("Erro: " + horarioPaciente + " é o horário de descanso do médico: " + medico.getNome());
            novoHorario(paciente, medico);
        }
    }


    private void novoHorario(Paciente paciente, Medico medico) {
        System.out.println("Outro horario disponível para consulta com o" +
                "  médico " + medico.getNome() + " é " + medico.getHorarioDisponivel());

        System.out.println("Deseja agendar para esse horario? (S/N)");
        String resposta = new Scanner(System.in).nextLine().trim().toUpperCase();

        if (resposta.contains("S")) {
            medico.setDataConsulta(medico.getHorarioDisponivel());
            System.out.println("horario da consulta atualizado com sucesso para: " + medico.getDataConsulta());
        } else {
            System.out.println("Informe o horário que deseja agendar:");
            LocalDateTime horario = LocalDateTime.parse(scanner.nextLine().trim());
            paciente.setConsulta(horario);
            medico.setDataConsulta(horario);
            System.out.println("horario da consulta atualizado com sucesso para: " + medico.getDataConsulta());
        }
    }

}
