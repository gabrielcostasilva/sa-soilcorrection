package edu.utfpr.cp.dacom.sa.soilcorrection;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

public class TestaCorrecaoCalcioMagnesio {

    @Test
    public void testaCustoReaisHa() {

        var correcaoCalcioMagnesio = new CorrecaoCalcioMagnesio();

        var qtdeCalcioMagnesioAplicarKgHa = 1844.76;

        assertEquals(
            922.68, 
            correcaoCalcioMagnesio.calculaCusto(
                500.0, 
                qtdeCalcioMagnesioAplicarKgHa),
            0.5);
    }

    @Test
    public void testaNutrientesAdicionais() {

        var correcaoCalcioMagnesio = new CorrecaoCalcioMagnesio();
        
        var qtdeCalcioMagnesioAplicarKgHa = 1844.76;

        assertEquals(
            1, 
            correcaoCalcioMagnesio.getNutrientesAdicionais(
                    qtdeCalcioMagnesioAplicarKgHa, 
                    FonteCalcioMagnesio.GESSO_AGRICOLA)
                        .size());

        qtdeCalcioMagnesioAplicarKgHa = 3.51 * 1000;

        assertEquals(
            526.16, 
            correcaoCalcioMagnesio.getNutrientesAdicionais(
                qtdeCalcioMagnesioAplicarKgHa, 
                    FonteCalcioMagnesio.GESSO_AGRICOLA)
                        .stream()
                        .findFirst()
                        .get()
                        .getCorrecaoAdicional(),
            0.5);
    }

    @Test
    public void testaQtdeAplicar() {

        double qtdeFonteAdicionar = 1.291755;
        double prntPercent = 0.7;

        assertEquals(1.85, 
            new CorrecaoCalcioMagnesio()
                .calculaQuantidadeAplicar(
                    qtdeFonteAdicionar, 
                    prntPercent),
            0.05);

    }

}
