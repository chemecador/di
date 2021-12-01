package tienda;

public class Producto {
    private String imagen;
    private String tipoProducto;

    public Producto(String tipoProducto, String imagen) {
        this.imagen = imagen;
        this.tipoProducto = tipoProducto;
    }

    public Producto() {
    }

    public String getImagen() {
        return imagen;
    }

    public void setImagen(String imagen) {
        this.imagen = imagen;
    }

    public String getTipoProducto() {
        return tipoProducto;
    }

    public void setTipoProducto(String tipoProducto) {
        this.tipoProducto = tipoProducto;
    }
}
