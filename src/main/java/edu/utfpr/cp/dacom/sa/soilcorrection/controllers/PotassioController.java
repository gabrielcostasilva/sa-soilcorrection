package edu.utfpr.cp.dacom.sa.soilcorrection.controllers;

import edu.utfpr.cp.dacom.sa.soilcorrection.services.ConverteCMolcDm3EmMgDm3;
import edu.utfpr.cp.dacom.sa.soilcorrection.services.ConverteKgHaEmK2O;
import edu.utfpr.cp.dacom.sa.soilcorrection.services.CorrecaoPotassio;
import edu.utfpr.cp.dacom.sa.soilcorrection.services.FontePotassio;
import io.javalin.http.Context;

public class PotassioController {
    private PotassioController() {
    }

    public static void calcularQuantidadeAAplicar(Context context) {
        String teorSolorFromQuery = context.queryParam("teor_solo");
        String fontePotassioFromQuery = context.queryParam("fonte_potassio");
        String participacaoCTCExistenteFromQuery = context.queryParam("participacao_ctc_existente");
        String participacaoCTCDesejadaFromQuery = context.queryParam("participacao_ctc_desejada");

        double teorSolo = Double.parseDouble(teorSolorFromQuery);
        double partCTCExistente = Double.parseDouble(participacaoCTCExistenteFromQuery);
        double partCTCDesejada = Double.parseDouble(participacaoCTCDesejadaFromQuery);
        Integer fontePotassio = Integer.parseInt(fontePotassioFromQuery);
        CorrecaoPotassio correcaoPotassio = new CorrecaoPotassio();

        double necessidadeAdicionarDM3 = correcaoPotassio.calculaNecessidadeAdicionarCMolcDm3(teorSolo, partCTCExistente, partCTCDesejada);
        double necessidadeAdicionarEmMgDm3 = new ConverteCMolcDm3EmMgDm3().converte(necessidadeAdicionarDM3);
        double necessidadeAdicionarEmKgHa = necessidadeAdicionarEmMgDm3 * 2;
        double necessidadeAdicionarEmK20 = new ConverteKgHaEmK2O().converte(necessidadeAdicionarEmKgHa);
        double eficienciaNutriente = correcaoPotassio.calculaEficienciaNutriente(necessidadeAdicionarEmK20, 0.85);

        FontePotassio teorFonte;

        switch (fontePotassio) {
            case 1:
                teorFonte = FontePotassio.CLORETO_POTASSIO;
                break;
            case 2:
                teorFonte = FontePotassio.SULFATO_POTASSIO;
                break;
            case 3:
                teorFonte = FontePotassio.SULFATO_POTASSIO_MAGNESIO;
                break;
            default: teorFonte = FontePotassio.CLORETO_POTASSIO;
                break;
        }
        double quantidadeAplicar = correcaoPotassio.calculaQuantidadeAplicar(eficienciaNutriente, teorFonte);

        String jsonResponse = "{" +
                "\"necessidade_adicionar_CMolcDm3\": " + necessidadeAdicionarDM3 +
                "," +
                "\"necessidade_adicionar_MgDm3\": " + necessidadeAdicionarEmMgDm3 +
                "," +
                "\"necessidade_adicionar_KgHa\": " + necessidadeAdicionarEmKgHa
                + "," +
                "\"eficiencia_nutriente\": " + eficienciaNutriente +
                "," +
                "\"quantidade_aplicar\": "+ quantidadeAplicar +
                "}";

        context.json(jsonResponse);
    }
}
