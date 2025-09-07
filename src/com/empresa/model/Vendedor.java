package com.empresa.model;

import java.time.LocalDate;
import java.time.YearMonth;
import java.util.HashMap;
import java.util.Map;

/* Representa um funcionário do cargo vendedor e contém um registro de vendas para calcular benefícios. */
public class Vendedor extends Funcionario {
    private static final double SALARIO_BASE = 12000.00;
    private static final double BONUS_ANUAL = 1800.00;
    private static final double PERCENTUAL_BENEFICIO_VENDA = 0.30; // 30%

    /* Mapa para armazenar o valor das vendas por mês ou ano */
    private Map<YearMonth, Double> vendasPorMes = new HashMap<>();

    public Vendedor(String nome, LocalDate dataContratacao) {
        super(nome, dataContratacao);
    }

    /**
     * Adiciona um registro de venda para um determinado mês/ano.
     * @param dataVenda A data da venda.
     * @param valorVenda O valor total vendido.
     */
    public void adicionarVenda(YearMonth dataVenda, double valorVenda) {
        this.vendasPorMes.put(dataVenda, valorVenda);
    }
    
    /**
     * Retorna o valor vendido em um determinado mês/ano.
     * @param dataReferencia A data para consulta.
     * @return O valor vendido, ou 0 se não houver vendas.
     */
    public double getVendaDoMes(YearMonth dataReferencia) {
        return this.vendasPorMes.getOrDefault(dataReferencia, 0.0);
    }

    @Override
    public double getSalario(YearMonth dataReferencia) {
        int anosDeServico = getAnosDeServico(dataReferencia);
        return SALARIO_BASE + (anosDeServico * BONUS_ANUAL);
    }

    @Override
    public double getBeneficio(YearMonth dataReferencia) {
        /* O benefício é 30% sobre o valor vendido no mês */
        double valorVendido = getVendaDoMes(dataReferencia);
        return valorVendido * PERCENTUAL_BENEFICIO_VENDA;
    }
}