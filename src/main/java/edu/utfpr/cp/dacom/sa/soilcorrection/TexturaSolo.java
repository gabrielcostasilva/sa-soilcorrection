package edu.utfpr.cp.dacom.sa.soilcorrection;

public enum TexturaSolo {
    
    ARGILOSO {
        public NutrientesCTC calculaValorIdeal() {
            return NutrientesCTC
                    .builder()
                    .fosforo(9.0)
                    .potassio(0.35)
                    .calcio(6.0)
                    .magnesio(1.5)
                    .enxofre(9.0)
                    .aluminio(0.0)
                    .aluminioHidrogenio(0.0)
                    .build();
        }
    },
    TEXTURA_MEDIA{
        public NutrientesCTC calculaValorIdeal() {
            return NutrientesCTC
                    .builder()
                    .fosforo(12.0)
                    .potassio(0.25)
                    .calcio(3.0)
                    .magnesio( 1.0)
                    .enxofre(6.0)
                    .aluminio(0.0)
                    .aluminioHidrogenio(0.0)
                    .build();

        }
    };
    
    public abstract NutrientesCTC calculaValorIdeal();
}
