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

        assertEquals(1.3442483221477,
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

        assertEquals(1.8428571428571, correcaoCalcioMagnesio.calculaQuantidadeCorretivo(quantidade, prnt));
    }

    @Test
    public void testeDeQuantidadeTotalCorretivo() {
        // Instanciando classe CorrecaoCalcioMagnesio
        var correcaoCalcioMagnesio = new CorrecaoCalcioMagnesio();

        // Memória de Cálculo: F113/G113
        double quantidade = 1.29;
        // Equilíbrio e Correção na CTC: H5
        double ha = 4.84;

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

        assertEquals(55.114416774, correcaoCalcioMagnesio.calculaValorDeCorrecaoCalcio(calcio, potassio, magnesio, hAl,
                fosfatagem, participacaoCTCExistente, participacaoCTCDesejada));
    }
    
    // Testes de Cálculo para Valores R$

    @Test
    public void testaCustoPorAlqueire() {
        // Instanciando classe CorrecaoCalcioMagnesio
        var correcaoCalcioMagnesio = new CorrecaoCalcioMagnesio();

        // Memória de Cálculo: A115/B115
        double toneladasPorHa = 1.85;
        // Equilíbrio e Correção na CTC: K55/L55
        double valorPorTonelada = 500.00;

        assertEquals(2238.5,
                correcaoCalcioMagnesio.calculaCustoPorAlqueire(toneladasPorHa, valorPorTonelada));
    }

    @Test
    public void testaCustoTotal() {
        // Instanciando classe CorrecaoCalcioMagnesio
        var correcaoCalcioMagnesio = new CorrecaoCalcioMagnesio();

        // Memória de Cálculo: F113/G113
        double quantidade = 1.29;
        // Equilíbrio e Correção na CTC: H5
        double ha = 4.84;
        // Memória de Cálculo: F117/G117
        double quantidadeTotalCorretivo = correcaoCalcioMagnesio.calculaQuantidadeTotalCorretivo(quantidade, ha);
        // Equilíbrio e Correção na CTC: K55/L55
        double valorPorTonelada = 500.00;

        assertEquals(3121.8, correcaoCalcioMagnesio.calculaCustoTotal(quantidadeTotalCorretivo, valorPorTonelada));
    }
    
    @Test
    public void testaTipoFonte() {
        // Instanciando classe CorrecaoCalcioMagnesio
        var verificacao = new VerificaFonte();

        // Equilíbrio e Correção na CTC: D52
        int fonteCorretivo = 2;

        assertEquals("Calcário Calcítico", verificacao.verificaFonte(fonteCorretivo));
    }
    
}
