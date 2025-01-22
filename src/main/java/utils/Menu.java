package utils;
import models.*;
import org.w3c.dom.html.HTMLImageElement;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Scanner;

public class Menu {
    public static Scanner sc = new Scanner(System.in);

    public static void logo(){
        System.out.print("""
                                ::::::::::::::::----------------------------------------------------------------------::::::::::::::
                                :::::::::::-=**########################################################################*+=::::::::::
                                ::::::::+%*:..................:-:. .........::::...........::............::::::::::.......-#%=::::::
                                :-----:+%=.......#= .......:+%%#%%+......:*%%###*:......=#%##%%###################%####%+...+@=:::::
                                ------*%:......=@@@*......-@%*++=-#%....:@#+++==*@:...:%%+=:-@#------------------=@+---%*....:%+::::
                                ------##......*@: .*%:....-@#+++++#%+-..:%%**+++*@-...:%%#*+*@#------------------=@+---%#.....%#::::
                                ------##.....-@+--:=%*....-@#*#@++%#%%..:%%+++++*%-...:%#=---@#------------------=@+---%#.....%#::::
                                ------##....-@#+=%*:=@+...-@#=*@=-%=*%...%#-=@+.+%:...:%#==-=@#------------------=@+---%#.....##::::
                                ------#%....-@*==%*:-@=...-@#=*@=-%=*#...%#-=%+.+%:...:%#==-=@#------------------=@+---%#.....%#::::
                                ------#%....-@#==%*:=@=...-@#=*@=-%%%=...%#-=%+.+%:...:%#==-=@#------------------=@+---%#.....%#::::
                                ------##....-@#==%*:=@=...-@#=*@=-##....:%#-=%+:*%:...:%#==-=@#------------------=@+---%#.....##::::
                                ------##....-@*==%*:=@=...-@*=*@=-##....:%#-=%+:*%:...:%#==-=@#------------------=@+---%#.....##::::
                                ------##....=@#*****#@=...:@#=*@+:##....:%#-=%+.*%:...:%#==-=@#------------------+@+---%#.....##::::
                                ------##....-@*+++++*@+....*@#:.-*@*....:%%##%##%%:...:%##%##@%##################%@%###@%-....##::::
                                ------##....-@#***+=+@+....:#%- :%*......#@+--::##....:%@*=====++++++++++++++==%@+@#+**--:....##::::
                                ------#%.....:*%###%#-........*@+.........:*%#%#:......:*#****#@%*************+#@%@%##%@*.....##::::
                                ------#%.....................................................:%%#.............................##::::
                                ------#%......................................................:::.............................##::::
                                ------##...=%###+.=%###+..*#*#*:..=#: .*+....**....+#: .#+..:*##*-..*+..-#-..=###*:..*###*:...##::::
                                ------##...+@++=..=@*++...%#-=#*..+%#%-%*...%*+%:..+@%%-%+..=##+-...%%++#@- -@- .##..%#-=%*...##::::
                                ------##...+@+=-..=@=--...%%+@#...+%:*@@*..=@+=@+..+%:#%@+ . .:=%*..#%--+@- -@- .#*..%%*+=....##::::
                                ------##...-*:....-****+..+=..=*:.-+:..==.:*:. :*:.=+...+=..:+**=...++..:*:..:+**-...+=.......##::::
                                ------##..................................................... ................ ...............##::::
                                ------#%**************************************************************************************%#::::
                                -----=#%-::::+*******+::::::::::::::::::::::::::::::::::::::::::::::::::::::::::-*#####*-:::::%#::::
                                -----=#%::::*#+++++++##-:::--:==:-:-==--:=-:--:==:=----:::-:::==:-+:-=:--:--:::+%*--*:-+%+::::%#::::
                                ------+@+::-@*+++++++*@=:::=*=:=:++:+.:+:++-+*-*+:++:=-::+*+:.+#--+:=*-*+:+*:::%#---#=-:##:::=@+::::
                                -------=#%+::-+*###*+=::::::::::::::::::::::::::::::::::::::::::::::::::::::::::-+#####+:::=%#-:::::
                                --------=*%#+-:::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::=#%+:::::::
                                -------------=++*************************************************+++++++++++++++++**+++=--::::::::::
                """);
    }

