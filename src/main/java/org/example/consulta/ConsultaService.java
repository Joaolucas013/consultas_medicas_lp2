package org.example.consulta;

import org.example.medico.*;
import org.example.paciente.Paciente;
import org.example.paciente.PacienteDto;
import org.example.paciente.PacienteService;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class ConsultaService {

    Scanner scanner = new Scanner(System.in);

    static List<Consultas> consultasList = new ArrayList<>();

    MedicoService medicoService = new MedicoService();
    PacienteService pacienteService = new PacienteService();


    public MedicoDto procurarMedico(String nome) {
        // retorna uma lista de MedicosDto
        List<MedicoDto> medicos = medicoService.retornaMedicos();

        if (medicos.isEmpty()) {
            throw new ExceptionConsultas("Lista de medicos esta vazia.");
        }

        // percorre toda a lista ate achar o nome igual
        for (MedicoDto medico1 : medicos) {
            if (medico1.nome().equalsIgnoreCase(nome)) {
                return medico1;
            }
        }
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
        pacienteService.cadastrarPaciente();

        medicoService.retornaMedicos().stream().forEach(System.out::println);
        System.out.println("escolha algum medico pelo nome  para agendar consulta: ");
        String nome = scanner.nextLine();

        MedicoDto m = procurarMedico(nome);
        Medico medico = new Medico(m);
//        Medico medico = new Medico(m.nome(), m.crm(), m.especialidade(),
//                m.dataConsulta(), m.horarioDisponivel(), m.horarioDescanso());


        System.out.println("Informe o nome do paciente: ");
        String nomePaciente = scanner.nextLine();

        PacienteDto p = buscarPaciente(nomePaciente);
        Paciente paciente = new Paciente(p);

        Consultas consultas = new Consultas(medico.getDataConsulta(), medico, paciente);
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

        pacienteService.cadastrarPaciente();
        System.out.println("Escolha a especialidade:");
        Especialidade especialidade = Especialidade.valueOf(scanner.nextLine().toUpperCase());

        var medicoEspecialidade = buscarEspecialidade(especialidade);
//        MedicoDto medicoDto=null;
//
//        for (MedicoDto medicoesp : buscarEspecialidade(especialidade)) {
//            if (medicoesp.especialidade().equals(especialidade)) {
//                medicoDto = medicoesp;
//            }
//        }

        System.out.println("Informe o nome do paciente novamente:");
        String nome = scanner.nextLine().trim();
        var p = buscarPaciente(nome);
        Paciente paciente = new Paciente(p);
        var medico = new Medico(medicoEspecialidade);


        Consultas consultas = new Consultas(medico.getDataConsulta(), medico, paciente);
        System.out.println("Agendando pela especialidade!");
        consultasList.add(consultas);
        consultasList.stream().forEach(System.out::println);

    }
}