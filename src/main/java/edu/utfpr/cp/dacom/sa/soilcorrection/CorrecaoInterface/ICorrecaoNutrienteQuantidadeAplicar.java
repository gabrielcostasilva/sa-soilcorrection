package edu.utfpr.cp.dacom.sa.soilcorrection.CorrecaoInterface;

import edu.utfpr.cp.dacom.sa.soilcorrection.FonteNutrienteInterface.IFonteNutriente;

public interface ICorrecaoNutrienteQuantidadeAplicar<T extends IFonteNutriente> {
    
    public default double calculaQuantidadeAplicar(
        double necessidade, 
        T fonteNutriente) {

        if (necessidade <= 0) {
            throw new IllegalArgumentException();
        }

        return necessidade / fonteNutriente.getTeorFonte();
    }
}
