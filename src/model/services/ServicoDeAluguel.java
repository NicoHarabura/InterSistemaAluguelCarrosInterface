package model.services;

import model.entities.AluguelCarro;
import model.entities.NotaFiscal;

public class ServicoDeAluguel {

	private Double precoPorHora;
	private Double precoPorDia;
	
	private ServicoImpostoBrasil servicoImposto;

	public ServicoDeAluguel(Double precoPorHora, Double precoPorDia, ServicoImpostoBrasil servicoImposto) {
		this.precoPorHora = precoPorHora;
		this.precoPorDia = precoPorDia;
		this.servicoImposto = servicoImposto;
	}
	
	public void processarNotaFiscal(AluguelCarro aluguelCarro) {
		//CALCULAR DIFERENÇA DE DATAS
		long t1 = aluguelCarro.getEntrada().getTime(); //CONVERTENDO PARA MILESEGUNDOS
		long t2 = aluguelCarro.getSaida().getTime();
		
		double periodo = (double) (t2 - t1)/1000/60/60;
		
		double pagamentoBasico;
		if (periodo <= 12.0){
			pagamentoBasico = Math.ceil(periodo) * precoPorHora;
		} else {
			pagamentoBasico = Math.ceil(periodo)/24 /*CONVERTENDO PRA DIAS*/ * precoPorDia;
		}
		
		double imposto = servicoImposto.imposto(pagamentoBasico);
		
		aluguelCarro.setNotaFiscal(new NotaFiscal(pagamentoBasico, imposto));
		
	}
	
}
