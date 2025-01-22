package models;

import Communications.Telegram;
import data.AdminData;
import data.ProductosData;
import utils.Utils;

import java.time.LocalDate;

public class Tienda {
    private Cliente cliente1;
    private Cliente cliente2;
    public Trabajador trabajador1;
    private Trabajador trabajador2;
    private Trabajador trabajador3;
    private Admin admin;
    private Producto producto1;
    private Producto producto2;
    private Producto producto3;
    private Producto producto4;
    private Producto producto5;

    public Tienda() {
        cliente1 = null;
        cliente2 = null;
        trabajador1 = null;
        trabajador2 = null;
        trabajador3 = null;
        admin = AdminData.admin();
        producto1 = ProductosData.producto1();
        producto2 = ProductosData.producto2();
        producto3 = ProductosData.producto3();
        producto4 = ProductosData.producto4();
        producto5 = ProductosData.producto5();
    }


    public void mock(Tienda tienda) {
        cliente1 = new Cliente(1,"Carlos", "1234", "Carlos Barroso", "c\\SalSiPuedes, 7", "Martos", "Jaen", 953605843, "carlos@prueba.es");
    //    cliente2 = new Cliente(2, "Luca", "1234", "Luca Rueda", "c\\Jurado Sin Salida, 14", "Castro del Rio", "Córdoba", 953605843, "Luca@prueba.es");
        trabajador1 = new Trabajador(3, "Lolo","Luca", "Lolo Rueda", "c\\Calle del famoso,1", "Castro del Rio", "Cordoba",  957370968, "loloruese@probado.es");
        trabajador2 = new Trabajador(4, "Edu","Jesus", "Edu Cruz","c\\Arroyo del Moro,3", "Martos", "Jaen", 953470988, "Jesus@probado.es");
        trabajador3 = new Trabajador(5, "Mire", "1234", "Mireya Cueto", "Av. Virgen de las Angustias, S/N", "Córdoba", "Cordoba", 957450488, "Mireya@probado.es");
    }

    //Otros Metodos

    public Object login(String user, String clave) {
        if ((admin != null) && admin.getUser().equals(user) && admin.getClave().equals(clave)) return admin;
        if ((cliente1 != null) && cliente1.getUser().equals(user) && cliente1.getClave().equals(clave))
            return cliente1;
        if ((cliente2 != null) && cliente2.getUser().equals(user) && cliente2.getClave().equals(clave))
            return cliente2;
        if ((trabajador1 != null) && trabajador1.getUser().equals(user) && trabajador1.getClave().equals(clave))
            return trabajador1;
        if ((trabajador2 != null) && trabajador2.getUser().equals(user) && trabajador2.getClave().equals(clave))
            return trabajador2;
        if ((trabajador3 != null) && trabajador3.getUser().equals(user) && trabajador3.getClave().equals(clave))
            return trabajador3;
        return null;
    }

    public static int generaId(Tienda tienda) {
        boolean idNuevo=true;
        int id;
        do{
            id = Utils.numAleatorio100(1,100000);
            if(tienda.trabajador1 != null && id == tienda.trabajador1.getId()) idNuevo = false;
            if(tienda.trabajador2 != null && id == tienda.trabajador2.getId()) idNuevo = false;
            if(tienda.trabajador3 != null && id == tienda.trabajador3.getId()) idNuevo = false;
            if(tienda.cliente1 != null && id == tienda.cliente1.getId()) idNuevo = false;
            if(tienda.cliente2 != null && id == tienda.cliente2.getId()) idNuevo = false;
        }while (!idNuevo);
        return id;
    }

    public void envioTelegramo(){
        Telegram.enviarMensajeTelegram("Lo siento");
    }

    private String pintaMensaje() {
        String salida = "PATATA\n";
        salida += "PEPE";
        return salida;
    }


    public int cantidadPedidosAdmin() {
        int cantidadPedidos = 0;
        if (admin.getPedido1() != null) cantidadPedidos++;
        if (admin.getPedido2() != null) cantidadPedidos++;
        if (admin.getPedido3() != null) cantidadPedidos++;
        if (admin.getPedido4() != null) cantidadPedidos++;
        if (admin.getPedido5() != null) cantidadPedidos++;
        if (admin.getPedido6() != null) cantidadPedidos++;
        return cantidadPedidos;
    }


    // Aqui empiezan los metodos de los clientes
    public Cliente copiarCliente(String user) {
        Cliente clienteCopia = null;
        if (cliente1 != null && cliente1.getUser().equals(user)) clienteCopia = new Cliente(cliente1);
        if (cliente2 != null && cliente2.getUser().equals(user)) clienteCopia = new Cliente(cliente2);
        return clienteCopia;
    }

    public String pintaNombreCliente(Cliente cliente) {
        return cliente.getNombre();
    }

    public boolean registroCliente(int id, String nombre, String direccion, String localidad, String provincia,
                                   int telefono, String introCorreo, String user, String clave, Tienda tienda) {
        if (cliente1 == null) {
            cliente1 = new Cliente(id, user, clave, nombre, direccion, localidad, provincia, telefono, introCorreo);
            return true;
        }
        if (cliente2 == null) {
            cliente2 = new Cliente(id, user, clave, nombre, direccion, localidad, provincia, telefono, introCorreo);
            return true;
        }
        return false;
    }

    public String pintaDatosCliente(Cliente cliente) {
        String salida = "";
        salida += "================== Datos Personales =================\n";
        salida += "\n";
        salida += "Nombre: " + cliente.getNombre() + "\n";
        salida += "Dirección: " + cliente.getDireccion() + "\n";
        salida += "localidad : " + cliente.getLocalidad() + "\n";
        salida += "Provincia: " + cliente.getProvincia() + "\n";
        salida += "telefono: " + cliente.getMovil() + "\n";
        salida += "correo: " + cliente.getCorreo() + "\n\n";
        salida += "====================================================\n";
        return salida;

    }

