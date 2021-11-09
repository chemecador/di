package botones;

import java.awt.event.ActionEvent;

import javax.swing.*;


public class Botones extends JFrame {
	JPanel panel = new JPanel();
	static JButton suma;
	static JButton resta;
	static JButton cerrar;
	static JTextArea jta;
	static int i;

	public Botones() {

		this.i = 0;
		panel.setLayout(null);
		resta = new JButton("Restar");
		suma = new JButton("Sumar");
		cerrar = new JButton("Cerrar");
		this.setDefaultCloseOperation(EXIT_ON_CLOSE);
		this.setBounds(300, 300, 600, 600);
		jta = new JTextArea("0");
		jta.setBounds(160, 100, 200, 150);
		resta.setBounds(20, 100, 100, 150);
		suma.setBounds(400, 100, 100, 150);
		cerrar.setBounds(400, 300, 100, 50);
		cerrar.addActionListener(this::actionPerformed);
		suma.addActionListener(this::actionPerformed);
		resta.addActionListener(this::actionPerformed);
		panel.add(resta);
		panel.add(jta);
		panel.add(suma);
		panel.add(cerrar);

		this.add(panel);

	}

	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == cerrar) {
			System.exit(0);
		} else if (e.getSource() == suma) {
			i++;
			jta.setText(String.valueOf(i));
		} else if (e.getSource() == resta) {
			i--;
			jta.setText(String.valueOf(i));
		}
	}

	public static void main(String[] args) {

		Botones e = new Botones();
		e.setVisible(true);
	}

}
