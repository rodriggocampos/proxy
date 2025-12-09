package org.example;

import java.util.List;

public class ContaBancariaProxy implements IConta {

    private ContaBancaria conta;
    private Integer numero;

    public ContaBancariaProxy(Integer numero) {
        this.numero = numero;
    }

    @Override
    public List<String> obterDadosBasicos() {
        if (this.conta == null) {
            this.conta = new ContaBancaria(this.numero);
        }
        return this.conta.obterDadosBasicos();
    }

    @Override
    public List<Float> obterDadosFinanceiros(FuncionarioBanco funcionario) {
        if (!funcionario.isGerente()) {
            throw new IllegalArgumentException("Funcionário não autorizado a visualizar dados financeiros");
        }
        if (this.conta == null) {
            this.conta = new ContaBancaria(this.numero);
        }
        return this.conta.obterDadosFinanceiros(funcionario);
    }
}