    public boolean modificarDatoCliente(int modificar, String datoNuevo, Cliente cliente) {
        switch (modificar) {
            case 1:
                cliente.setNombre(datoNuevo);
                return true;
            case 2:
                cliente.setDireccion(datoNuevo);
                return true;
            case 3:
                cliente.setLocalidad(datoNuevo);
                return true;
            case 4:
                cliente.setProvincia(datoNuevo);
                return true;
            case 5:
                if (datoNuevo.length() != 9) return false;
                else {
                    for (int i = 0; i < (datoNuevo.length() - 1); i++) {
                        if (!Character.isDigit(datoNuevo.charAt(i))) return false;
                    }
                }
                cliente.setMovil(Integer.parseInt(datoNuevo));
                return true;
            case 6:
                if (!datoNuevo.contains("@")) return false;
                cliente.setCorreo(datoNuevo);
                return true;
            case 7:
                cliente.setUser(datoNuevo);
                return true;
            case 8:
                cliente.setClave(datoNuevo);
                return true;
        }
        return false;
    }

    public String pintaPedidosCliente(Cliente clienteCopia) {
        String salida = "";
        salida = clienteCopia.pintaPedido(salida);
        return salida;
    }

    public String pintaProductosSinStock() {
        String salida = "===============================\n";
        if (producto1 != null) salida += "- " + producto1.pintaProductoCatalogo();
        if (producto2 != null) salida += "- " + producto2.pintaProductoCatalogo();
        if (producto3 != null) salida += "- " + producto3.pintaProductoCatalogo();
        if (producto4 != null) salida += "- " + producto4.pintaProductoCatalogo();
        if (producto5 != null) salida += "- " + producto5.pintaProductoCatalogo();
        return salida;
    }

    public boolean realizaPedidoCliente(int idElegida, Pedido pedidoNuevo, int cantidad) {
        Producto producto = null;
        // comprobamos cual es el producto deseado
        if (idElegida == producto1.getId() && producto1.getStock() >= cantidad) {
            producto1.sacarStock(cantidad);
            producto = new Producto(producto1);
            return pedidoNuevo.incluirProducto(idElegida, producto, cantidad);
        }
        if (idElegida == producto2.getId() && producto2.getStock() >= cantidad) {
            producto2.sacarStock(cantidad);
            producto = new Producto(producto2);
            return pedidoNuevo.incluirProducto(idElegida, producto, cantidad);
        }
        if (idElegida == producto3.getId() && producto3.getStock() >= cantidad) {
            producto3.sacarStock(cantidad);
            producto = new Producto(producto3);
            return pedidoNuevo.incluirProducto(idElegida, producto, cantidad);
        }
        if (idElegida == producto4.getId() && producto4.getStock() >= cantidad) {
            producto4.sacarStock(cantidad);
            producto = new Producto(producto4);
            return pedidoNuevo.incluirProducto(idElegida, producto, cantidad);
        }
        if (idElegida == producto5.getId() && producto5.getStock() >= cantidad) {
            producto5.sacarStock(cantidad);
            producto = new Producto(producto5);
            return pedidoNuevo.incluirProducto(idElegida, producto, cantidad);
        }
        return false;
    }

    public void cierraSesionCliente(Cliente clienteCopia, int idCliente) {
        if (cliente1 != null && cliente1.getId() == clienteCopia.getId()) cliente1 = clienteCopia;
        if (cliente2 != null && cliente2.getId() == clienteCopia.getId()) cliente2 = clienteCopia;
    }


    // Empiezan los metodos para los trabajadores
    public Trabajador copiarTrabajador(String user) {
        Trabajador trabajadorCopia = null;
        if (trabajador1 != null && trabajador1.getUser().equals(user)) trabajadorCopia = new Trabajador(trabajador1);
        if (trabajador2 != null && trabajador2.getUser().equals(user)) trabajadorCopia = new Trabajador(trabajador2);
        if (trabajador3 != null && trabajador3.getUser().equals(user)) trabajadorCopia = new Trabajador(trabajador3);
        return trabajadorCopia;
    }

    public String pintaNombreTrabajador(Trabajador trabajador) {
        return trabajador.getNombre();
    }

    public static int cantidadPedidosTrabajador(Trabajador trabajador) {
        int numPedidos = 0;
        if (trabajador.getPedido1() != null && trabajador.getPedido1().getEstado().equals("En Preparación"))
            numPedidos++;
        if (trabajador.getPedido2() != null && trabajador.getPedido2().getEstado().equals("En Preparación"))
            numPedidos++;
        return numPedidos;
    }

    public String pintaDatosTrabajador(Trabajador trabajador) {
        String salida = "";
        salida += "================== Datos Personales =================\n";
        salida += "\n";
        salida += "Nombre: " + trabajador.getNombre() + "\n";
        salida += "Dirección: " + trabajador.getDireccion() + "\n";
        salida += "localidad : " + trabajador.getLocalidad() + "\n";
        salida += "Provincia: " + trabajador.getProvincia() + "\n";
        salida += "telefono: " + trabajador.getMovil() + "\n";
        salida += "correo: " + trabajador.getCorreo() + "\n\n";
        salida += "====================================================\n";
        return salida;

    }

    public boolean modificarDatoTrabajador(int modificar, String datoNuevo, Trabajador trabajador) {
        switch (modificar) {
            case 1:
                trabajador.setNombre(datoNuevo);
                return true;
            case 2:
                trabajador.setDireccion(datoNuevo);
                return true;
            case 3:
                trabajador.setLocalidad(datoNuevo);
                return true;
            case 4:
                trabajador.setProvincia(datoNuevo);
                return true;
            case 5:
                if (datoNuevo.length() != 9) return false;
                else {
                    for (int i = 0; i < (datoNuevo.length() - 1); i++) {
                        if (!Character.isDigit(datoNuevo.charAt(i))) return false;
                    }
                }
                trabajador.setMovil(Integer.parseInt(datoNuevo));
                return true;
            case 6:
                if (!datoNuevo.contains("@")) return false;
                trabajador.setCorreo(datoNuevo);
                return true;
            case 7:
                trabajador.setUser(datoNuevo);
                return true;
            case 8:
                trabajador.setClave(datoNuevo);
                return true;
        }
        return false;
    }

