package tienda;

import java.awt.*;
import javax.swing.*;

public class Escaparate extends JFrame {

    public JPanel panelPrincipal;
    public JPanel panelImagenes;
    public JLabel etiqueta;

    public Escaparate() {
        initComponents();

    }

    private void setVentana() {
        setSize(400, 400);
        setTitle("Escaparate");
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);
        this.getContentPane().setBackground(Color.WHITE);
    }

    private void initComponents() {
        setVentana();
        setPaneles();
        setEtiquetas();
        setLogo();
        setImagenes();
        //this.pack();
    }

    private void setPaneles() {
        panelPrincipal = new JPanel();
        panelPrincipal.setLayout(null);
        this.getContentPane().add(panelPrincipal);

        panelImagenes = new JPanel();
        panelImagenes.setLayout(new BorderLayout());
        this.getContentPane().add(panelImagenes);
    }

    private void setEtiquetas() {
        etiqueta = new JLabel("Tienda", SwingConstants.CENTER);
        Font font = new Font("Agency FB", Font.BOLD, 50);
        etiqueta.setFont(font);
        etiqueta.setSize(350, 100);
        etiqueta.setOpaque(true);
        panelPrincipal.add(etiqueta);
    }

    private void setLogo() {
        Toolkit miSistema = Toolkit.getDefaultToolkit();
        Image logo = miSistema.getImage("logo.png");
        this.setIconImage(logo);
    }

    private void setImagenes() {
        JLabel imagen = new JLabel();
        ImageIcon pelota = new ImageIcon("pelota.jpg");
        imagen.setBounds(0, 200, 50, 50);
        imagen.setIcon(new ImageIcon(pelota.getImage()));
        imagen.setIcon(new ImageIcon(pelota.getImage().
                getScaledInstance(imagen.getWidth(), imagen.getHeight(), Image.SCALE_SMOOTH)));
        panelImagenes.add(imagen);

        imagen = new JLabel();
        ImageIcon equipacion = new ImageIcon("equipacion.jpg");
        imagen.setBounds(0, 600, 50, 50);
        imagen.setIcon(new ImageIcon(equipacion.getImage()));
        imagen.setIcon(new ImageIcon(equipacion.getImage().
                getScaledInstance(imagen.getWidth(), imagen.getHeight(), Image.SCALE_SMOOTH)));
        panelImagenes.add(imagen);
    }
}
