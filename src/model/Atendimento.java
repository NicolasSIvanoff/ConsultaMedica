package model;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Objects;

public class Atendimento {
    private LocalDate data;
    private String descricao;

    public Atendimento(LocalDate data, String descricao) {
        this.data = data;
        this.descricao = descricao;
    }

    public LocalDate getData() {
        return data;
    }

    public String getDescricao() {
        return descricao;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj == null || getClass() != obj.getClass()) return false;
        Atendimento that = (Atendimento) obj;
        return Objects.equals(data, that.data) && Objects.equals(descricao, that.descricao);
    }

    @Override
    public String toString() {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
        String dataFormatada = data.format(formatter);
        return "Data: " + dataFormatada + ", Descrição: " + descricao;
    }
}
