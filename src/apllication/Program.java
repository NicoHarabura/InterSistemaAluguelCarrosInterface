package apllication;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;

import model.entities.AluguelCarro;
import model.entities.Carro;
import model.services.ServicoDeAluguel;
import model.services.ServicoImpostoBrasil;

public class Program {

	public static void main(String[] args) throws ParseException {
		Scanner sc = new Scanner (System.in);
		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy HH:ss");
		
		System.out.println("Digite os dados da locação: ");
		System.out.println("Modelo do carro: ");
		String modelo = sc.nextLine();
		System.out.println("Data de retirada do veiculo (dd/mm/aaaa hh:ss):");
		Date entrada = sdf.parse(sc.nextLine());
		System.out.println("Data de saida do veiculo (dd/mm/aaaa hh:ss:");
		Date saida = sdf.parse(sc.nextLine());
		
		AluguelCarro aluguelCarro = new AluguelCarro(entrada, saida, new Carro(modelo));
		
		System.out.println("Digite o preço por hora: ");
		double precoPorHora = sc.nextDouble();
		System.out.println("Digite o preço por dia: ");
		double precoPorDia = sc.nextDouble();
		
		ServicoDeAluguel servicoDeAluguel = new ServicoDeAluguel(precoPorHora, precoPorDia,  new ServicoImpostoBrasil());
		
		servicoDeAluguel.processarNotaFiscal(aluguelCarro);
		
		System.out.println("NOTA FISCAL: ");
		System.out.println("Pagamento Básico: " + String.format("%.2f", aluguelCarro.getNotaFiscal().getPagamentoBasico()));
		System.out.println("Imposto: " + String.format("%.2f", aluguelCarro.getNotaFiscal().getImposto()));
		System.out.println("Total: " + String.format("%.2f", aluguelCarro.getNotaFiscal().pagamentoTotal()));
		
		sc.close();
	}
	
}
