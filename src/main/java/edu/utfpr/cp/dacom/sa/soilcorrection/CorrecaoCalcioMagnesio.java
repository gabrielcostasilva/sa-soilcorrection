package edu.utfpr.cp.dacom.sa.soilcorrection;

public class CorrecaoCalcioMagnesio implements ICorrecaoNutriente<FonteCalcioMagnesio> {

    public double teorCaO(
        double calcio,
        double participacaoCTCExistente,
        double participacaoCTCDesejada
    ) {
        return ((calcio * participacaoCTCDesejada)
                    / participacaoCTCExistente
            ) - calcio;
    }

    public double calculaValorDeCorrecaoCalcio(
        double calcio,
        double potassio,
        double magnesio,
        double participacaoCTCExistente,
        double participacaoCTCDesejada
    ) {
            if (participacaoCTCExistente <= 0) {
                throw new IllegalArgumentException();
            }

            if (participacaoCTCDesejada <= 0) {
                throw new IllegalArgumentException();
            }
    }
}
