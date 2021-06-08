package edu.utfpr.cp.dacom.sa.soilcorrection;

public class ConverteCMolcDm3EmMgDm3 
        implements Conversao<Double, Double> {

    @Override
    public Double converte(Double valor) {
        
        if (valor <= 0) {
            throw new IllegalArgumentException();
        }

        return valor * 391;
    }

}
