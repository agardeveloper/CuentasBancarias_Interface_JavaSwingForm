/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.nowe.negocio;

import com.nowe.persistencia.AccesoCuentasBancarias;
import java.sql.SQLException;

/**
 *
 * @author agarm
 */
public class Cajero {
    //por ahora no le pongo atributos
    
    //Método de consultar saldo:
    public double consultaSaldo(int idCuenta) throws ClassNotFoundException, SQLException
    {
        AccesoCuentasBancarias acb1 = new AccesoCuentasBancarias();
        //llamamos al metodo que nos devuelve el saldo:
        return acb1.ConsultaSaldo(idCuenta);
    }
    
    public double consultaSaldoCDT(int idInversion) throws ClassNotFoundException, SQLException
    {
        AccesoCuentasBancarias acb1 = new AccesoCuentasBancarias();
        //llamamos al metodo que nos devuelve el saldo:
        return acb1.ConsultaSaldoCDT(idInversion);
    }
    
    //Consulta de saldo total
     public double consultaSaldoTotal(String nif) throws ClassNotFoundException, SQLException
    {
        AccesoCuentasBancarias acb1 = new AccesoCuentasBancarias();
        //llamamos al metodo que nos devuelve el saldo:
        return acb1.ConsultaSaldoTotal(nif);
    }
     
}
