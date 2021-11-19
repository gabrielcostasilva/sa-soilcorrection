package edu.utfpr.cp.dacom.sa.soilcorrection;

import static org.junit.jupiter.api.Assertions.*;

import edu.utfpr.cp.dacom.sa.soilcorrection.services.ConverteCMolcDm3EmMgDm3;
import edu.utfpr.cp.dacom.sa.soilcorrection.services.ConverteKgHaEmK2O;
import edu.utfpr.cp.dacom.sa.soilcorrection.services.CorrecaoPotassio;
import edu.utfpr.cp.dacom.sa.soilcorrection.services.FontePotassio;
import org.junit.jupiter.api.Test;

public class TestaCorrecaoPotassio {

    @Test
    public void testaNecessidadeAdicionarCMolcDM3() {
        
        var correcaoPotassio = new CorrecaoPotassio();

        var necessidadeAdicionarCMolcDM3 = correcaoPotassio
        .calculaNecessidadeAdicionarCMolcDm3(0.15, 
                                             0.01164, 
                                             0.03);
        
        assertEquals(0.23659793814432992, 
                    necessidadeAdicionarCMolcDM3);
    }

    @Test
    public void testaConverteCMolcDm3EmMgDm3() {

        var necessidadeAdicionarCMolcDM3 = 0.23659793814432992;

        var cmolcConvertido = new ConverteCMolcDm3EmMgDm3()
                                .converte(necessidadeAdicionarCMolcDM3);

        assertEquals(92.509793814433, cmolcConvertido);
    }

    @Test
    public void testaConverteKgHaEmK2O() {

        var valorKgHa = 185.10;
        var valorK2o = new ConverteKgHaEmK2O()
                            .converte(valorKgHa);

        assertEquals(222.11999999999998, valorK2o);
    }

    @Test
    public void testaCalculaEficienciaNutriente() {

        var correcaoPotassio = new CorrecaoPotassio();

        var eficiencia = correcaoPotassio
                        .calculaEficienciaNutriente(222.12, 0.85);

        assertEquals(261.3176470588235, eficiencia);
    }

    @Test
    public void testaQuantidadeAplicar() {

        var correcaoPotassio = new CorrecaoPotassio();
        
        var eficiencia = 261.3176470588235;
        
        assertEquals(450.54766734279923,
        correcaoPotassio.calculaQuantidadeAplicar(eficiencia, FontePotassio.CLORETO_POTASSIO));
    }
    
    @Test
    public void testaCustoReaisHa() {

        var correcaoPotassio = new CorrecaoPotassio();
        
        var qtdeAplicar = 450.54766734279923;
        
        assertEquals(1126.3691683569982, 
        correcaoPotassio
        .calculaCusto(
            2500.0, 
            qtdeAplicar)
            );
        }
        
        
    @Test
    public void testaNutrientesAdicionais() {
            
        var correcaoPotassio = new CorrecaoPotassio();
        
        var qtdePotassioAplicar = 450.54766734279923;

        assertEquals(0, 
                    correcaoPotassio
                            .getNutrientesAdicionais(
                                qtdePotassioAplicar, 
                                FontePotassio.CLORETO_POTASSIO).size()
                    );
    }
}
