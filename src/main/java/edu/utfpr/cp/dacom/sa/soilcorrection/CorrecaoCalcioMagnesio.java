package edu.utfpr.cp.dacom.sa.soilcorrection;

import edu.utfpr.cp.dacom.sa.soilcorrection.CorrecaoInterface.ICorrecaoNutriente;
import edu.utfpr.cp.dacom.sa.soilcorrection.FonteMaterial.FonteCalcioMagnesio;

public class CorrecaoCalcioMagnesio
        implements ICorrecaoNutriente<FonteCalcioMagnesio> {

    public double calculaQuantidadeAplicar(
        double qtdeFonteAdicionar, 
        double prntPercent) {

        if (qtdeFonteAdicionar <= 0) {
            throw new IllegalArgumentException();
        }

        if (prntPercent <= 0) {
            throw new IllegalArgumentException();
        }

        return qtdeFonteAdicionar / prntPercent;
    }
}
