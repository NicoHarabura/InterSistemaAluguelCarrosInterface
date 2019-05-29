package model.entities;

import java.util.Date;

public class AluguelCarro {

	private Date entrada;
	private Date saida;
	
	private Carro carro;
	private NotaFiscal notaFiscal;
	
	public AluguelCarro (){
		
	}

	public AluguelCarro(Date entrada, Date saida, Carro carro) {
		this.entrada = entrada;
		this.saida = saida;
		this.carro = carro;
	}

	public Date getEntrada() {
		return entrada;
	}

	public void setEntrada(Date entrada) {
		this.entrada = entrada;
	}

	public Date getSaida() {
		return saida;
	}

	public void setSaida(Date saida) {
		this.saida = saida;
	}

	public Carro getCarro() {
		return carro;
	}

	public void setCarro(Carro carro) {
		this.carro = carro;
	}

	public NotaFiscal getNotaFiscal() {
		return notaFiscal;
	}

	public void setNotaFiscal(NotaFiscal notaFiscal) {
		this.notaFiscal = notaFiscal;
	}

	
	
	
	
}
