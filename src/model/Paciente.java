package model;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Objects;

public class Paciente {
    private String nome;
    private LocalDate dataNascimento;
    private ArrayList<Atendimento> atendimentos;

    public Paciente(String nome, LocalDate dataNascimento) {
        this.nome = nome;
        this.dataNascimento = dataNascimento;
        this.atendimentos = new ArrayList<>();
    }

    public void alterarPaciente(String nome, LocalDate dataNascimento) {
        this.nome = nome;
        this.dataNascimento = dataNascimento;
    }

    public String getNome() {
        return nome;
    }

    public LocalDate getDataNascimento() {
        return dataNascimento;
    }

    public ArrayList<Atendimento> getAtendimentos() {
        return atendimentos;
    }

    public void adicionarAtendimento(Atendimento atendimento) {
        atendimentos.add(atendimento);
    }

    public void mostrarPaciente() {
        System.out.println("Nome: " + nome);
        System.out.println("Data de Nascimento: " + dataNascimento);
        System.out.println("Atendimentos:");

        for (Atendimento atendimento : atendimentos) {
            System.out.println(atendimento);
        }
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj == null || getClass() != obj.getClass()) return false;
        Paciente paciente = (Paciente) obj;
        return Objects.equals(nome, paciente.nome) && Objects.equals(dataNascimento, paciente.dataNascimento);
    }

    @Override
    public String toString() {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
        String dataFormatada = dataNascimento.format(formatter);
        return "Nome: " + nome + ", Data de Nascimento: " + dataFormatada;
    }
}
