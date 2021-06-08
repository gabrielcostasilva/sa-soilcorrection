package edu.utfpr.cp.dacom.sa.soilcorrection;

public enum TexturaSolo {
    
    ARGILOSO {
        public NutrientesCTC calculaValorIdeal() {
            return new NutrientesCTC(9.0, 0.35, 6.0, 1.5, 9.0, 0.0, 0.0);
        }
    },
    TEXTURA_MEDIA{
        public NutrientesCTC calculaValorIdeal() {
            return new NutrientesCTC(12.0, 0.25, 3.0, 1.0, 6.0, 0.0, 0.0);
        }
    };
    
    public abstract NutrientesCTC calculaValorIdeal();
}
