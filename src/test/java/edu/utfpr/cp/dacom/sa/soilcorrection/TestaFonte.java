package edu.utfpr.cp.dacom.sa.soilcorrection;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class TestaFonte {
    @Test
    public void testaTipoFonte() {
        // Instanciando classe CorrecaoCalcioMagnesio
        var verificacao = new VerificaFonte();

        // Equilíbrio e Correção na CTC: D52
        int fonteCorretivo = 2;

        assertEquals("Calcário Calcítico", verificacao.verificaFonte(fonteCorretivo));
    }
}
