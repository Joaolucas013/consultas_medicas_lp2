package org.example.paciente;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDateTime;
// caso o plugin não esteja habilitado, remova @Getter @Setter@AllArgsConstructor @NoArgsConstructor
// e chame os metodos  getters e setters ou vá em settings ---> plugins ---> e instale o Lombok

@Getter
@Setter
@NoArgsConstructor
public class Paciente {
    private String nome;
    private String sexo;
    private int idade;

//    public Paciente(String nome, String sexo, int idade) {
//        this.nome = nome;
//        this.sexo = sexo;
//        this.idade = idade;
//    }
    public Paciente(PacienteDto dados) {
        this.nome = dados.nome();
        this.sexo = dados.sexo();
        this.idade = dados.idade();
    }


    @Override
    public String toString() {
        return "Paciente{" +
                "nome='" + nome + '\'' +
                ", sexo='" + sexo + '\'' +
                ", idade=" + idade +
                '}';
    }
}
