package edu.utfpr.cp.dacom.sa.soilcorrection;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class NewEmptyJUnitTest {

        @Test
        public void testaCorrecaoFosforo() {
                // várias conversões ...

                var correcaoFosforo = new CorrecaoFosforo();

                assertEquals(123.94444444444444, 
                        correcaoFosforo.calculaQuantidadeAplicar(22.31, FonteFosforo.SUPERFOSFATO_SIMPLES));

                assertEquals(156.1644, 
                        correcaoFosforo.calculaCusto(1260.0, 123.94));

                assertEquals(2, 
                        correcaoFosforo.getNutrientesAdicionais(123.94, FonteFosforo.SUPERFOSFATO_SIMPLES).size());

        }

        @Test
        public void testaCorrecaoPotassio() {
                // várias conversões ...

                var correcaoPotassio = new CorrecaoPotassio();

                assertEquals(450.55172413793105,
                        correcaoPotassio.calculaQuantidadeAplicar(261.32, FontePotassio.CLORETO_POTASSIO));

                assertEquals(1126.375, 
                        correcaoPotassio.calculaCusto(2500.0, 450.55));

                assertEquals(0, 
                        correcaoPotassio.getNutrientesAdicionais(450.55, FontePotassio.CLORETO_POTASSIO).size());
                        

        }

        @Test
        public void testaValoresIdeaisArgiloso() {
                assertEquals(new NutrientesCTC(9.0, 0.35, 6.0, 1.5, 9.0, 0.0, 0.0).getFosforo(),
                                TexturaSolo.ARGILOSO.calculaValorIdeal().getFosforo());

                assertEquals(new NutrientesCTC(9.0, 0.35, 6.0, 1.5, 9.0, 0.0, 0.0).getAluminio(),
                                TexturaSolo.ARGILOSO.calculaValorIdeal().getAluminio());

                assertEquals(new NutrientesCTC(9.0, 0.35, 6.0, 1.5, 9.0, 0.0, 0.0).getAluminioHidrogenio(),
                                TexturaSolo.ARGILOSO.calculaValorIdeal().getAluminioHidrogenio());
                assertEquals(new NutrientesCTC(9.0, 0.35, 6.0, 1.5, 9.0, 0.0, 0.0).getCalcio(),
                                TexturaSolo.ARGILOSO.calculaValorIdeal().getCalcio());
                assertEquals(new NutrientesCTC(9.0, 0.35, 6.0, 1.5, 9.0, 0.0, 0.0).getEnxofre(),
                                TexturaSolo.ARGILOSO.calculaValorIdeal().getEnxofre());
                assertEquals(new NutrientesCTC(9.0, 0.35, 6.0, 1.5, 9.0, 0.0, 0.0).getMagnesio(),
                                TexturaSolo.ARGILOSO.calculaValorIdeal().getMagnesio());
                assertEquals(new NutrientesCTC(9.0, 0.35, 6.0, 1.5, 9.0, 0.0, 0.0).getPotassio(),
                                TexturaSolo.ARGILOSO.calculaValorIdeal().getPotassio());
        }

        @Test
        public void testaValoresIdeaisTexturaMedia() {
                assertEquals(new NutrientesCTC(12.0, 0.25, 3.0, 1.0, 6.0, 0.0, 0.0).getFosforo(),
                                TexturaSolo.TEXTURA_MEDIA.calculaValorIdeal().getFosforo());
                assertEquals(new NutrientesCTC(12.0, 0.25, 3.0, 1.0, 6.0, 0.0, 0.0).getAluminio(),
                                TexturaSolo.TEXTURA_MEDIA.calculaValorIdeal().getAluminio());
                assertEquals(new NutrientesCTC(12.0, 0.25, 3.0, 1.0, 6.0, 0.0, 0.0).getAluminioHidrogenio(),
                                TexturaSolo.TEXTURA_MEDIA.calculaValorIdeal().getAluminioHidrogenio());
                assertEquals(new NutrientesCTC(12.0, 0.25, 3.0, 1.0, 6.0, 0.0, 0.0).getCalcio(),
                                TexturaSolo.TEXTURA_MEDIA.calculaValorIdeal().getCalcio());
                assertEquals(new NutrientesCTC(12.0, 0.25, 3.0, 1.0, 6.0, 0.0, 0.0).getEnxofre(),
                                TexturaSolo.TEXTURA_MEDIA.calculaValorIdeal().getEnxofre());
                assertEquals(new NutrientesCTC(12.0, 0.25, 3.0, 1.0, 6.0, 0.0, 0.0).getMagnesio(),
                                TexturaSolo.TEXTURA_MEDIA.calculaValorIdeal().getMagnesio());
                assertEquals(new NutrientesCTC(12.0, 0.25, 3.0, 1.0, 6.0, 0.0, 0.0).getPotassio(),
                                TexturaSolo.TEXTURA_MEDIA.calculaValorIdeal().getPotassio());

        }

        @Test
        public void testaCalculaSCmol() {
                assertEquals(7.54, new EquilibrioCorrecaoCTC().calculaSCmol(0.15, 5.76, 1.63));

        }

        @Test
        public void testaCalculaCTCCmol() {
                assertEquals(12.89, new EquilibrioCorrecaoCTC().calculaCTCCmol(0.15, 5.76, 1.63, 5.35));
        }

        @Test
        public void testaVPercentual() {
                assertEquals(58.494957331264544,
                                new EquilibrioCorrecaoCTC().calculaVPercentual(
                                                new EquilibrioCorrecaoCTC().calculaSCmol(0.15, 5.76, 1.63),
                                                new EquilibrioCorrecaoCTC().calculaCTCCmol(0.15, 5.76, 1.63, 5.35)));
        }

        @Test
        public void testaMOPercentual() {
                assertEquals(3.07, new EquilibrioCorrecaoCTC().calculaMOPercentual(30.7));
        }

        @Test
        public void testaCalculaCarbono() {
                assertEquals(17.848837209302324, new EquilibrioCorrecaoCTC()
                                .calculaCarbono(new EquilibrioCorrecaoCTC().calculaMOPercentual(30.7)));
        }
}
