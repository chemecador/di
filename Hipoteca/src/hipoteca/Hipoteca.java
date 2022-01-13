package hipoteca;

import javax.swing.*;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;
import java.awt.*;

class Slider implements ChangeListener {
    //se crean tres instancias, deben ser estáticas para poder ser accesibles desde fuera de la clase
    static JSlider capitalSl, interesSl, plazoSl;
    static JLabel tituloLbl, capitalLbl, interesLbl, plazoLbl, mesLbl, intTotal;
    static JTextField capitalTf, interesTf, plazoTf, mensualidad;

    //constructor
    public Slider() {
        JFrame ventana = new JFrame("Hipoteca");
        ventana.setSize(600, 600); //se establece el tamaño
        JPanel pGlobal = new JPanel();
        JPanel pTitulo = new JPanel();
        JPanel pCapital = new JPanel();
        JPanel pCapitalIzq = new JPanel();
        JPanel pCapitalDer = new JPanel();
        JPanel pInteres = new JPanel();
        JPanel pInteresIzq = new JPanel();
        JPanel pInteresDer = new JPanel();
        JPanel pPlazo = new JPanel();
        JPanel pPlazoIzq = new JPanel();
        JPanel pPlazoDer = new JPanel();
        JPanel pMes = new JPanel();
        JPanel pMesIzq = new JPanel();
        JPanel pMesDer = new JPanel();
        JPanel pIntTotal = new JPanel();


        pGlobal.setLayout(new FlowLayout());
        pTitulo.setLayout(new FlowLayout());

        pCapital.setLayout(new GridLayout());
        pCapitalIzq.setLayout(new FlowLayout());
        pCapitalDer.setLayout(new FlowLayout());

        pInteres.setLayout(new GridLayout());
        pInteresIzq.setLayout(new FlowLayout());
        pInteresDer.setLayout(new FlowLayout());

        pPlazo.setLayout(new GridLayout());
        pPlazo.setLayout(new FlowLayout());
        pPlazo.setLayout(new FlowLayout());

        pMes.setLayout(new GridLayout());
        pMes.setLayout(new FlowLayout());
        pMes.setLayout(new FlowLayout());

        pIntTotal.setLayout(new FlowLayout());


        tituloLbl = new JLabel("Cálculo de hipoteca de Alejandro");
        mesLbl = new JLabel("Mensualidad");
        mensualidad = new JTextField();
        mensualidad.setEditable(false);

        capitalTf = new JTextField();
        capitalTf.setPreferredSize(new Dimension(100, 30));
        capitalLbl = new JLabel("Capital");

        capitalSl = new JSlider(JSlider.HORIZONTAL, 50000, 1000000, 200000);
        capitalSl.setPreferredSize(new Dimension(300, 40));
        capitalSl.setPaintTicks(true); //se pintan los ticks intermedios
        capitalSl.setMajorTickSpacing(250000);
        capitalSl.setPaintLabels(true); //pintar las etiquetas
        capitalSl.addChangeListener(this); //añade el listener que escuche cada vez que se realiza un cambio en el slider


        interesTf = new JTextField();
        interesTf.setPreferredSize(new Dimension(100, 30));
        interesLbl = new JLabel("Interés %");

        interesSl = new JSlider(JSlider.HORIZONTAL, 0, 50, 3);
        interesSl.setPreferredSize(new Dimension(300, 40));
        interesSl.setPaintTicks(true); //se pintan los ticks intermedios
        interesSl.setMajorTickSpacing(5);
        interesSl.setPaintLabels(true); //pintar las etiquetas
        interesSl.addChangeListener(this); //añade el listener que escuche cada vez que se realiza un cambio en el slider


        plazoTf = new JTextField();
        plazoTf.setPreferredSize(new Dimension(100, 30));
        plazoLbl = new JLabel("Plazo");

        plazoSl = new JSlider(JSlider.HORIZONTAL, 1, 50, 30);
        plazoSl.setPreferredSize(new Dimension(300, 40));
        plazoSl.setPaintTicks(true); //se pintan los ticks intermedios
        plazoSl.setMajorTickSpacing(5);
        plazoSl.setPaintLabels(true); //pintar las etiquetas
        plazoSl.addChangeListener(this); //añade el listener que escuche cada vez que se realiza un cambio en el slider

        intTotal = new JLabel("Intereses totales pagados al banco");

        pTitulo.add(tituloLbl);
        pCapitalIzq.add(capitalLbl);
        pCapitalIzq.add(capitalTf);
        pCapitalDer.add(capitalSl);
        pCapital.add(pCapitalIzq, BorderLayout.WEST);
        pCapital.add(pCapitalDer, BorderLayout.EAST);

        pInteresIzq.add(interesLbl);
        pInteresIzq.add(interesTf);
        pInteresDer.add(interesSl);
        pInteres.add(pInteresIzq, BorderLayout.WEST);
        pInteres.add(pInteresDer, BorderLayout.EAST);

        pPlazoIzq.add(plazoLbl);
        pPlazoIzq.add(plazoTf);
        pPlazoDer.add(plazoSl);
        pPlazo.add(pPlazoIzq, BorderLayout.WEST);
        pPlazo.add(pPlazoDer, BorderLayout.EAST);

        pMesIzq.add(mesLbl);
        pMesIzq.add(mensualidad);
        pMes.add(pMesIzq, BorderLayout.WEST);
        pMes.add(pMesDer, BorderLayout.EAST);

        pIntTotal.add(intTotal);


        pGlobal.add(pTitulo);
        pGlobal.add(pCapital);
        pGlobal.add(pInteres);
        pGlobal.add(pPlazo);
        pGlobal.add(pMes);
        pGlobal.add(pIntTotal);

        ventana.add(pGlobal);
        ventana.setLocationRelativeTo(null);
        ventana.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        ventana.setVisible(true);
    }

    @Override
    public void stateChanged(ChangeEvent e) {
    }

}

public class Hipoteca {
    public static void main(String[] args) {
        new Slider();
    }
}
