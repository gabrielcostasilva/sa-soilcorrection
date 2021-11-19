package edu.utfpr.cp.dacom.sa.soilcorrection;

import edu.utfpr.cp.dacom.sa.soilcorrection.services.ConverteKgHaEmP2O5;
import edu.utfpr.cp.dacom.sa.soilcorrection.services.ConverteMgDm3EmKgHa;
import edu.utfpr.cp.dacom.sa.soilcorrection.services.CorrecaoFosforo;
import edu.utfpr.cp.dacom.sa.soilcorrection.services.FonteFosforo;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class TestaCorrecaoFosforo {

    @Test
    public void testaConverteMgDm3EmKgHa() {

        var teorFosforoAdicionarMgDm3 = 3.41;
        var teorFosforoAdicionarKgHa = new ConverteMgDm3EmKgHa()
        .converte(teorFosforoAdicionarMgDm3);
        
        assertEquals(6.82, teorFosforoAdicionarKgHa);
    }
    
    @Test
    public void testaConverteKgHaEmP2O5() {
        
        var teorFosforoAdicionarKgHa = 6.82;
        var teorFosforoAdicionarP2O5 = new ConverteKgHaEmP2O5()
                                    .converte(teorFosforoAdicionarKgHa);
        
        assertEquals(15.6178, teorFosforoAdicionarP2O5);
    }

    @Test
    public void testaNecessidadeFosforo() {

        var teorFosforoAdicionarP2O5 = 15.6178;

        var correcaoFosforo = new CorrecaoFosforo();

        var necessidadeFosforo = correcaoFosforo
                    .calculaEficienciaNutriente(teorFosforoAdicionarP2O5, 0.7);

        assertEquals(22.31114285714286, necessidadeFosforo);
    }

    @Test
    public void testaQuantidadeAplicar() {

        var necessidadeFosforo = 22.31114285714286;

        var correcaoFosforo = new CorrecaoFosforo();

        assertEquals(123.95079365079366,
                correcaoFosforo.calculaQuantidadeAplicar(
                    necessidadeFosforo, 
                    FonteFosforo.SUPERFOSFATO_SIMPLES)
        );
    }

    @Test
    public void testaCustoReaisHa() {

        var correcaoFosforo = new CorrecaoFosforo();
        
        var qtdeFosforoAplicar = 123.95079365079366;
        
        assertEquals(156.178, correcaoFosforo.calculaCusto(
                                                        1260.0, 
                                                        qtdeFosforoAplicar)
            );
        }
        
        @Test
        public void testaNutrientesAdicionais() {

            var correcaoFosforo = new CorrecaoFosforo();
            
            var qtdeFosforoAplicar = 123.95079365079366;

            assertEquals(2, correcaoFosforo.getNutrientesAdicionais(
                                                qtdeFosforoAplicar, 
                                                FonteFosforo.SUPERFOSFATO_SIMPLES).size());
    }

}
