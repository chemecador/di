package tienda;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;

public class Escaparate extends JFrame implements ActionListener {

    int precio;
    String usuario;
    String aPagar;
    String cantidad[] = {"0", "1", "2", "3", "4", "5"};
    String colores[] = {"blanco", "negro", "azul", "verde", "amarillo", "rojo"};


    JPanel panelPrincipal;
    JPanel panelImagenes;
    JPanel panelTitulo;
    JPanel panelTexto;

    Producto balon;
    Producto equipacion;
    Producto peto;
    Producto cono;

    JComboBox cantidadBalones;
    JComboBox cantidadCamisetas;
    JComboBox cantidadPantalones;
    JComboBox cantidadMedias;

    JComboBox colorCamiseta;
    JComboBox colorPantalon;
    JComboBox colorMedias;

    JComboBox cantidadPetos;
    JComboBox colorPeto;

    JComboBox cantidadConos;

    JButton pagar;
    JScrollPane jsp;

    JTextArea totalTA;
    JMenuBar menuBar;
    JMenu opciones;
    JMenuItem cerrarSesion;
    JMenuItem salir;


    public Escaparate() {
        initComponents();
    }
    public Escaparate (String usuario){
        this.usuario=usuario;
        JOptionPane.showMessageDialog(null,
                "Bienvenido, "+usuario,
                "Bienvenido",
                JOptionPane.PLAIN_MESSAGE);
        initComponents();
    }

    private void setVentana() {
        setSize(800, 800);
        setTitle("Escaparate");
        setResizable(false);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
    }

    private void initComponents() {
        precio = 0;
        aPagar = "";
        cono = new Producto("Cono", "cono.jpg");
        balon = new Producto("Balon", "pelota.jpg");
        equipacion = new Producto("Equipacion", "equipacion.jpg");
        peto = new Producto("Peto", "peto.jpg");

        Dimension dimension = Toolkit.getDefaultToolkit().getScreenSize();
        JLabel emptyLabel = new JLabel("");
        emptyLabel.setPreferredSize(new Dimension( (int)dimension.getWidth() / 2, (int)dimension.getHeight()/2 ));
        getContentPane().add(emptyLabel, BorderLayout.CENTER);
        setLocation((int)dimension.getWidth()/4, (int)dimension.getHeight()/4);
        setVentana();
        setPaneles();
        setLogo();
        setImagenes();
        setTexto();
        setMenu();
        setVisible(true);
    }

    private void setMenu() {
        menuBar = new JMenuBar();
        opciones = new JMenu("Opciones");
        cerrarSesion = new JMenuItem("Cerrar sesión (" +this.usuario+")");
        salir = new JMenuItem("Salir");

        cerrarSesion.addActionListener(this);
        salir.addActionListener(this);
        opciones.add(cerrarSesion);
        opciones.add(salir);
        menuBar.add(opciones);
        setJMenuBar(menuBar);
        setVisible(true);
    }

    private void setPaneles() {
        panelPrincipal = new JPanel();
        panelPrincipal.setLayout(new BorderLayout());
        panelPrincipal.setBackground(Color.BLACK);
        panelPrincipal.setPreferredSize(new Dimension(800, 1200));
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

        jsp = new JScrollPane(panelPrincipal, ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS, ScrollPaneConstants.HORIZONTAL_SCROLLBAR_ALWAYS);
        add(jsp);
    }

    private void setLogo() {
        Toolkit miSistema = Toolkit.getDefaultToolkit();
        Image logo = miSistema.getImage("logo.png");
        this.setIconImage(logo);
    }

