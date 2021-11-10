package eventos1;

import java.awt.Color;
import java.awt.event.MouseWheelEvent;
import java.awt.event.MouseWheelListener;

import javax.swing.*;

public class Eventos1 extends JFrame {

    public JPanel panel;
    public JLabel etiqueta;
    public JButton rojo;
    public JButton verde;
    public JButton azul;
    static int red;
    static int green;
    static int blue;

    public Eventos1() {
        setVentana();
        initC();
        red = 100;
        green = 100;
        blue = 100;
        actualizar();
    }

    private void setVentana() {
        setSize(400, 400);
        setTitle("Eventos1");
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);
        this.getContentPane().setBackground(Color.WHITE);
//	this.setLayout(null);
    }

    private void initC() {
        colocarPaneles();
        colocarEtiquetas();
        ponerBotones();
    }

    private void colocarPaneles() {
        panel = new JPanel();
        panel.setLayout(null);
        this.getContentPane().add(panel);
    }

    private void colocarEtiquetas() {
        etiqueta = new JLabel("Esto es una etiqueta ", SwingConstants.CENTER);
        etiqueta.setBounds(10, 10, 350, 100);
        etiqueta.setOpaque(true);
        panel.add(etiqueta);

    }

    private void ponerBotones() {
        rojo = new JButton("Rojo");
        rojo.setBounds(35, 160, 70, 70);
        rojo.setBackground(Color.WHITE);
        panel.add(rojo);

        verde = new JButton("Verde");
        verde.setBounds(155, 160, 70, 70);
        verde.setBackground(Color.WHITE);
        panel.add(verde);

        azul = new JButton("Azul");
        azul.setBounds(285, 160, 70, 70);
        azul.setBackground(Color.WHITE);
        panel.add(azul);

        accionRojo();
        accionVerde();
        accionAzul();

    }

    private void accionRojo() {
        rojo.addMouseWheelListener(new MouseWheelListener() {

            @Override
            public void mouseWheelMoved(MouseWheelEvent arg0) {
                red += arg0.getWheelRotation()*10;
                if (red >= 0 && red <= 255){
                    red += arg0.getWheelRotation()*5;
                    actualizar();
                }
                else {
                    if (red < 0)
                        red = 0;
                    if (red > 255)
                        red = 255;
                }
            }

        });

    }

    private void accionVerde() {
        verde.addMouseWheelListener(new MouseWheelListener() {

            @Override
            public void mouseWheelMoved(MouseWheelEvent arg0) {
                green += arg0.getWheelRotation()*10;
                if (green >= 0 && green <= 255){
                    green += arg0.getWheelRotation()*5;
                    actualizar();
                }
                else {
                    if (green < 0)
                        green = 0;
                    if (green > 255)
                        green = 255;
                }
            }

        });

    }

    private void accionAzul() {
        azul.addMouseWheelListener(new MouseWheelListener() {

            @Override
            public void mouseWheelMoved(MouseWheelEvent arg0) {
                blue += arg0.getWheelRotation()*10;
                if (blue >= 0 && blue <= 255){
                    blue += arg0.getWheelRotation()*5;
                    actualizar();
                }
                else {
                    if (blue < 0)
                        blue = 0;
                    if (blue > 255)
                        blue = 255;
                }
            }

        });

    }

    private void actualizar() {
        etiqueta.setText("Color (" + red + " - " + green + " - " + blue + ")");
        panel.setBackground(new Color(red, green, blue));
    }

    public static void main(String[] args) {
        // TODO Auto-generated method stub

        Eventos1 e01 = new Eventos1();
        e01.setVisible(true);


    }

}
