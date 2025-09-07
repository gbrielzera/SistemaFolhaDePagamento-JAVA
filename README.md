# Folha de Pagamento - Java OOP

Este projeto foi desenvolvido como parte de um teste técnico de estágio.  
Objetivo: implementar um sistema de **folha de pagamento** utilizando os princípios de **Programação Orientada a Objetos (POO)** em Java.

---

## 📌 Descrição do problema

Uma empresa possui três cargos diferentes (Secretário, Vendedor e Gerente), cada um com suas regras específicas de **salário** e **benefícios**:

| Cargo       | Salário base + por tempo de serviço | Benefícios |
|-------------|--------------------------------------|------------|
| Secretário  | R$ 7.000,00 + R$ 1.000,00/ano       | 20% sobre o salário |
| Vendedor    | R$ 12.000,00 + R$ 1.800,00/ano      | 30% sobre as vendas do mês |
| Gerente     | R$ 20.000,00 + R$ 3.000,00/ano      | Sem benefícios |

A folha de pagamento é calculada a partir da lista de funcionários, sua data de contratação e, no caso de vendedores, os valores de vendas mensais.

---

## 📊 Funcionalidades implementadas

O sistema contém métodos para:

1. Calcular o **valor total pago (salário + benefícios)** em determinado mês/ano.  
2. Calcular o **total pago apenas em salários**.  
3. Calcular o **total pago apenas em benefícios**.  
4. Determinar o **funcionário com maior pagamento total** no mês.  
5. Determinar o **funcionário com maior valor em benefícios** no mês.  
6. Determinar o **vendedor que mais vendeu** no mês.

---

## 🧮 Exemplo de execução (Abril/2022)

Entrada: lista de funcionários e vendas de abril/2022.

Saída:

```
--- CÁLCULOS DA FOLHA DE PAGAMENTO PARA 2022-04 ---

1. Valor total pago (salário + benefícios): R$ 132.850,00
2. Total pago em salários: R$ 124.000,00
3. Total pago em benefícios: R$ 8.850,00
4. Funcionário com maior pagamento: Bento Albino (R$ 44.000,00)
5. Funcionário com maior benefício: Maria Souza (R$ 2.600,00)
6. Vendedor que mais vendeu: Ana Silva (R$ 7.000,00)
```

---

## 🛠️ Tecnologias utilizadas

- **Java 17**  
- Paradigma **Orientado a Objetos**  
- Estruturas de classes, herança e polimorfismo.

---

## 🚀 Como executar

**1. Clone o repositório:**
   ```bash
   git clone [https://github.com/gbrielzera/SistemaFolhaDePagamento-JAVA.git](https://github.com/gbrielzera/SistemaFolhaDePagamento-JAVA.git)
   # Navegue para a pasta do projeto
   cd SistemaFolhaDePagamento-JAVA
   ```

**2. Crie um diretório para os arquivos compilados:**
   ```bash
   mkdir bin
   ```

**3. Compile todo o código-fonte:**
   O comando `-d bin` diz ao compilador para colocar todos os arquivos `.class` dentro da pasta `bin`.
   ```bash
   javac -d bin src/com/empresa/model/*.java src/com/empresa/service/*.java src/com/empresa/Main.java
   ```

**4. Execute a aplicação:**
   O comando `-cp bin` diz ao Java para procurar as classes dentro da pasta `bin`. Executamos usando o "nome completo" da classe principal (`pacote.NomeDaClasse`).
   ```bash
   java -cp bin com.empresa.Main
   ```

---

## 📂 Estrutura do projeto (exemplo)

```
src/
└── com/
    └── empresa/
    ├── Main.java
    ├── model/
        │ ├── Funcionario.java
        │ ├── Secretario.java
        │ ├── Vendedor.java
        │ ├── Gerente.java
    └── service/
        ├── FolhaPagamento.java
```

---

## 📌 Observações

- Os cálculos foram validados conforme o enunciado do desafio.  
- O código foi estruturado para ser extensível, permitindo adicionar novos cargos ou regras facilmente.  
