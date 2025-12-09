package org.example;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.*;

class ContaBancariaProxyTest {

    @BeforeEach
    void setUp() {
        BDConta.addConta(new ContaBancaria(1, "João Silva", "Agência Centro", 5000.0f, 1000.0f));
        BDConta.addConta(new ContaBancaria(2, "Maria Souza", "Agência Bairro", 10000.0f, 2000.0f));
    }

    @Test
    void deveRetornarDadosBasicosConta() {
        ContaBancariaProxy conta = new ContaBancariaProxy(1);

        assertEquals(Arrays.asList("João Silva", "Agência Centro"), conta.obterDadosBasicos());
    }

    @Test
    void deveRetonarDadosFinanceirosConta() {
        FuncionarioBanco funcionario = new FuncionarioBanco("Ana", true);
        ContaBancariaProxy conta = new ContaBancariaProxy(2);

        assertEquals(Arrays.asList(10000.0f, 2000.0f), conta.obterDadosFinanceiros(funcionario));
    }

    @Test
    void deveRetonarExcecaoFuncionarioNaoAutorizadoConsultarDadosFinanceirosConta() {
        try {
            FuncionarioBanco funcionario = new FuncionarioBanco("Joana", false);
            ContaBancariaProxy conta = new ContaBancariaProxy(2);

            conta.obterDadosFinanceiros(funcionario);
            fail();
        }
        catch (IllegalArgumentException e) {
            assertEquals("Funcionário não autorizado a visualizar dados financeiros", e.getMessage());
        }
    }
}
