package flayout;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

public class FLayout extends JFrame {
	JPanel panel = new JPanel();
	private JButton boton1,boton2,boton3,boton4,boton5;

	public FLayout() {
		setVentana();
		init();
	}
	
	private void setVentana() {
		setTitle("Botones");
		setBounds(600,360,600,300);
		this.setDefaultCloseOperation(EXIT_ON_CLOSE);
		this.add(panel);
	}

	private void init() {
		JButton boton = new JButton();
		boton.setText("boton 1");

	}
	public static void main (String[] args) {
		
	}
}
