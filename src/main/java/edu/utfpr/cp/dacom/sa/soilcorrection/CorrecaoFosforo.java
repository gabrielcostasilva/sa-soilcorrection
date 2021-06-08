package edu.utfpr.cp.dacom.sa.soilcorrection;

public class CorrecaoFosforo implements ICorrecaoNutriente<FonteFosforo> {

    public double calculaNecessidadeP2O5(
        double P2O5, 
        double eficienciaFosforoPercentual) {

        if (P2O5 <= 0) {
            throw new IllegalArgumentException();
        }

        if (eficienciaFosforoPercentual <= 0) {
            throw new IllegalArgumentException();
        }

        return P2O5 / eficienciaFosforoPercentual;
    }
    
}
