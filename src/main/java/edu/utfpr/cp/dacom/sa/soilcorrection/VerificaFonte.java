package edu.utfpr.cp.dacom.sa.soilcorrection;

public class VerificaFonte implements Verificacao<int, String> {
    // (Memória de Cálculo) Método para Verificar Fonte
    @Override
    public String verificaFonte(int fonteCorretivo) {
        String fonte;
        switch (fonteCorretivo) {
            case 1:
                fonte = "Calcário Dolomítico";
                break;
            case 2:
                fonte = "Calcário Calcítico";
                break;
            case 3:
                fonte = "Calcário de Concha";
                break;
            case 4:
                fonte = "Gesso Agrícola";
                break;
            case 5:
                fonte = "Hidróxido de Cálcio";
                break;
            case 6:
                fonte = "Calcário Magnesiano";
                break;
            case 7:
                fonte = "";
                break;
            default:
                throw new IllegalArgumentException();
                break;
        }
        return fonte;
    }
}
