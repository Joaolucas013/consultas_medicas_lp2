package org.example.paciente;

import org.example.medico.Medico;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.Scanner;
import java.util.stream.Collectors;

public class PacienteService {
    Scanner scanner = new Scanner(System.in);
  static  List<Paciente> pacienteList = new ArrayList<>();

    public Paciente cadastrarPaciente() {
        System.out.println("Informe o  nome do paciente:");
        String nome = new Scanner(System.in).nextLine().trim();
        System.out.println("Informe o sexo:");
        String sexo = new Scanner(System.in).nextLine().trim();
        System.out.println("Informe o data e horario da consulta:");
        LocalDateTime horario = LocalDateTime.parse(scanner.nextLine().trim());
        System.out.println("Informe a sua idade:");
        int idade = scanner.nextInt();


        var pacienteDto = new PacienteDto(nome, sexo, idade, horario);
        Paciente paciente = new Paciente(pacienteDto);
        pacienteList.add(paciente);
        return paciente;
    }

    public List<PacienteDto> retornaListaPaciente() {
        List<PacienteDto> pacienteDtos = pacienteList
                .stream().map(p -> new PacienteDto(p.getNome(), p.getSexo(), p.getIdade(), p.getConsulta()))
                .collect(Collectors.toList());

        return pacienteDtos;
    }

}
