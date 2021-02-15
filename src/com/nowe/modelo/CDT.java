/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.nowe.modelo;

import java.time.LocalDate;

/**
 *
 * @author agarm
 */
public class CDT {
    
    //Atributos
    private int idInversion;
    private int idCuenta;
    private LocalDate fechaApertura;
    private double interesesMensuales;
    private double valorInversion;
    private String estado;
    
    //Métodos

    @Override
    public String toString() {
        return "CDT{" + "idInversion=" + idInversion + ", idCuenta=" + idCuenta + ", fechaApertura=" + fechaApertura + ", interesesMensuales=" + interesesMensuales + ", valorInversion=" + valorInversion + ", estado=" + estado + '}' + "\n";
    }
   
    
    //Constructores
    public CDT() {
    }

    public CDT(int idInversion, int idCuenta, LocalDate fechaApertura, double interesesMensuales, double valorInversion, String estado) {
        this.idInversion = idInversion;
        this.idCuenta = idCuenta;
        this.fechaApertura = fechaApertura;
        this.interesesMensuales = interesesMensuales;
        this.valorInversion = valorInversion;
        this.estado = estado;
    }

    public CDT(int idCuenta, double interesesMensuales, double valorInversion) {
        this.idCuenta = idCuenta;
        this.interesesMensuales = interesesMensuales;
        this.valorInversion = valorInversion;
    }
       
    
    //Setters y Getteres
    public int getIdInversion() {
        return idInversion;
    }

    public void setIdInversion(int idInversion) {
        this.idInversion = idInversion;
    }

    public int getIdCuenta() {
        return idCuenta;
    }

    public void setIdCuenta(int idCuenta) {
        this.idCuenta = idCuenta;
    }

    public LocalDate getFechaApertura() {
        return fechaApertura;
    }

    public void setFechaApertura(LocalDate fechaApertura) {
        this.fechaApertura = fechaApertura;
    }

    public double getInteresesMensuales() {
        return interesesMensuales;
    }

    public void setInteresesMensuales(double interesesMensuales) {
        this.interesesMensuales = interesesMensuales;
    }

    public double getValorInversion() {
        return valorInversion;
    }

    public void setValorInversion(double valorInversion) {
        this.valorInversion = valorInversion;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }
    
    
}
