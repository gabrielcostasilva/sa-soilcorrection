package edu.utfpr.cp.dacom.sa.soilcorrection.FonteNutrienteInterface;

import edu.utfpr.cp.dacom.sa.soilcorrection.NutrienteAdicional;

import java.util.Set;

public interface IFonteNutriente {
    
    public double getTeorFonte();
    public Set<NutrienteAdicional> getNutrientesAdicionais();
}
