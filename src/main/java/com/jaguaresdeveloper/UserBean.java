package com.jaguaresdeveloper;

import java.io.Serializable;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

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
        return correo;
    }

    private void setPassword(String correo){
        this.correo = correo;
    }

}