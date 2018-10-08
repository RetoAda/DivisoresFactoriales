package es.unex.cum.retoada;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.Scanner;
import java.util.StringTokenizer;

public class Main {

	public static void main(String[] args) {
		Main m = new Main();
		int n = 2^31;

		//Lo primero es leer lo introducido por teclado
		Scanner s = new Scanner (System.in);
		String entrada = s.nextLine();
		ArrayList <String>lista = new ArrayList <String>();
		lista.add(entrada); //voy guardando en la lista lo que me va metiendo por teclado
		StringTokenizer tokens_numeros = new StringTokenizer(entrada);
		String num1 = tokens_numeros.nextToken(); //cojo el primer numero
		String num2 = tokens_numeros.nextToken(); //cojo el segundo numero
		while ((entrada.charAt(0) != '0' || entrada.charAt(2) != '0') && 
				(Integer.parseInt(num1) < n) &&
				(Integer.parseInt(num2) < n)) { //dejo de leer cuando introduce 0 0
			entrada = s.nextLine();	
			if (entrada.charAt(0) != '0' || entrada.charAt(2) != '0') lista.add(entrada);
		}
		
		m.separar(lista);
		s.close();

	}
	
	public void separar (ArrayList <String>lista) {
		Iterator it = lista.iterator();
		
		while (it.hasNext()) {
			int cont = 0; //numero de acarreos
			
			String numeros = (String) it.next();
			StringTokenizer tokens_numeros = new StringTokenizer(numeros);
			String num1 = tokens_numeros.nextToken(); //cojo el primer numero
			String num2 = tokens_numeros.nextToken(); //cojo el segundo numero
			
			double fact = factorial(num1);
			divisor (fact, num2, num1);
		}
		
	}
	
	public double factorial (String num1) {
		if (Double.parseDouble(num1) == 0) return 1;
		else {
			return Double.parseDouble(num1) * factorial(Double.toString(Double.parseDouble(num1) - 1));
		}
	}
	
	public void divisor (double fact, String num2, String num1) {
		double n = Double.parseDouble(num2);
		if (fact % n == 0) 
			System.out.println(num2 + " divide a " + num1 + "!");
		else
			System.out.println(num2 + " no divide a " + num1 + "!");
	}

}