    public String pintaProductosConStock() {
        String salida = "===============================\n";
        if (producto1 != null) salida += "- " + producto1.pintaProducto();
        if (producto2 != null) salida += "- " + producto2.pintaProducto();
        if (producto3 != null) salida += "- " + producto3.pintaProducto();
        if (producto4 != null) salida += "- " + producto4.pintaProducto();
        if (producto5 != null) salida += "- " + producto5.pintaProducto();
        return salida;
    }

    public void modificarDatosProducto(int modificar, int selectProducto, String datoNuevo) {
        Producto productoModificar = null;
        if (producto1 != null && producto1.getId() == selectProducto) productoModificar = producto1;
        if (producto2 != null && producto2.getId() == selectProducto) productoModificar = producto2;
        if (producto3 != null && producto3.getId() == selectProducto) productoModificar = producto3;
        if (producto4 != null && producto4.getId() == selectProducto) productoModificar = producto4;
        if (producto5 != null && producto5.getId() == selectProducto) productoModificar = producto5;
        switch (modificar) {
            case 1:
                productoModificar.setNombre(datoNuevo);
                break;
            case 2:
                productoModificar.setPvp(Float.parseFloat(datoNuevo));
                break;
            case 3:
                productoModificar.setStock(Integer.parseInt(datoNuevo));
                break;
        }
    }

    public void asignarPedido(Pedido pedidoNuevo) {
        if (trabajador1 == null && trabajador2 == null && trabajador3 == null) admin.asignarPedidoAdmin(pedidoNuevo);
        if (trabajador1 != null && trabajador2 != null && trabajador3 != null) {
            if (cantidadPedidosTrabajador(trabajador1) == cantidadPedidosTrabajador(trabajador2) &&
                    cantidadPedidosTrabajador(trabajador1) == cantidadPedidosTrabajador(trabajador3))
                admin.asignarPedidoAdmin(pedidoNuevo);
            else if (cantidadPedidosTrabajador(trabajador1) < cantidadPedidosTrabajador(trabajador2) &&
                    cantidadPedidosTrabajador(trabajador1) < cantidadPedidosTrabajador(trabajador3))
                trabajador1.asignarPedidoTrabajador(pedidoNuevo, admin);
            else if (cantidadPedidosTrabajador(trabajador2) < cantidadPedidosTrabajador(trabajador1) &&
                    cantidadPedidosTrabajador(trabajador2) < cantidadPedidosTrabajador(trabajador3))
                trabajador2.asignarPedidoTrabajador(pedidoNuevo, admin);
            else if (cantidadPedidosTrabajador(trabajador3) < cantidadPedidosTrabajador(trabajador1) &&
                    cantidadPedidosTrabajador(trabajador3) < cantidadPedidosTrabajador(trabajador2))
                trabajador3.asignarPedidoTrabajador(pedidoNuevo, admin);
        }
        if (trabajador1 != null && trabajador2 != null && trabajador3 == null) {
            if (cantidadPedidosTrabajador(trabajador1) == cantidadPedidosTrabajador(trabajador2))
                admin.asignarPedidoAdmin(pedidoNuevo);
            else if (cantidadPedidosTrabajador(trabajador1) < cantidadPedidosTrabajador(trabajador2))
                trabajador1.asignarPedidoTrabajador(pedidoNuevo, admin);
            else trabajador2.asignarPedidoTrabajador(pedidoNuevo, admin);
        }
        if (trabajador1 != null && trabajador2 == null && trabajador3 != null) {
            if (cantidadPedidosTrabajador(trabajador1) == cantidadPedidosTrabajador(trabajador3))
                admin.asignarPedidoAdmin(pedidoNuevo);
            else if (cantidadPedidosTrabajador(trabajador1) < cantidadPedidosTrabajador(trabajador3))
                trabajador1.asignarPedidoTrabajador(pedidoNuevo, admin);
            else trabajador3.asignarPedidoTrabajador(pedidoNuevo, admin);
        }
        if (trabajador1 == null && trabajador2 != null && trabajador3 != null) {
            if (cantidadPedidosTrabajador(trabajador2) == cantidadPedidosTrabajador(trabajador3))
                admin.asignarPedidoAdmin(pedidoNuevo);
            else if (cantidadPedidosTrabajador(trabajador2) < cantidadPedidosTrabajador(trabajador3))
                trabajador2.asignarPedidoTrabajador(pedidoNuevo, admin);
            else trabajador3.asignarPedidoTrabajador(pedidoNuevo, admin);
        }
        if (trabajador1 != null && trabajador2 == null && trabajador3 == null)
            trabajador1.asignarPedidoTrabajador(pedidoNuevo, admin);
        if (trabajador1 == null && trabajador2 != null && trabajador3 == null)
            trabajador2.asignarPedidoTrabajador(pedidoNuevo, admin);
        if (trabajador1 == null && trabajador2 == null && trabajador3 != null)
            trabajador3.asignarPedidoTrabajador(pedidoNuevo, admin);
    }

    public String pintaPedidosTrabajador(Trabajador trabajadorCopia) {
        String salida = "";
        Cliente clienteCopia1 = null;
        Cliente clienteCopia2 = null;
        // Sacamos los datos del cliente relacionado con el pedido1
        if (trabajadorCopia.getPedido1() != null) {
            if (cliente1 != null) {
                if (cliente1.getPedido1() != null && cliente1.getPedido1().getId() == trabajador1.getPedido1().getId())
                    clienteCopia1 = cliente1;
                if (cliente1.getPedido2() != null && cliente1.getPedido2().getId() == trabajador1.getPedido1().getId())
                    clienteCopia1 = cliente1;
            }
            if (cliente2 != null) {
                if (cliente2.getPedido1() != null && cliente2.getPedido1().getId() == trabajador1.getPedido1().getId())
                    clienteCopia1 = cliente2;
                if (cliente2.getPedido2() != null && cliente2.getPedido2().getId() == trabajador1.getPedido1().getId())
                    clienteCopia1 = cliente2;
            }
        }
        if (trabajadorCopia.getPedido2() != null) {
            if (cliente1 != null) {
                if (cliente1.getPedido1() != null && cliente1.getPedido1().getId() == trabajador1.getPedido2().getId())
                    clienteCopia2 = cliente1;
                if (cliente1.getPedido2() != null && cliente1.getPedido2().getId() == trabajador1.getPedido2().getId())
                    clienteCopia2 = cliente1;
            }
            if (cliente2 != null) {
                if (cliente2.getPedido1() != null && cliente2.getPedido1().getId() == trabajador1.getPedido2().getId())
                    clienteCopia2 = cliente2;
                if (cliente2.getPedido2() != null && cliente2.getPedido2().getId() == trabajador1.getPedido2().getId())
                    clienteCopia2 = cliente2;
            }
        }
        salida = trabajadorCopia.pintaPedido(salida, clienteCopia1, clienteCopia2);
        return salida;
    }

