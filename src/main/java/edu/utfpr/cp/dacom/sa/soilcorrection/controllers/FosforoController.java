package edu.utfpr.cp.dacom.sa.soilcorrection.controllers;

import edu.utfpr.cp.dacom.sa.soilcorrection.services.CorrecaoFosforo;
import edu.utfpr.cp.dacom.sa.soilcorrection.services.FonteFosforo;
import io.javalin.http.Context;

import java.text.NumberFormat;

public final class FosforoController {

    private FosforoController() {}


    public static void calcularCorrecao(Context context) {
        String teorFromQuery = context.queryParam("teor_fosforo");
        String fonteFosforoFromQuery = context.queryParam("fonte_fosforo");

        double teorFosforo = Double.parseDouble(teorFromQuery);
        Integer codigoFonteFosforo = Integer.parseInt(fonteFosforoFromQuery);
        FonteFosforo fonteFosforo;
        CorrecaoFosforo correcaoFosforo = new CorrecaoFosforo();

        switch (codigoFonteFosforo) {
            case 1:
                fonteFosforo = FonteFosforo.SUPERFOSFATO_SIMPLES;
                break;
            case 2:
                fonteFosforo = FonteFosforo.SUPERFOSFATO_TRIPO;
                break;
            default:
                fonteFosforo = FonteFosforo.MAP;
                break;
        }

        Number eficienciaNutriente = correcaoFosforo.calculaEficienciaNutriente(teorFosforo, 0.7);
        Number quantidadeAplicar = correcaoFosforo.calculaQuantidadeAplicar(teorFosforo, fonteFosforo);

        String jsonResponse = "{\"eficiencia_nutriente\": " + eficienciaNutriente + ", \"quantidade_aplicar\":" + quantidadeAplicar + "}";
        context.json(jsonResponse);
    }
}