    public static void menuAdmin(Tienda tienda) {
            Utils.limpiarPantalla();
            System.out.print("FERNANSHOP\n" +
                    "Bienvenido Admin. Tiene " + tienda.cantidadPedidosAdmin() + " pedidos por asignar\n" +
                    "1.- Asignar un pedido a un trabajador\n" +
                    "2.- Modificar el estado de un pedido\n" +
                    "3.- Dar de alta a un trabajador\n" +
                    "4.- Ver todos los pedidos\n" +
                    "5.- Ver todos los clientes\n" +
                    "6.- Ver todos los trabajadores\n" +
                    "7.- Cerrar sesión\n" +
                    "Introduce la opción deseada:\s"
            );
    }

    public static void menuModificarPedidoAdmin(int id, Tienda tienda) {
        String select;
        int op = -1;
        do {
            System.out.print("""
                    Elige el parámetro que deseas modificar
                    
                    1.- Dirección del envio
                    2.- Estado del pedido
                    3.- Fecha de entrega
                    4.- Añadir comentario
                    0.- Salir
                    """);
            select = sc.nextLine();
            if (!Utils.esDigito(select)) System.out.println("La opción introducida no es válida");
            else {
                op = Integer.parseInt(select);
                if (op != 0) {
                    switch (op) {
                        case 1:
                            String direccion = "", localidad = "", provincia = "";
                            System.out.print("Introduce la nueva dirección: ");
                            direccion = sc.nextLine();
                            System.out.println("Introduce la nueva localidad (Si no es nueva pulsa ENTER)");
                            localidad = sc.nextLine();
                            if (!localidad.isEmpty()) {
                                System.out.println("Introduce la nueva provincia (Si no es nueva pulsa ENTER)");
                                provincia = sc.nextLine();
                            }
                            System.out.println(tienda.modificarDireccionPedido(id, direccion, localidad, provincia)
                                    ? "Nueva dirección introducida"
                                    : "No se ha podido realizar la modificación");
                            break;
                        case 2:
                            int opc = -1;
                            System.out.println("Introduce el nuevo estado del pedido:");
                            select = sc.nextLine();
                            System.out.println(tienda.modificarEstadoPedido(id, select)
                                    ? "Nuevo estado introducido"
                                    : "No se ha podido realizar la modificación");
                            break;
                        case 3:
                            System.out.println("Introduce la nueva fecha de entrega del pedido (formato yyyy-mm-dd): ");
                            select = sc.nextLine();
                            System.out.println(tienda.modificarFechaEntregaPedido(id, select)
                                    ? "Modificada la fecha de entrega"
                                    : "No se ha podido realizar la modificación");
                            break;
                        case 4:
                            System.out.println("Introduce el nuevo comentario del pedido: ");
                            select = sc.nextLine();
                            System.out.println(tienda.modificarComentarioPedido(id, select)
                                    ? "Nuevo comentario introducido"
                                    : "No se ha podido realizar la modificación");
                            break;
                        default:
                            System.out.println("La opción introducida no es válida");
                            break;
                    }
                }
            }
        } while (op != 0);

    }

