package org.example.medico;

import java.time.LocalDateTime;
import java.util.*;
import java.util.stream.Collectors;

public class MedicoService {
    Scanner scanner = new Scanner(System.in);

    List<Medico> medicoList = new ArrayList<>();


    public void cadastrarMedico() {
        System.out.println("Informe o nome do medico:");
        String nome = scanner.nextLine().trim();
        System.out.println("Informe o CRM");
        String crm = scanner.nextLine().trim();
        System.out.println("Informe a sua especialidade:");
        Especialidade especialidade = Especialidade.valueOf(scanner.nextLine().toUpperCase());
        System.out.println("Informe a data da consulta");
        LocalDateTime dataConsulta = LocalDateTime.parse(scanner.nextLine().trim());
        System.out.println("Informe algum horario disponível no dia:");
        LocalDateTime horarioDisponivel = LocalDateTime.parse(scanner.nextLine().trim());
        System.out.println("Informe o horario de descanso");
        LocalDateTime horarioDescanso = LocalDateTime.parse(scanner.nextLine());
        MedicoDto medicoDto = new MedicoDto(nome, crm, especialidade, dataConsulta, horarioDisponivel, horarioDescanso);

        medicoList.add(new Medico(medicoDto));

    }

    public List<MedicoDto> retornaMedicos() {

       List<MedicoDto> medicos = medicoList
                .stream()
                .map(m -> new MedicoDto(m.getNome(), m.getCrm(), m.getEspecialidade(), m.getDataConsulta(),
                        m.getHorarioDisponivel(), m.getHorarioDescanso())).collect(Collectors.toList());

       return medicos;
    }


}
