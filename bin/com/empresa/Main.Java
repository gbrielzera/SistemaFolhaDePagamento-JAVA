package com.empresa;

import com.empresa.model.*;
import com.empresa.service.FolhaDePagamentoService;

import java.text.NumberFormat;
import java.time.LocalDate;
import java.time.YearMonth;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import java.util.stream.Collectors;

public class Main {

    public static void main(String[] args) {
        // CADASTRO DE DADOS

        // Lista de todos os funcionários.
        List<Funcionario> todosFuncionarios = new ArrayList<>();
        todosFuncionarios.add(new Secretario("Jorge Carvalho", LocalDate.of(2018, 1, 1)));
        todosFuncionarios.add(new Secretario("Maria Souza", LocalDate.of(2015, 12, 1)));
        todosFuncionarios.add(new Gerente("Juliana Alves", LocalDate.of(2017, 7, 1)));
        todosFuncionarios.add(new Gerente("Bento Albino", LocalDate.of(2014, 3, 1)));

        // Vendedores precisam ser criados e ter suas vendas adicionadas.
        Vendedor ana = new Vendedor("Ana Silva", LocalDate.of(2021, 12, 1));
        ana.adicionarVenda(YearMonth.of(2021, 12), 5200.00);
        ana.adicionarVenda(YearMonth.of(2022, 1), 4000.00);
        ana.adicionarVenda(YearMonth.of(2022, 2), 4200.00);
        ana.adicionarVenda(YearMonth.of(2022, 3), 5850.00);
        ana.adicionarVenda(YearMonth.of(2022, 4), 7000.00);

        Vendedor joao = new Vendedor("João Mendes", LocalDate.of(2021, 12, 1));
        joao.adicionarVenda(YearMonth.of(2021, 12), 3400.00);
        joao.adicionarVenda(YearMonth.of(2022, 1), 7700.00);
        joao.adicionarVenda(YearMonth.of(2022, 2), 5000.00);
        joao.adicionarVenda(YearMonth.of(2022, 3), 5900.00);
        joao.adicionarVenda(YearMonth.of(2022, 4), 6500.00);
        
        todosFuncionarios.add(ana);
        todosFuncionarios.add(joao);

        // Instancia o serviço que fará os cálculos.
        FolhaDePagamentoService service = new FolhaDePagamentoService();

        // Define o mês e ano de referência para os cálculos.
        YearMonth dataReferencia = YearMonth.of(2022, 4);

        // Formatador para moeda (R$).
        NumberFormat formatadorMoeda = NumberFormat.getCurrencyInstance(new Locale("pt", "BR"));

        System.out.println("--- CÁLCULOS DA FOLHA DE PAGAMENTO PARA " + dataReferencia + " ---\n");

        // EXECUÇÃO DOS MÉTODOS SOLICITADOS

        // 1. Valor total pago (salário e benefício) no mês.
        double totalPago = service.calcularValorTotalPago(todosFuncionarios, dataReferencia);
        System.out.println("1. Valor total pago (salário + benefícios): " + formatadorMoeda.format(totalPago));

        // 2. Total pago somente em salários no mês.
        double totalSalarios = service.calcularTotalSalarios(todosFuncionarios, dataReferencia);
        System.out.println("2. Total pago em salários: " + formatadorMoeda.format(totalSalarios));

        // 3. Total pago em benefícios no mês.
        // Primeiro, filtramos a lista para ter apenas funcionários com benefícios.
        List<Funcionario> funcionariosComBeneficio = todosFuncionarios.stream()
                .filter(f -> f instanceof Secretario || f instanceof Vendedor)
                .collect(Collectors.toList());
        double totalBeneficios = service.calcularTotalBeneficios(funcionariosComBeneficio, dataReferencia);
        System.out.println("3. Total pago em benefícios: " + formatadorMoeda.format(totalBeneficios));

        // 4. Funcionário que recebeu o valor mais alto no mês.
        Funcionario maiorPagamento = service.obterFuncionarioMaiorValor(todosFuncionarios, dataReferencia);
        if (maiorPagamento != null) {
            System.out.println("4. Funcionário com maior pagamento: " + maiorPagamento.getNome() + 
                               " (" + formatadorMoeda.format(maiorPagamento.getValorTotalRecebido(dataReferencia)) + ")");
        }

        // 5. Nome do funcionário que recebeu o valor mais alto em benefícios.
        String nomeMaiorBeneficio = service.obterNomeFuncionarioMaiorBeneficio(funcionariosComBeneficio, dataReferencia);
        System.out.println("5. Funcionário com maior benefício: " + nomeMaiorBeneficio);

        // 6. Vendedor que mais vendeu no mês.
        // Precisamos de uma lista apenas com os vendedores.
        List<Vendedor> vendedores = todosFuncionarios.stream()
                .filter(f -> f instanceof Vendedor)
                .map(f -> (Vendedor) f)
                .collect(Collectors.toList());
        Vendedor maiorVendedor = service.obterVendedorMaiorVenda(vendedores, dataReferencia);
        if (maiorVendedor != null) {
            System.out.println("6. Vendedor que mais vendeu: " + maiorVendedor.getNome() +
                               " (" + formatadorMoeda.format(maiorVendedor.getVendaDoMes(dataReferencia)) + ")");
        }
    }
}