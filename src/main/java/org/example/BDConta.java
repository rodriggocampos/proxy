package org.example;

import java.util.HashMap;
import java.util.Map;

public class BDConta {
    private static Map<Integer, ContaBancaria> contas = new HashMap<>();

    public static ContaBancaria getConta(Integer numero) {
        return contas.get(numero);
    }

    public static void addConta(ContaBancaria conta) {
        contas.put(conta.getNumero(), conta);
    }
}

