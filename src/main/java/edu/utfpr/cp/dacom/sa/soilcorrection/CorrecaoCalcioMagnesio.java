package edu.utfpr.cp.dacom.sa.soilcorrection;

public class CorrecaoCalcioMagnesio implements ICorrecaoNutriente<FonteCalcioMagnesio> {

    // (Memória de Cálculo) Método de Cálculo de Teor de CaO a Adicionar: F96
    public double teorCaO(double calcio, double fosfatagem, double participacaoCTCExistente,
            double participacaoCTCDesejada) {
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
    public double calculaQuantidadeCorretivo(double quantidade, double prnt) {
        if (quantidade <= 0) {
            throw new IllegalArgumentException();
        }

        if (prnt <= 0) {
            throw new IllegalArgumentException();
        }

        return (quantidade * 100) / prnt;
    }

    // (Memória de Cálculo) Método de Quantidade Total de Corretivo a Incorporar: F117/G117
    public double calculaQuantidadeTotalCorretivo(double quantidade, double ha) {
        if (quantidade <= 0) {
            throw new IllegalArgumentException();
        }

        if (ha <= 0) {
            throw new IllegalArgumentException();
        }

        return quantidade * ha;
    }

    // Método Pós-Correção
    public double calculaValorDeCorrecaoCalcio(double calcio, double potassio, double magnesio, double hAl,
            double fosfatagem, double participacaoCTCExistente, double participacaoCTCDesejada) {
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
        double teorCaO = teorCaO(calcio, fosfatagem, participacaoCTCExistente, participacaoCTCDesejada); // 1.3442483221477
        // CaO Total
        double caOTotal = teorCaO + calcio; // 7.104248322

        return (caOTotal / aluminio) * 100; // 55.114416774
    }

    // Métodos de Cálculo para Valores R$

    // (Memória de Cálculo) Método para Cálculo de Custo/Alqueire: K118/L118
    public double calculaCustoPorAlqueire(double toneladasPorHa, double valorPorTonelada) {
        // Memória de Cálculo - A116/B116
        double toneladasPorAlqueire = toneladasPorHa * 2.42; // 4.477
        // Equilíbrio e Correção na CTC: P104
        return toneladasPorAlqueire * valorPorTonelada; // 2238.5
    }

    // (Memória de Cálculo) Método para Cálculo de Custo Total: K120/L120
    public double calculaCustoTotal(double quantidadeTotalCorretivo, double valorPorTonelada) {
        // Equilíbrio e Correção na CTC: O137
        return quantidadeTotalCorretivo * valorPorTonelada; // 3121.8
    }

}
