package edu.utfpr.cp.dacom.sa.soilcorrection;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class TestaCorrecaoCalcioMagnesio {

    @Test
    public void testeDeTeorCaO() {
        // Instanciando classe CorrecaoCalcioMagnesio
        var correcaoCalcioMagnesio = new CorrecaoCalcioMagnesio();

        // Equilíbrio e Correção na CTC: E51
        double participacaoCTCDesejada = 55.0;
        // Equilíbrio e Correção na CTC: E48
        double participacaoCTCExistente = 44.7;

        // Equilíbrio e Correção na CTC: F11/G11
        double calcio = 5.76;
        // Memória de Cálculo: I105
        double fosfatagem = 0.017;

        assertEquals(1.31024832,
                correcaoCalcioMagnesio.teorCaO(calcio, fosfatagem, participacaoCTCExistente, participacaoCTCDesejada));
    }
    
    @Test
    public void testeDeQuantidadeCorretivo() {
        // Instanciando classe CorrecaoCalcioMagnesio
        var correcaoCalcioMagnesio = new CorrecaoCalcioMagnesio();

        // Memória de Cálculo: F113/G113
        double quantidade = 1.29;
        // Equilíbrio e Correção na CTC: C53
        double prnt = 70.0;

        assertEquals(1.85, correcaoCalcioMagnesio.calculaQuantidadeCorretivo(quantidade, prnt));
    }

    @Test
    public void testeDeQuantidadeTotalCorretivo() {
        // Instanciando classe CorrecaoCalcioMagnesio
        var correcaoCalcioMagnesio = new CorrecaoCalcioMagnesio();

        // Memória de Cálculo: F113/G113
        double quantidade = 1.29;
        // Equilíbrio e Correção na CTC: H5
        double ha = 70.0;

        assertEquals(6.2436, correcaoCalcioMagnesio.calculaQuantidadeTotalCorretivo(quantidade, ha));
    }

    @Test
    public void testePosCorrecao() {
        // Instanciando classe CorrecaoCalcioMagnesio
        var correcaoCalcioMagnesio = new CorrecaoCalcioMagnesio();

        // Equilíbrio e Correção na CTC: E51
        double participacaoCTCDesejada = 55.0;
        // Equilíbrio e Correção na CTC: E48
        double participacaoCTCExistente = 44.7;

        // Equilíbrio e Correção na CTC: F11/G11
        double calcio = 5.76;
        // Equilíbrio e Correção na CTC: D11/E11
        double potassio = 0.15;
        // Equilíbrio e Correção na CTC: H11/I11
        double magnesio = 1.63;
        // Equilíbrio e Correção na CTC: L11
        double hAl = 5.35;
        // Memória de Cálculo: I105
        double fosfatagem = 0.017;

        // Memória de Cálculo

        assertEquals(54.850646, correcaoCalcioMagnesio.calculaValorDeCorrecaoCalcio(calcio, potassio,
                magnesio, hAl, fosfatagem, participacaoCTCExistente, participacaoCTCDesejada));
    }
    
}
