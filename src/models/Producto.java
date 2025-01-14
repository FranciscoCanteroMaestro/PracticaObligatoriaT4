package models;

public class Producto {

    private int id = 0;
    private String nombre;
    private float pvp;
    private int stock;

    // Constructor

    public Producto(int id, String nombre, float pvp, int stock) {
        this.id = id;
        this.nombre = nombre;
        this.pvp = pvp;
        this.stock = stock;
    }

    public Producto(Producto producto){
        this.id = producto.id;
        this.nombre = producto.nombre;
        this.pvp = producto.pvp;
        this.stock = producto.stock;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public float getPvp() {
        return pvp;
    }

    public void setPvp(float pvp) {
        this.pvp = pvp;
    }

    public int getStock() {
        return stock;
    }

    public void setStock(int stock) {
        this.stock = stock;
    }

    //Otros Metodos

    public void sacarStock(int cantidad){
        this.stock -= cantidad;
    }

    @Override
    public String toString() {
        return "Producto{" +
                "id=" + id +
                ", nombre='" + nombre + '\'' +
                ", pvp=" + pvp +
                ", stock=" + stock +
                '}';
    }

    public String pintaProductoCatalogo(){
        return "numRef: "+ id + " - " + nombre + " - (" + pvp + "€)\n";
    }

    public String pintaProducto(){
        return "numRef: "+ id + " - " + nombre + " - (" + pvp + "€) - Stock disponible: "+stock+" \n";
    }

    //public String pintaProductoComprado (){}
}
