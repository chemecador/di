package ventana;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Image;
import java.awt.Toolkit;

import javax.swing.JFrame;
import javax.swing.JLabel;

public class Ventana extends JFrame {

	public Ventana() {
		Toolkit miSistema = Toolkit.getDefaultToolkit();
		Image logo = miSistema.getImage("bart.jpg");
		this.setIconImage(logo);
			//resolucion del so
		Dimension resolucion = miSistema.getScreenSize();
		JLabel etiqueta = new JLabel();
		etiqueta.setText("La dimensi?n es " + (int)resolucion.getWidth() + "x" + (int)resolucion.getHeight());
		this.add(etiqueta);
		//tama?o de la ventana
		//this.setSize(400, 400);
			//localizacion de un punto en la pantalla
		//this.setLocation(440,250);
			//union de setSize y setLocation
		this.setBounds(400,400,400,400);
			//tama?o minimo de la pantalla
		this.setMinimumSize(new Dimension(200,200));
		this.setResizable(false);
		this.setTitle("Hola mundo");
		this.setDefaultCloseOperation(EXIT_ON_CLOSE);
		this.getContentPane().setBackground(Color.ORANGE);
	}

	public static void main(String[] args) {

		Ventana ventana = new Ventana();
		ventana.setVisible(true);
	}

}
