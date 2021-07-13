package edu.utfpr.cp.dacom.sa.soilcorrection;

public enum FonteCalcioMagnesio implements IFonteNutriente {

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
