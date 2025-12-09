package org.example;

public class FuncionarioBanco {

    private String nome;
    private boolean gerente;

    public FuncionarioBanco(String nome, boolean gerente) {
        this.nome = nome;
        this.gerente = gerente;
    }

    public String getNome() {
        return nome;
    }

    public boolean isGerente() {
        return gerente;
    }

    public void setGerente(boolean gerente) {
        this.gerente = gerente;
    }
}