    public String pintaPedidosAsignados(Trabajador trabajadorCopia) {
        String salida = "";
        salida = trabajadorCopia.pintaPedidosSimple();

        return salida;
    }

    public void cierraSesionTrabajador(Trabajador trabajadorCopia, String user) {
        if (trabajador1 != null && trabajador1.getUser().equals(user)) trabajador1 = trabajadorCopia;
        if (trabajador2 != null && trabajador2.getUser().equals(user)) trabajador2 = trabajadorCopia;
        if (trabajador3 != null && trabajador3.getUser().equals(user)) trabajador3 = trabajadorCopia;
    }

    //Metodos Administrador

    public String pintaTrabajadores() {
        String salida = "";
        if (trabajador1 != null) {
            salida += trabajador1.pintaTrabajador();
            salida += "Este trabajador tiene " + cantidadPedidosTrabajador(trabajador1) + " pedidos asignados\n\n";
        }
        if (trabajador2 != null) {
            salida += trabajador2.pintaTrabajador();
            salida += "Este trabajador tiene " + cantidadPedidosTrabajador(trabajador2) + " pedidos asignados\n\n";
        }
        if (trabajador3 != null) {
            salida += trabajador3.pintaTrabajador();
            salida += "Este trabajador tiene " + cantidadPedidosTrabajador(trabajador3) + " pedidos asignados\n";
        }
        if (trabajador1 == null && trabajador2 == null && trabajador3 == null) salida += "No hay ningún trabajador";
        return salida;
    }

    public String pintaClientes() {
        String salida = "";
        if (cliente1 != null) {
            salida += pintaDatosCliente(cliente1);
        }
        if (cliente2 != null) {
            salida += pintaDatosCliente(cliente2);
        }
        return salida;
    }

    public String pintaPedidos() {
        String salida = "";
        salida += "=========Lista de pedidos=========\n";
        if (cliente1 != null) {
            if (cliente1.getPedido1() != null) {
                salida += cliente1.pintaPedidoSolo(cliente1.getPedido1());
                if (trabajador1 != null) {
                    if (trabajador1.getPedido1() != null && cliente1.getPedido1().getId() == trabajador1.getPedido1().getId() ||
                            trabajador1.getPedido2() != null && cliente1.getPedido1().getId() == trabajador1.getPedido2().getId()) {
                        salida += "\n Este pedido esta asignado al trabajador: " + trabajador1.getNombre() + "\n\n";
                    } else {
                        if (trabajador2 != null) {
                            if (trabajador2.getPedido1() != null && cliente1.getPedido1().getId() == trabajador2.getPedido1().getId() ||
                                    trabajador2.getPedido2() != null && cliente1.getPedido1().getId() == trabajador2.getPedido2().getId()) {
                                salida += "\n Este pedido esta asignado al trabajador: " + trabajador2.getNombre() + "\n\n";
                            } else {
                                if (trabajador3 != null) {
                                    if (trabajador3.getPedido1() != null && cliente1.getPedido1().getId() == trabajador3.getPedido1().getId() ||
                                            trabajador3.getPedido2() != null && cliente1.getPedido1().getId() == trabajador3.getPedido2().getId()) {
                                        salida += "\n Este pedido esta asignado al trabajador: " + trabajador3.getNombre() + "\n\n";
                                    } else {
                                        salida += "\n Este pedido todavia no esta asignado a ningun trabajador\n";
                                    }
                                }
                            }
                        }
                    }
                }
            }

            if (cliente1.getPedido2() != null) {
                salida += cliente1.pintaPedidoSolo(cliente1.getPedido2());
                if (trabajador1 != null) {
                    if (trabajador1.getPedido1() != null && cliente1.getPedido2().getId() == trabajador1.getPedido1().getId() ||
                            trabajador1.getPedido2() != null && cliente1.getPedido2().getId() == trabajador1.getPedido2().getId()) {
                        salida += "\n Este pedido esta asignado al trabajador: " + trabajador1.getNombre() + "\n\n";
                    } else if (trabajador2 != null) {
                        if (trabajador2.getPedido1() != null && cliente1.getPedido2().getId() == trabajador2.getPedido1().getId() ||
                                trabajador2.getPedido2() != null && cliente1.getPedido2().getId() == trabajador2.getPedido2().getId()) {
                            salida += "\n Este pedido esta asignado al trabajador: " + trabajador2.getNombre() + "\n\n";
                        } else if (trabajador3 != null) {
                            if (trabajador3.getPedido1() != null && cliente1.getPedido2().getId() == trabajador3.getPedido1().getId() ||
                                    trabajador3.getPedido2() != null && cliente1.getPedido2().getId() == trabajador3.getPedido2().getId()) {
                                salida += "\n Este pedido esta asignado al trabajador: " + trabajador3.getNombre() + "\n\n";
                            } else {
                                salida += "\n Este pedido todavia no esta asignado a ningun trabajador\n";
                            }
                        }
                    }
                }
            }
        }
        if (cliente2 != null) {
            if (cliente2.getPedido1() != null) {
                salida += cliente2.pintaPedidoSolo(cliente2.getPedido1());
                if (trabajador1 != null) {
                    if (trabajador1.getPedido1() != null && cliente2.getPedido1().getId() == trabajador1.getPedido1().getId() ||
                            trabajador1.getPedido2() != null && cliente2.getPedido1().getId() == trabajador1.getPedido2().getId()) {
                        salida += "\n Este pedido esta asignado al trabajador: " + trabajador1.getNombre() + "\n\n";
                    } else if (trabajador2 != null) {
                        if (trabajador2.getPedido1() != null && cliente2.getPedido1().getId() == trabajador2.getPedido1().getId() ||
                                trabajador2.getPedido2() != null && cliente2.getPedido1().getId() == trabajador2.getPedido2().getId()) {
                            salida += "\n Este pedido esta asignado al trabajador: " + trabajador2.getNombre() + "\n\n";
                        } else if (trabajador3 != null) {
                            if (trabajador3.getPedido1() != null && cliente2.getPedido1().getId() == trabajador3.getPedido1().getId() ||
                                    trabajador3.getPedido2() != null && cliente2.getPedido1().getId() == trabajador3.getPedido2().getId()) {
                                salida += "\n Este pedido esta asignado al trabajador: " + trabajador3.getNombre() + "\n\n";
                            } else {
                                salida += "\n Este pedido todavia no esta asignado a ningun trabajador\n";
                            }
                        }
                    }
                }
            }

            if (cliente2.getPedido2() != null) {
                salida += cliente2.pintaPedidoSolo(cliente2.getPedido2());
                if (trabajador1 != null) {
                    if (trabajador1.getPedido1() != null && cliente2.getPedido2().getId() == trabajador1.getPedido1().getId() ||
                            trabajador1.getPedido2() != null && cliente2.getPedido2().getId() == trabajador1.getPedido2().getId()) {
                        salida += "\n Este pedido esta asignado al trabajador: " + trabajador1.getNombre() + "\n\n";
                    } else if (trabajador2 != null) {
                        if (trabajador2.getPedido1() != null && cliente2.getPedido2().getId() == trabajador2.getPedido1().getId() ||
                                trabajador2.getPedido2() != null && cliente2.getPedido2().getId() == trabajador2.getPedido2().getId()) {
                            salida += "\n Este pedido esta asignado al trabajador: " + trabajador2.getNombre() + "\n\n";
                        } else if (trabajador3 != null) {
                            if (trabajador3.getPedido1() != null && cliente2.getPedido2().getId() == trabajador3.getPedido1().getId() ||
                                    trabajador3.getPedido2() != null && cliente2.getPedido2().getId() == trabajador3.getPedido2().getId()) {
                                salida += "\n Este pedido esta asignado al trabajador: " + trabajador3.getNombre() + "\n\n";
                            } else {
                                salida += "\n Este pedido todavia no esta asignado a ningun trabajador\n";
                            }
                        }
                    }
                }
            }
        }
        return salida;
    }

