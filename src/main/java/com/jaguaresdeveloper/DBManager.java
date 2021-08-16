package com.jaguaresdeveloper;


import java.sql.*;

public class DBManager {

    public static Connection conectar() {
        Connection con = null;
        try {
            Class.forName("org.sqlite.JDBC");
            con = DriverManager.getConnection("jdbc:sqlite:database/correos.db"); // conexion a la base de datos
            System.out.println("Connected!");
        } catch (ClassNotFoundException | SQLException e ) {
            System.out.println(e+"");
        }
        return con;
    }

    public static void leerTabla(){
        Connection con = conectar(); //Conexion de la base de datos
        PreparedStatement ps = null;
        ResultSet rs = null;

        try{
            String query = "SELECT * FROM user;";
            ps = con.prepareStatement(query);
            rs = ps.executeQuery();
            System.out.println("Tabla users\n");
            while(rs.next()){
                int id = rs.getInt("id");
                String username = rs.getString("username");
                String password = rs.getString("password");
                int user_root = rs.getInt("user_root");

                System.out.println("id: " + id);
                System.out.println("username: " + username);
                System.out.println("password: " + password);
                System.out.println("user root: " + user_root + "\n");

            }
        }catch (SQLException e) {
            System.out.println(e);
        }finally {
            try{
                ps.close();
                rs.close();
                con.close();
            }catch (SQLException e){
                System.out.println(e);
            }
        }
    }

    public static void insertarDatos(String username, String password, int user_root){
        Connection con = conectar();
        PreparedStatement ps = null;
        try{
            String query = "INSERT INTO user(USERNAME, PASSWORD, user_root) VALUES(?,?,?);";
            ps = con.prepareStatement(query);
            ps.setString(1,username);
            ps.setString(2,password);
            ps.setInt(3,user_root);
            ps.execute();
            System.out.println("Se ha ingresado el usuario correctamente!");
        }catch (SQLException e) {
            System.out.println(e);
        }
    }

    public static void BorrarDatos(int id) {
        Connection con = conectar();
        PreparedStatement ps = null;

        try{
            String query = "DELETE FROM user WHERE id = ?";
            ps = con.prepareStatement(query);
            ps.setInt(1,id);
            ps.execute();
            System.out.println("Se ha eliminado el usuario correctamente!");
        }catch (SQLException e){
            System.out.println(e);
        }
    }
}
