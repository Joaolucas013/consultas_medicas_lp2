package org.example.demo.service;

import org.example.demo.exception.ExceptionConsultas;
import org.example.demo.medico.Especialidade;
import org.example.demo.medico.Especialidade;
import org.example.demo.medico.Medico;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

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


         var medico = new Medico(nome, crmChecado,especialidade, dataConsulta, horarioDisponivel, horarioDescanso);
        medicoList.add(medico);
        medicoList.stream().forEach(System.out::println);

        return medico;

    }

    private String validarCrm(String crm) {
        List<Medico> list = retornaMedicos();
        String novo = "";

        for (int i = 0; i < list.size(); i++) {
            Medico m = list.get(i);

            if (m.getCrm().equals(crm) || crm.length() < 4) {
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
        Medico med1 = new Medico("Joao", "1234", Especialidade.CARDIOLOGIA,
                LocalDateTime.parse("2025-01-16T09:00"),
                LocalDateTime.parse("2025-01-16T16:40"),
                LocalDateTime.parse("2025-01-16T11:00")
        );
        Medico med2 = new Medico(
                "Luiz Gabriel",
                "1122",
                Especialidade.ORTOPEDIA,
                LocalDateTime.parse("2025-01-18T11:00"),
                LocalDateTime.parse("2025-01-18T15:00"),
                LocalDateTime.parse("2025-01-18T13:00:00")
        );

        Medico med3 = new Medico(
                "Gabriel Silvestre",
                "3344",
                Especialidade.NEUROLOGIA,
                LocalDateTime.parse("2025-01-19T07:00"),
                LocalDateTime.parse("2025-01-19T11:00"),
                LocalDateTime.parse("2025-01-19T09:00")
        );
        Medico med4 = new Medico(
                "Láiza Kevelly",
                "5678",
                Especialidade.DERMATOLOGIA,
                LocalDateTime.parse("2025-01-16T09:00"),
                LocalDateTime.parse("2025-01-16T13:00"),
                LocalDateTime.parse("2025-01-16T11:00")
        );

        Medico med5 = new Medico(
                "Gabriel Barbosa",
                "5678",
                Especialidade.DERMATOLOGIA,
                LocalDateTime.parse("2025-01-17T09:00"),
                LocalDateTime.parse("2025-01-17T13:00"),
                LocalDateTime.parse("2025-01-17T11:00")
        );


        medicoList.add(med1);
        medicoList.add(med2);
        medicoList.add(med3);
        medicoList.add(med4);
        medicoList.add(med5);
    }

    public List<Medico> retornaMedicos() {
        return medicoList;
    }

    public Medico procurarMedico(String nome) {
        List<Medico> medicos = retornaMedicos();

        if (medicos.isEmpty()) {
            throw new ExceptionConsultas("Lista de medicos esta vazia.");
        }

        for (Medico medico1 : medicos) {
            if (medico1.getNome().equalsIgnoreCase(nome)) {
                return medico1;
            }
        }
        System.out.println("Medico não encontrado!!!");
        return null;
    }



}


