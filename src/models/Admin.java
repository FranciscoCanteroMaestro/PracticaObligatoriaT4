package models;

public class Admin {
    //Atributos
    private String user;
    private String clave;
    private String tipo;
    private Pedido pedido1;
    private Pedido pedido2;
    private Pedido pedido3;
    private Pedido pedido4;
    private Pedido pedido5;
    private Pedido pedido6;
    private Trabajador trabajador1;
    private Trabajador trabajador2;
    private Trabajador trabajador3;

    //Constructor


    public Admin(String user, String clave) {
        this.user = user;
        this.clave = clave;
        this.tipo = "Admin";
    }

    //Getters y Setters


    public String getUser() {
        return user;
    }

    public void setUser(String user) {
        this.user = user;
    }

    public String getClave() {
        return clave;
    }

    public void setClave(String clave) {
        this.clave = clave;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public Pedido getPedido1() {
        return pedido1;
    }

    public void setPedido1(Pedido pedido1) {
        this.pedido1 = pedido1;
    }

    public Pedido getPedido2() {
        return pedido2;
    }

    public void setPedido2(Pedido pedido2) {
        this.pedido2 = pedido2;
    }

    public Pedido getPedido3() {
        return pedido3;
    }

    public void setPedido3(Pedido pedido3) {
        this.pedido3 = pedido3;
    }

    public Pedido getPedido4() {
        return pedido4;
    }

    public void setPedido4(Pedido pedido4) {
        this.pedido4 = pedido4;
    }

    public Pedido getPedido5() {
        return pedido5;
    }

    public void setPedido5(Pedido pedido5) {
        this.pedido5 = pedido5;
    }

    public Pedido getPedido6() {
        return pedido6;
    }

    public void setPedido6(Pedido pedido6) {
        this.pedido6 = pedido6;
    }

    // Otros Metodos
    // Asignar el pedido al admin
    public void asignarPedidoAdmin(Pedido pedidoNuevo) {
    if (pedido1 == null ) pedido1 = pedidoNuevo;
    else if (pedido2 == null) pedido2 = pedidoNuevo;
        else if (pedido3 == null) pedido3 = pedidoNuevo;
            else if (pedido4 == null) pedido4 = pedidoNuevo;
                else if (pedido5 == null) pedido5 = pedidoNuevo;
                    else if (pedido6 == null) pedido6 = pedidoNuevo;
    }


    public void AsignarPedidoaTrabajador(){
    }
    //Modificar el estado de un pedido
    public void modificarPedido(Pedido pedido){

    }

    public void DarAltaTrabajador(Trabajador trabajador){
        if (trabajador1 == null) trabajador1 = trabajador;
        else if (trabajador2 == null) trabajador2 = trabajador;
        else trabajador3 = trabajador;
    }
}
