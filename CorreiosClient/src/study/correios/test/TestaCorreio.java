package study.correios.test;

import java.math.BigDecimal;
import java.util.List;

import study.correios.client.CResultado;
import study.correios.client.CServico;
import study.correios.client.CalcPrecoPrazoWS;
import study.correios.client.CalcPrecoPrazoWSSoap;

public class TestaCorreio {

	public static void main(String[] args) {

		CalcPrecoPrazoWSSoap calcPrecoPrazoWSSoap = new CalcPrecoPrazoWS().getCalcPrecoPrazoWSSoap();

		String codigoSedex = "40010";
		String cepOrigemCaelumSP = "18040690"; // Caelum SP
		String cepDestino = "18040429"; // Caelum RJ
		String peso3kg = "3";
		BigDecimal comprimento20cm = new BigDecimal(20);
		BigDecimal altura10cm = new BigDecimal(10);
		BigDecimal largura15cm = new BigDecimal(15);
		BigDecimal diametro10cm = new BigDecimal(10);
		int formatoEncomendaCaixa = 1; // 1 é caixa ou pacote
		BigDecimal semValorDeclarado = BigDecimal.ZERO;
		String semEntregueEmMaos = "N";
		String semAvisoRecebimento = "N";
		String semCodigoEmpresa = "";
		String semSenhaEmpresa = "";

		CResultado calcPrecoPrazo = calcPrecoPrazoWSSoap.calcPrecoPrazo(semCodigoEmpresa, semSenhaEmpresa, codigoSedex, cepOrigemCaelumSP,
				cepDestino, peso3kg, formatoEncomendaCaixa, comprimento20cm, altura10cm, largura15cm, diametro10cm,
				semEntregueEmMaos, semValorDeclarado, semAvisoRecebimento);
		
		List<CServico> cServico = calcPrecoPrazo.getServicos().getCServico();
		String valor = cServico.get(0).getValor();
		
		System.out.printf("Frete para %s eh de %s %n", cepDestino, valor);
	}

}
