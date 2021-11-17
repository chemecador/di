package tienda;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;

public class Escaparate extends JFrame implements ActionListener {

    int precio;

    JPanel panelPrincipal;
    JPanel panelImagenes;
    JPanel panelTitulo;
    JPanel panelTexto;
    JLabel etiqueta;

    JComboBox cantidadBalones;
    JComboBox cantidadCamisetas;
    JComboBox cantidadPantalones;
    JComboBox cantidadMedias;

    JComboBox colorCamiseta;
    JComboBox colorPantalon;
    JComboBox colorMedias;

    JComboBox cantidadPetos;
    JComboBox colorPeto;


    JButton calcular;
    JLabel total;

    public Escaparate() {
        precio = 0;
        initComponents();

    }

    private void setVentana() {
        setSize(800, 800);
        setTitle("Escaparate");
        this.setResizable(false);
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);
    }

    private void initComponents() {
        setVentana();
        setPaneles();
        setEtiquetas();
        setLogo();
        setImagenes();
        setTexto();
    }

    private void setPaneles() {
        panelPrincipal = new JPanel();
        panelPrincipal.setLayout(new BorderLayout());
        panelPrincipal.setBackground(Color.BLACK);
        panelPrincipal.setPreferredSize(new Dimension(0, 0));
        add(panelPrincipal);

        panelTitulo = new JPanel();
        panelTitulo.setLayout(new BorderLayout());
        panelPrincipal.add(panelTitulo, BorderLayout.NORTH);

        panelImagenes = new JPanel();
        panelImagenes.setLayout(new BoxLayout(panelImagenes, BoxLayout.Y_AXIS));
        panelImagenes.setBackground(new Color(0x20AA20));
        panelImagenes.setPreferredSize(new Dimension(this.getWidth() / 2, 0));
        panelPrincipal.add(panelImagenes, BorderLayout.WEST);

        panelTexto = new JPanel();
        //panelTexto.setLayout(new BoxLayout(panelTexto,BoxLayout.Y_AXIS));
        panelTexto.setLayout(null);
        panelTexto.setBackground(new Color(0xA0FFA0));
        panelTexto.setPreferredSize(new Dimension(this.getWidth() / 2, 0));
        panelPrincipal.add(panelTexto, BorderLayout.EAST);

    }

    private void setEtiquetas() {
        etiqueta = new JLabel("Tienda", SwingConstants.CENTER);
        Font font = new Font("Agency FB", Font.BOLD, 50);
        etiqueta.setFont(font);
        etiqueta.setOpaque(true);
        panelTitulo.add(etiqueta);
    }

    private void setLogo() {
        Toolkit miSistema = Toolkit.getDefaultToolkit();
        Image logo = miSistema.getImage("logo.png");
        this.setIconImage(logo);
    }

    private void setImagenes() {
        JLabel imagen = new JLabel();
        ImageIcon pelota = new ImageIcon("pelota.jpg");
        imagen.setBounds(0, 200, 100, 100);
        imagen.setIcon(new ImageIcon(pelota.getImage()));
        imagen.setIcon(new ImageIcon(pelota.getImage().
                getScaledInstance(imagen.getWidth(), imagen.getHeight(), Image.SCALE_SMOOTH)));

        panelImagenes.add(Box.createRigidArea(new Dimension(30, 70)));
        panelImagenes.add(imagen);

        imagen = new JLabel();
        ImageIcon equipacion = new ImageIcon("equipacion.jpg");
        imagen.setBounds(0, 600, 100, 100);
        imagen.setIcon(new ImageIcon(equipacion.getImage()));
        imagen.setIcon(new ImageIcon(equipacion.getImage().
                getScaledInstance(imagen.getWidth(), imagen.getHeight(), Image.SCALE_SMOOTH)));

        panelImagenes.add(Box.createRigidArea(new Dimension(30, 140)));
        panelImagenes.add(imagen);

        imagen = new JLabel();
        ImageIcon peto = new ImageIcon("peto.jpg");
        imagen.setBounds(0, 1200, 100, 100);
        imagen.setIcon(new ImageIcon(peto.getImage()));
        imagen.setIcon(new ImageIcon(peto.getImage().
                getScaledInstance(imagen.getWidth(), imagen.getHeight(), Image.SCALE_SMOOTH)));

        panelImagenes.add(Box.createRigidArea(new Dimension(30, 140)));
        panelImagenes.add(imagen);


    }

    private void calcularTotal(){
        this.precio = 0;
        this.precio += Integer.parseInt(cantidadBalones.getSelectedItem().toString())*20;
        this.precio += Integer.parseInt(cantidadCamisetas.getSelectedItem().toString())*20;
        this.precio += Integer.parseInt(cantidadPantalones.getSelectedItem().toString())*10;
        this.precio += Integer.parseInt(cantidadMedias.getSelectedItem().toString())*5;
        this.precio += Integer.parseInt(cantidadPetos.getSelectedItem().toString())*8;


        total.setText("Total: " + precio + "€");
    }
    private void setTexto() {

        //------------------ balones
        JLabel balon = new JLabel("Balones");
        balon.setFont(new Font("Tahoma", Font.BOLD, 20));

        balon.setBounds(30, 40, 100, 100);

        panelTexto.add(balon);

        JLabel precioBalon = new JLabel("Precio: 20€");
        precioBalon.setFont(new Font("Tahoma", Font.PLAIN, 18));
        precioBalon.setBounds(30, 90, 150, 100);
        panelTexto.add(precioBalon);

        String cantidad[] = {"0", "1", "2", "3", "4", "5"};
        cantidadBalones = new JComboBox(cantidad);
        cantidadBalones.setBounds(200, 130, 40, 20);
        panelTexto.add(cantidadBalones);

        //------------------ equipaciones

        JLabel equipacion = new JLabel("Equipaciones");
        equipacion.setFont(new Font("Tahoma", Font.BOLD, 20));

        equipacion.setBounds(30, 230, 150, 100);

        panelTexto.add(equipacion);

        JLabel precioCamiseta = new JLabel("Camiseta: 20€");
        JLabel precioPantalon = new JLabel("Pantalón: 10€");
        JLabel precioMedias = new JLabel("Medias: 5€");

        precioCamiseta.setFont(new Font("Tahoma", Font.PLAIN, 18));
        precioCamiseta.setBounds(30, 280, 150, 100);
        panelTexto.add(precioCamiseta);

        precioPantalon.setFont(new Font("Tahoma", Font.PLAIN, 18));
        precioPantalon.setBounds(30, 310, 150, 100);
        panelTexto.add(precioPantalon);

        precioMedias.setFont(new Font("Tahoma", Font.PLAIN, 18));
        precioMedias.setBounds(30, 340, 150, 100);
        panelTexto.add(precioMedias);


        cantidadCamisetas = new JComboBox(cantidad);
        cantidadCamisetas.setBounds(200, 320, 40, 20);
        cantidadCamisetas.addActionListener(this);
        panelTexto.add(cantidadCamisetas);

        cantidadPantalones = new JComboBox(cantidad);
        cantidadPantalones.setBounds(200, 350, 40, 20);
        cantidadPantalones.addActionListener(this);
        panelTexto.add(cantidadPantalones);

        cantidadMedias = new JComboBox(cantidad);
        cantidadMedias.setBounds(200, 380, 40, 20);
        cantidadMedias.addActionListener(this);
        panelTexto.add(cantidadMedias);



        String colores[] = {"blanco", "negro", "azul", "verde", "amarillo", "rojo"};

        colorCamiseta = new JComboBox(colores);
        colorPantalon = new JComboBox(colores);
        colorMedias = new JComboBox(colores);

        colorCamiseta.setVisible(false);
        colorPantalon.setVisible(false);
        colorMedias.setVisible(false);


        colorCamiseta.setBounds(250, 320, 100, 20);
        colorPantalon.setBounds(250, 350, 100, 20);
        colorMedias.setBounds(250, 380, 100, 20);
        panelTexto.add(colorCamiseta);
        panelTexto.add(colorPantalon);
        panelTexto.add(colorMedias);


        //------------------ petos


        JLabel peto = new JLabel("Petos");
        peto.setFont(new Font("Tahoma", Font.BOLD, 20));

        peto.setBounds(30, 480, 150, 100);

        panelTexto.add(peto);

        JLabel precioPeto = new JLabel("Precio: 8€");
        precioPeto.setFont(new Font("Tahoma", Font.PLAIN, 18));
        precioPeto.setBounds(30, 530, 150, 100);
        panelTexto.add(precioPeto);


        cantidadPetos = new JComboBox(cantidad);
        cantidadPetos.setBounds(200, 570, 40, 20);
        cantidadPetos.addActionListener(this);
        panelTexto.add(cantidadPetos);

        colorPeto = new JComboBox(colores);

        colorPeto.setVisible(false);


        colorPeto.setBounds(250, 570, 100, 20);
        panelTexto.add(colorPeto);

        calcular = new JButton("Calcular Total");
        calcular.setBounds(30,610,160,50);
        calcular.addActionListener(this);
        panelTexto.add(calcular);

        total = new JLabel("Total: " + precio + "€");
        total.setFont(new Font("Tahoma", Font.PLAIN, 23));
        total.setBounds(230, 585, 150, 100);
        total.setVisible(false);
        panelTexto.add(total);

    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == cantidadCamisetas) {
            if (Integer.parseInt(cantidadCamisetas.getSelectedItem().toString()) > 0) {
                colorCamiseta.setVisible(true);
            } else {
                colorCamiseta.setVisible(false);
            }
        } else if (e.getSource() == cantidadPantalones) {
            if (Integer.parseInt(cantidadPantalones.getSelectedItem().toString()) > 0) {
                colorPantalon.setVisible(true);
            } else {
                colorPantalon.setVisible(false);
            }
            this.precio = precio + Integer.parseInt(cantidadPantalones.getSelectedItem().toString())*10;
        } else if (e.getSource() == cantidadMedias) {
            if (Integer.parseInt(cantidadMedias.getSelectedItem().toString()) > 0) {
                colorMedias.setVisible(true);
            } else {
                colorMedias.setVisible(false);
            }
        }
        else if (e.getSource() == cantidadPetos) {
            if (Integer.parseInt(cantidadPetos.getSelectedItem().toString()) > 0) {
                colorPeto.setVisible(true);
            } else {
                colorPeto.setVisible(false);
            }
            this.precio = precio + Integer.parseInt(cantidadMedias.getSelectedItem().toString())*8;
        }
        else if (e.getSource() == calcular){
            calcularTotal();
            total.setVisible(true);
        }
    }
}
