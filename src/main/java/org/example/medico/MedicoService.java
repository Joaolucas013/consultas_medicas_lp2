package org.example.medico;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;

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

        public void iniciarMedicos(){

                MedicoDto med1 = new MedicoDto("João Lucas", "1234", Especialidade.CARDIOLOGIA,
                        LocalDateTime.parse("2025-01-16T09:00"),
                        LocalDateTime.parse("2025-01-16T13:00"),
                        LocalDateTime.parse("2025-01-16T11:00")
                );
                MedicoDto med2 = new MedicoDto(
                        "Luiz Gabriel",
                        "1122",
                        Especialidade.ORTOPEDIA,
                        LocalDateTime.parse("2025-01-18T11:00"),
                        LocalDateTime.parse("2025-01-18T15:00"),
                        LocalDateTime.parse("2025-01-18T13:00")
                );

        MedicoDto med3 = new MedicoDto(
                "Gabriel Silvestre",
                "3344",
                Especialidade.NEUROLOGIA,
                LocalDateTime.parse("2025-01-19T07:00"),
                LocalDateTime.parse("2025-01-19T11:00"),
                LocalDateTime.parse("2025-01-19T09:00")
        );
            MedicoDto med4 = new MedicoDto(
                    "Láiza Kevelly",
                    "5678",
                    Especialidade.DERMATOLOGIA,
                    LocalDateTime.parse("2025-01-16T09:00"),
                    LocalDateTime.parse("2025-01-16T13:00"),
                    LocalDateTime.parse("2025-01-16T11:00")
            );

            MedicoDto med5 = new MedicoDto(
                    "Gabriel Barbosa",
                    "5678",
                    Especialidade.DERMATOLOGIA,
                    LocalDateTime.parse("2025-01-17T09:00"),
                    LocalDateTime.parse("2025-01-17T13:00"),
                    LocalDateTime.parse("2025-01-17T11:00")
            );

            medicoList.add(new Medico(med1));
            medicoList.add(new Medico(med2));
            medicoList.add(new Medico(med3));
            medicoList.add(new Medico(med4));
            medicoList.add(new Medico(med5));
        }



    public List<MedicoDto> retornaMedicos() {

        List<MedicoDto> medicos = medicoList
                .stream()
                .map(m -> new MedicoDto(m.getNome(), m.getCrm(), m.getEspecialidade(), m.getDataConsulta(),
                        m.getHorarioDisponivel(), m.getHorarioDescanso())).collect(Collectors.toList());
        return medicos;
    }

}


