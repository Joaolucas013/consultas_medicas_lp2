package org.example.medico;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class MedicoService {
    Scanner scanner = new Scanner(System.in);

   static  List<Medico> medicoList = new ArrayList<>();


        public Medico cadastrarMedico() {
            System.out.println("Informe o nome do medico:");
            String nome = scanner.nextLine().trim();

            System.out.println("Informe o CRM");
            String crm = scanner.nextLine().trim();
            String crmChecado =  validarCrm(crm);

            System.out.println("Informe a sua especialidade:");
            Especialidade especialidade = Especialidade.valueOf(scanner.nextLine().toUpperCase());

            System.out.println("Informe a data da consulta");
            LocalDateTime dataConsulta = LocalDateTime.parse(scanner.nextLine().trim());

            System.out.println("Informe algum outro horario de disponibilidade para atendimento:");
            LocalDateTime horarioDisponivel = LocalDateTime.parse(scanner.nextLine().trim());

            System.out.println("Informe o horario de descanso");
            LocalDateTime horarioDescanso = LocalDateTime.parse(scanner.nextLine());

            var medicoDto = new MedicoDto(nome, crmChecado, especialidade, dataConsulta, horarioDisponivel, horarioDescanso);
            var medico = new Medico(medicoDto);
            medicoList.add(new Medico(medicoDto));
            medicoList.stream().forEach(System.out::println);

            return medico;

        }

    private String validarCrm(String crm) {
        List<MedicoDto> list = retornaMedicos();
        String novo = "";

        for (int i = 0; i < list.size(); i++) {
            MedicoDto m = list.get(i);

            if (m.crm().equals(crm) || crm.length() < 4) {
                System.out.println("CRM inválido! informe novamente corretamente");
                String validado = novoCrm(crm);
                novo =  validarCrm(validado);
                return novo;
            }
        }
        return novo+=crm;
    }

    private String novoCrm(String crm) {
        System.out.println("Informe o novo crm");
        String novoCrm = scanner.nextLine().trim();
        return novoCrm;
    }

    public static void iniciarMedicos(){

                MedicoDto med1 = new MedicoDto("João Lucas", "1234", Especialidade.CARDIOLOGIA,
                        LocalDateTime.parse("2025-01-16T09:00"),
                        LocalDateTime.parse("2025-01-16T16:40"),
                        LocalDateTime.parse("2025-01-16T11:00")
                );
                MedicoDto med2 = new MedicoDto(
                        "Luiz Gabriel",
                        "1122",
                        Especialidade.ORTOPEDIA,
                        LocalDateTime.parse("2025-01-18T11:00"),
                        LocalDateTime.parse("2025-01-18T15:00"),
                        LocalDateTime.parse("2025-01-18T13:00:00")
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


