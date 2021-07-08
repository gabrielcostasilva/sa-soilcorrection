package edu.utfpr.cp.dacom.sa.soilcorrection;

public class CorrecaoCalcioMagnesio implements ICorrecaoNutriente<FonteCalcioMagnesio> {
    
    // public atribuicaoDeCalcio() {
    //     double calcio = 5.76;
    //     double participacaoCTCExistente = 44.7;
    //     double participacaoCTCDesejada = 55.0;
    //     double calcioTotal = 1.038;
    //     double quantidadeAditiva = 1.63;

    //     double calcioHa = calculaValorDeCorrecaoCalcio(calcio, participacaoCTCExistente, participacaoCTCDesejada);

    //     return calcioHa;
    // }
    
    public double calculaValorDeCorrecaoCalcio(
        double calcio,
        double participacaoCTCExistente,
        double participacaoCTCDesejada
    ) {
            if (participacaoCTCExistente <= 0) {
                throw new IllegalArgumentException();
            }

            if (participacaoCTCDesejada <= 0) {
                throw new IllegalArgumentException();
            }

            double magnesio = calculaValorDeCorrecaoMagnesio(calcio, participacaoCTCExistente, participacaoCTCDesejada);

            return ((calcio * 0.3035) / magnesio) * 100;
    }

    public double calculaValorDeCorrecaoMagnesio(
        double calcio,
        double participacaoCTCExistente,
        double participacaoCTCDesejada
    ) {
            if (participacaoCTCExistente <= 0) {
                throw new IllegalArgumentException();
            }

            if (participacaoCTCDesejada <= 0) {
                throw new IllegalArgumentException();
            }

            return ((calcio * participacaoCTCDesejada)
                    / participacaoCTCExistente
            ) - calcio;
    }
}
