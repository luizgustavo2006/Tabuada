package br.senai.sp.jandira.model;

import java.util.ArrayList;

public class Tabuada {

	// Atributos:
	public int multiplicando;
	public int minMultiplicador;
	public int maxMultiplicador;

	
	// Metódos
	public ArrayList<String> getTabuada() {
		
		ArrayList<String> tabuada = new ArrayList<String>();
		
		while (minMultiplicador <= maxMultiplicador) {
			int resultado = multiplicando * minMultiplicador;
			tabuada.add(multiplicando + "X" + minMultiplicador + " = " + resultado);

			minMultiplicador++;
		}
		return tabuada;
	}
}
