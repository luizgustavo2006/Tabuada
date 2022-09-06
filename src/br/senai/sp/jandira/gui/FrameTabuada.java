package br.senai.sp.jandira.gui;

import javax.swing.JFrame;

public class FrameTabuada {

	public String titulo;
	public int altura;
	public int largura;

	public void criarTela() {
		JFrame tela = new JFrame();
		//Configuração da tela
		tela.setTitle(titulo);
		tela.setSize(largura, altura);
		tela.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		
		
		
		
		
		
		
		
		
		
		//Definindo que Tela é visivel ou não 
		tela.setVisible(true);
	}
}
