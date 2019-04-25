package br.com.jsfspringboot.config;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import br.com.jsfspringboot.repository.ColaboradorRepository;

public class Teste2 {
	private static Validador<String> validarCEP = valor -> valor.matches("[0-9]{5}-[0-9]{3}");
	@Autowired
	ColaboradorRepository colab;
	
	public void printCola() {
		colab.findAll().forEach(c -> System.out.println(c.getNome()));
	}
	
	public static void main(String[] args) {
		
		
		
		new Teste2().printCola();
		
		//System.out.println(validarCEP.valida("66083-410"));
//		Date abert = null;
//		Date fecha = null;
//		Date teste = null;
//		try {
//			abert = new SimpleDateFormat("HH:mm").parse("16:00");
//			fecha = new SimpleDateFormat("HH:mm").parse("17:00");
//			teste = new SimpleDateFormat("HH:mm").parse(new SimpleDateFormat("HH:mm").format(new Date()));
//			
//		} catch (ParseException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
//		
//		if(teste.after(abert) && teste.before(fecha)) {
//			System.out.println("OK");
//			System.out.println("["+abert+"] "+"["+fecha+"] "+"["+teste+"] ");
//		}else {
//			System.out.println("Falhou");
//		}
		
//		Stream.of("Jose", "Maria", "Fernando", "Gabriel").forEach(name->{
//			System.out.println(name);
//		});

	}

}

interface Validador<T> {
	boolean valida(T t);
}