package edu.utfpr.cp.dacom.sa.soilcorrection;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class TestaCorrecaoCalcio {

    @Test
    public void testaValorAposCorrecao() {
        var correcaoCalcio = new CorrecaoCalcio();

        // E48 - Valor calculado previamente pela planilha
        var participacaoAtual = 44.7;

        // E51 - Valor inserido pelo usuario
        var porcentagemParticipacaoCalcio = 55.0;

        // L11
        var hidrogenioAluminio = 5.35;

        // D11:E11
        var potacio = 0.15;

        // F11:G11
        var calcio = 5.76;

        // H11:I11
        var magnesio = 1.63;

        assertEquals(55.0, correcaoCalcio.calculaValorAposCorrecao(porcentagemParticipacaoCalcio, participacaoAtual,
                hidrogenioAluminio, potacio, calcio, magnesio));
    }

    @Test
    public void testaCalculoQuantidadeCalcio() {
        var correcaoCalcio = new CorrecaoCalcio();

        assertEquals(1.327966734, correcaoCalcio.calculaQuantidadeCalcio());
    }
}