    public boolean altaTrabajador(String nombre, String direccion, String localidad, String provincia, String introTelefono, String introCorreo, String user, String clave, int id) {
        if (introTelefono.length() != 9) return false;
        if (!Utils.esDigito(introTelefono)) return false;
        int telefono = Integer.parseInt(introTelefono);
        if (!introCorreo.contains("@")) return false;
        if (trabajador1 == null) {
            trabajador1 = new Trabajador(id, user,  clave, nombre,  direccion, localidad, provincia, telefono, introCorreo);
            return true;
        }
        if (trabajador2 == null) {
            trabajador2 = new Trabajador(id, user, clave, nombre,  direccion, localidad, provincia, telefono, introCorreo);
            return true;
        }
        if (trabajador3 == null) {
            trabajador3 = new Trabajador(id, user, clave, nombre,  direccion, localidad, provincia, telefono, introCorreo);
            return true;
        }
        return false;
    }

    public boolean modificarDireccionPedido(int id, String direccion, String localidad, String provincia) {
        Pedido pedidoCopia = null;
        if (admin.getPedido1() != null && admin.getPedido1().getId() == id) pedidoCopia = admin.getPedido1();
        if (admin.getPedido2() != null && admin.getPedido2().getId() == id) pedidoCopia = admin.getPedido2();
        if (admin.getPedido3() != null && admin.getPedido3().getId() == id) pedidoCopia = admin.getPedido3();
        if (admin.getPedido4() != null && admin.getPedido4().getId() == id) pedidoCopia = admin.getPedido4();
        if (admin.getPedido5() != null && admin.getPedido5().getId() == id) pedidoCopia = admin.getPedido5();
        if (admin.getPedido6() != null && admin.getPedido6().getId() == id) pedidoCopia = admin.getPedido6();
        if (trabajador1 != null) {
            if (trabajador1.getPedido1() != null && trabajador1.getPedido1().getId() == id)
                pedidoCopia = trabajador1.getPedido1();
            if (trabajador1.getPedido2() != null && trabajador1.getPedido2().getId() == id)
                pedidoCopia = trabajador1.getPedido2();
        }
        if (trabajador2 != null) {
            if (trabajador2.getPedido1() != null && trabajador2.getPedido1().getId() == id)
                pedidoCopia = trabajador2.getPedido1();
            if (trabajador2.getPedido2() != null && trabajador2.getPedido2().getId() == id)
                pedidoCopia = trabajador2.getPedido2();
        }
        if (trabajador3 != null) {
            if (trabajador3.getPedido1() != null && trabajador3.getPedido1().getId() == id)
                pedidoCopia = trabajador3.getPedido1();
            if (trabajador3.getPedido2() != null && trabajador3.getPedido2().getId() == id)
                pedidoCopia = trabajador3.getPedido2();
        }
        if (pedidoCopia != null && !direccion.isEmpty()) {
            pedidoCopia.setDireccionEnvio(direccion);
            if (!localidad.isEmpty()) pedidoCopia.setLocalidadEnvio(localidad);
            if (!provincia.isEmpty()) pedidoCopia.setProvinciaEnvio(provincia);
            if (admin.getPedido1() != null && admin.getPedido1() == pedidoCopia) admin.setPedido1(pedidoCopia);
            if (admin.getPedido2() != null && admin.getPedido2() == pedidoCopia) admin.setPedido2(pedidoCopia);
            if (admin.getPedido3() != null && admin.getPedido3() == pedidoCopia) admin.setPedido3(pedidoCopia);
            if (admin.getPedido4() != null && admin.getPedido4() == pedidoCopia) admin.setPedido4(pedidoCopia);
            if (admin.getPedido5() != null && admin.getPedido5() == pedidoCopia) admin.setPedido5(pedidoCopia);
            if (admin.getPedido6() != null && admin.getPedido6() == pedidoCopia) admin.setPedido6(pedidoCopia);
            if (trabajador1 != null) {
                if (trabajador1.getPedido1() != null && trabajador1.getPedido1() == pedidoCopia)
                    trabajador1.setPedido1(pedidoCopia);
                if (trabajador1.getPedido2() != null && trabajador1.getPedido2() == pedidoCopia)
                    trabajador1.setPedido2(pedidoCopia);
            }
            if (trabajador2 != null) {
                if (trabajador2.getPedido1() != null && trabajador2.getPedido1() == pedidoCopia)
                    trabajador2.setPedido1(pedidoCopia);
                if (trabajador2.getPedido2() != null && trabajador2.getPedido2() == pedidoCopia)
                    trabajador2.setPedido2(pedidoCopia);
            }
            if (trabajador3 != null) {
                if (trabajador3.getPedido1() != null && trabajador3.getPedido1() == pedidoCopia)
                    trabajador3.setPedido1(pedidoCopia);
                if (trabajador3.getPedido2() != null && trabajador3.getPedido2() == pedidoCopia)
                    trabajador3.setPedido2(pedidoCopia);
            }
            return true;
        }
        return false;
    }

