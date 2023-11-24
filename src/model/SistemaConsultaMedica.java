package model;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Objects;

public class SistemaConsultaMedica {
    private ArrayList<Paciente> pacientes;

    public SistemaConsultaMedica() {
        this.pacientes = new ArrayList<>();
    }

    public void incluirPaciente(Paciente paciente) {
        pacientes.add(paciente);
        System.out.println("Paciente incluído com sucesso.");
    }

    public Paciente buscarPacientePorNome(String nome) {
        for (Paciente paciente : pacientes) {
            if (paciente.getNome().equalsIgnoreCase(nome)) {
                return paciente;
            }
        }
        return null;
    }

    public void alterarPaciente(String nome, String novoNome, LocalDate novaDataNascimento) {
        Paciente paciente = buscarPacientePorNome(nome);

        if (paciente != null) {
            paciente.alterarPaciente(novoNome, novaDataNascimento);
            System.out.println("Paciente alterado com sucesso.");
        } else {
            System.out.println("Paciente não encontrado.");
        }
    }

    public void realizarConsulta(String nome, Atendimento atendimento) {
        Paciente paciente = buscarPacientePorNome(nome);

        if (paciente != null) {
            paciente.adicionarAtendimento(atendimento);
            System.out.println("Consulta realizada com sucesso.");
        } else {
            System.out.println("Paciente não encontrado.");
        }
    }

    // Outros métodos do SistemaConsultaMedica...

    public void listarPacientes() {
        for (Paciente paciente : pacientes) {
            System.out.println(paciente);
        }
    }

    public void mostrarPaciente(String nome) {
        Paciente paciente = buscarPacientePorNome(nome);

        if (paciente != null) {
            paciente.mostrarPaciente();
        } else {
            System.out.println("Paciente não encontrado.");
        }
    }

    public void apagarPaciente(String nome) {
        Iterator<Paciente> iterator = pacientes.iterator();

        while (iterator.hasNext()) {
            Paciente paciente = iterator.next();

            if (paciente.getNome().equalsIgnoreCase(nome)) {
                iterator.remove();
                System.out.println("Paciente removido com sucesso.");
                return;
            }
        }

        System.out.println("Paciente não encontrado.");
    }
}

