package com.example.a06exercicio01.model;

public class ProfessorHorista extends  Professor{

    private int horasAula;
    private double valorHoraAula;

    @Override
    public Double calcSalario() {
        return horasAula * valorHoraAula;
    }

    public int getHorasAula() {
        return horasAula;
    }

    public void setHorasAula(int horasAula) {
        this.horasAula = horasAula;
    }

    public double getValorHoraAula() {
        return valorHoraAula;
    }

    public void setValorHoraAula(double valorHoraAula) {
        this.valorHoraAula = valorHoraAula;
    }
}
