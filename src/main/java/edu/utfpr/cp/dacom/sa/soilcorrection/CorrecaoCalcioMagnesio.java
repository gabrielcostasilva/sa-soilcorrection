package edu.utfpr.cp.dacom.sa.soilcorrection;

public class CorrecaoCalcioMagnesio implements ICorrecaoNutriente<FonteCalcioMagnesio> {

    // (Memória de Cálculo) Método de Cálculo de Teor de CaO a Adicionar: F96
    public double teorCaO(
        double calcio,
        double fosfatagem,
        double participacaoCTCExistente,
        double participacaoCTCDesejada
    ) {
        if (calcio <= 0) {
            throw new IllegalArgumentException();
        }

        if (fosfatagem <= 0) {
            throw new IllegalArgumentException();
        }

        if (participacaoCTCExistente <= 0) {
            throw new IllegalArgumentException();
        }

        if (participacaoCTCDesejada <= 0) {
            throw new IllegalArgumentException();
        }

        return ((calcio * participacaoCTCDesejada) / participacaoCTCExistente) - (calcio - fosfatagem);
    }

    // (Memória de Cálculo) Método de Quantidade de Corretivo a Incorporar: I113
    public double calculaQuantidadeCorretivo(
        double quantidade,
        double prnt
    ) {
        if (quantidade <= 0) {
            throw new IllegalArgumentException();
        }

        if (prnt <= 0) {
            throw new IllegalArgumentException();
        }

        return (quantidade * 100) / prnt;
    }

    // (Memória de Cálculo) Método de Quantidade Total de Corretivo a Incorporar: F117/G117
    public double calculaQuantidadeTotalCorretivo(
        double quantidade,
        double ha
    ) {
        if (quantidade <= 0) {
            throw new IllegalArgumentException();
        }

        if (ha <= 0) {
            throw new IllegalArgumentException();
        }

        return quantidade * ha;
    }

    // Método Pós-Correção
    public double calculaValorDeCorrecaoCalcio(
        double calcio,
        double potassio,
        double magnesio,
        double hAl,
        double fosfatagem,
        double participacaoCTCExistente,
        double participacaoCTCDesejada
    ) {
        if (calcio <= 0) {
            throw new IllegalArgumentException();
        }

        if (potassio <= 0) {
            throw new IllegalArgumentException();
        }

        if (magnesio <= 0) {
            throw new IllegalArgumentException();
        }

        if (hAl <= 0) {
            throw new IllegalArgumentException();
        }

        if (fosfatagem <= 0) {
            throw new IllegalArgumentException();
        }

        if (participacaoCTCExistente <= 0) {
            throw new IllegalArgumentException();
        }

        if (participacaoCTCDesejada <= 0) {
            throw new IllegalArgumentException();
        }

        // Cálculo de Cmol/Dm3
        double cmolDm3 = calcio + potassio + magnesio; // 7.54
        // Cálculo Al Total Pela Tabela
        double aluminio = cmolDm3 + hAl; // 12.89
        // Cálculo de Quantidade de Teor de CaO
        double teorCaO = teorCaO(calcio, fosfatagem, participacaoCTCExistente, participacaoCTCDesejada); // 1.31024832
        // CaO Total
        double caOTotal = teorCaO + calcio; // 7.07024832

        return (caOTotal / aluminio) * 100;

    }

    // public void validaValor(double valor) {
    //     if (valor <= 0) {
    //         throw new IllegalArgumentException();
    //     }
    // }
}
