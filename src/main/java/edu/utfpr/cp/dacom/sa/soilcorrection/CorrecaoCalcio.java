package edu.utfpr.cp.dacom.sa.soilcorrection;

public class CorrecaoCalcio {

	double calculaQuantidadeCalcio() {

		// MC_G111 + MC_I105
		// MC_G111: G109+F113
		// MC_I105: 0.017326734

		// G109
		var totalCalcioAdicionado = 1.016;
		// F113
		var quantidadeCorretivoIncorporar = 1.29;

		var QuantidadeCalcioHa = totalCalcioAdicionado * quantidadeCorretivoIncorporar;

		return QuantidadeCalcioHa + 0.017326734;
	}

	double calculaValorAposCorrecao(double porcentagemCalcio, double participacaoAtual, double hidrogenioAluminio,
			double potacio, double calcio, double magnesio) {

		var somaCmol = potacio + calcio + magnesio;

		var somaAluminio = somaCmol + hidrogenioAluminio;

		var quantidadeCalcio = calculaQuantidadeCalcio(); // O179

		var somaCalcioQuantidade = calcio + quantidadeCalcio;

		double calculoCalcio = (somaCalcioQuantidade / somaAluminio) * 100;

		return Math.round(calculoCalcio);
	}
}