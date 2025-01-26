package org.example;

import Communications.Email;
import models.*;
import utils.Menu;
import utils.Utils;

import java.util.Locale;
import java.util.Scanner;

public class Main {
    public final static Scanner SC = new Scanner(System.in);
    public static void main(String[] args) {
        Tienda tienda = new Tienda();
        String user = "", clave = "", logueo = "";
        int op;
        String select;

        //Creamos usuarios MOCK

        tienda.mock(tienda);
        //tienda.envioTelegramo();

        //Empieza el programa
        do{
            Menu.logo();
            op = 0;
            System.out.print("""
                ================= BIENVENIDO ===================
                                      A
                                  FERNANSHOP
                ________________________________________________
                
                1. Iniciar Sesión
                2. Registrarte
                
                Ingresas la opción que desee:\s""");
            try{
                op = Integer.parseInt(SC.nextLine());
            }catch (NumberFormatException e) {
                System.out.println("Error, ingresa un numero.");
                Utils.pulsaEnter();
                Utils.limpiarPantalla();
            }
            if (op != 0 ){
                switch (op){
                    case 1:
                        System.out.print("Ingresa usuario: ");
                        user = SC.nextLine();
                        System.out.print("Ingresa contraseña: ");
                        clave = SC.nextLine();
                        Object obj = (tienda.login(user,clave));
                        if (obj == null){
                            System.out.println("ERROR EN EL LOGUEO");
                            Utils.pulsaEnter();
                        }
                        if (obj instanceof Admin){
                            do {
                                Utils.limpiarPantalla();
                                Menu.menuAdmin(tienda);
                                select = SC.nextLine();
                                if (!Utils.esDigito(select)) {
                                    System.out.println("Opcion no valida");
                                    Utils.pulsaEnter();
                                } else {
                                    op = Integer.parseInt(select);
                                    switch (op) {
                                        case 1:
                                            Utils.limpiarPantalla();
                                            if(tienda.cantidadPedidosAdmin()>0){
                                                System.out.println(tienda.pintaPedidos());
                                                System.out.print("Introduce el ID del producto que deseas modificar: ");
                                                select = SC.nextLine();
                                                if (!Utils.esDigito(select)) System.out.println("La opción introducida no es válida");
                                                else {
                                                    int id = Integer.parseInt(select);
                                                    System.out.println(tienda.pintaTrabajadores());
                                                    System.out.print("Introduce el nombre del trabajador que desees asignarle el pedido: ");
                                                    select = SC.nextLine();
                                                    tienda.asignarPedidoATrabajador(id, select);
                                                }
                                            }
                                            else{
                                                System.out.print("No tienes pedidos por asignar.");
                                            }
                                            Utils.pulsaEnter();
                                            break;
                                        case 2:
                                            Utils.limpiarPantalla();
                                            System.out.println(tienda.pintaPedidos());
                                            System.out.print("Introduce el ID del producto que deseas modificar: ");
                                            select = SC.nextLine();
                                            if (!Utils.esDigito(select)) System.out.println("La opción introducida no es válida");
                                            else {
                                                int id = Integer.parseInt(select);
                                                Menu.menuModificarPedidoAdmin(id, tienda);
                                            }
                                            Utils.pulsaEnter();
                                            break;
                                        case 3:
                                            Utils.limpiarPantalla();
                                            if (tienda.huecoTrabajadores()){
                                                System.out.print("Ingresa nombre: ");
                                                String nombre = SC.nextLine();
                                                System.out.print("Ingresa tu dirección: ");
                                                String direccion = SC.nextLine();
                                                System.out.print("Ingresa tu localidad: ");
                                                String localidad = SC.nextLine();
                                                System.out.print("Ingresa la provincia: ");
                                                String provincia = SC.nextLine();
                                                System.out.print("Ingresa tu telefono de contacto: ");
                                                String introTelefono = SC.nextLine();
                                                System.out.print("Ingresa tu correo: ");
                                                String introCorreo = SC.nextLine();
                                                System.out.print("Ingresa usuario: ");
                                                user = SC.nextLine();
                                                System.out.print("Ingresa tu contraseña: ");
                                                clave = SC.nextLine();
                                                int id = Tienda.generaId(tienda);
                                                System.out.println((tienda.altaTrabajador(nombre, direccion, localidad, provincia, introTelefono, introCorreo, user, clave, id))
                                                        ? "Exito al registrarse"
                                                        : "Fallo al registrarse");
                                            }
                                            else System.out.println("No se pueden agregar más trabajadores en estos momentos.");
                                            Utils.pulsaEnter();
                                            break;
                                        case 4:
                                            Utils.limpiarPantalla();
                                            System.out.println(tienda.pintaPedidos());
                                            Utils.pulsaEnter();
                                            break;
                                        case 5:
                                            Utils.limpiarPantalla();
                                            System.out.println(tienda.pintaClientes());
                                            Utils.pulsaEnter();
                                            break;
                                        case 06:
                                            Utils.limpiarPantalla();
                                            System.out.println("====================================");
                                            System.out.println(tienda.pintaTrabajadores());
                                            System.out.println("====================================");
                                            Utils.pulsaEnter();
                                            break;
                                        case 7:
                                            System.out.println("Cerrando sesión...");
                                            break;
                                        default:
                                            System.out.println("Opción no válida");
                                    }
                                }
                            } while (op != 7);

                        }
                        if (obj instanceof Trabajador){
                            Trabajador trabajadorCopia = (Trabajador)obj;
                            Menu.menuTrabajador(tienda, trabajadorCopia);
                        }
                        if (obj instanceof Cliente) {
                            Cliente clienteCopia = (Cliente)obj;
                            int idCliente = clienteCopia.getId();
                            int opc = -1;
                            do {
                                Utils.limpiarPantalla();
                                Menu.menuCliente(tienda, clienteCopia);
                                try{
                                    opc = Integer.parseInt(SC.nextLine());
                                } catch (NumberFormatException e) {
                                    System.out.println("ERROR. INTRODUZCA UN NUMERO.");
                                    Utils.pulsaEnter();
                                }
                                switch (opc) {
                                    case 1:
                                        Menu.menuProductosParaPedidos(tienda);
                                        Utils.pulsaEnter();
                                        Utils.limpiarPantalla();
                                        break;
                                    case 2:
                                        Pedido pedidoNuevo = new Pedido(clienteCopia, tienda);
                                        int cantidad;
                                        int idProducto = -1;
                                        boolean idCorrecta = true;
                                        if (clienteCopia.getPedido1() != null && clienteCopia.getPedido2() != null) {
                                            System.out.print("No se pueden realizar más pedidos");
                                        }
                                        else {
                                            Utils.limpiarPantalla();
                                            do {
                                                idCorrecta=true;
                                                cantidad = 0;
                                                idProducto = -1;
                                                Menu.menuProductosParaPedidos(tienda);
                                                System.out.print("""
                                    
                                                 Introduce un 0 si no quieres cuando quiera parar de añadir productos: \s""");
                                                try{
                                                    idProducto = Integer.parseInt(SC.nextLine());
                                                }catch (NumberFormatException e){
                                                    System.out.println("Error. no se ha introducido un numero de id");
                                                    idCorrecta = false;
                                                }
                                                if (idCorrecta && idProducto > 0) {
                                                    if (pedidoNuevo.hayHuecoProductos()) {
                                                        System.out.print("¿Cuantas unidades del producto desea? ");
                                                        try{
                                                            cantidad = Integer.parseInt(SC.nextLine());
                                                        }catch (NumberFormatException e){
                                                            System.out.println("Error. No se introdujo una cantidad aceptable");
                                                        }
                                                        if (cantidad > 0){
                                                            System.out.println(tienda.realizaPedidoCliente(idProducto, pedidoNuevo, cantidad) ? "Producto añadido" : "No hay Stock suficiente.");
                                                            Utils.pulsaEnter();
                                                        }
                                                        else{
                                                            System.out.println("Cantidad no aceptada");
                                                            Utils.pulsaEnter();
                                                        }
                                                    } else {
                                                        if (!pedidoNuevo.comprobarContenidoPedido(idProducto)){
                                                            System.out.println("No puede añadir más productos aunque puede añadir más cantidad a los ya elegidos");
                                                            Utils.pulsaEnter();
                                                        }
                                                        else {
                                                            System.out.print("¿Cuantas unidades del producto desea? ");
                                                            cantidad = Integer.parseInt(SC.nextLine());
                                                            if (cantidad != 0){
                                                                System.out.println(tienda.realizaPedidoCliente(idProducto, pedidoNuevo, cantidad) ? "Producto añadido" : "No hay Stock suficiente.");
                                                                Utils.pulsaEnter();
                                                            }
                                                        }
                                                    }
                                                }
                                                Utils.limpiarPantalla();
                                                System.out.println(clienteCopia.pintaCarrito(pedidoNuevo));
                                            } while (idProducto != 0);
                                            String terminarPedido;
                                            do {
                                                terminarPedido = pedirDatos("¿Desea guardar el pedido? (S/N)");
                                            } while (!terminarPedido.equalsIgnoreCase("S") && !terminarPedido.equalsIgnoreCase("N"));
                                            if (terminarPedido.equalsIgnoreCase("S")){
                                                clienteCopia.guardarPedido(pedidoNuevo, clienteCopia);
                                                tienda.asignarPedido(pedidoNuevo);
                                            }
                                            if (terminarPedido.equalsIgnoreCase("N")) pedidoNuevo = null;
                                        }
                                        Utils.pulsaEnter();
                                        Utils.limpiarPantalla();
                                        break;
                                    case 3:
                                        System.out.println(tienda.pintaPedidosCliente(clienteCopia));
                                        Utils.pulsaEnter();
                                        Utils.limpiarPantalla();
                                        break;
                                    case 4:
                                        System.out.println(tienda.pintaDatosCliente(clienteCopia));
                                        Utils.pulsaEnter();
                                        Utils.limpiarPantalla();
                                        break;
                                    case 5:
                                        String datoNuevo = "";
                                        int modificar;
                                        do {
                                            Menu.menuModificarPerfil();
                                            modificar = Integer.parseInt(SC.nextLine());
                                            if (modificar != 9) {
                                                System.out.print("Introduce el nuevo dato: ");
                                                datoNuevo = SC.nextLine();
                                                System.out.println(tienda.modificarDatoCliente(modificar, datoNuevo, clienteCopia)
                                                        ? "Modificación realizada con exito"
                                                        : "Error al realizar modificación");
                                            } else System.out.println("Error al realizar modificación");
                                            Utils.pulsaEnter();
                                            Utils.limpiarPantalla();
                                        } while (modificar != 9);
                                        break;
                                    case 6:
                                        System.out.print("Gracias por usar FERNANSHOP :D\n");
                                        tienda.cierraSesionCliente(clienteCopia, idCliente);
                                        Utils.pulsaEnter();
                                        Utils.limpiarPantalla();
                                        break;
                                    default:
                                        System.out.println("Error, opción no valida.");
                                        break;
                                }
                            } while (opc != 6);
                        }
                        break;
                    case 2:
                        if (!tienda.huecoCliente())
                            System.out.println("No podemos albergar más clientes en estos momentos. ");
                            else {
                            String nombre = pedirDatos("Ingresa nombre: ");
                            String direccion = pedirDatos("Ingresa tu dirección: ");
                            String localidad = pedirDatos("Ingresa tu localidad: ");
                            String provincia = pedirDatos("Ingresa la provincia: ");
                            String introTelefono;
                            do{
                                introTelefono = pedirDatos("Ingresa tu telefono de contacto: ");
                            } while(!Utils.validaTelefono(introTelefono));
                            int telefono = Integer.parseInt(introTelefono);
                            String introCorreo;
                            do{
                                introCorreo = pedirDatos("Ingresa tu correo: ");
                            }while (!Utils.validaCorreo(introCorreo));
                            user = pedirDatos("Ingresa usuario: ");
                            clave = pedirDatos("Ingresa tu contraseña: ");
                            int id = tienda.generaId(tienda);
                            System.out.println((tienda.registroCliente(id, nombre, direccion, localidad, provincia, telefono, introCorreo, user, clave, tienda))
                                    ? "Exito al registrarse"
                                    : "Fallo al registrarse");
                            String token = generarToken();

                        }
                        break;
                    default:
                        break;
                };
            }
        }while (true);
    }

    private static String generarToken() {
        String token = "";
        String nums = "1234567890";
        String carEspe =".:!$%&/()=*+-_";
        String letras ="abcdefghijklmnopqrstuvwxyz";
        for (int i = 0; i < 10; i++) {
            switch ((int)(Math.random()*4)){
                case 0-> token += carEspe.charAt(Utils.numAleatorio100(0,( carEspe.length())-1));
                case 1-> token += nums.charAt(Utils.numAleatorio100(0,nums.length()-1));
                case 2-> token += letras.charAt(Utils.numAleatorio100(0,letras.length()-1));
                case 3-> token += letras.toUpperCase().charAt(Utils.numAleatorio100(0,letras.length()-1));
            };
        }
        return token;
    }

    private static String pedirDatos(String mensaje) {
        String dato;
        System.out.print(mensaje);
        dato = SC.nextLine();
        return dato;
    }
}