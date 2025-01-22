package Communications;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.URL;
import java.net.URLConnection;
import java.nio.Buffer;

public class Telegram {
    static final String TOKEN = "8148816360:AAFfRln6xCZWwRAkqaCD5jLHnY_NOvvaet8";

    public static boolean enviarMensajeTelegram(String mensaje){
        String direccion;
        String fijo="https://api.telegram.org/bot" + TOKEN + "/sendMessage?chat_id=5794559438&text=";
        direccion=fijo+mensaje;
        URL url;
        boolean dev = false;
        try{
            url = new URL(direccion);
            URLConnection con = url.openConnection();
            BufferedReader in = new BufferedReader(new InputStreamReader(con.getInputStream()));
            dev=true;
        }catch (IOException e){
            System.out.println(e.getMessage());
        }
        return dev;
    }
}
