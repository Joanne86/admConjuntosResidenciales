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
import co.edu.uan.entidad.Servicio;
import co.edu.uan.util.PropertiesUtil;

public class EnvioCorreo implements Correo {
	 private static final String DB_PROPERTIES = "Correo.properties";

	    //Propiedades de los archivos properties
	    private static final String DB_EMAIL_PROP = "correo";
	    private static final String DB_PASSWORD_PROP = "contraseña";

	@Override
	public boolean enviarCorreoResidente(Propietario prop) {
		try {
            Properties props = new Properties();
            props.setProperty("mail.smtp.host", "smtp.gmail.com");
            props.setProperty("mail.smtp.starttls.enable", "true");
            props.setProperty("mail.smtp.port", "587");
            props.setProperty("mail.smtp.auth", "true");

            Session session = Session.getDefaultInstance(props);

            
            Properties admin = PropertiesUtil.loadProperty(DB_PROPERTIES);
            String correoRemitente = admin.getProperty(DB_EMAIL_PROP);
            String passwordRemitente = admin.getProperty(DB_PASSWORD_PROP);

            System.out.println(correoRemitente);
            System.out.println(passwordRemitente);
            
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
        	System.out.println(ex.getMessage());
        	return false;
        } catch (MessagingException ex) {
        	System.out.println(ex.getMessage());
        	return false;
        }
	}

	@Override
	public boolean enviarCorreoPServicio(Servicio servicio) {
		try {
            Properties props = new Properties();
            props.setProperty("mail.smtp.host", "smtp.gmail.com");
            props.setProperty("mail.smtp.starttls.enable", "true");
            props.setProperty("mail.smtp.port", "587");
            props.setProperty("mail.smtp.auth", "true");

            Session session = Session.getDefaultInstance(props);

            Properties admin = PropertiesUtil.loadProperty(DB_PROPERTIES);
            String correoRemitente = admin.getProperty(DB_EMAIL_PROP);
            String passwordRemitente = admin.getProperty(DB_PASSWORD_PROP);
            String correoReceptor = servicio.getCorreo();
            String asunto = "Horario personal de servicio del conjunto residencial UANconjuntos";
            String mensaje = "Hola<br>Hola "+servicio.getNombre()+", su servicio y horario son:<br> servicio:"+servicio.getServicio()+" "
            		+ " y horario: "+servicio.getHorario()+"<br><br>Por <b>Software conjunto residencial</b>";

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
