package com.empresa.model;

import java.time.LocalDate;
import java.time.Period;
import java.time.YearMonth;

/* Funcionário genérico da empresa. Classe abstrata que serve de base para os cargos específicos. */
public abstract class Funcionario {
    private String nome;
    private LocalDate dataContratacao;

    public Funcionario(String nome, LocalDate dataContratacao) {
        this.nome = nome;
        this.dataContratacao = dataContratacao;
    }

    public String getNome() {
        return nome;
    }

    public LocalDate getDataContratacao() {
        return dataContratacao;
    }

    /**
     * Calcula os anos de serviço com base na data de contratação e uma data de referência.
     * @param dataReferencia Mês e ano para o cálculo.
     * @return O número de anos completos de serviço.
     */
    public int getAnosDeServico(YearMonth dataReferencia) {
        return Period.between(dataContratacao, dataReferencia.atEndOfMonth()).getYears();
    }

    /**
     * Método abstrato para calcular o salário em um determinado mês/ano.
     * Cada subclasse (cargo) deve implementar sua própria lógica de cálculo.
     * @param dataReferencia Mês e ano para o cálculo do salário.
     * @return O valor do salário.
     */
    public abstract double getSalario(YearMonth dataReferencia);

    /**
     * Método abstrato para calcular o benefício em um determinado mês/ano.
     * Cada subclasse (cargo) deve implementar sua própria lógica de cálculo.
     * @param dataReferencia Mês e ano para o cálculo do benefício.
     * @return O valor do benefício.
     */
    public abstract double getBeneficio(YearMonth dataReferencia);

    /**
     * Calcula o valor total recebido (salário + benefício) no mês de referência.
     * @param dataReferencia Mês e ano para o cálculo.
     * @return O valor total.
     */
    public double getValorTotalRecebido(YearMonth dataReferencia) {
        return getSalario(dataReferencia) + getBeneficio(dataReferencia);
    }
}