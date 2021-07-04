package edu.utfpr.cp.dacom.sa.soilcorrection.interfaces;

import edu.utfpr.cp.dacom.sa.soilcorrection.NutrienteAdicional;
import java.util.Set;

public interface ICorrecaoNutriente<T extends IFonteNutriente> {

    public default double calculaQuantidadeAplicar(double necessidade, T fonteNutriente) {

        if (necessidade <= 0) {
            throw new IllegalArgumentException();
        }

        return necessidade / fonteNutriente.getTeorFonte();
    }
    
    public default double calculaCusto(double custoFonte, double qtdeAplicar) {

        if (custoFonte <= 0) {
            throw new IllegalArgumentException();
        }

        if (qtdeAplicar <= 0) {
            throw new IllegalArgumentException();
        }

        return custoFonte * qtdeAplicar / 1000;
    }

    public default Set<NutrienteAdicional> getNutrientesAdicionais(double qtdeAplicar, T fonteNutriente) {

        fonteNutriente
            .getNutrientesAdicionais()
            .forEach(
                item -> 
                        item.setCorrecaoAdicional(
                                item.getTeorNutriente() * qtdeAplicar)
            );

        return fonteNutriente.getNutrientesAdicionais();
    }

    public default double calculaEficienciaNutriente(
        double qtdeNutrienteAdicionar, 
        double eficienciaNutriente) {

        if (qtdeNutrienteAdicionar <= 0) {
            throw new IllegalArgumentException();
        }

        if (eficienciaNutriente <= 0) {
            throw new IllegalArgumentException();
        }

        return qtdeNutrienteAdicionar / eficienciaNutriente;
    }
}
