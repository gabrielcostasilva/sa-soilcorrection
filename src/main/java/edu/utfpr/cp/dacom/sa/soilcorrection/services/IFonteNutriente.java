package edu.utfpr.cp.dacom.sa.soilcorrection.services;

import edu.utfpr.cp.dacom.sa.soilcorrection.services.NutrienteAdicional;

import java.util.Set;

public interface IFonteNutriente {
    
    public double getTeorFonte();
    public Set<NutrienteAdicional> getNutrientesAdicionais();
}
