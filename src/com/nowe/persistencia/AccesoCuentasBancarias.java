/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.nowe.persistencia;

import com.nowe.modelo.CDT;
import com.nowe.modelo.Movimiento;
import java.sql.CallableStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Types;

/**
 *
 * @author agarm
 */
public class AccesoCuentasBancarias extends Conexion{
    //Método consulta saldo
    public double ConsultaSaldo(int idCuenta) throws ClassNotFoundException, SQLException{
        /*
        1. Declarar variables
        2. Abrir conexion
        3. Obtener la sentencia de la conexion
        3A. Asignar valor a los parametros
        4. Ejecutar la sentencia
        5. Recoger los datos
        6. Cerrar la conexion
        7. Devolver los datos
        */
        
        //Declaracion JDBC
        CallableStatement cmd;
        ResultSet rs;
        //Otras variables
        double saldo = 0;
        String sql = "EXEC CONSULTA_CC ?";
        
        abrirConexion();
        
        cmd = miConexion.prepareCall(sql);
        
        cmd.setInt(1, idCuenta);
        
        rs = cmd.executeQuery();
        
        if (rs.next()) {
            saldo = rs.getDouble("SALDO");      
        }
        
        cerrarConexion();
        cmd.close();
        rs.close();
        
        return saldo;

    }
    
    //Método consulta CDT
    public double ConsultaSaldoCDT(int idInversion) throws ClassNotFoundException, SQLException{
        /*
        1. Declarar variables
        2. Abrir conexion
        3. Obtener la sentencia de la conexion
        3A. Asignar valor a los parametros
        4. Ejecutar la sentencia
        5. Recoger los datos
        6. Cerrar la conexion
        7. Devolver los datos
        */
        
        //Declaracion JDBC
        CallableStatement cmd;
        ResultSet rs;
        //Otras variables
        double saldo = 0;
        String sql = "EXEC CONSULTA_CDT ?";
        
        abrirConexion();
        
        cmd = miConexion.prepareCall(sql);
        
        cmd.setInt(1, idInversion);
        
        rs = cmd.executeQuery();
        
        if (rs.next()) {
            saldo = rs.getDouble("VALOR_INVERSION");      
        }
        
        cerrarConexion();
        cmd.close();
        rs.close();
        
        return saldo;

    }
    
    //Método de consultar saldo total
    public double ConsultaSaldoTotal(String nif) throws ClassNotFoundException, SQLException{
        /*
        1. Declarar variables
        2. Abrir conexion
        3. Obtener la sentencia de la conexion
        3A. Asignar valor a los parametros
        4. Ejecutar la sentencia
        5. Recoger los datos
        6. Cerrar la conexion
        7. Devolver los datos
        */
        
        //Declaracion JDBC
        CallableStatement cmd;
        //Otras variables
        double saldo = 0;
        String sql = "EXEC SALDO_TOTAL ?, ?";
        
        abrirConexion();
        
        cmd = miConexion.prepareCall(sql);
        
        cmd.setString(1, nif);
        
       // Registrar un parametro de salida, la segunda interrogacion de la consulta
        cmd.registerOutParameter(2, Types.DOUBLE);//double porque es money
        
        cmd.execute();
        
        //Recoger el valor del parametro de salida, la segunda interrogacion de la consulta
        saldo = cmd.getDouble(2);
        
        cerrarConexion();
        cmd.close();
        
        return saldo;

    }
    
    //Método para crear una inversión
    //Parametro de entrada -> un objeto CDT 
    //Salida un boolean (si fue exitosa o no)
    public boolean crearInversion(CDT inversion) throws ClassNotFoundException, SQLException{

//        1. Declarar variables
//         Declaraciones de JDBC
        CallableStatement sentencia;
//          Otras variables
        int resultado;
        String sql = "EXEC ALTA_INVERSION ?,?,?";
//        2. Abrir conexion
        abrirConexion();
//        3. Obtener la sentencia de la conexion
        sentencia = miConexion.prepareCall(sql);
//        3A. Asignar valor a los parametros
        //Se asignan valor al parámetro almacenado, mirar que hay un constructor así:
        sentencia.setInt(1, inversion.getIdCuenta());
        sentencia.setDouble(2, inversion.getInteresesMensuales());
        sentencia.setDouble(3, inversion.getValorInversion());
//        4. Ejecutar el comando
        resultado = sentencia.executeUpdate();
//        5. Cerrar la conexion
        cerrarConexion();
        sentencia.close();
//        6. Devolver el resultado
        return (resultado > 0);
        //es un boolean, si resultado es mayor que 0 es true
        
    }
    