    public static void menuTrabajador(Tienda tienda, Trabajador trabajadorCopia) {
        int op = 0;
        String select;
        do {
            Utils.limpiarPantalla();
            System.out.print("FERNANSHOP\n" +
                    "Bienvenido " + tienda.pintaNombreTrabajador(trabajadorCopia) + ". Tienes " + Tienda.cantidadPedidosTrabajador(trabajadorCopia) + " pedidos por gestionar\n" +
                    "1.- Consultar los pedidos que tengo asignados\n" +
                    "2.- Modificar el estado de un pedido\n" +
                    "3.- Consultar el catálogo de productos\n" +
                    "4.- Modificar un producto del catalogo\n" +
                    "5.- Ver mi perfil\n" +
                    "6.- Modificar mis datos personales\n" +
                    "7.- Cerrar sesión\n" +
                    "Introduce la opción deseada:\s");
            select = sc.nextLine();
            if (!Utils.esDigito(select)) {
                System.out.println("opcion no valida");
                Utils.pulsaEnter();
            } else {

                op = Integer.parseInt(select);
                switch (op) {
                    case 1:
                        Utils.limpiarPantalla();
                        System.out.println(tienda.pintaPedidosTrabajador(trabajadorCopia));
                        Utils.pulsaEnter();
                        break;
                    case 2:
                        Utils.limpiarPantalla();
                        menuPedidosTrabajador(tienda, trabajadorCopia);
                        Utils.pulsaEnter();
                        break;
                    case 3:
                        Utils.limpiarPantalla();
                        System.out.println(tienda.pintaProductosConStock());
                        Utils.pulsaEnter();
                        break;
                    case 4:
                        Utils.limpiarPantalla();
                        selecionProductoModificar(tienda);
                        Utils.pulsaEnter();
                        break;
                    case 5:
                        Utils.limpiarPantalla();
                        System.out.println(tienda.pintaDatosTrabajador(trabajadorCopia));
                        Utils.pulsaEnter();
                        break;
                    case 6:
                        String datoNuevo = "";
                        int modificar;
                        do {
                            menuModificarPerfil();
                            modificar = Integer.parseInt(sc.nextLine());
                            if (modificar != 9) {
                                System.out.print("Introduce el nuevo dato: ");
                                datoNuevo = sc.nextLine();
                                System.out.println(tienda.modificarDatoTrabajador(modificar, datoNuevo, trabajadorCopia)
                                        ? "Modificación realizada con exito"
                                        : "Error al realizar modificación");
                            } else System.out.println("Error al realizar modificación");
                            Utils.pulsaEnter();
                            Utils.limpiarPantalla();
                        } while (modificar != 9);
                        break;
                    case 7:
                        //tienda.cierraSesionTrabajador(trabajadorCopia, user);
                        System.out.print("\n\nGracias por usar FERNANSHOP :D\n");
                        Utils.pulsaEnter();
                        Utils.limpiarPantalla();
                        break;
                    default:
                }
            }
        } while (op != 7);
    }

    private static void menuPedidosTrabajador(Tienda tienda, Trabajador trabajadorCopia) {
        String select = "";
        int op = -1;
        if (trabajadorCopia.getPedido1() == null && trabajadorCopia.getPedido2() == null) {
            System.out.println("""
                    ====================================
                    
                    No tienes pedidos asignados
                    
                    =====================================""");
        } else {
            do {
                System.out.printf("""
                        ===============================
                        %s
                        
                        Pulsa 0 para salir
                        
                        Elige el ID sobre el que quieres trabajar:\s """, tienda.pintaPedidosAsignados(trabajadorCopia));
                select = sc.nextLine();
                if (Utils.esDigito(select)) {
                    op = Integer.parseInt(select);
                    Pedido pedidoCopia = null;
                    if (trabajadorCopia.getPedido1() != null && op == trabajadorCopia.getPedido1().getId())
                        pedidoCopia = trabajadorCopia.getPedido1();
                    if (trabajadorCopia.getPedido2() != null && op == trabajadorCopia.getPedido2().getId())
                        pedidoCopia = trabajadorCopia.getPedido2();
                    if (pedidoCopia != null) menuModificarPedido(tienda, trabajadorCopia, pedidoCopia);
                    else {
                        if (op != 0) System.out.println("Opción no valida");
                    }
                    //if (trabajadorCopia.getPedido1() != null && pedidoCopia.getId() == trabajadorCopia.getPedido1().getId)
                } else System.out.println("Opción no valida");
            } while (op != 0);
        }
    }

