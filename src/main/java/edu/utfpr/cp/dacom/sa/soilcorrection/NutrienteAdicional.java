package edu.utfpr.cp.dacom.sa.soilcorrection;

public class NutrienteAdicional {

    private final NomeNutrienteAdicional nome;
    private final double teorNutriente;

    private double correcaoAdicional;

    public NutrienteAdicional(
        final NomeNutrienteAdicional nome, 
        double teorNutriente) {

        this.nome = nome;
        this.teorNutriente = teorNutriente;
    }

    public double getTeorNutriente() {
        return this.teorNutriente;
    }

    public void setCorrecaoAdicional(double correcaoAdicional) {
        this.correcaoAdicional = correcaoAdicional;
    }

    public double getCorrecaoAdicional() {
        return this.correcaoAdicional;
    }
    
}
