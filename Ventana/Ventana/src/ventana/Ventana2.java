package ventana;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.FontFormatException;
import java.awt.Image;
import java.awt.Toolkit;
import java.io.File;
import java.io.IOException;

import javax.swing.ImageIcon;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;

public class Ventana2 extends JFrame {
	public Ventana2() {
		setVentana();
		iniciarComponentes();
	}
	private void setVentana() {
		this.setSize(400,400);
		this.setTitle("Hola Mundo");
		this.setMaximumSize(new Dimension (600,600));
		this.setMinimumSize(new Dimension(200,200));
		this.setLayout(null);
		this.setDefaultCloseOperation(EXIT_ON_CLOSE);
	}
	private void iniciarComponentes() {
		JPanel panel = new JPanel();
		panel.setBackground(Color.GREEN);
		panel.setSize(400,400);
		panel.setLayout(null);
		this.getContentPane().add(panel);
		JLabel etiqueta = new JLabel("Esto es una etiqueta",SwingConstants.CENTER);
		//etiqueta.setText("Esto es una etiqueta");
		etiqueta.setBounds(10,10,300,30);
		//color letra
		etiqueta.setForeground(Color.WHITE);
		//color etiqueta
		etiqueta.setBackground(Color.ORANGE);
		//quitar la transparencia
		etiqueta.setOpaque(true);
		etiqueta.setFont(new Font("times new roman",Font.BOLD,20));
		File fuente = new File("letra.ttf");
		try {
			Font font = Font.createFont(Font.TRUETYPE_FONT, fuente);
			etiqueta.setFont(font.deriveFont(30f));
		} catch (FontFormatException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		JLabel imagen = new JLabel();
		ImageIcon emoticono = new ImageIcon("bart.jpg");
		imagen.setBounds(100,100,150,150);
		imagen.setIcon(new ImageIcon(emoticono.getImage()));
		imagen.setIcon(new ImageIcon(emoticono.getImage().getScaledInstance(imagen.getWidth(),imagen.getHeight(),Image.SCALE_SMOOTH)));
		
		JComboBox combo = new JComboBox();
		String[] fontName = Toolkit.getDefaultToolkit().getFontList();
		for (int i = 0; i<fontName.length; i++) {
			combo.addItem(fontName[i]);
		}
		combo.setBounds(1,1,100,30);
		
		panel.add(combo);
		panel.add(imagen);
		panel.add(etiqueta);
	}

	public static void main(String[] args) {
		Ventana2 v = new Ventana2();
		v.setVisible(true);

	}

}