    private static void menuModificarPedido(Tienda tienda, Trabajador trabajadorCopia, Pedido pedidoCopia) {
        Utils.limpiarPantalla();
        String select;
        String datoNuevo;
        int op = 0;
        do {

            System.out.printf("""
                    ============== ID pedido: %d ===============
                    
                    1. Modificar el estado del pedido.
                    2. Añadir un comentario.
                    3. Cambiar fecha de entrega.
                    
                    0. Dejar de modificar.
                    
                    Selecciona la opción deseada: \s""", pedidoCopia.getId());
            select = sc.nextLine();
            if (Utils.esDigito(select)) {
                op = Integer.parseInt(select);
                if (op != 0 && op < 4) {
                    if (op == 1) {
                        int opc = -1;
                        do {
                            System.out.print("""
                                    ==============Modificar estado de un pedido==============
                                    
                                    1. Recibido.
                                    2. En preparación.
                                    3. Retrasado.
                                    4. Cancelado.
                                    5. Enviado.
                                    
                                    0. Salir.
                                    
                                    =========================================================
                                    Introduzca el nuevo estado: 
                                    """);
                            select = sc.nextLine();
                            if (!Utils.esDigito(select)) System.out.println("La opción introducida no es válida");
                            else {
                                opc = Integer.parseInt(select);
                                if (opc != 0) {
                                    switch (opc) {
                                        case 1:
                                            pedidoCopia.setEstado("Recibido");
                                            System.out.println("Se modificó el estado satisfactoriamente");
                                            break;
                                        case 2:
                                            pedidoCopia.setEstado("En preparación");
                                            System.out.println("Se modificó el estado satisfactoriamente");
                                            break;
                                        case 3:
                                            pedidoCopia.setEstado("Retrasado");
                                            System.out.println("Se modificó el estado satisfactoriamente");
                                            break;
                                        case 4:
                                            pedidoCopia.setEstado("Cancelado");
                                            System.out.println("Se modificó el estado satisfactoriamente");
                                            break;
                                        case 5:
                                            pedidoCopia.setEstado("Enviado");
                                            System.out.println("Se modificó el estado satisfactoriamente");
                                            break;
                                        default:
                                            System.out.println("La opción introducida no es válida");
                                            break;
                                    }
                                }
                            }

                        }while (opc > 5 || opc < 0);
                    }
                    if (op == 2) {
                        System.out.println("Introduce el comentario que quieres añadir:");
                        datoNuevo = sc.nextLine();
                        System.out.println(trabajadorCopia.modificarPedido(op, datoNuevo, pedidoCopia)
                                ? "Comentario añadido"
                                : "No se pudo añadir el comentario");
                    }
                    if (op == 3){
                        System.out.print("Introduce la nueva fecha de entrega (formato yyyy-mm-dd): ");
                        LocalDate fecha = LocalDate.from(LocalDateTime.parse(sc.nextLine()));
                        pedidoCopia.setFechaEntregaEstimada(fecha);
                    }
                }
            } else System.out.println("Opción no valida.");
        } while (op != 0);
    }

    public static void menuCliente(Tienda tienda, Cliente clienteCopia) {
        System.out.print("FERNANSHOP\n" +
                "Bienvenido " + tienda.pintaNombreCliente(clienteCopia) + ".\n" +
                "1.- Consultar catalogo de productos\n" +
                "2.- Realizar un pedido\n" +
                "3.- Ver mis pedidos realizados\n" +
                "4.- Ver mis datos personales\n" +
                "5.- Modificar mis datos personales\n" +
                "6.- Cerrar sesión\n" +
                "Introduce la opción deseada:\s");
    }


    //Menus internos
    public static void menuModificarPerfil() {
        System.out.print("""
                =========================\n
                1. Nombre
                2. Dirección
                3. Localidad
                4. Provincia
                5. Telefono
                6. Correo
                7. Usuario
                8. Contraseña
                9. Salir
                ¿Que datos quieres modificar?\s""");
    }

    private static void selecionProductoModificar(Tienda tienda) {
        int selectProducto = 0;
        String select;
        do {
            System.out.println(tienda.pintaProductosConStock());
            System.out.print("Selecciona el producto que deseas modificar o O para salir: ");
            select = sc.nextLine();
            if (Utils.esDigito(select)) selectProducto = Integer.parseInt(select);
            else System.out.println("opcion no valida");
            if (selectProducto != 0 && selectProducto < 6 && Utils.esDigito(select))
                seleccionDatosProducto(tienda, selectProducto);
        } while (selectProducto != 0);
    }

    private static void seleccionDatosProducto(Tienda tienda, int selectProducto) {
        int modificar = 0;
        String select, datoNuevo;
        do {
            System.out.print("""
                    1. Nombre producto.
                    2. Precio producto
                    3. Cantidad de stock del producto
                    
                    0. Salir
                    
                    Seleccione el dato que desea modificar.""");
            select = sc.nextLine();
            if (Utils.esDigito(select)) modificar = Integer.parseInt(select);
            else System.out.println("opcion no valida");
            if (modificar != 0 && modificar < 4 && Utils.esDigito(select)) {
                System.out.print("¿Cual es el nuevo dato? ");
                datoNuevo = sc.nextLine();
                tienda.modificarDatosProducto(modificar, selectProducto, datoNuevo);
                modificar = 0;
            }
        } while (modificar != 0);
    }

    public static void menuProductosParaPedidos(Tienda tienda) {
        System.out.println(tienda.pintaProductosSinStock());
    }
}
