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

    Producto balon;
    Producto equipacion;
    Producto peto;

    JComboBox cantidadBalones;
    JComboBox cantidadCamisetas;
    JComboBox cantidadPantalones;
    JComboBox cantidadMedias;

    JComboBox colorCamiseta;
    JComboBox colorPantalon;
    JComboBox colorMedias;

    JComboBox cantidadPetos;
    JComboBox colorPeto;

    JButton pagar;
    JScrollPane jsp,jsp2;

    public Escaparate() {
        precio = 0;
        balon = new Producto("Balon", "pelota.jpg");
        equipacion = new Producto("Equipacion", "equipacion.jpg");
        peto = new Producto("Peto", "peto.jpg");
        initComponents();
        setVisible(true);
    }

    private void setVentana() {
        setSize(800, 800);
        setTitle("Escaparate");
        setResizable(false);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
    }

    private void initComponents() {
        setVentana();
        setPaneles();
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
        panelTexto.setLayout(null);
        panelTexto.setBackground(new Color(0xA0FFA0));
        panelTexto.setPreferredSize(new Dimension(this.getWidth() / 2, 0));
        panelPrincipal.add(panelTexto, BorderLayout.EAST);

        /*jsp = new JScrollPane(panelImagenes, ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS,ScrollPaneConstants.HORIZONTAL_SCROLLBAR_ALWAYS);
        panelPrincipal.add(jsp);
        jsp2 = new JScrollPane(panelTexto, ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS,ScrollPaneConstants.HORIZONTAL_SCROLLBAR_ALWAYS);
        panelPrincipal.add(jsp2);*/
    }

    private void setLogo() {
        Toolkit miSistema = Toolkit.getDefaultToolkit();
        Image logo = miSistema.getImage("logo.png");
        this.setIconImage(logo);
    }

    private void setImagenes() {
        JLabel imagen = new JLabel();
        ImageIcon pelota = new ImageIcon(balon.getImagen());

        imagen.setBounds(0, 200, 100, 100);
        imagen.setIcon(new ImageIcon(pelota.getImage()));
        imagen.setIcon(new ImageIcon(pelota.getImage().
                getScaledInstance(imagen.getWidth(), imagen.getHeight(), Image.SCALE_SMOOTH)));


        panelImagenes.add(Box.createRigidArea(new Dimension(30, 70)));
        panelImagenes.add(imagen);

        imagen = new JLabel();
        ImageIcon eq = new ImageIcon(equipacion.getImagen());
        imagen.setBounds(0, 600, 100, 100);
        imagen.setIcon(new ImageIcon(eq.getImage()));
        imagen.setIcon(new ImageIcon(eq.getImage().
                getScaledInstance(imagen.getWidth(), imagen.getHeight(), Image.SCALE_SMOOTH)));

        panelImagenes.add(Box.createRigidArea(new Dimension(30, 140)));
        panelImagenes.add(imagen);

        imagen = new JLabel();
        ImageIcon pe = new ImageIcon(peto.getImagen());
        imagen.setBounds(0, 1200, 100, 100);
        imagen.setIcon(new ImageIcon(pe.getImage()));
        imagen.setIcon(new ImageIcon(pe.getImage().
                getScaledInstance(imagen.getWidth(), imagen.getHeight(), Image.SCALE_SMOOTH)));

        panelImagenes.add(Box.createRigidArea(new Dimension(30, 140)));
        panelImagenes.add(imagen);


    }

    private void calcularTotal() {
        this.precio = 0;
        this.precio += Integer.parseInt(cantidadBalones.getSelectedItem().toString()) * 20;
        this.precio += Integer.parseInt(cantidadCamisetas.getSelectedItem().toString()) * 20;
        this.precio += Integer.parseInt(cantidadPantalones.getSelectedItem().toString()) * 10;
        this.precio += Integer.parseInt(cantidadMedias.getSelectedItem().toString()) * 5;
        this.precio += Integer.parseInt(cantidadPetos.getSelectedItem().toString()) * 8;
    }

    private void setTexto() {
        //------------------- tienda
        etiqueta = new JLabel("Tienda", SwingConstants.CENTER);
        Font font = new Font("Agency FB", Font.BOLD, 50);
        etiqueta.setFont(font);
        etiqueta.setOpaque(true);
        panelTitulo.add(etiqueta);

        //------------------ balones
        JLabel balonEtiqueta = new JLabel(balon.getTipoProducto() + "es");

        balonEtiqueta.setFont(new Font("Tahoma", Font.BOLD, 20));
        balonEtiqueta.setBounds(30, 40, 100, 100);

        panelTexto.add(balonEtiqueta);

        JLabel precioBalon = new JLabel("Precio: 20€");
        precioBalon.setFont(new Font("Tahoma", Font.PLAIN, 18));
        precioBalon.setBounds(30, 90, 150, 100);
        panelTexto.add(precioBalon);

        String cantidad[] = {"0", "1", "2", "3", "4", "5"};
        cantidadBalones = new JComboBox(cantidad);
        cantidadBalones.setBounds(200, 130, 40, 20);
        panelTexto.add(cantidadBalones);

        //------------------ equipaciones

        JLabel eqLbl = new JLabel(equipacion.getTipoProducto() + "es");
        eqLbl.setFont(new Font("Tahoma", Font.BOLD, 20));

        eqLbl.setBounds(30, 230, 150, 100);

        panelTexto.add(eqLbl);

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


        JLabel petoLbl = new JLabel(peto.getTipoProducto() + "s");
        petoLbl.setFont(new Font("Tahoma", Font.BOLD, 20));

        petoLbl.setBounds(30, 480, 150, 100);

        panelTexto.add(petoLbl);

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

        pagar = new JButton("Pagar");
        pagar.setBounds(30, 610, 350, 30);
        pagar.addActionListener(this);
        panelTexto.add(pagar);


    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == cantidadCamisetas) {
            if (Integer.parseInt(cantidadCamisetas.getSelectedItem().toString()) > 0) {
                colorCamiseta.setVisible(true);
            } else {
                colorCamiseta.setVisible(false);
                JOptionPane.showMessageDialog(null,
                        "Camiseta eliminada correctamente de la cesta",
                        "Producto eliminado",
                        JOptionPane.PLAIN_MESSAGE);
            }
        } else if (e.getSource() == cantidadPantalones) {
            if (Integer.parseInt(cantidadPantalones.getSelectedItem().toString()) > 0) {
                colorPantalon.setVisible(true);
            } else {
                colorPantalon.setVisible(false);
                JOptionPane.showMessageDialog(null,
                        "Pantalón correctamente de la cesta",
                        "Producto eliminado",
                        JOptionPane.PLAIN_MESSAGE);
            }
            this.precio = precio + Integer.parseInt(cantidadPantalones.getSelectedItem().toString()) * 10;
        } else if (e.getSource() == cantidadMedias) {
            if (Integer.parseInt(cantidadMedias.getSelectedItem().toString()) > 0) {
                colorMedias.setVisible(true);
            } else {
                colorMedias.setVisible(false);
                JOptionPane.showMessageDialog(null,
                        "Medias eliminadas correctamente de la cesta",
                        "Producto eliminado",
                        JOptionPane.PLAIN_MESSAGE);
            }
        } else if (e.getSource() == cantidadPetos) {
            if (Integer.parseInt(cantidadPetos.getSelectedItem().toString()) > 0) {
                colorPeto.setVisible(true);
            } else {
                colorPeto.setVisible(false);
                JOptionPane.showMessageDialog(null,
                        "Petos eliminados correctamente de la cesta",
                        "Producto eliminado",
                        JOptionPane.PLAIN_MESSAGE);
            }
            this.precio = precio + Integer.parseInt(cantidadMedias.getSelectedItem().toString()) * 8;
        } else if (e.getSource() == pagar) {
            calcularTotal();
            if (this.precio > 0) {
                int respuesta = JOptionPane.showConfirmDialog(null,
                        "Tu cesta suma un total de " + this.precio + "€.\n¿Quieres proceder con el pago?",
                        "Pagar",
                        JOptionPane.YES_NO_OPTION);
                if (respuesta == JOptionPane.YES_OPTION) {
                    JOptionPane.showMessageDialog(null,
                            "Pago realizado correctamente.",
                            "",
                            JOptionPane.PLAIN_MESSAGE);
                }
            } else {
                JOptionPane.showMessageDialog(null,
                        "No has añadido productos a la cesta",
                        "Cesta vacía",
                        JOptionPane.ERROR_MESSAGE);
            }
        }
    }
}
