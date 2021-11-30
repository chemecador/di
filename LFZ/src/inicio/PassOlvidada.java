package inicio;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class PassOlvidada extends JFrame implements ActionListener {


    JPanel panelPrincipal;
    JTextField correoTxt;
    JLabel correoLbl;
    JButton passOlv;

    public PassOlvidada() {
        initComponents();

    }

    private void setVentana() {
        setSize(800, 800);
        setTitle("LFZ");
        this.setResizable(false);
        this.setDefaultCloseOperation(DISPOSE_ON_CLOSE);
    }

    private void initComponents() {
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


        passOlv = new JButton("Recuperar Contraseña");
        passOlv.setBounds(100, 300, 500, 40);
        passOlv.addActionListener(this);
        panelPrincipal.add(passOlv);
    }

    private void setEtiquetas() {
        correoLbl = new JLabel("Introduce tu email:", SwingConstants.RIGHT);

        correoTxt = new JTextField();

        correoTxt.setBounds(400, 120, 200, 30);


        correoLbl.setBounds(100, 120, 200, 30);
        correoLbl.setFont(new Font("Agency FB", Font.PLAIN, 30));



        panelPrincipal.add(correoLbl);

        panelPrincipal.add(correoTxt);
    }

    private void setLogo() {

    }

    private void setImagenes() {

    }

    private void setTexto() {

    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == passOlv && correoTxt.getText().contains("@") && correoTxt.getText().contains(".")){
            JOptionPane.showMessageDialog(null,
                    "Te hemos enviado tu contraseña por correo electrónico",
                    "Correo enviado",
                    JOptionPane.PLAIN_MESSAGE);
            dispose();

        }
        else if (e.getSource() == passOlv){
            JOptionPane.showMessageDialog(null,
                    "La dirección de correo electrónico no es correcta",
                    "Error",
                    JOptionPane.ERROR_MESSAGE);
        }
    }
}