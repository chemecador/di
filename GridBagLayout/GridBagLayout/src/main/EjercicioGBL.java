package main;

import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;

import javax.swing.*;

public class EjercicioGBL extends JFrame {
	JPanel panel = new JPanel();

	public EjercicioGBL() {

		this.setDefaultCloseOperation(EXIT_ON_CLOSE);
		this.setBounds(300, 300, 500, 500);
		JButton abrir = new JButton("Abrir");
		JButton guardar = new JButton("Guardar");
		JButton guardarComo = new JButton("Guardar como");
		JButton cerrar = new JButton("Cerrar");
		JButton buscar = new JButton("Buscar");
		JButton ayuda = new JButton("Ayuda");

		panel.setLayout(new GridBagLayout());
		GridBagConstraints config = new GridBagConstraints();

		config.gridx = 0;
		config.gridy = 0;
		config.weightx = 1.0;
		config.weighty = 1.0;
		config.gridwidth = 1;
		config.gridheight = 1;
		config.fill = GridBagConstraints.BOTH;
		panel.add(abrir, config);

		config.gridx = 1;
		config.gridy = 0;
		panel.add(guardar, config);

		config.gridx = 2;
		config.gridy = 0;

		panel.add(guardarComo, config);

		config.gridx = 3;
		config.gridy = 0;

		panel.add(cerrar, config);

		config.gridx = 0;
		config.gridy = 1;
		config.gridwidth = 2;
		config.weightx = 1;

		panel.add(buscar, config);

		config.gridx = 0;
		config.gridy = 2;
		config.weighty = 100;

		panel.add(ayuda, config);

		config.gridx = 2;
		config.gridy = 1;
		config.weighty = 1;
		JTextField jtf = new JTextField("");
		panel.add(jtf, config);

		config.gridx = 2;
		config.gridy = 2;
		config.weightx = 1.0;
		config.weighty = 1.0;
		JTextArea jta = new JTextArea("Texto de área");
		panel.add(jta, config);

		this.add(panel);

	}

	public static void main(String[] args) {

		EjercicioGBL e = new EjercicioGBL();
		e.setVisible(true);
	}

}
