
import java.awt.Container;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;

public class JOption extends JFrame {
    //componentes para JOption
    JTextField jtfn, jtfa,jtfe;
    JButton jbtaceptar,jbtsalir;
    JLabel lbn, lba,lbe;
    String texto;
    JPanel blbotones = new JPanel();



    public JOption() {
        this.setTitle("Opciones");
        this.setSize(640, 480);
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);
        this.setLayout(new GridLayout(4,2));
        blbotones.setLayout(new BoxLayout(blbotones, BoxLayout.Y_AXIS));
        initC();

    }

    private void initC() {
        insertarCampos();

    }
    private void insertarCampos() {
        //colocar los componenetes en la ventana
        lbn = new JLabel("Nombre");
        jtfn = new JTextField();
        lba = new JLabel("Apellido");
        jtfa = new JTextField();
        lbe = new JLabel("Edad:");
        jtfe = new JTextField();
        jbtaceptar = new JButton("Aceptar");
        jbtsalir = new JButton("Salir");
        this.add(lbn);
        this.add(jtfn);
        this.add(lba);
        this.add(jtfa);
        this.add(lbe);
        this.add(jtfe);
        blbotones.add(jbtaceptar);
        blbotones.add(jbtsalir);

        this.add(blbotones);

        jbtaceptar.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                // TODO Auto-generated method stub
                /*JOptionPane.showMessageDialog(null,
                        "error desconocido",
                        "Error",JOptionPane.ERROR_MESSAGE);
                JOptionPane.showMessageDialog(null,
                        "error fatal",
                        "Información",JOptionPane.INFORMATION_MESSAGE);
                JOptionPane.showMessageDialog(null,
                        "aviso",
                        "aviso",JOptionPane.WARNING_MESSAGE);
                JOptionPane.showMessageDialog(null,
                        "tienes un mensaje",
                        "mensaje",JOptionPane.PLAIN_MESSAGE);*/
                int seleccion = JOptionPane.showConfirmDialog(null,
                        "¿Datos correctos?",
                        "Aviso",
                        JOptionPane.WARNING_MESSAGE);

            }
        });
    }


    public static void main(String[] args) {
        // TODO Auto-generated method stub
        JOption tf = new JOption();
        tf.setVisible(true);

    }

}
