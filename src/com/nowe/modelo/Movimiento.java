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
public class Movimiento {
    
    //Atributos
    private int idMovimiento;
    private LocalDate fecha;
    private String tipoMovimiento;
    private double cantidad;
    private int idCuenta;
    
    
    //Métodos
    @Override
    public String toString() {
        return "Movimientos{" + "idMovimiento=" + idMovimiento + ", fecha=" + fecha + ", tipoMovimiento=" + tipoMovimiento + ", cantidad=" + cantidad + ", idCuenta=" + idCuenta + '}' + "\n";
    }
    
    
    //Constructores
    public Movimiento() {
    }

    public Movimiento(int idMovimiento, LocalDate fecha, String tipoMovimiento, double cantidad, int idCuenta) {
        this.idMovimiento = idMovimiento;
        this.fecha = fecha;
        this.tipoMovimiento = tipoMovimiento;
        this.cantidad = cantidad;
        this.idCuenta = idCuenta;
    }

    public Movimiento(double cantidad, int idCuenta) {
        this.cantidad = cantidad;
        this.idCuenta = idCuenta;
    }
    
    
    //Setters y Getters
    public int getIdMovimiento() {
        return idMovimiento;
    }

    public void setIdMovimiento(int idMovimiento) {
        this.idMovimiento = idMovimiento;
    }

    public LocalDate getFecha() {
        return fecha;
    }

    public void setFecha(LocalDate fecha) {
        this.fecha = fecha;
    }

    public String getTipoMovimiento() {
        return tipoMovimiento;
    }

    public void setTipoMovimiento(String tipoMovimiento) {
        this.tipoMovimiento = tipoMovimiento;
    }

    public double getCantidad() {
        return cantidad;
    }

    public void setCantidad(double cantidad) {
        this.cantidad = cantidad;
    }

    public int getIdCuenta() {
        return idCuenta;
    }

    public void setIdCuenta(int idCuenta) {
        this.idCuenta = idCuenta;
    }
    
    
}
