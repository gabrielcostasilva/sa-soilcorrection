package edu.utfpr.cp.dacom.sa.soilcorrection;

public enum FonteCalcioMagnesio implements IFonteNutriente {
    CALCARIO_DOLOMITICO(0.55, Set.of(new NutrienteAdicional(NomeNutrienteAdicional.CALCIO, 0.5), new NutrienteAdicional(NomeNutrienteAdicional.MAGNESIO, 0.1))),
    CALCARIO_CALCITICO(0.07, Set.of(new NutrienteAdicional(NomeNutrienteAdicional.ENXOFRE, 0.1), new NutrienteAdicional(NomeNutrienteAdicional.CALCIO, 0.4))),

    private final double teorFonte;
    private final Set<NutrienteAdicional> nutrientesAdicionais;

    FonteCalcio(
        double teorFonte,
        final Set<NutrienteAdicional> nutrientesAdicionais) {

        this.teorFonte = teorFonte;
        this.nutrientesAdicionais = nutrientesAdicionais;
    }

    @Override
    public double getTeorFonte() {
        return this.teorFonte;
    }

    @Override
    public Set<NutrienteAdicional> getNutrientesAdicionais() {
        return this.nutrientesAdicionais;
    }
}
