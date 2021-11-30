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
        //linea
        g2d.setColor(Color.BLUE);
        g2d.setStroke(new BasicStroke(5));
        g2d.drawLine(30,70,770,70);

        //rectangulo
        g2d.setColor(Color.BLUE);
        g2d.fillRect(30,100,350,60);
        g2d.setColor(Color.BLACK);
        g2d.drawRect(30,100,350,60);

        //rectangulo redondeado
        g2d.setColor(Color.CYAN);
        g2d.drawRoundRect(420,100,350,60,50,50);

        //arco
        g2d.setColor(Color.PINK);
        g2d.drawArc(30,200,100,100,180,-90);

        //ovalo con relleno y borde
        g2d.setStroke(new BasicStroke(2));
        g2d.setColor(Color.YELLOW);
        g2d.fillOval(240,200,150,100);
        g2d.setColor(Color.BLACK);
        g2d.drawOval(240,200,150,100);

        //triangulo
        //int[] triangulo_x = {450,510,570};
        //int[] triangulo_y = {300,200,300};
        int[][] triangulo = {{450, 510, 570},
                             {300, 200, 300}};

        g2d.setStroke(new BasicStroke(7));
        g2d.setColor(Color.ORANGE);
        g2d.drawPolygon(triangulo[0],triangulo[1],3);




    }



    public static void main(String[] args) {

        Graphics g2 = new Graphics();
        g2.setVisible(true);


    }
}
