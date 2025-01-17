package org.example.paciente;

import org.example.medico.Medico;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class PacienteService {
    Scanner scanner = new Scanner(System.in);
  static  List<Paciente> pacienteList = new ArrayList<>();


    public Paciente cadastrarPaciente() {
        System.out.println("Informe o  nome do paciente:");
        String nome = scanner.nextLine().trim();
        System.out.println("Informe a sua idade:");
        int idade = scanner.nextInt();
        scanner.nextLine();
        System.out.println("Informe o sexo:");
        String sexo = scanner.nextLine().trim();
        System.out.println("Informe o data e horario da consulta:");
        LocalDateTime horario = LocalDateTime.parse(scanner.nextLine().trim());


        var pacienteDto = new PacienteDto(nome, sexo, idade, horario);
        Paciente paciente = new Paciente(pacienteDto);
        validar(paciente);
        pacienteList.add(paciente);

        return paciente;
    }

    private void validar(Paciente paciente) {
        List<PacienteDto> listPaciente= this.retornaListaPaciente();

        for (int i = 0; i <listPaciente.size(); i++) {
            PacienteDto p = listPaciente.get(i);
            if(p.consulta().getDayOfWeek().equals(paciente.getConsulta().getDayOfWeek()) ){
                System.out.println("Erro! já existe uma consulta agendada para o dia: " + paciente.getConsulta());
                System.out.println("Escolha outra data:");
                System.out.println("Informe o data e horario da consulta:");
                LocalDateTime horario = LocalDateTime.parse(scanner.nextLine().trim());
                paciente.setConsulta(horario);

            }
        }
    }

    public List<PacienteDto> retornaListaPaciente() {
        List<PacienteDto> pacienteDtos = pacienteList
                .stream().map(p -> new PacienteDto(p.getNome(), p.getSexo(), p.getIdade(), p.getConsulta()))
                .collect(Collectors.toList());

        return pacienteDtos;
    }

}
