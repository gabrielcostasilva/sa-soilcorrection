package edu.utfpr.cp.dacom.sa.soilcorrection;

import edu.utfpr.cp.dacom.sa.soilcorrection.EnumClasses.NomeNutrienteAdicional;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;

@RequiredArgsConstructor
public class NutrienteAdicional {

    private final NomeNutrienteAdicional nome;

    @Getter
    private final double teorNutriente;

    @Getter @Setter
    private double correcaoAdicional;
    
}
