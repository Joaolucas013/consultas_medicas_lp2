package org.example.demo.service;

import org.example.demo.consulta.Consultas;
import org.example.demo.medico.Especialidade;
import org.example.demo.medico.Medico;
import org.example.demo.paciente.Paciente;
import org.example.demo.armazenamento.ArmazenamentoConsultas;
import org.example.demo.exception.ExceptionConsultas;
import org.example.demo.validacoes.ValidarConsulta;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class ConsultaService {

    static Scanner scanner = new Scanner(System.in);
    public ArmazenamentoConsultas armazenamentoConsultas = new ArmazenamentoConsultas();
    static List<Consultas> consultasList = new ArrayList<>();
    static MedicoService medicoService = new MedicoService();
    static PacienteService pacienteService = new PacienteService();
    static ValidarConsulta validarConsulta = new ValidarConsulta();

    public void agendar() {
        Paciente paciente = pacienteService.cadastrarPaciente();
        medicoService.retornaMedicos().stream().forEach(System.out::println);
        System.out.println("Informe o nome do médico para agendamento: ");
        String nome = scanner.nextLine();
        var medico = medicoService.procurarMedico(nome);
        medico.setDataConsulta(paciente.getConsulta());

        validarConsulta.verificacao(paciente, medico);
        validarConsulta.validarHorario(paciente, medico);

        Consultas consultas = new Consultas(medico.getDataConsulta(), medico, paciente);

        armazenamentoConsultas.salvarConsultas(consultas);
        System.out.println("Consulta marcada com sucesso!!!");
        consultasList.stream().forEach(System.out::println);

    }

    private Medico buscarEspecialidade(Especialidade especialidade) {
        var medico = medicoService.retornaMedicos();
        for (Medico med : medico) {
            if (med.getEspecialidade().equals(especialidade)) {
                return med;
            }
        }
        return null;
    }

    public void cadastrarPelaEspecialidade() {

        var paciente = pacienteService.cadastrarPaciente();
        medicoService.retornaMedicos().stream().forEach(System.out::println);

        System.out.println("Escolha a especialidade:");
        Especialidade especialidade = Especialidade.valueOf(scanner.nextLine().toUpperCase());

        var medicoEspecialidade = buscarEspecialidade(especialidade);
        var medico = new Medico(medicoEspecialidade.getNome(), medicoEspecialidade.getCrm(), medicoEspecialidade.getEspecialidade(), medicoEspecialidade.getDataConsulta(),
                medicoEspecialidade.getHorarioDisponivel(), medicoEspecialidade.getHorarioDescanso());

        medico.setDataConsulta(paciente.getConsulta());
        validarConsulta.validarHorario(paciente, medico);
        validarConsulta.verificacao(paciente, medico);


        Consultas consultas = new Consultas(paciente.getConsulta(), medico, paciente);
        System.out.println("Agendado com sucesso!");
        consultasList.add(consultas);
        armazenamentoConsultas.salvarConsultas(consultas);
        consultasList.stream().forEach(System.out::println);
    }


    public static void bloquearHorario() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Informe o nome do médico:");
        String nome = scanner.nextLine().trim();
        Medico medico = medicoService.procurarMedico(nome);

        if (medico == null) {
            throw  new ExceptionConsultas("Médico não encontrado!!!");
        }
        System.out.println("Informe o horário que deseja bloquear (exemplo:(2019-01-16T19:00))");
        LocalDateTime horario = LocalDateTime.parse(scanner.nextLine().trim());
        medico.setBloqueado(horario);
        System.out.println("Horário bloqueado com sucesso!");
        System.out.println("Nome: " + medico.getNome() + ", Horário Bloqueado: " + medico.getBloqueado());

    }

    public List<Consultas> list(){
        return consultasList;
    }

}