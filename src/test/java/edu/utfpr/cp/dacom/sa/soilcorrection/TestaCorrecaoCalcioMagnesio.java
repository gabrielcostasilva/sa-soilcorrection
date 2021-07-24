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

}