    //Método para hacer un ingreso
    //Parámetro de entrada -> movimiento con los datos de cuenta y cantidad
    //Salida un boolean
    public boolean ingreso(Movimiento m1) throws ClassNotFoundException, SQLException {
        //        1. Declarar variables
//         Declaraciones de JDBC
        CallableStatement sentencia;
//          Otras variables
        int resultado;
        String sql = "EXEC INGRESO ?,?"; 
//        2. Abrir conexion
        abrirConexion();
//        3. Obtener la sentencia de la conexion
        sentencia = miConexion.prepareCall(sql);
//        3A. Asignar valor a los parametros
        //Se asignan valor al parámetro almacenado, mirar que hay un constructor así:
        sentencia.setInt(1, m1.getIdCuenta());
        sentencia.setDouble(2, m1.getCantidad());
//        4. Ejecutar el comando
        resultado = sentencia.executeUpdate();
//        5. Cerrar la conexion
        cerrarConexion();
        sentencia.close();
//        6. Devolver el resultado
        return (resultado > 0);
        //es un boolean, si resultado es mayor que 0 es true
        
    }
    
    //Método para cerrar una inversión
    //Parametro de entrada -> idInversion
    //Parametro de salida -> boolean exito / no exito
     public boolean cerrarInversion(int idInversion) throws ClassNotFoundException, SQLException{
          
        //1. Declarar variables
        //1a. JDBC
        CallableStatement sentencia;
        //variables
        boolean exito;
        String sql = "EXEC CERRAR_INVERSION ?";
        //2. Abrir conexion
        abrirConexion();
        //3. Obtener la sentencia de la conexion
        sentencia = miConexion.prepareCall(sql);
        //3A. Asignar valor a los parametros
        sentencia.setInt(1, idInversion);
        //4. Ejecutar la sentencia
        exito = sentencia.execute();
        //5. Cerrar la conexion y la sentencia
        cerrarConexion();
        sentencia.close();
        //6. Devolver los datos
        return exito;
        
         
     }
     
         //Método para hacer un retiro
    //Parámetro de entrada -> movimiento con los datos de cuenta y cantidad
    //Salida un boolean
    public boolean retiro(Movimiento m1) throws ClassNotFoundException, SQLException {
        //  1. Declarar variables
//         Declaraciones de JDBC
        CallableStatement sentencia;
//          Otras variables
        int resultado;
        String sql = "EXEC RETIRO ?,?"; 
//        2. Abrir conexion
        abrirConexion();
//        3. Obtener la sentencia de la conexion
        sentencia = miConexion.prepareCall(sql);
//        3A. Asignar valor a los parametros
        //Se asignan valor al parámetro almacenado, mirar que hay un constructor así:
        sentencia.setInt(1, m1.getIdCuenta());
        sentencia.setDouble(2, m1.getCantidad());
//        4. Ejecutar el comando
        resultado = sentencia.executeUpdate();
//        5. Cerrar la conexion
        cerrarConexion();
        sentencia.close();
//        6. Devolver el resultado
        return (resultado > 0);
        //es un boolean, si resultado es mayor que 0 es true
        
    }
    
    
        //Método de consultar simulacion
    public double simulacion(String nif) throws ClassNotFoundException, SQLException{
        /*
        1. Declarar variables
        2. Abrir conexion
        3. Obtener la sentencia de la conexion
        3A. Asignar valor a los parametros
        4. Ejecutar la sentencia
        5. Recoger los datos
        6. Cerrar la conexion
        7. Devolver los datos
        */
        
        //Declaracion JDBC
        CallableStatement cmd;
        //Otras variables
        double simulacion = 0;
        String sql = "EXEC SIMULACION ?, ?";       
        abrirConexion();        
        cmd = miConexion.prepareCall(sql);      
        cmd.setString(1, nif);     
       // Registrar un parametro de salida, la segunda interrogacion de la consulta
        cmd.registerOutParameter(2, Types.DOUBLE);//double porque es money       
        cmd.execute();     
        //Recoger el valor del parametro de salida, la segunda interrogacion de la consulta
        simulacion = cmd.getDouble(2);       
        cerrarConexion();
        cmd.close();     
        return simulacion;
    }
    
}
