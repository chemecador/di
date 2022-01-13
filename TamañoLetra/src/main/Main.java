package main;

import javax.swing.*;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;
import java.awt.*;

class Slider implements ChangeListener {
    //se crean tres instancias, deben ser estáticas para poder ser accesibles desde fuera de la clase
    static JSlider slider;
    static JLabel label;
    static JTextArea ta;
    static int tam;

    //constructor
    public Slider() {
        JFrame ventana = new JFrame("Tamaño del texto"); //se declara una nueva ventana
        JPanel panel = new JPanel(); //se declara un nuevo panel
        ventana.setSize(400, 400); //se establece el tamaño
        panel.setLayout(new BoxLayout(panel, BoxLayout.Y_AXIS));
        slider = new JSlider(JSlider.HORIZONTAL, 5, 60, 12); //se define la forma que tiene la ventana
        slider.setLocation(30, 30);
        slider.setPaintTicks(true); //se pintan los ticks intermedios
        slider.setMajorTickSpacing(5); //se dejan 5 ticks entre número y número (15-20-25)
        slider.setMinorTickSpacing(1); //cada tick representa un grado
        slider.setPaintLabels(true); //pintar las etiquetas
        slider.addChangeListener(this); //añade el listener que escuche cada vez que se realiza un cambio en el slider
        label = new JLabel();
        ta = new JTextArea();
        tam = slider.getValue();
        ta.setFont(new Font("Calibri", Font.ITALIC, tam));
        ta.setEditable(true);

        panel.add(label);
        panel.add(slider);
        panel.add(ta);

        ventana.add(panel);
        ventana.setVisible(true);
        ventana.setLocationRelativeTo(null);
        ventana.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }

    @Override
    public void stateChanged(ChangeEvent e) {
        tam = slider.getValue(); //obtiene el valor de la temperatura
        String s = Integer.toString(tam); //lo convierte a string
        ta.setFont(new Font("Calibri", Font.ITALIC, tam));
        label.setText(s); //lo muestra en la etiqueta de la ventana
    }

}

public class Main {
    public static void main(String[] args) {
        new Slider();
    }
}