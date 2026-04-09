# Projeto de Testes Unitários: Entidade Financing

Este projeto faz parte de um estudo aprofundado sobre Testes Unitários com **JUnit 5**, focado na validação de regras de negócio para financiamentos imobiliários.

## 📋 Regra de Negócio
Para que um financiamento seja aprovado, a prestação mensal não pode ultrapassar **50% da renda mensal** do cliente.
- **Entrada:** 20% do valor total.
- **Prestação:** (Valor Total - Entrada) / Meses.

## 🧪 Suíte de Testes
Foram implementados 10 testes cobrindo construtores, métodos de cálculo e métodos de atualização (Setters).

### Tabela de Faixas de Teste (Base: Factory 100k, 2k, 80 meses)

| Atributo | Teste | Valor Testado | Resultado Esperado | Motivo |
| :--- | :--- | :--- | :--- | :--- |
| **TotalAmount** | Sucesso | 90.000,0 | ✅ Atualiza | Parcela diminui, permanece seguro. |
| **TotalAmount** | Falha | 110.000,0 | ❌ Exception | Parcela excede 50% da renda. |
| **Income** | Sucesso | 3.000,0 | ✅ Atualiza | Maior renda aumenta a segurança. |
| **Income** | Falha | 1.900,0 | ❌ Exception | Renda insuficiente para a parcela atual. |
| **Months** | Sucesso | 90 | ✅ Atualiza | Mais parcelas diminuem o valor mensal. |
| **Months** | Falha | 78 | ❌ Exception | Menos parcelas elevam o valor acima do limite. |

### Métodos de Cálculo
- **entry()**: Valida se a entrada calculada é exatamente 20% do `totalAmount`.
- **quota()**: Valida se o valor da prestação mensal está matematicamente correto.

## 🛠️ Tecnologias Utilizadas
- Java 17+
- JUnit 5
- Maven
- STS (Spring Tool Suite)