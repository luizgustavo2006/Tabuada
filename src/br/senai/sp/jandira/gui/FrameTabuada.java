package br.senai.sp.jandira.gui;

import java.awt.Color;
import java.awt.Container;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.BorderFactory;
import javax.swing.DefaultListModel;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;

import br.senai.sp.jandira.model.Tabuada;

public class FrameTabuada {
	public String titulo;
	public int altura;
	public int largura;

	public void criarTela() {

		JFrame tela = new JFrame();
		// Configuração da tela
		tela.setTitle(titulo);
		tela.setSize(largura, altura);
		tela.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		tela.setLayout(null);

		// Pegar o container para colocar componentes dentro dele
		Container painel = tela.getContentPane();

		// Criando os componentes e configurando para o container

		// Componente Tabuada
		JLabel labelTabuada = new JLabel();
		Font fTabuada = new Font("SansSerif", Font.BOLD, 30);
		labelTabuada.setText("Tabuada 1.0");
		labelTabuada.setBounds(100, 20, 200, 30);
		labelTabuada.setForeground(Color.RED);
		labelTabuada.setFont(fTabuada);

		// Componente Texto
		JTextArea labelTexto = new JTextArea();
		Font fTexto = new Font("SansSerif", Font.ROMAN_BASELINE, 12);
		labelTexto.setText(
				"Com a tabuada 1.0 os seus problemas acabaram. Calcule " + "a tabuada que desejar em segundos!");
		labelTexto.setBounds(100, 50, 330, 35);
		labelTexto.setForeground(Color.GRAY);
		labelTexto.setEditable(false);
		labelTexto.setLineWrap(true);
		labelTexto.setFont(fTexto);

		// Componente Multiplicando
		JLabel labelMultiplicando = new JLabel();
		Font fMultiplicadores = new Font("SansSerif", Font.PLAIN, 23);
		JTextField textFieldMultiplicando = new JTextField();
		labelMultiplicando.setText("Multiplicando: ");
		labelMultiplicando.setBounds(120, 120, 150, 35);
		labelMultiplicando.setForeground(Color.BLACK);
		labelMultiplicando.setFont(fMultiplicadores);
		textFieldMultiplicando.setBounds(270, 122, 160, 35);
		textFieldMultiplicando.setBorder(BorderFactory.createLineBorder(Color.BLUE));

		// Componente Minimo Multiplicador
		JLabel labelMinimoMultiplicador = new JLabel();
		JTextField textFieldMinimoMultiplicador = new JTextField();
		labelMinimoMultiplicador.setText("Mínimo Multiplicador: ");
		labelMinimoMultiplicador.setBounds(44, 175, 250, 35);
		labelMinimoMultiplicador.setForeground(Color.BLACK);
		labelMinimoMultiplicador.setFont(fMultiplicadores);
		textFieldMinimoMultiplicador.setBounds(270, 178, 160, 35);
		textFieldMinimoMultiplicador.setBorder(BorderFactory.createLineBorder(Color.BLUE));

		// Componente Maximo Multiplicador
		JLabel labelMaximoMultiplicador = new JLabel();
		JTextField textFieldMaximoMultiplicador = new JTextField();
		labelMaximoMultiplicador.setText("Maximo Multiplicador: ");
		labelMaximoMultiplicador.setBounds(39, 230, 250, 35);
		labelMaximoMultiplicador.setForeground(Color.BLACK);
		labelMaximoMultiplicador.setFont(fMultiplicadores);
		textFieldMaximoMultiplicador.setBounds(270, 233, 160, 35);
		textFieldMaximoMultiplicador.setBorder(BorderFactory.createLineBorder(Color.BLUE));

		// Componente Botão Calcular
		JButton buttonCalcular = new JButton();
		Color corCalcular = new Color(00, 130, 00);
		buttonCalcular.setText("Calcular");
		buttonCalcular.setBounds(39, 310, 230, 35);
		buttonCalcular.setForeground(Color.WHITE);
		buttonCalcular.setBackground(corCalcular);
		buttonCalcular.setBorder(BorderFactory.createLineBorder(Color.BLUE));

		// Componente Botão Limpar
		JButton buttonLimpar = new JButton();
		Color corLimpar = new Color(238, 173, 45);
		buttonLimpar.setText("Limpar");
		buttonLimpar.setBounds(275, 310, 150, 35);
		buttonLimpar.setForeground(Color.WHITE);
		buttonLimpar.setBackground(corLimpar);
		buttonLimpar.setBorder(BorderFactory.createLineBorder(Color.BLUE));

		// Componente Resultado
		JLabel labelResultado = new JLabel();
		Font fResultado = new Font("SansSerif", Font.BOLD, 16);
		labelResultado.setText("Resultado:");
		labelResultado.setBounds(39, 360, 100, 35);
		labelResultado.setFont(fResultado);

		// Componente de Aparição dos Resultados
		JList<String> listaResultado = new JList<String>();
		Color corLista = new Color(255,255,200);
		listaResultado.setBackground(corLista);
		
		JScrollPane scroll = new JScrollPane(listaResultado);
		scroll.setBounds(39, 400, 400, 200);

		// Painel de aparição dos Labels
		painel.add(labelTabuada);
		painel.add(labelTexto);
		painel.add(labelMultiplicando);
		painel.add(labelMinimoMultiplicador);
		painel.add(labelMaximoMultiplicador);
		painel.add(labelResultado);

		// Painel de aparição dos TextField
		painel.add(textFieldMultiplicando);
		painel.add(textFieldMinimoMultiplicador);
		painel.add(textFieldMaximoMultiplicador);
		painel.add(scroll);

		// Painel de aparição dos Botões
		painel.add(buttonCalcular);
		painel.add(buttonLimpar);
		
		// Definindo que Tela é visivel ou não
		tela.setVisible(true);

		// Definindo ActionListener(Ouvinte)

		buttonCalcular.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {

				Tabuada tabuada = new Tabuada();
				tabuada.multiplicando = Integer.parseInt(textFieldMultiplicando.getText());
				tabuada.minMultiplicador = Integer.parseInt(textFieldMinimoMultiplicador.getText());
				tabuada.maxMultiplicador = Integer.parseInt(textFieldMaximoMultiplicador.getText());

				DefaultListModel<String> listModel = new DefaultListModel<String>();
				for (String linhaTabuada : tabuada.getTabuada()) {
					listModel.addElement(linhaTabuada);
				}

				listaResultado.setModel(listModel);

			}

		});
		
		buttonLimpar.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				
				
			}
		});
	}
}