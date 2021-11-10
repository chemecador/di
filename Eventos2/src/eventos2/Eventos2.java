package eventos2;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.*;

public class Eventos2 extends JFrame {

    public JPanel panel;
    public JLabel etiqueta;
    public JButton boton;
    public JButton boton2;
    static int i;

    public Eventos2() {
        this.i = 0;
        setVentana();
        initC();
    }
    public Eventos2(JLabel etiqueta){
        JPanel panel2 = new JPanel();
        setBounds(600, 300, 300,200);
        setTitle("Eventos2");
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        getContentPane().setBackground(Color.WHITE);
        getContentPane().add(panel2);
        boton2 = new JButton("Volver");
        boton2.setBackground(Color.GREEN);
        panel2.add(boton2);
        boton2.addActionListener (new ActionListener() {
            public void actionPerformed (ActionEvent e) {
                dispose();
                cambiarEtiqueta(etiqueta);
            }
        });
    }

    private void setVentana() {
        setSize(600, 600);
        setTitle("Eventos2");
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);
        this.getContentPane().setBackground(Color.WHITE);
    }

    private void initC() {
        colocarPaneles();
        colocarEtiquetas();
        colocarBotones();
    }

    private void colocarPaneles() {
        panel = new JPanel();
        panel.setLayout(null);
        this.getContentPane().add(panel);
    }
    private void colocarEtiquetas(){
        etiqueta = new JLabel("Has pulsado " + i + " veces el boton de volver",SwingConstants.CENTER);
        etiqueta.setBounds(10, 10, 350, 100);
        etiqueta.setForeground(Color.BLACK);
        etiqueta.setOpaque(true);
        panel.add(etiqueta);
    }
    private void colocarBotones(){
        boton = new JButton("Boton");
        boton.setBounds(100, 160, 200, 80);
        boton.setBackground(Color.GREEN);
        panel.add(boton);
        interaccionBoton();
    }
    public void cambiarEtiqueta(JLabel etiqueta){

        etiqueta.setText("Has pulsado " + i + " veces el boton de volver");
    }

    private void interaccionBoton() {
        boton.addMouseListener(new MouseListener() {

            @Override
            public void mouseClicked(MouseEvent arg0) {


                Eventos2 e2 = new Eventos2(etiqueta);
                e2.setVisible(true);
                i++;

            }

            @Override
            public void mousePressed(MouseEvent e) {

            }

            @Override
            public void mouseReleased(MouseEvent e) {

            }

            @Override
            public void mouseEntered(MouseEvent e) {

            }

            @Override
            public void mouseExited(MouseEvent e) {

            }
        });
    }

    public static void main(String[] args) {
        Eventos2 e = new Eventos2();
        e.setVisible(true);
    }

}
