package org.example;

import java.util.List;

public interface IConta {
    List<String> obterDadosBasicos();
    List<Float> obterDadosFinanceiros(FuncionarioBanco funcionario);
}

