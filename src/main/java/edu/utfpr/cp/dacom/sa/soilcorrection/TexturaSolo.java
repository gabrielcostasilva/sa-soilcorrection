package edu.utfpr.cp.dacom.sa.soilcorrection;

public enum TexturaSolo {
    
    ARGILOSO {
        public Nutrientes calculaValorIdeal() {
            return new Nutrientes(9.0, 0.35, 6.0, 1.5, 9.0, 0.0, 0.0);
        }
    },
    TEXTURA_MEDIA{
        public Nutrientes calculaValorIdeal() {
            return new Nutrientes(12.0, 0.25, 3.0, 1.0, 6.0, 0.0, 0.0);
        }
    };
    
    public abstract Nutrientes calculaValorIdeal();
}
