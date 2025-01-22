package Communications;

import jakarta.mail.Authenticator;
import jakarta.mail.Message;
import jakarta.mail.PasswordAuthentication;
import jakarta.mail.Session;
import jakarta.mail.internet.InternetAddress;
import jakarta.mail.internet.MimeMessage;

import java.util.Properties;

import static jakarta.mail.Transport.send;

public class Email {
    public static final String host = "smtp.gmail.com";

    private static final String user = "don.92.ald@gmail.com";

    private static final String pass = "lqnj bjvx itud khdx";

    public static boolean enviarVerificacionEmailRegistro(String destino, String asunto, String mensaje){
        String contenido;

        // Creamos nuestra variable de propiedades con los datos de nuestro servidor de correo
        Properties props = new Properties();
        props.put("mail.smtp.auth","true");
        props.put("mail.smtp.starttls.enable","true");
        props.put("mail.smtp.host", host);
        props.put("mail.smtp.socketFactory.port","465");
        props.put("mail.smtp.socketFactor.class","javax.net.ssl.SSLSocketFactory");

        // Obtenemos la sesión en nuestro servidor de correo
        Session session = Session.getInstance(props, new Authenticator() {
            @Override
            protected PasswordAuthentication getPasswordAuthentication() {
                return new PasswordAuthentication(user, pass);
            }
        });


        try{
            //Creamos un mensaje de correo por defecto
            Message message = new MimeMessage(session);

            // En el mensaje, establecemos el receptor
            message.setRecipients(Message.RecipientType.TO, InternetAddress.parse(destino));

            //Establecemos el Asunto
            message.setSubject(asunto);

            // Añadimos el contenido del mensaje
            message.setContent(mensaje, "text/html; charset=utf-8");

            //Intentamos mandar el mensaje
            send(message);
        }catch (Exception e) { //Si entra aqui hemos tenido fallo
            throw new RuntimeException(e);
        }
        return true;
    }
}
