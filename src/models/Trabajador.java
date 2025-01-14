package models;

public class Trabajador {
    //Atributos
    private String user;
    private String nombre;
    private String clave;
    private String correo;
    private String direccion;
    private String localidad;
    private String provincia;
    private int telefono;
    private String tipo;
    private Pedido pedido1;
    private Pedido pedido2;

    //Constructor


    public Trabajador(String user, String nombre, String clave, String correo, String direccion,
                      String localidad, String provincia, int telefono){
        this.user = user;
        this.nombre = nombre;
        this.clave = clave;
        this.correo = correo;
        this.direccion = direccion;
        this.localidad = localidad;
        this.provincia = provincia;
        this.telefono = telefono;
        this.tipo = "Trabajador";
        this.pedido1 = null;
        this.pedido2 = null;
    }

    public Trabajador(Trabajador trabajador){
        this.user = trabajador.user;
        this.nombre = trabajador.nombre;
        this.clave = trabajador.clave;
        this.correo = trabajador.correo;
        this.direccion = trabajador.direccion;
        this.localidad = trabajador.localidad;
        this.provincia = trabajador.provincia;
        this.telefono = trabajador.telefono;
        this.tipo = "Trabajador";
        this.pedido1 = trabajador.pedido1;
        this.pedido2 = trabajador.pedido2;
    }

    //Getters y Setters


    public String getUser() {
        return user;
    }

    public void setUser(String user) {
        this.user = user;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getClave() {
        return clave;
    }

    public void setClave(String clave) {
        this.clave = clave;
    }

    public String getCorreo() {
        return correo;
    }

    public void setCorreo(String correo) {
        this.correo = correo;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public String getLocalidad() {
        return localidad;
    }

    public void setLocalidad(String localidad) {
        this.localidad = localidad;
    }

    public String getProvincia() {
        return provincia;
    }

    public void setProvincia(String provincia) {
        this.provincia = provincia;
    }

    public int getTelefono() {
        return telefono;
    }

    public void setTelefono(int telefono) {
        this.telefono = telefono;
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



    //Otros Metodos
    public void asignarPedidoTrabajador(Pedido pedidoNuevo, Admin admin) {
        if (pedido1 == null) pedido1 = pedidoNuevo;
        else if (pedido2 == null) pedido2 = pedidoNuevo;
            else admin.asignarPedidoAdmin(pedidoNuevo);
    }

    public String pintaPedido(String salida, Cliente clienteCopia1, Cliente clienteCopia2) {
        if (pedido1 != null){
            salida += "==============  Pedido "+ pedido1.getId() +"  ================\n";
            salida += "Estado: "+ pedido1.getEstado() +"\n";
            salida += "Cliente "+ clienteCopia1.getNombre() +"\n";
            salida += "Direccion: "+ clienteCopia1.getDireccion() +"\n";
            salida += "Localidad: "+ clienteCopia1.getLocalidad() +"\n";
            salida += "Provincia: "+ clienteCopia1.getProvincia() +"\n";
            salida += "Teléfono: "+ clienteCopia1.getMovil() +"\n";
            salida += "Correo: "+ clienteCopia1.getCorreo() +"\n";
            salida += "Fecha de pedido: "+ pedido1.getFechaPedido() +"\n";
            salida += "Fecha de entrega estimada: "+ pedido1.getFechaEntregaEstimada() +"\n";
            salida += "Comentario del pedido: "+ pedido1.getComentario() +"\n";
            salida += "Detalles del pedido: \n";
            // Modificar por metodo cuando funcione
            salida += pedido1.pintaPedido() + "\n";
            salida += "Total pedido: " + pedido1.getPrecioTotal()  +"\n";;
        }
        if(pedido2 !=  null){
            salida += "==============  Pedido "+ pedido2.getId() +"  ================\n";
            salida += "Estado: "+ pedido2.getEstado() +"\n";
            salida += "Cliente "+ clienteCopia2.getNombre() +"\n";
            salida += "Direccion: "+ clienteCopia2.getDireccion() +"\n";
            salida += "Localidad: "+ clienteCopia2.getLocalidad() +"\n";
            salida += "Provincia: "+ clienteCopia2.getProvincia() +"\n";
            salida += "Teléfono: "+ clienteCopia2.getMovil() +"\n";
            salida += "Correo: "+ clienteCopia2.getCorreo() +"\n";
            salida += "Fecha de pedido: "+ pedido2.getFechaPedido() +"\n";
            salida += "Fecha de entrega estimada: "+ pedido2.getFechaEntregaEstimada() +"\n";
            salida += "Comentario del pedido: "+ pedido2.getComentario() +"\n";
            salida += "Detalles del pedido: \n";
            salida += pedido2.pintaPedido() + "\n";
            salida += "Total pedido: " + pedido2.getPrecioTotal()  +"\n";
            salida += "\n======================================================\n";
        }
        if (pedido1 == null && pedido2 == null){
            salida += "======================================================\n";
            salida += "\nAun no tienes ningun pedido asignado\n";
            salida += "======================================================\n";
        }
        return salida;
    }

    public String pintaPedidosAsignados() {
        String salida = "";
        if(pedido1 != null) salida += pedido1.pintaPedidoMenu();
        if(pedido2 != null) salida += pedido2.pintaPedidoMenu();
        return salida;
    }

    public String pintaPedidosSimple() {
        String salida = "\n";
        if (pedido1 != null){
            salida += "- num ref: " + pedido1.getId() + "- " +
                    (pedido1.getCantidadProducto1() + pedido1.getCantidadProducto2() + pedido1.getCantidadProducto3()) +
                    " Productos - " + pedido1.getPrecioTotal() + "€ - ESTADO DEL PEDIDO: " + pedido1.getEstado();
            if (!pedido1.getComentario().equals(" ")) salida += "\n COMENTARIOS: \n" + pedido1.getComentario();
        }
        if (pedido2 != null){
            salida += "- num ref: " + pedido2.getId() + "- " +
                    (pedido2.getCantidadProducto1() + pedido2.getCantidadProducto2() + pedido2.getCantidadProducto3()) +
                    " Productos - " + pedido2.getPrecioTotal() + "€ - ESTADO DEL PEDIDO: " + pedido2.getEstado();
            if (!pedido2.getComentario().equals(" ")) salida += "\n COMENTARIOS: \n" + pedido2.getComentario();
        }
        return salida;
    }

    public boolean modificarPedido(int op, String datoNuevo, Pedido pedidoCopia) {
        if (op == 1){
            pedidoCopia.setEstado(datoNuevo);
            return true;
        }
        if (op == 2){
            pedidoCopia.setComentario(datoNuevo);
            return true;
        }
        return false;
    }

    public String pintaTrabajador() {
        String salida = "";
        salida += "Nombre del trabajador:\t" + nombre + "\n";
        salida += "- Usuario:\t\t\t\t" + user + "\n";
        salida += "- Contraseña:\t\t\t" + clave + "\n";
        salida += "- Correo:\t\t\t\t" + correo + "\n";
        salida += "- Dirección:\t\t\t" + direccion + ", " + localidad + " (" + provincia + ")\n";
        salida += "- Teléfono:\t\t\t\t" + telefono + "\n";
        return salida;
    }
}
