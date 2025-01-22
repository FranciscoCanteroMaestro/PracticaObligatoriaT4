package utils;

import java.time.LocalDate;
import java.util.Scanner;

public class Utils {


    public static void limpiarPantalla(){
        for (int i = 0; i < 1000; i++) {
            System.out.println();
        }
    }
    public static void pulsaEnter(){
        Scanner sc = new Scanner(System.in);
        System.out.print("Pulsa enter para continuar ...");
        sc.nextLine();
    }

    public static boolean esDigito(String comprobar){
        if(comprobar.isEmpty()) return false;
        for (int i = 0; i < comprobar.length(); i++) {
            if (!Character.isDigit(comprobar.charAt(i))) return false;
        }
        return true;
    }

    public static int potencia(int x, int y) {
        int resultado = 1;
        for (int i = 0; i < y; i++) {
            resultado *= x;
        }

        return resultado;
    }

    public static int digitos(int num){
        int digitos = 0;
        do{
            num /= 10;
            digitos++;
        }while (num!=0);
        return digitos;
    }

    public static int numAleatorio100(int min, int max) {
        int num;
        do{
            num=(int) (Math.random()*potencia(10, digitos(max)));
        }while (num<min || num>max);
        return num;
    }


    public static float redondearDosDecimales(float decimal) {
        int pasoEntero;
        pasoEntero = (int) (decimal * 100);
        return (float) (pasoEntero) / 100;
    }

    public static String fechaAString(LocalDate fechaFormato) {
        String fecha = "";
        String fechaRecibida = String.valueOf(fechaFormato);
        for (int i = 0; i < fechaRecibida.length(); i++) {
            if((fechaRecibida.charAt(i)=='-') || (i==fechaRecibida.length()-1)){
                if (i==9) i++;
                for (int j = i-1; j > -1; j--) {
                    if (fechaRecibida.charAt(j) != '-') fecha = fechaRecibida.charAt(j) + fecha;
                    else{
                        j = -1;
                    }
                }
                if (i!=10 && fechaRecibida.charAt(i)=='-') fecha = '/' + fecha;
            }

        }
        return fecha;
    }

    public static LocalDate stringAFecha(String fecha) {
        LocalDate localDate;
        String fechaFormato = "";
        for (int i = 0; i < fecha.length(); i++) {
            if((fecha.charAt(i)=='/') || (i==fecha.length()-1)){
                if (i==9) i++;
                for (int j = i-1; j > -1; j--) {
                    if (fecha.charAt(j) != '/') fechaFormato = fecha.charAt(j) + fechaFormato;
                    else{
                        j = -1;
                    }
                }
                if (i!=10 && fecha.charAt(i)=='/') fechaFormato = '-' + fechaFormato;
            }

        }
        localDate = LocalDate.parse(fechaFormato);

        return localDate;
    }

    public static boolean validaTelefono(String introTelefono) {
        if (introTelefono.length()!=9) return false;
        return esDigito(introTelefono);
    }

    public static boolean validaCorreo(String introCorreo) {
        return (introCorreo.endsWith("@gmail.com")) || (introCorreo.endsWith("@gmail.es"));
    }
}