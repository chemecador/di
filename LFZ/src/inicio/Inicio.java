package inicio;

import tienda.Escaparate;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;

public class Inicio extends JFrame implements ActionListener {

    /**
     * todo: scrollpane en tienda
     */

    JPanel panelPrincipal;
    JTextField userTxt, emailRegTxt;
    JPasswordField passTxt, passRegTxt;
    JLabel isLbl, regLbl, userLbl, passLbl, emailRegLbl, passRegLbl;
    JButton is, passOlv, reg;
    Usuarios users = new Usuarios();

    public Inicio() {
        initComponents();
        setVisible(true);
    }

    private void setVentana() {
        setSize(800, 800);
        setTitle("LFZ");
        setResizable(false);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
    }

    private void initComponents() {
        Dimension dimension = Toolkit.getDefaultToolkit().getScreenSize();
        JLabel emptyLabel = new JLabel("");
        emptyLabel.setPreferredSize(new Dimension( (int)dimension.getWidth() / 2, (int)dimension.getHeight()/2 ));
        getContentPane().add(emptyLabel, BorderLayout.CENTER);
        setLocation((int)dimension.getWidth()/4, (int)dimension.getHeight()/4);
        setVentana();
        setPaneles();
        setEtiquetas();
        setLogo();
        setImagenes();
        setTexto();
        setBotones();
    }


    private void setPaneles() {
        panelPrincipal = new JPanel();
        panelPrincipal.setLayout(null);
        panelPrincipal.setBackground(new Color(0xA0FFA0));
        add(panelPrincipal);


    }

    private void setBotones() {
        is = new JButton("Iniciar Sesión");
        //is.setPreferredSize(new Dimension(40, 40));
        is.setBounds(450, 250, 150, 30);

        passOlv = new JButton("He olvidado mi contraseña");
        passOlv.setBounds(100, 300, 500, 25);

        reg = new JButton("Registrarse");
        //is.setPreferredSize(new Dimension(40, 40));
        reg.setBounds(450, 620, 150, 30);


        passOlv.addActionListener(this);
        is.addActionListener(this);
        reg.addActionListener(this);


        panelPrincipal.add(is);
        panelPrincipal.add(passOlv);
        panelPrincipal.add(reg);
    }

    private void setEtiquetas() {

        isLbl = new JLabel("Iniciar sesión", SwingConstants.CENTER);
        isLbl.setFont(new Font("Tahoma", Font.BOLD, 40));
        isLbl.setBounds(80, 20, 600, 100);

        regLbl = new JLabel("Registrarse", SwingConstants.CENTER);
        regLbl.setFont(new Font("Tahoma", Font.BOLD, 40));
        regLbl.setBounds(80, 400, 600, 100);


        userLbl = new JLabel("Usuario: ", SwingConstants.RIGHT);
        passLbl = new JLabel("Contraseña: ", SwingConstants.RIGHT);

        userTxt = new JTextField();
        passTxt = new JPasswordField();

        userTxt.setBounds(400, 120, 200, 30);
        passTxt.setBounds(400, 170, 200, 30);


        userLbl.setBounds(100, 120, 200, 30);
        userLbl.setFont(new Font("Agency FB", Font.PLAIN, 30));

        passLbl.setBounds(100, 170, 200, 30);
        passLbl.setFont(new Font("Agency FB", Font.PLAIN, 30));

        emailRegLbl = new JLabel("Email:", SwingConstants.RIGHT);
        emailRegLbl.setFont(new Font("Agency FB", Font.PLAIN, 30));
        emailRegLbl.setBounds(100, 500, 200, 30);

        passRegLbl = new JLabel("Contraseña:", SwingConstants.RIGHT);
        passRegLbl.setFont(new Font("Agency FB", Font.PLAIN, 30));
        passRegLbl.setBounds(100, 550, 200, 30);


        emailRegTxt = new JTextField();
        emailRegTxt.setBounds(400, 500, 200, 30);

        passRegTxt = new JPasswordField();
        passRegTxt.setBounds(400, 550, 200, 30);

        panelPrincipal.add(userLbl);
        panelPrincipal.add(passLbl);
        panelPrincipal.add(userTxt);
        panelPrincipal.add(passTxt);
        panelPrincipal.add(isLbl);
        panelPrincipal.add(regLbl);
        panelPrincipal.add(emailRegTxt);
        panelPrincipal.add(passRegTxt);
        panelPrincipal.add(emailRegLbl);
        panelPrincipal.add(passRegLbl);

    }

    private void setLogo() {
        Toolkit miSistema = Toolkit.getDefaultToolkit();
        Image logo = miSistema.getImage("logo.png");
        this.setIconImage(logo);
    }

    private void setImagenes() {

        JLabel imagen = new JLabel();
        ImageIcon pelota = new ImageIcon("logo.png");

        imagen.setBounds(50, 50, 70, 70);
        imagen.setIcon(new ImageIcon(pelota.getImage()));
        imagen.setIcon(new ImageIcon(pelota.getImage().
                getScaledInstance(imagen.getWidth(), imagen.getHeight(), Image.SCALE_SMOOTH)));
        panelPrincipal.add(imagen);
    }

    private void setTexto() {

    }

    public static void main(String[] args) {
        new Inicio();
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == passOlv) {
            new PassOlvidada();
        } else if (e.getSource() == is) {
            if (users.iniciarSesion(userTxt.getText(), new String(passTxt.getPassword()))) {
                new Escaparate(userTxt.getText());
            }
        } else if (e.getSource() == reg && emailRegTxt.getText().contains("@") && emailRegTxt.getText().contains(".")) {
            if (new String(passRegTxt.getPassword()).length() > 0) {

                users.registro(emailRegTxt.getText(), new String(passRegTxt.getPassword()));
                JOptionPane.showMessageDialog(null,
                        "Registro realizado correctamente",
                        "Usuario registrado",
                        JOptionPane.PLAIN_MESSAGE);
            } else {
                JOptionPane.showMessageDialog(null,
                        "La contraseña está vacía",
                        "Error",
                        JOptionPane.ERROR_MESSAGE);
            }
        } else if (e.getSource() == reg) {
            JOptionPane.showMessageDialog(null,
                    "La dirección de correo electrónico no es correcta",
                    "Error",
                    JOptionPane.ERROR_MESSAGE);
        }
    }
}