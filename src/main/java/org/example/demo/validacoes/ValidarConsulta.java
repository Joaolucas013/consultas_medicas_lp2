package org.example.demo.validacoes;


import org.example.demo.medico.Medico;
import org.example.demo.service.MedicoService;
import org.example.demo.paciente.Paciente;

import java.time.LocalDateTime;
import java.util.Scanner;

public class ValidarConsulta {

    Scanner scanner = new Scanner(System.in);
    static MedicoService medicoService = new MedicoService();

    public void validarHorario(Paciente paciente, Medico medico) {
        var horarioPaciente = paciente.getConsulta();
        var horarioDescansoMedico = medico.getHorarioDescanso();

        if (horarioPaciente.equals(horarioDescansoMedico)) {
            System.out.println("Erro: " + horarioPaciente + " é o horário de descanso do médico: " + medico.getNome());
            novoHorario(paciente, medico);
        }
    }


    private void novoHorario(Paciente paciente, Medico medico) {
        System.out.println("Outro horario disponível para consulta com "
                + medico.getNome() + " é " + medico.getHorarioDisponivel());

        System.out.println("Deseja agendar para esse horario? (S/N)");
        String resposta = new Scanner(System.in).nextLine().trim().toUpperCase();

        if (resposta.contains("S")) {
            medico.setDataConsulta(medico.getHorarioDisponivel());
            paciente.setConsulta(medico.getHorarioDisponivel());
            System.out.println("horario da consulta atualizado com sucesso para: " + medico.getDataConsulta());
        } else {
            System.out.println("Informe o horário que deseja agendar:");
            LocalDateTime horario = LocalDateTime.parse(scanner.nextLine().trim());
            paciente.setConsulta(horario);
            medico.setDataConsulta(horario);
            System.out.println("horario da consulta atualizado com sucesso para: " + medico.getDataConsulta());
        }
    }

    public void verificacao(Paciente paciente,  Medico medico) {


        if (paciente.getConsulta().equals(medico.getBloqueado())) {
            System.out.println("Horário [" + medico.getBloqueado() + "] está bloqueado. Escolha outro!");
            System.out.println("Outra opção de horário: [" + medico.getHorarioDisponivel() + "] deseja agendar para essa data? (S/N)");
            String resposta = new Scanner(System.in).nextLine().trim().toUpperCase();

            if (resposta.contains("S")) {
                medico.setDataConsulta(medico.getHorarioDisponivel());
                paciente.setConsulta(medico.getHorarioDisponivel());
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


}
