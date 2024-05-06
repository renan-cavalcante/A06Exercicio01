package com.example.a06exercicio01.model;

public class ProfessorTitular extends Professor{

    private int anosInstituicao;
    private double salario;

    @Override
    public Double calcSalario() {
        return getSalario() + (getSalario() *(0.05 * (int)anosInstituicao/5));
    }

    public int getAnosInstituicao() {
        return anosInstituicao;
    }

    public void setAnosInstituicao(int anosInstituicao) {
        this.anosInstituicao = anosInstituicao;
    }

    public double getSalario() {
        return salario;
    }

    public void setSalario(double salario) {
        this.salario = salario;
    }
}
