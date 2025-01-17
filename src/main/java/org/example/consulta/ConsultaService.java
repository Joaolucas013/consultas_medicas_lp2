package org.example.consulta;

import org.example.medico.Especialidade;
import org.example.medico.Medico;
import org.example.medico.MedicoDto;
import org.example.medico.MedicoService;
import org.example.paciente.PacienteDto;
import org.example.paciente.PacienteService;
import org.example.validacoes.ValidarConsulta;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class ConsultaService {

    Scanner scanner = new Scanner(System.in);

    static List<Consultas> consultasList = new ArrayList<>();
    MedicoService medicoService = new MedicoService();
    PacienteService pacienteService = new PacienteService();
   static ValidarConsulta validarConsulta = new ValidarConsulta();

    public MedicoDto procurarMedico(String nome) {
        List<MedicoDto> medicos = medicoService.retornaMedicos();

        if (medicos.isEmpty()) {
            throw new ExceptionConsultas("Lista de medicos esta vazia.");
        }

        for (MedicoDto medico1 : medicos) {
            if (medico1.nome().equalsIgnoreCase(nome)) {
                return medico1;
            }
        }
        System.out.println("Medico não encontrado!!!");
        return null;
    }

    private PacienteDto buscarPaciente(String nomePaciente) {
        List<PacienteDto> pacienteList = pacienteService.retornaListaPaciente();
        boolean encontrado = false;

        if (pacienteList.isEmpty()) {
            throw new ExceptionConsultas("Lista de paciente esta vazia.");
        }

        for (PacienteDto pacienteDto : pacienteList) {
            if (pacienteDto.nome().equalsIgnoreCase(nomePaciente)) {
                encontrado = true;
                return pacienteDto;
            }
        }
        if (!encontrado) {
            System.out.println("Paciente não foi encontrado!!!");
        }
        return null;
    }


    public void agendar() {

        var paciente = pacienteService.cadastrarPaciente();

        medicoService.retornaMedicos().stream().forEach(System.out::println);
        System.out.println("escolha algum medico   para agendar consulta: ");
        String nome = scanner.nextLine();

        MedicoDto m = procurarMedico(nome);
        Medico medico = new Medico(m);

        validarConsulta.validarHorario(paciente, medico);
        Consultas consultas = new Consultas(paciente.getConsulta(), medico, paciente);

        consultasList.add(consultas);
        System.out.println("Consulta marcada com sucesso!!!");
        consultasList.stream().forEach(System.out::println);

    }


    private MedicoDto buscarEspecialidade(Especialidade especialidade) {
        var medico = medicoService.retornaMedicos();
        for (MedicoDto med : medico) {
            if (med.especialidade().equals(especialidade)) {
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
        var medico = new Medico(medicoEspecialidade);
        medico.setDataConsulta(paciente.getConsulta());


        Consultas consultas = new Consultas(medico.getDataConsulta(), medico, paciente);
        System.out.println("Agendado com sucesso!");
        consultasList.add(consultas);
        consultasList.stream().forEach(System.out::println);

    }
}