package br.senai.sp.jandira.model;

import java.util.ArrayList;

public class Tabuada {
	// Atributos:
	public int multiplicando;
	public int minMultiplicador;
	public int maxMultiplicador;

	// Metódos
	ArrayList<String> tabuada = new ArrayList<String>();

	public ArrayList<String> getTabuada() {

		while (minMultiplicador <= maxMultiplicador) {
			tabuada.add(multiplicando + " X " + minMultiplicador + " = " + (multiplicando * minMultiplicador));

			minMultiplicador++;
		}
		return tabuada;
	}
}