    private void setImagenes() {
        JLabel imagen = new JLabel();
        ImageIcon pelota = new ImageIcon(balon.getImagen());
        imagen.setSize(100, 100);
        imagen.setIcon(new ImageIcon(pelota.getImage()));
        imagen.setIcon(new ImageIcon(pelota.getImage().
                getScaledInstance(imagen.getWidth(), imagen.getHeight(), Image.SCALE_SMOOTH)));


        panelImagenes.add(Box.createRigidArea(new Dimension(120, 70)));
        panelImagenes.add(imagen);

        imagen = new JLabel();
        ImageIcon eq = new ImageIcon(equipacion.getImagen());
        imagen.setSize(100, 100);
        imagen.setIcon(new ImageIcon(eq.getImage()));
        imagen.setIcon(new ImageIcon(eq.getImage().
                getScaledInstance(imagen.getWidth(), imagen.getHeight(), Image.SCALE_SMOOTH)));

        panelImagenes.add(Box.createRigidArea(new Dimension(0, 130)));
        panelImagenes.add(imagen);

        imagen = new JLabel();
        ImageIcon pe = new ImageIcon(peto.getImagen());
        imagen.setSize(100, 100);
        imagen.setIcon(new ImageIcon(pe.getImage()));
        imagen.setIcon(new ImageIcon(pe.getImage().
                getScaledInstance(imagen.getWidth(), imagen.getHeight(), Image.SCALE_SMOOTH)));

        panelImagenes.add(Box.createRigidArea(new Dimension(0, 130)));
        panelImagenes.add(imagen);

        imagen = new JLabel();
        ImageIcon co = new ImageIcon(cono.getImagen());
        imagen.setSize(100, 100);
        imagen.setIcon(new ImageIcon(co.getImage()));
        imagen.setIcon(new ImageIcon(co.getImage().
                getScaledInstance(imagen.getWidth(), imagen.getHeight(), Image.SCALE_SMOOTH)));

        panelImagenes.add(Box.createRigidArea(new Dimension(0, 130)));
        panelImagenes.add(imagen);
    }


    private void calcularTotal() {
        this.precio = 0;
        this.precio += Integer.parseInt(cantidadBalones.getSelectedItem().toString()) * 20;
        this.precio += Integer.parseInt(cantidadCamisetas.getSelectedItem().toString()) * 20;
        this.precio += Integer.parseInt(cantidadPantalones.getSelectedItem().toString()) * 10;
        this.precio += Integer.parseInt(cantidadMedias.getSelectedItem().toString()) * 5;
        this.precio += Integer.parseInt(cantidadPetos.getSelectedItem().toString()) * 8;
        this.precio += Integer.parseInt(cantidadConos.getSelectedItem().toString()) * 4;
    }

    private void setTexto() {
        //------------------- tienda
        JLabel tienda = new JLabel("Tienda", SwingConstants.CENTER);
        Font font = new Font("Agency FB", Font.BOLD, 50);
        tienda.setFont(font);
        tienda.setOpaque(true);
        panelTitulo.add(tienda);

        setBalones();

        setEquipaciones();

        setPetos();

        setConos();

        totalTA = new JTextArea();
        totalTA.setFont(new Font("Tahoma", Font.PLAIN, 15));
        totalTA.setOpaque(false);
        totalTA.setBounds(30, 900, 300, 200);
        totalTA.setFocusable(false);
        panelTexto.add(totalTA);


        pagar = new JButton("Pagar");
        pagar.setBounds(30, 1100, 330, 30);
        pagar.addActionListener(this);
        panelTexto.add(pagar);


    }

    private void setConos() {
        JLabel conoLbl = new JLabel(cono.getTipoProducto() + "s");
        conoLbl.setFont(new Font("Tahoma", Font.BOLD, 20));
        conoLbl.setBounds(30, 720, 150, 100);
        panelTexto.add(conoLbl);

        JLabel precioCono = new JLabel("Precio: 4€");
        precioCono.setFont(new Font("Tahoma", Font.PLAIN, 18));
        precioCono.setBounds(30, 770, 150, 100);
        panelTexto.add(precioCono);

        cantidadConos = new JComboBox(cantidad);
        cantidadConos.setBounds(200, 810, 40, 20);
        cantidadConos.addActionListener(this);
        panelTexto.add(cantidadConos);

    }

    private void setPetos() {
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
        colorPeto.addActionListener(this);
        colorPeto.setVisible(false);
        colorPeto.setBounds(250, 570, 100, 20);
        panelTexto.add(colorPeto);

    }

