package graphics2D;

import java.awt.*;
import javax.swing.*;


public class Graphics extends JFrame{

    JPanel panel;

    public Graphics(){

        this.setTitle("Graphics");
        this.setSize(800, 700);

        setResizable(false);
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);
        panel = new JPanel();
        this.add(panel);


    }
    /*
     * La Clase Graphics nos permite realizar operaciones tipo grafico
     * esta clase no se puede instanciar directamente, no que tenemos
     * que instanciar directamente, tenemos que usar un componente  y pasarlo
     * al programa con un metodo mediante el metodo paint()
     * el unico argumente del metodo paint() es un opjeto de esta clase
     */

    public void paint(java.awt.Graphics g){
        super.paint(g);
        Graphics2D g2d = (Graphics2D) g;
        g2d.setColor(Color.BLUE);
        g2d.setStroke(new BasicStroke(5));
        g2d.drawLine(30,70,770,70);

    }



    public static void main(String[] args) {

        Graphics g2 = new Graphics();
        g2.setVisible(true);


    }
}
