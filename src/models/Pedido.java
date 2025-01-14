package models;

import java.time.LocalDate;

public class Pedido {

    private static int cantPedidos = 0;
    private int id;
    private String direccionEnvio;
    private String localidadEnvio;
    private String provinciaEnvio;
    private String estado;
    private LocalDate fechaPedido;
    private LocalDate fechaEntregaEstimada;
    private String comentario;
    private float precioTotal;
    private Producto producto1;
    private int cantidadProducto1;
    private Producto producto2;
    private int cantidadProducto2;
    private Producto producto3;
    private int cantidadProducto3;


    //Constructor


    public Pedido(int id, String estado, LocalDate fechaPedido, LocalDate fechaEntregaEstimada, String comentario, float precioTotal) {
        this.id = id;
        this.estado = estado;
        this.fechaPedido = fechaPedido;
        this.fechaEntregaEstimada = fechaEntregaEstimada;
        this.comentario = comentario;
        this.precioTotal = precioTotal;
        this.producto1 = null;
        this.cantidadProducto1 = 0;
        this.producto2 = null;
        this.cantidadProducto2 = 0;
        this.producto3 = null;
        this.cantidadProducto3 = 0;
    }

    public Pedido(Cliente cliente){
        cantPedidos++;
        String idString = "" + cantPedidos + LocalDate.now().getDayOfYear() + LocalDate.now().getMonthValue() + LocalDate.now().getYear();
        this.id = Integer.parseInt(idString);
        this.direccionEnvio = cliente.getDireccion();
        this.localidadEnvio = cliente.getLocalidad();
        this.provinciaEnvio = cliente.getProvincia();
        this.estado = "En Preparación";
        this.fechaPedido = LocalDate.now();
        this.fechaEntregaEstimada = fechaPedido.plusDays(5);
        this.comentario = " ";
        this.precioTotal = 0;
        this.producto1 = null;
        this.producto2 = null;
        this.producto3 = null;
    }

    //Getters y Setters


    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    public LocalDate getFechaPedido() {
        return fechaPedido;
    }

    public void setFechaPedido(LocalDate fechaPedido) {
        this.fechaPedido = fechaPedido;
    }

    public LocalDate getFechaEntregaEstimada() {
        return fechaEntregaEstimada;
    }

    public void setFechaEntregaEstimada(LocalDate fechaEntregaEstimada) {
        this.fechaEntregaEstimada = fechaEntregaEstimada;
    }

    public String getComentario() {
        return comentario;
    }

    public void setComentario(String comentario) {
        this.comentario = comentario;
    }

    public float getPrecioTotal() {
        return precioTotal;
    }

    public void setPrecioTotal(float precioTotal) {
        this.precioTotal = precioTotal;
    }

    public Producto getProducto1() {
        return producto1;
    }

    public void setProducto1(Producto producto1) {
        this.producto1 = producto1;
    }

    public Producto getProducto2() {
        return producto2;
    }

    public void setProducto2(Producto producto2) {
        this.producto2 = producto2;
    }

    public Producto getProducto3() {
        return producto3;
    }

    public void setProducto3(Producto producto3) {
        this.producto3 = producto3;
    }

    public static int getCantPedidos() {
        return cantPedidos;
    }

    public static void setCantPedidos(int cantPedidos) {
        Pedido.cantPedidos = cantPedidos;
    }

    public int getCantidadProducto1() {
        return cantidadProducto1;
    }

    public void setCantidadProducto1(int cantidadProducto1) {
        this.cantidadProducto1 = cantidadProducto1;
    }

    public int getCantidadProducto2() {
        return cantidadProducto2;
    }

    public void setCantidadProducto2(int cantidadProducto2) {
        this.cantidadProducto2 = cantidadProducto2;
    }

    public int getCantidadProducto3() {
        return cantidadProducto3;
    }

    public void setCantidadProducto3(int cantidadProducto3) {
        this.cantidadProducto3 = cantidadProducto3;
    }

    public String getDireccionEnvio() {
        return direccionEnvio;
    }

    public void setDireccionEnvio(String direccionEnvio) {
        this.direccionEnvio = direccionEnvio;
    }

    public String getLocalidadEnvio() {
        return localidadEnvio;
    }

    public void setLocalidadEnvio(String localidadEnvio) {
        this.localidadEnvio = localidadEnvio;
    }

    public String getProvinciaEnvio() {
        return provinciaEnvio;
    }

    public void setProvinciaEnvio(String provinciaEnvio) {
        this.provinciaEnvio = provinciaEnvio;
    }

    //Otros Metodos


    @Override
    public String toString() {
        return "Pedido{" +
                "id=" + id +
                ", estado='" + estado + '\'' +
                ", fechaPedido=" + fechaPedido +
                ", fechaEntregaEstimada=" + fechaEntregaEstimada +
                ", comentario='" + comentario + '\'' +
                ", precioTotal=" + precioTotal +
                ", producto1=" + producto1 +
                ", producto2=" + producto2 +
                ", producto3=" + producto3 +
                '}';
    }

    public boolean incluirProducto(int opc, Producto producto, int cantidad) {
        if (producto1 == null || producto1.getId() == opc){
            producto1 = producto;
            cantidadProducto1 += cantidad;
            precioTotal += producto.getPvp() * cantidad;
            return true;
        }
        if (producto2 == null || producto2.getId() == opc){
            producto2 = producto;
            cantidadProducto2 += cantidad;
            precioTotal += producto.getPvp() * cantidad;
            return true;
        }
        if (producto3 == null || producto3.getId() == opc){
            producto3 = producto;
            cantidadProducto3 += cantidad;
            precioTotal += producto.getPvp() * cantidad;
            return true;
        }
        return false;
    }

    public String pintaPedido() {
        String salida = "";
        salida += "====== Productos ======\n";
        if (producto1 != null) salida += "\t- "+ producto1.getNombre() + " ("+ producto1.getPvp()+") x" + cantidadProducto1 + "\n";
        if (producto2 != null) salida += "\t- "+ producto2.getNombre() + " ("+ producto2.getPvp()+") x" + cantidadProducto2 + "\n";
        if (producto3 != null) salida += "\t- "+ producto3.getNombre() + " ("+ producto3.getPvp()+") x" + cantidadProducto3 + "\n";
        return salida;
    }

    public boolean hayHueco() {
        if(producto1 == null) return true;
        if(producto2 == null) return true;
        if(producto3 == null) return true;
        return false;
    }

    public boolean comprobarContenidoPedido(int opc) {
        if (producto1.getId() == opc) return true;
        if (producto2.getId() == opc) return true;
        if (producto3.getId() == opc) return true;
        return false;
    }

    public String pintaPedidoMenu() {
        String salida = "";
        salida = "ID pedido: " + id;
        return salida;
    }
}