    private void setEquipaciones() {
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

        colorCamiseta = new JComboBox(colores);
        colorPantalon = new JComboBox(colores);
        colorMedias = new JComboBox(colores);

        colorCamiseta.addActionListener(this);
        colorPantalon.addActionListener(this);
        colorMedias.addActionListener(this);
        colorCamiseta.setVisible(false);
        colorPantalon.setVisible(false);
        colorMedias.setVisible(false);


        colorCamiseta.setBounds(250, 320, 100, 20);
        colorPantalon.setBounds(250, 350, 100, 20);
        colorMedias.setBounds(250, 380, 100, 20);
        panelTexto.add(colorCamiseta);
        panelTexto.add(colorPantalon);
        panelTexto.add(colorMedias);
    }

    private void setBalones() {
        JLabel balonEtiqueta = new JLabel(balon.getTipoProducto() + "es");

        balonEtiqueta.setFont(new Font("Tahoma", Font.BOLD, 20));
        balonEtiqueta.setBounds(30, 40, 100, 100);

        panelTexto.add(balonEtiqueta);

        JLabel precioBalon = new JLabel("Precio: 20€");
        precioBalon.setFont(new Font("Tahoma", Font.PLAIN, 18));
        precioBalon.setBounds(30, 90, 150, 100);
        panelTexto.add(precioBalon);

        cantidadBalones = new JComboBox(cantidad);
        cantidadBalones.addActionListener(this);
        cantidadBalones.setBounds(200, 130, 40, 20);
        panelTexto.add(cantidadBalones);
    }

    private void actualizarTotal() {

        aPagar = " TOTAL A PAGAR: ";
        if (Integer.parseInt(cantidadBalones.getSelectedItem().toString()) > 0) {
            aPagar += "\n- " + cantidadBalones.getSelectedItem().toString() + " balones";
        }
        if (Integer.parseInt(cantidadCamisetas.getSelectedItem().toString()) > 0) {
            aPagar += "\n- " + cantidadCamisetas.getSelectedItem().toString() + " camisetas de color " + colorCamiseta.getSelectedItem().toString();
        }
        if (Integer.parseInt(cantidadPantalones.getSelectedItem().toString()) > 0) {
            aPagar += "\n- " + cantidadPantalones.getSelectedItem().toString() + " pantalones de color " + colorPantalon.getSelectedItem().toString();
        }
        if (Integer.parseInt(cantidadMedias.getSelectedItem().toString()) > 0) {
            aPagar += "\n- " + cantidadMedias.getSelectedItem().toString() + " medias de color " + colorMedias.getSelectedItem().toString();
        }
        if (Integer.parseInt(cantidadPetos.getSelectedItem().toString()) > 0) {
            aPagar += "\n- " + cantidadPetos.getSelectedItem().toString() + " petos de color " + colorPeto.getSelectedItem().toString();
        }
        if (Integer.parseInt(cantidadConos.getSelectedItem().toString()) > 0) {
            aPagar += "\n- " + cantidadConos.getSelectedItem().toString() + " conos";
        }
        calcularTotal();
        aPagar += "\n\n  " + precio + "€";
        totalTA.setText(aPagar);
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
        } else if (e.getSource() == colorCamiseta) {

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
        }  else if (e.getSource() == pagar) {
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
        } else if (e.getSource() == cerrarSesion) {
            int respuesta = JOptionPane.showConfirmDialog(null,
                    "¿Desea cerrar sesión?",
                    "Cerrar sesión",
                    JOptionPane.YES_NO_OPTION);
            if (respuesta == JOptionPane.YES_OPTION) {
                dispose();
            }
        } else if (e.getSource() == salir) {
            int respuesta = JOptionPane.showConfirmDialog(null,
                    "¿Desea salir de la aplicación?",
                    "Salir",
                    JOptionPane.YES_NO_OPTION);
            if (respuesta == JOptionPane.YES_OPTION) {
                System.exit(0);
            }
        }
        actualizarTotal();
    }
}
