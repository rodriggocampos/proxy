package org.example;

import java.util.Arrays;
import java.util.List;

public class ContaBancaria implements IConta {

    private Integer numero;
    private String titular;
    private String agencia;
    private Float saldo;
    private Float limite;

    public ContaBancaria(Integer numero) {
        this.numero = numero;
        ContaBancaria contaBD = BDConta.getConta(numero);
        this.titular = contaBD.titular;
        this.agencia = contaBD.agencia;
        this.saldo = contaBD.saldo;
        this.limite = contaBD.limite;
    }

    public ContaBancaria(Integer numero, String titular, String agencia, Float saldo, Float limite) {
        this.numero = numero;
        this.titular = titular;
        this.agencia = agencia;
        this.saldo = saldo;
        this.limite = limite;
    }

    public Integer getNumero() {
        return numero;
    }

    @Override
    public List<String> obterDadosBasicos() {
        return Arrays.asList(this.titular, this.agencia);
    }

    @Override
    public List<Float> obterDadosFinanceiros(FuncionarioBanco funcionario) {
        // Aqui a conta real não valida o funcionário, isso é papel do Proxy
        return Arrays.asList(this.saldo, this.limite);
    }
}

