package edu.utfpr.cp.dacom.sa.soilcorrection;

import edu.utfpr.cp.dacom.sa.soilcorrection.services.TexturaSolo;
import edu.utfpr.cp.dacom.sa.soilcorrection.services.NutrientesCTC;
import edu.utfpr.cp.dacom.sa.soilcorrection.services.EquilibrioCorrecaoCTC;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class TestaValoresIdeais {

        @Test
        public void testaValoresIdeaisArgiloso() {
                assertEquals(NutrientesCTC
                                .builder()
                                .fosforo(9.0)
                                .potassio(0.35)
                                .calcio(6.0)
                                .magnesio(1.5)
                                .enxofre(9.0)
                                .aluminio(0.0)
                                .aluminioHidrogenio(0.0)
                                .build()
                                .fosforo(),
                                TexturaSolo.ARGILOSO.calculaValorIdeal().fosforo());

                assertEquals(NutrientesCTC
                                .builder()
                                .fosforo(9.0)
                                .potassio(0.35)
                                .calcio(6.0)
                                .magnesio(1.5)
                                .enxofre(9.0)
                                .aluminio(0.0)
                                .aluminioHidrogenio(0.0)
                                .build()
                                        .aluminio(),
                                TexturaSolo.ARGILOSO.calculaValorIdeal().aluminio());

                assertEquals(NutrientesCTC
                                .builder()
                                .fosforo(9.0)
                                .potassio(0.35)
                                .calcio(6.0)
                                .magnesio(1.5)
                                .enxofre(9.0)
                                .aluminio(0.0)
                                .aluminioHidrogenio(0.0)
                                .build()
                                        .aluminioHidrogenio(),
                                TexturaSolo.ARGILOSO.calculaValorIdeal().aluminioHidrogenio());
                assertEquals(NutrientesCTC
                                .builder()
                                .fosforo(9.0)
                                .potassio(0.35)
                                .calcio(6.0)
                                .magnesio(1.5)
                                .enxofre(9.0)
                                .aluminio(0.0)
                                .aluminioHidrogenio(0.0)
                                .build()
                                        .calcio(),
                                TexturaSolo.ARGILOSO.calculaValorIdeal().calcio());
                assertEquals(NutrientesCTC
                                .builder()
                                .fosforo(9.0)
                                .potassio(0.35)
                                .calcio(6.0)
                                .magnesio(1.5)
                                .enxofre(9.0)
                                .aluminio(0.0)
                                .aluminioHidrogenio(0.0)
                                .build()
                                        .enxofre(),
                                TexturaSolo.ARGILOSO.calculaValorIdeal().enxofre());
                assertEquals(NutrientesCTC
                                .builder()
                                .fosforo(9.0)
                                .potassio(0.35)
                                .calcio(6.0)
                                .magnesio(1.5)
                                .enxofre(9.0)
                                .aluminio(0.0)
                                .aluminioHidrogenio(0.0)
                                .build()
                                        .magnesio(),
                                TexturaSolo.ARGILOSO.calculaValorIdeal().magnesio());
                assertEquals(NutrientesCTC
                                .builder()
                                .fosforo(9.0)
                                .potassio(0.35)
                                .calcio(6.0)
                                .magnesio(1.5)
                                .enxofre(9.0)
                                .aluminio(0.0)
                                .aluminioHidrogenio(0.0)
                                .build()
                                        .potassio(),
                                TexturaSolo.ARGILOSO.calculaValorIdeal().potassio());
        }

        @Test
        public void testaValoresIdeaisTexturaMedia() {
                assertEquals(NutrientesCTC
                                .builder()
                                .fosforo(12.0)
                                .potassio(0.25)
                                .calcio(3.0)
                                .magnesio( 1.0)
                                .enxofre(6.0)
                                .aluminio(0.0)
                                .aluminioHidrogenio(0.0)
                                .build()
                                        .fosforo(),
                                TexturaSolo.TEXTURA_MEDIA.calculaValorIdeal().fosforo());
                assertEquals(NutrientesCTC
                                .builder()
                                .fosforo(12.0)
                                .potassio(0.25)
                                .calcio(3.0)
                                .magnesio( 1.0)
                                .enxofre(6.0)
                                .aluminio(0.0)
                                .aluminioHidrogenio(0.0)
                                .build()
                                        .aluminio(),
                                TexturaSolo.TEXTURA_MEDIA.calculaValorIdeal().aluminio());
                assertEquals(NutrientesCTC
                                .builder()
                                .fosforo(12.0)
                                .potassio(0.25)
                                .calcio(3.0)
                                .magnesio( 1.0)
                                .enxofre(6.0)
                                .aluminio(0.0)
                                .aluminioHidrogenio(0.0)
                                .build()
                                        .aluminioHidrogenio(),
                                TexturaSolo.TEXTURA_MEDIA.calculaValorIdeal().aluminioHidrogenio());
                assertEquals(NutrientesCTC
                                .builder()
                                .fosforo(12.0)
                                .potassio(0.25)
                                .calcio(3.0)
                                .magnesio( 1.0)
                                .enxofre(6.0)
                                .aluminio(0.0)
                                .aluminioHidrogenio(0.0)
                                .build()
                                        .calcio(),
                                TexturaSolo.TEXTURA_MEDIA.calculaValorIdeal().calcio());
                assertEquals(NutrientesCTC
                                .builder()
                                .fosforo(12.0)
                                .potassio(0.25)
                                .calcio(3.0)
                                .magnesio( 1.0)
                                .enxofre(6.0)
                                .aluminio(0.0)
                                .aluminioHidrogenio(0.0)
                                .build()
                                        .enxofre(),
                                TexturaSolo.TEXTURA_MEDIA.calculaValorIdeal().enxofre());
                assertEquals(NutrientesCTC
                                .builder()
                                .fosforo(12.0)
                                .potassio(0.25)
                                .calcio(3.0)
                                .magnesio( 1.0)
                                .enxofre(6.0)
                                .aluminio(0.0)
                                .aluminioHidrogenio(0.0)
                                .build()
                                        .magnesio(),
                                TexturaSolo.TEXTURA_MEDIA.calculaValorIdeal().magnesio());
                assertEquals(NutrientesCTC
                                .builder()
                                .fosforo(12.0)
                                .potassio(0.25)
                                .calcio(3.0)
                                .magnesio( 1.0)
                                .enxofre(6.0)
                                .aluminio(0.0)
                                .aluminioHidrogenio(0.0)
                                .build()
                                        .potassio(),
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
