package com.empresa.model;

import java.time.LocalDate;
import java.time.YearMonth;

/* Representa um funcionário do cargo Gerente. */
public class Gerente extends Funcionario {
    private static final double SALARIO_BASE = 20000.00;
    private static final double BONUS_ANUAL = 3000.00;

    public Gerente(String nome, LocalDate dataContratacao) {
        super(nome, dataContratacao);
    }

    @Override
    public double getSalario(YearMonth dataReferencia) {
        int anosDeServico = getAnosDeServico(dataReferencia);
        return SALARIO_BASE + (anosDeServico * BONUS_ANUAL);
    }

    @Override
    public double getBeneficio(YearMonth dataReferencia) {
        /* Gerente não tem benefícios */
        return 0.0;
    }
}