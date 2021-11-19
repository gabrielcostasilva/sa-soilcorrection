package edu.utfpr.cp.dacom.sa.soilcorrection;

import io.javalin.Javalin;

public class Main {
    public static void main(String[] args) {
        Javalin app = Javalin.create().start(8080);
    }
}
