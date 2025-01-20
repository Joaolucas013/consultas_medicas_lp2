package org.example.demo.paciente;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDateTime;
import java.util.Objects;



@Getter
@Setter
@NoArgsConstructor
public class Paciente {
    private String nome;
    private String sexo;
    private int idade;
    private LocalDateTime consulta;


    public Paciente(String nome, String sexo, int idade, LocalDateTime consulta) {
        this.nome = nome;
        this.sexo = sexo;
        this.idade = idade;
        this.consulta = consulta;
    }



    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getSexo() {
        return sexo;
    }

    public void setSexo(String sexo) {
        this.sexo = sexo;
    }

    public int getIdade() {
        return idade;
    }

    public void setIdade(int idade) {
        this.idade = idade;
    }

    public LocalDateTime getConsulta() {
        return consulta;
    }

    public void setConsulta(LocalDateTime consulta) {
        this.consulta = consulta;
    }



    @Override
    public String toString() {
        return "Paciente{" +
                "nome='" + nome + '\'' +
                ", sexo='" + sexo + '\'' +
                ", idade=" + idade +
                ", consulta=" + consulta +
                '}';
    }

    // se tiver todos os atributos iguais, então o paciente é o mesmo
    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        Paciente paciente = (Paciente) o;
        return idade == paciente.idade && Objects.equals(nome, paciente.nome) && Objects.equals(sexo, paciente.sexo) && Objects.equals(consulta, paciente.consulta);
    }

    @Override
    public int hashCode() {
        return Objects.hash(nome, sexo, idade, consulta);
    }

}
