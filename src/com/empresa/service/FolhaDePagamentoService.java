package com.empresa.service;

import com.empresa.model.Funcionario;
import com.empresa.model.Vendedor;

import java.time.YearMonth;
import java.util.Comparator;
import java.util.List;
import java.util.Optional;

/* Serviço responsável por realizar os cálculos da folha de pagamento. */
public class FolhaDePagamentoService {

    /* 1. Calcula o valor total pago (salário + benefício) a uma lista de funcionários em um dado mês. */
    public double calcularValorTotalPago(List<Funcionario> funcionarios, YearMonth dataReferencia) {
        return funcionarios.stream()
                .mapToDouble(f -> f.getValorTotalRecebido(dataReferencia))
                .sum();
    }

    /* 2. Calcula o total pago somente em salários em um dado mês. */
    public double calcularTotalSalarios(List<Funcionario> funcionarios, YearMonth dataReferencia) {
        return funcionarios.stream()
                .mapToDouble(f -> f.getSalario(dataReferencia))
                .sum();
    }

    /* 3. Calcula o total pago em benefícios em um dado mês. A lista já vem filtrada apenas com funcionários que recebem benefícios. */
    public double calcularTotalBeneficios(List<Funcionario> funcionariosComBeneficio, YearMonth dataReferencia) {
        return funcionariosComBeneficio.stream()
                .mapToDouble(f -> f.getBeneficio(dataReferencia))
                .sum();
    }

    /* 4. Encontra o funcionário que recebeu o valor mais alto (salário + benefício) no mês. */
    public Funcionario obterFuncionarioMaiorValor(List<Funcionario> funcionarios, YearMonth dataReferencia) {
        Optional<Funcionario> funcionarioMaiorValor = funcionarios.stream()
                .max(Comparator.comparingDouble(f -> f.getValorTotalRecebido(dataReferencia)));
        return funcionarioMaiorValor.orElse(null);
    }

    /* 5. Encontra o nome do funcionário que recebeu o maior valor em benefícios no mês. */
    public String obterNomeFuncionarioMaiorBeneficio(List<Funcionario> funcionariosComBeneficio, YearMonth dataReferencia) {
        Optional<Funcionario> funcionarioMaiorBeneficio = funcionariosComBeneficio.stream()
                .max(Comparator.comparingDouble(f -> f.getBeneficio(dataReferencia)));
        return funcionarioMaiorBeneficio.map(Funcionario::getNome).orElse("Nenhum");
    }

    /* 6. Encontra o vendedor que mais vendeu no mês. */
    public Vendedor obterVendedorMaiorVenda(List<Vendedor> vendedores, YearMonth dataReferencia) {
        Optional<Vendedor> maiorVendedor = vendedores.stream()
                .max(Comparator.comparingDouble(v -> v.getVendaDoMes(dataReferencia)));
        return maiorVendedor.orElse(null);
    }
}