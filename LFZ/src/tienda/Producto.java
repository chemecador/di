package tienda;

import javax.swing.*;
import java.awt.*;

public class Producto {
    private Image imagen;
    private JLabel tipoProducto;

    public Producto(Image imagen, JLabel tipoProducto) {
        this.imagen = imagen;
        this.tipoProducto = tipoProducto;
    }

    public Producto() {
    }

    public Image getImagen() {
        return imagen;
    }

    public void setImagen(Image imagen) {
        this.imagen = imagen;
    }

    public JLabel getTipoProducto() {
        return tipoProducto;
    }

    public void setTipoProducto(JLabel tipoProducto) {
        this.tipoProducto = tipoProducto;
    }
}
