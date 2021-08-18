package com.jaguaresdeveloper;

import java.io.IOException;
import java.io.OutputStream;
import java.io.Serializable;
import java.util.Properties;
import javax.activation.DataHandler;
import javax.activation.FileDataSource;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.mail.*;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import javax.swing.*;

@ManagedBean(name = "user")
@SessionScoped
public class UserBean implements Serializable{

    private String correo = "";
    private String password = "";

    /*public String login(){
        if(correo.length().equals("correo") && password.length().equals("contra")){
        
        } else {

        }
    }*/ /* <- Validacion de los datos dentro de los beans*/

    private String getCorreo(){
        return correo;
    }

    private void setCorreo(String correo){
        this.correo = correo;
    }

    private String getPassword(){
        return password;
    }

    private void setPassword(String password){
        this.password = password;
    }

    private void enviarMail(String _correo, String _asunto, String _mensaje) throws MessagingException {
        String username = this.correo;
        String password = this.password;
        String correo = _correo.length() > 0 ? _correo : obtDestinatario.getText();
        String asunto = _asunto.length() > 0 ? _asunto : obtAsunto.getText();
        String mensaje = _mensaje.length() > 0 ? _mensaje : obtMensaje.getText();

        //ADJUNTAR ARCHIVO
        //BodyPart adjunto = new MimeBodyPart();
        //BodyPart mensaje2 = new MimeBodyPart();
        BodyPart mensaje2 = new MimeBodyPart();
        MimeMultipart multiParte = new MimeMultipart();

        /*if (Guardar != null) {
            BodyPart adjunto = new MimeBodyPart();
            adjunto.setDataHandler(new DataHandler(new FileDataSource(Guardar)));
            adjunto.setFileName(nombreArchivo);
            multiParte.addBodyPart(adjunto);
        }*/

        //adjunto.setDataHandler(new DataHandler(new FileDataSource(Guardar)));
        //adjunto.setFileName(nombreArchivo);
        multiParte.addBodyPart(mensaje2);
        //multiParte.addBodyPart(adjunto);

        Properties prop = new Properties();
        prop.put("mail.smtp.host", "smtp.gmail.com");
        prop.put("mail.smtp.port", "587");
        prop.put("mail.smtp.auth", "true");
        prop.put("mail.smtp.starttls.enable", "true"); //TLS

        String finalUsername = username;
        String finalPassword = password;
        Session session = Session.getInstance(prop,
                new javax.mail.Authenticator() {
                    protected PasswordAuthentication getPasswordAuthentication() {
                        return new PasswordAuthentication(finalUsername, finalPassword);
                    }
                });

        try {

            mensaje2.setText(mensaje);

            Message message = new MimeMessage(session);
            message.setFrom(new InternetAddress(username));
            message.setRecipients(
                    Message.RecipientType.TO,
                    InternetAddress.parse(correo)
            );
            message.setSubject(asunto);
            //message.setText(mensaje);
            message.setContent(multiParte);

            Transport.send(message, message.getAllRecipients());
            //Transport.send(message);

            System.out.println("Done");
            
        } catch (MessagingException e) {
            e.printStackTrace();
        }
    }

    private class MimeMultipart extends Multipart {
        public void addBodyPart(BodyPart mensaje2) {
        }

        @Override
        public void writeTo(OutputStream outputStream) throws IOException, MessagingException {
            
        }
    }

    private class MimeBodyPart extends BodyPart {
    }

    private class BodyPart {
        public void setText(String mensaje) {
        }
    }
}