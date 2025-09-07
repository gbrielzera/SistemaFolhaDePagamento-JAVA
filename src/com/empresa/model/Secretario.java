package com.empresa.model;

import java.time.LocalDate;
import java.time.YearMonth;

/* Herda de Funcionario e implementa as regras de cálculo de salário e benefício. */
public class Secretario extends Funcionario {
    private static final double SALARIO_BASE = 7000.00;
    private static final double BONUS_ANUAL = 1000.00;
    private static final double PERCENTUAL_BENEFICIO = 0.20; // 20%

    public Secretario(String nome, LocalDate dataContratacao) {
        super(nome, dataContratacao);
    }

    @Override
    public double getSalario(YearMonth dataReferencia) {
        int anosDeServico = getAnosDeServico(dataReferencia);
        return SALARIO_BASE + (anosDeServico * BONUS_ANUAL);
    }

    @Override
    public double getBeneficio(YearMonth dataReferencia) {
        /* O benefício é 20% sobre o salário do mês */
        return getSalario(dataReferencia) * PERCENTUAL_BENEFICIO;
    }
}