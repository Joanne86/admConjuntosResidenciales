package co.edu.uan.envioCorreoProxy;

import java.util.Properties;

import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.AddressException;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

import co.edu.uan.entidad.Propietario;

public class EnvioCorreo implements Correo {

	@Override
	public boolean enviarCorreo(Propietario prop) {
		try {
            Properties props = new Properties();
            props.setProperty("mail.smtp.host", "smtp.gmail.com");
            props.setProperty("mail.smtp.starttls.enable", "true");
            props.setProperty("mail.smtp.port", "587");
            props.setProperty("mail.smtp.auth", "true");

            Session session = Session.getDefaultInstance(props);

            String correoRemitente = "leidyjoanne86@gmail.com";
            String passwordRemitente = "6835820gaga";
            String correoReceptor = prop.getCorreo();
            String asunto = "Usuario y contraseña del conjunto residencial";
            String mensaje = "Hola<br>Hola "+prop.getNombre()+", su usuario y contraseña son:<br> usuario:"+prop.getLogin().getUsuario()+" "
            		+ " y contraseña: "+prop.getLogin().getContraseña()+"<br><br>Por <b>Software conjunto residencial</b>";

            MimeMessage message = new MimeMessage(session);
            message.setFrom(new InternetAddress(correoRemitente));

            message.addRecipient(Message.RecipientType.TO, new InternetAddress(correoReceptor));
            message.setSubject(asunto);
            message.setText(mensaje, "ISO-8859-1", "html");

            Transport t = session.getTransport("smtp");
            t.connect(correoRemitente, passwordRemitente);
            t.sendMessage(message, message.getRecipients(Message.RecipientType.TO));
            t.close();
            
            return true;     
        } catch (AddressException ex) {
        	return false;
        } catch (MessagingException ex) {
        	return false;
        }
	}

}
