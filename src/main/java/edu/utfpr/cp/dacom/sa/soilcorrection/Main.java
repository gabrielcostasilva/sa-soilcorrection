package edu.utfpr.cp.dacom.sa.soilcorrection;

import edu.utfpr.cp.dacom.sa.soilcorrection.controllers.CalcioMagnesioController;
import edu.utfpr.cp.dacom.sa.soilcorrection.controllers.FosforoController;
import edu.utfpr.cp.dacom.sa.soilcorrection.controllers.PotassioController;
import io.javalin.Javalin;

public class Main {
    public static void main(String[] args) {
        Javalin app = Javalin.create().start(8080);
        app.get("/fosforo", FosforoController::calcularCorrecao);
        app.get("/potassio", PotassioController::calcularQuantidadeAAplicar);
        app.get("/calcio_magnesio", CalcioMagnesioController::calcularCorrecao);
    }
}
