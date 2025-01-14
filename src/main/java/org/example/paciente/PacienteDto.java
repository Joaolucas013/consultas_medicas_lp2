package org.example.paciente;

public record PacienteDto(String nome, String sexo, int idade){

    public PacienteDto(Paciente p){
        this(p.getNome(), p.getSexo(), p.getIdade());
    }
}
