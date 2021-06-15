package edu.utfpr.cp.dacom.sa.soilcorrection;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class TestaValoresIdeais {

        @Test
        public void testaValoresIdeaisArgiloso() {
                assertEquals(new NutrientesCTC(9.0, 0.35, 6.0, 1.5, 9.0, 0.0, 0.0).fosforo(),
                                TexturaSolo.ARGILOSO.calculaValorIdeal().fosforo());

                assertEquals(new NutrientesCTC(9.0, 0.35, 6.0, 1.5, 9.0, 0.0, 0.0).aluminio(),
                                TexturaSolo.ARGILOSO.calculaValorIdeal().aluminio());

                assertEquals(new NutrientesCTC(9.0, 0.35, 6.0, 1.5, 9.0, 0.0, 0.0).aluminioHidrogenio(),
                                TexturaSolo.ARGILOSO.calculaValorIdeal().aluminioHidrogenio());
                assertEquals(new NutrientesCTC(9.0, 0.35, 6.0, 1.5, 9.0, 0.0, 0.0).calcio(),
                                TexturaSolo.ARGILOSO.calculaValorIdeal().calcio());
                assertEquals(new NutrientesCTC(9.0, 0.35, 6.0, 1.5, 9.0, 0.0, 0.0).enxofre(),
                                TexturaSolo.ARGILOSO.calculaValorIdeal().enxofre());
                assertEquals(new NutrientesCTC(9.0, 0.35, 6.0, 1.5, 9.0, 0.0, 0.0).magnesio(),
                                TexturaSolo.ARGILOSO.calculaValorIdeal().magnesio());
                assertEquals(new NutrientesCTC(9.0, 0.35, 6.0, 1.5, 9.0, 0.0, 0.0).potassio(),
                                TexturaSolo.ARGILOSO.calculaValorIdeal().potassio());
        }

        @Test
        public void testaValoresIdeaisTexturaMedia() {
                assertEquals(new NutrientesCTC(12.0, 0.25, 3.0, 1.0, 6.0, 0.0, 0.0).fosforo(),
                                TexturaSolo.TEXTURA_MEDIA.calculaValorIdeal().fosforo());
                assertEquals(new NutrientesCTC(12.0, 0.25, 3.0, 1.0, 6.0, 0.0, 0.0).aluminio(),
                                TexturaSolo.TEXTURA_MEDIA.calculaValorIdeal().aluminio());
                assertEquals(new NutrientesCTC(12.0, 0.25, 3.0, 1.0, 6.0, 0.0, 0.0).aluminioHidrogenio(),
                                TexturaSolo.TEXTURA_MEDIA.calculaValorIdeal().aluminioHidrogenio());
                assertEquals(new NutrientesCTC(12.0, 0.25, 3.0, 1.0, 6.0, 0.0, 0.0).calcio(),
                                TexturaSolo.TEXTURA_MEDIA.calculaValorIdeal().calcio());
                assertEquals(new NutrientesCTC(12.0, 0.25, 3.0, 1.0, 6.0, 0.0, 0.0).enxofre(),
                                TexturaSolo.TEXTURA_MEDIA.calculaValorIdeal().enxofre());
                assertEquals(new NutrientesCTC(12.0, 0.25, 3.0, 1.0, 6.0, 0.0, 0.0).magnesio(),
                                TexturaSolo.TEXTURA_MEDIA.calculaValorIdeal().magnesio());
                assertEquals(new NutrientesCTC(12.0, 0.25, 3.0, 1.0, 6.0, 0.0, 0.0).potassio(),
                                TexturaSolo.TEXTURA_MEDIA.calculaValorIdeal().potassio());

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
