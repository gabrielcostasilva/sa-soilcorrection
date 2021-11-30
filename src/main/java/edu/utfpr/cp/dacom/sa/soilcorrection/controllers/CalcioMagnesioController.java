package edu.utfpr.cp.dacom.sa.soilcorrection.controllers;

import edu.utfpr.cp.dacom.sa.soilcorrection.services.CorrecaoCalcioMagnesio;
import io.javalin.http.Context;

public class CalcioMagnesioController {
    public static void calcularCorrecao(Context context){
        double prntPercent = Double.parseDouble(context.queryParam("prnt_percentagem"));
        double quantidadeFonte = Double.parseDouble(context.queryParam("quantidade_fonte"));
        Integer fonteCorretivo = Integer.parseInt(context.queryParam("fonte_corretivo"));

        CorrecaoCalcioMagnesio correcaoCalcioMagnesio = new CorrecaoCalcioMagnesio();

        double quantidadeAplicar = correcaoCalcioMagnesio.calculaQuantidadeAplicar(quantidadeFonte/100, prntPercent/100);

        context.json("{ \"quantidade_aplicar\": " + quantidadeAplicar + "}");
    }
}