    public boolean modificarEstadoPedido(int id, String select) {
        Pedido pedidoCopia = null;
        if (admin.getPedido1() != null && admin.getPedido1().getId() == id) pedidoCopia = admin.getPedido1();
        if (admin.getPedido2() != null && admin.getPedido2().getId() == id) pedidoCopia = admin.getPedido2();
        if (admin.getPedido3() != null && admin.getPedido3().getId() == id) pedidoCopia = admin.getPedido3();
        if (admin.getPedido4() != null && admin.getPedido4().getId() == id) pedidoCopia = admin.getPedido4();
        if (admin.getPedido5() != null && admin.getPedido5().getId() == id) pedidoCopia = admin.getPedido5();
        if (admin.getPedido6() != null && admin.getPedido6().getId() == id) pedidoCopia = admin.getPedido6();
        if (trabajador1 != null) {
            if (trabajador1.getPedido1() != null && trabajador1.getPedido1().getId() == id)
                pedidoCopia = trabajador1.getPedido1();
            if (trabajador1.getPedido2() != null && trabajador1.getPedido2().getId() == id)
                pedidoCopia = trabajador1.getPedido2();
        }
        if (trabajador2 != null) {
            if (trabajador2.getPedido1() != null && trabajador2.getPedido1().getId() == id)
                pedidoCopia = trabajador2.getPedido1();
            if (trabajador2.getPedido2() != null && trabajador2.getPedido2().getId() == id)
                pedidoCopia = trabajador2.getPedido2();
        }
        if (trabajador3 != null) {
            if (trabajador3.getPedido1() != null && trabajador3.getPedido1().getId() == id)
                pedidoCopia = trabajador3.getPedido1();
            if (trabajador3.getPedido2() != null && trabajador3.getPedido2().getId() == id)
                pedidoCopia = trabajador3.getPedido2();
        }
        if (pedidoCopia != null && !select.isEmpty()) {
            if (admin.getPedido1() != null && admin.getPedido1() == pedidoCopia) admin.setPedido1(pedidoCopia);
            if (admin.getPedido2() != null && admin.getPedido2() == pedidoCopia) admin.setPedido2(pedidoCopia);
            if (admin.getPedido3() != null && admin.getPedido3() == pedidoCopia) admin.setPedido3(pedidoCopia);
            if (admin.getPedido4() != null && admin.getPedido4() == pedidoCopia) admin.setPedido4(pedidoCopia);
            if (admin.getPedido5() != null && admin.getPedido5() == pedidoCopia) admin.setPedido5(pedidoCopia);
            if (admin.getPedido6() != null && admin.getPedido6() == pedidoCopia) admin.setPedido6(pedidoCopia);
            if (trabajador1 != null) {
                if (trabajador1.getPedido1() != null && trabajador1.getPedido1() == pedidoCopia)
                    trabajador1.setPedido1(pedidoCopia);
                if (trabajador1.getPedido2() != null && trabajador1.getPedido2() == pedidoCopia)
                    trabajador1.setPedido2(pedidoCopia);
            }
            if (trabajador2 != null) {
                if (trabajador2.getPedido1() != null && trabajador2.getPedido1() == pedidoCopia)
                    trabajador2.setPedido1(pedidoCopia);
                if (trabajador2.getPedido2() != null && trabajador2.getPedido2() == pedidoCopia)
                    trabajador2.setPedido2(pedidoCopia);
            }
            if (trabajador3 != null) {
                if (trabajador3.getPedido1() != null && trabajador3.getPedido1() == pedidoCopia)
                    trabajador3.setPedido1(pedidoCopia);
                if (trabajador3.getPedido2() != null && trabajador3.getPedido2() == pedidoCopia)
                    trabajador3.setPedido2(pedidoCopia);
            }
            pedidoCopia.setEstado(select);
        return true;
        }
        return false;
    }

