package edu.utfpr.cp.dacom.sa.soilcorrection.services;

public class EquilibrioCorrecaoCTC {

    public double calculaSCmol(
            double potassio, 
            double calcio, 
            double magnesio) {
        
        return potassio + calcio + magnesio;
    }

    public double calculaCTCCmol(
            double potassio, 
            double calcio, 
            double magnesio,
            double hidrogenioAluminio) {
    
        return calculaSCmol(potassio, calcio, magnesio) + hidrogenioAluminio;
    }

    public double calculaVPercentual(double Scmol, double CTCcmol) {
        
        if (Scmol > 0 && CTCcmol > 0) {
            return Scmol / CTCcmol * 100;
            
        } else {
            return 0.0;
        }
    }

    public double calculaMOPercentual(double mo) {
        if (mo > 0) {
            return mo / 10;
            
        } else {
            return 0.0;
        }
    }

   public double calculaCarbono(double moPercentual) {
        
        if (moPercentual > 0) {
            return moPercentual / 1.72 * 10;
            
        } else {
            return 0.0;
        }
    }

}
