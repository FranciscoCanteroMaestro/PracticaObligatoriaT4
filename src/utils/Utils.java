package utils;

import java.util.Scanner;

public class Utils {

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
}