    public boolean modificarComentarioPedido(int id, String select) {
        Pedido pedidoCopia = null;
        if (admin.getPedido1() != null && admin.getPedido1().getId() == id) pedidoCopia = admin.getPedido1();
        if (admin.getPedido2() != null && admin.getPedido2().getId() == id) pedidoCopia = admin.getPedido2();
        if (admin.getPedido3() != null && admin.getPedido3().getId() == id) pedidoCopia = admin.getPedido3();
        if (admin.getPedido4() != null && admin.getPedido4().getId() == id) pedidoCopia = admin.getPedido4();
        if (admin.getPedido5() != null && admin.getPedido5().getId() == id) pedidoCopia = admin.getPedido5();
        if (admin.getPedido6() != null && admin.getPedido6().getId() == id) pedidoCopia = admin.getPedido6();
        if (trabajador1 != null) {
            if (trabajador1.getPedido1() != null && trabajador1.getPedido1().getId() == id)
                pedidoCopia = trabajador1.getPedido1();
            if (trabajador1.getPedido2() != null && trabajador1.getPedido2().getId() == id)
                pedidoCopia = trabajador1.getPedido2();
        }
        if (trabajador2 != null) {
            if (trabajador2.getPedido1() != null && trabajador2.getPedido1().getId() == id)
                pedidoCopia = trabajador2.getPedido1();
            if (trabajador2.getPedido2() != null && trabajador2.getPedido2().getId() == id)
                pedidoCopia = trabajador2.getPedido2();
        }
        if (trabajador3 != null) {
            if (trabajador3.getPedido1() != null && trabajador3.getPedido1().getId() == id)
                pedidoCopia = trabajador3.getPedido1();
            if (trabajador3.getPedido2() != null && trabajador3.getPedido2().getId() == id)
                pedidoCopia = trabajador3.getPedido2();
        }
        if (pedidoCopia != null && !select.isEmpty()) {
            pedidoCopia.setComentario(select);
            if (admin.getPedido1() != null && admin.getPedido1() == pedidoCopia) admin.setPedido1(pedidoCopia);
            if (admin.getPedido2() != null && admin.getPedido2() == pedidoCopia) admin.setPedido2(pedidoCopia);
            if (admin.getPedido3() != null && admin.getPedido3() == pedidoCopia) admin.setPedido3(pedidoCopia);
            if (admin.getPedido4() != null && admin.getPedido4() == pedidoCopia) admin.setPedido4(pedidoCopia);
            if (admin.getPedido5() != null && admin.getPedido5() == pedidoCopia) admin.setPedido5(pedidoCopia);
            if (admin.getPedido6() != null && admin.getPedido6() == pedidoCopia) admin.setPedido6(pedidoCopia);
            if (trabajador1 != null) {
                if (trabajador1.getPedido1() != null && trabajador1.getPedido1() == pedidoCopia)
                    trabajador1.setPedido1(pedidoCopia);
                if (trabajador1.getPedido2() != null && trabajador1.getPedido2() == pedidoCopia)
                    trabajador1.setPedido2(pedidoCopia);
            }
            if (trabajador2 != null) {
                if (trabajador2.getPedido1() != null && trabajador2.getPedido1() == pedidoCopia)
                    trabajador2.setPedido1(pedidoCopia);
                if (trabajador2.getPedido2() != null && trabajador2.getPedido2() == pedidoCopia)
                    trabajador2.setPedido2(pedidoCopia);
            }
            if (trabajador3 != null) {
                if (trabajador3.getPedido1() != null && trabajador3.getPedido1() == pedidoCopia)
                    trabajador3.setPedido1(pedidoCopia);
                if (trabajador3.getPedido2() != null && trabajador3.getPedido2() == pedidoCopia)
                    trabajador3.setPedido2(pedidoCopia);
            }
            return true;
    }
        return false;
}

    public boolean modificarFechaEntregaPedido(int id, String select) {
        Pedido pedidoCopia = null;
        if (admin.getPedido1() != null && admin.getPedido1().getId() == id) pedidoCopia = admin.getPedido1();
        if (admin.getPedido2() != null && admin.getPedido2().getId() == id) pedidoCopia = admin.getPedido2();
        if (admin.getPedido3() != null && admin.getPedido3().getId() == id) pedidoCopia = admin.getPedido3();
        if (admin.getPedido4() != null && admin.getPedido4().getId() == id) pedidoCopia = admin.getPedido4();
        if (admin.getPedido5() != null && admin.getPedido5().getId() == id) pedidoCopia = admin.getPedido5();
        if (admin.getPedido6() != null && admin.getPedido6().getId() == id) pedidoCopia = admin.getPedido6();
        if (trabajador1 != null) {
            if (trabajador1.getPedido1() != null && trabajador1.getPedido1().getId() == id)
                pedidoCopia = trabajador1.getPedido1();
            if (trabajador1.getPedido2() != null && trabajador1.getPedido2().getId() == id)
                pedidoCopia = trabajador1.getPedido2();
        }
        if (trabajador2 != null) {
            if (trabajador2.getPedido1() != null && trabajador2.getPedido1().getId() == id)
                pedidoCopia = trabajador2.getPedido1();
            if (trabajador2.getPedido2() != null && trabajador2.getPedido2().getId() == id)
                pedidoCopia = trabajador2.getPedido2();
        }
        if (trabajador3 != null) {
            if (trabajador3.getPedido1() != null && trabajador3.getPedido1().getId() == id)
                pedidoCopia = trabajador3.getPedido1();
            if (trabajador3.getPedido2() != null && trabajador3.getPedido2().getId() == id)
                pedidoCopia = trabajador3.getPedido2();
        }
        if (pedidoCopia != null && !select.isEmpty()) {
            pedidoCopia.setFechaEntregaEstimada(LocalDate.parse(select));
            if (admin.getPedido1() != null && admin.getPedido1() == pedidoCopia) admin.setPedido1(pedidoCopia);
            if (admin.getPedido2() != null && admin.getPedido2() == pedidoCopia) admin.setPedido2(pedidoCopia);
            if (admin.getPedido3() != null && admin.getPedido3() == pedidoCopia) admin.setPedido3(pedidoCopia);
            if (admin.getPedido4() != null && admin.getPedido4() == pedidoCopia) admin.setPedido4(pedidoCopia);
            if (admin.getPedido5() != null && admin.getPedido5() == pedidoCopia) admin.setPedido5(pedidoCopia);
            if (admin.getPedido6() != null && admin.getPedido6() == pedidoCopia) admin.setPedido6(pedidoCopia);
            if (trabajador1 != null) {
                if (trabajador1.getPedido1() != null && trabajador1.getPedido1() == pedidoCopia)
                    trabajador1.setPedido1(pedidoCopia);
                if (trabajador1.getPedido2() != null && trabajador1.getPedido2() == pedidoCopia)
                    trabajador1.setPedido2(pedidoCopia);
            }
            if (trabajador2 != null) {
                if (trabajador2.getPedido1() != null && trabajador2.getPedido1() == pedidoCopia)
                    trabajador2.setPedido1(pedidoCopia);
                if (trabajador2.getPedido2() != null && trabajador2.getPedido2() == pedidoCopia)
                    trabajador2.setPedido2(pedidoCopia);
            }
            if (trabajador3 != null) {
                if (trabajador3.getPedido1() != null && trabajador3.getPedido1() == pedidoCopia)
                    trabajador3.setPedido1(pedidoCopia);
                if (trabajador3.getPedido2() != null && trabajador3.getPedido2() == pedidoCopia)
                    trabajador3.setPedido2(pedidoCopia);
            }
            return true;
        }
        return false;
    }

