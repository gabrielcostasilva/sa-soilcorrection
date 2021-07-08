package edu.utfpr.cp.dacom.sa.soilcorrection;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class TestaCorrecaoCalcioMagnesio {

    // @Test
    // public void testePosCorrecao() {
    //     var correcaoCalcioMagnesio = new CorrecaoCalcioMagnesio();

    //     double participacaoCTCDesejada = 55.0;
    //     double participacaoCTCExistente = 44.7;

    //     double calcio = 5.76;
    //     double potassio = 0.15;
    //     double magnesio = 1.63;

    //     assertEquals(participacaoCTCDesejada, correcaoCalcioMagnesio.calculaValorDeCorrecaoCalcio(calcio, potassio,
    //             magnesio, participacaoCTCExistente, participacaoCTCDesejada));
    // }
    
    @Test
    public void testeDeTeorCaO() {
        var correcaoCalcioMagnesio = new CorrecaoCalcioMagnesio();
        
        // Exemplo 1 resulta em 1.32724832, já os exemplos 2 e 3 resultam em 0???

        double participacaoCTCDesejada = 55.0;
        double participacaoCTCExistente = 44.7;

        double calcio = 5.76;

        double teorCaOEsperado = 1.32724832;

        assertEquals(teorCaOEsperado, correcaoCalcioMagnesio.teorCaO(calcio, participacaoCTCExistente, participacaoCTCDesejada));
    }
}
