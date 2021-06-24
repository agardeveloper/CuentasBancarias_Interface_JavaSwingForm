/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.nowe.persistencia;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 *
 * @author agarm
 */
public class Conexion {
    protected Connection miConexion;
    public void abrirConexion() throws ClassNotFoundException, SQLException  {
        //Cargar el driver
        Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver"); //para obtener el driver
        String stringConexion =  "jdbc:sqlserver://localhost:1433;" + //este String para conectarnos
                       "databaseName=CUENTAS_BANCOS;" +  //este código(entero amarillo) lo obtenemos del SGBD, en este caso SQL Server
                       "user=USUARIO_BD;" +
                        "password=CONTRASENIA_BD;" +
                      "encrypt=false;" +
                     "trustServerCertificate=false;" +
                      "loginTimeout=30;";
        //Obtenermos un objeto de tipo conexion
        miConexion = DriverManager.getConnection(stringConexion); //Obtenemos la conexion y le damos el string de conexion
        //System.out.println("Exito al abrir la conexion");                     //Obtenemos un objeto conexion que está conectado a la BD
    }
    
    public void cerrarConexion() throws SQLException {
        miConexion.close(); //es muy importante cerrar la conexion porque los servidores de BD tienen limitadas las conexiones que puede atender
    }
}