    public boolean asignarPedidoATrabajador(int id, String select) {
        Pedido pedidoCopia = null;
        if (admin.getPedido1() != null && admin.getPedido1().getId() == id) pedidoCopia = admin.getPedido1();
        if (admin.getPedido2() != null && admin.getPedido2().getId() == id) pedidoCopia = admin.getPedido2();
        if (admin.getPedido3() != null && admin.getPedido3().getId() == id) pedidoCopia = admin.getPedido3();
        if (admin.getPedido4() != null && admin.getPedido4().getId() == id) pedidoCopia = admin.getPedido4();
        if (admin.getPedido5() != null && admin.getPedido5().getId() == id) pedidoCopia = admin.getPedido5();
        if (admin.getPedido6() != null && admin.getPedido6().getId() == id) pedidoCopia = admin.getPedido6();
        if (trabajador1 != null) {
            if (trabajador1.getPedido1() != null && trabajador1.getPedido1().getId() == id)
                pedidoCopia = trabajador1.getPedido1();
            if (trabajador1.getPedido2() != null && trabajador1.getPedido2().getId() == id)
                pedidoCopia = trabajador1.getPedido2();
        }
        if (trabajador2 != null) {
            if (trabajador2.getPedido1() != null && trabajador2.getPedido1().getId() == id)
                pedidoCopia = trabajador2.getPedido1();
            if (trabajador2.getPedido2() != null && trabajador2.getPedido2().getId() == id)
                pedidoCopia = trabajador2.getPedido2();
        }
        if (trabajador3 != null) {
            if (trabajador3.getPedido1() != null && trabajador3.getPedido1().getId() == id)
                pedidoCopia = trabajador3.getPedido1();
            if (trabajador3.getPedido2() != null && trabajador3.getPedido2().getId() == id)
                pedidoCopia = trabajador3.getPedido2();
        }
        if (pedidoCopia != null){
            if (admin.getPedido1() != null && admin.getPedido1() == pedidoCopia) admin.setPedido1(null);
            if (admin.getPedido2() != null && admin.getPedido2() == pedidoCopia) admin.setPedido2(null);
            if (admin.getPedido3() != null && admin.getPedido3() == pedidoCopia) admin.setPedido3(null);
            if (admin.getPedido4() != null && admin.getPedido4() == pedidoCopia) admin.setPedido4(null);
            if (admin.getPedido5() != null && admin.getPedido5() == pedidoCopia) admin.setPedido5(null);
            if (admin.getPedido6() != null && admin.getPedido6() == pedidoCopia) admin.setPedido6(null);
            if (trabajador1 != null) {
                if (trabajador1.getPedido1() != null && trabajador1.getPedido1() == pedidoCopia)
                    trabajador1.setPedido1(null);
                if (trabajador1.getPedido2() != null && trabajador1.getPedido2() == pedidoCopia)
                    trabajador1.setPedido2(null);
            }
            if (trabajador2 != null) {
                if (trabajador2.getPedido1() != null && trabajador2.getPedido1() == pedidoCopia)
                    trabajador2.setPedido1(null);
                if (trabajador2.getPedido2() != null && trabajador2.getPedido2() == pedidoCopia)
                    trabajador2.setPedido2(null);
            }
            if (trabajador3 != null) {
                if (trabajador3.getPedido1() != null && trabajador3.getPedido1() == pedidoCopia)
                    trabajador3.setPedido1(null);
                if (trabajador3.getPedido2() != null && trabajador3.getPedido2() == pedidoCopia)
                    trabajador3.setPedido2(null);
            }
        }
        if (pedidoCopia != null && !select.isEmpty()) {
            if (trabajador1 != null && trabajador1.getNombre().equals(select)){
                if (trabajador1.getPedido1() == null){
                    trabajador1.setPedido1(pedidoCopia);
                    return true;
                }
                if (trabajador1.getPedido2() == null){
                    trabajador1.setPedido2(pedidoCopia);
                    return true;
                }
            }
            if (trabajador2 != null && trabajador2.getNombre().equals(select)){
                if (trabajador2.getPedido1() == null){
                    trabajador2.setPedido1(pedidoCopia);
                    return true;
                }
                if (trabajador2.getPedido2() == null){
                    trabajador2.setPedido2(pedidoCopia);
                    return true;
                }
            }
            if (trabajador3 != null && trabajador3.getNombre().equals(select)){
                if (trabajador3.getPedido1() == null){
                    trabajador3.setPedido1(pedidoCopia);
                    return true;
                }
                if (trabajador3.getPedido2() == null){
                    trabajador3.setPedido2(pedidoCopia);
                    return true;
                }
            }

        }
        return false;
    }

    public boolean huecoTrabajadores() {
        if (trabajador1 == null) return true;
        if (trabajador2 == null) return true;
        if (trabajador3 == null) return true;
        return false;
    }

    //Comprobamos si existe la ID antes de crear el pedido
    public boolean compruebaID(int posId) {
        if (cliente1 != null){
            if (cliente1.getPedido1() != null && cliente1.getPedido1().getId() == posId) return false;
            if (cliente1.getPedido2() != null && cliente1.getPedido2().getId() == posId) return false;
        }
        if (cliente2 != null){
            if (cliente2.getPedido1() != null && cliente2.getPedido1().getId() == posId) return false;
            if (cliente2.getPedido2() != null && cliente2.getPedido2().getId() == posId) return false;

        }
        return true;
    }

    public boolean huecoCliente() {
        if (cliente1 == null) return true;
        if (cliente2 == null) return true;
        return false;
    }
}