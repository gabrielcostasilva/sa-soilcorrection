package edu.utfpr.cp.dacom.sa.soilcorrection.controllers;

import io.javalin.http.Context;

import java.text.NumberFormat;

public final class FosforoController {

    private FosforoController() {}


    public static void calcularCorrecao(Context context) {
        String teorFromQuery = context.queryParam("teor_fosforo");
        double teorFosforo = Double.parseDouble(teorFromQuery);

        System.out.println(teorFosforo);
    }
}
