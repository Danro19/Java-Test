/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.contratoMVC.ContratoModel;

import java.time.LocalDate;

/**
 *
 * @author camper
 */
public class ContratoModel {
    private int id;
    private LocalDate fechaInicio;
    private LocalDate fechaFin;
    private int costoTotal;
    private String estado;

    public ContratoModel(LocalDate fechaInicio, LocalDate fechaFin, int costoTotal, String estado) {
        this.fechaInicio = fechaInicio;
        this.fechaFin = fechaFin;
        this.costoTotal = costoTotal;
        this.estado = estado;
    }

    public ContratoModel(int id, LocalDate fechaInicio, LocalDate fechaFin, int costoTotal, String estado) {
        this.id = id;
        this.fechaInicio = fechaInicio;
        this.fechaFin = fechaFin;
        this.costoTotal = costoTotal;
        this.estado = estado;
    }

    
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public LocalDate getFechaInicio() {
        return fechaInicio;
    }

    public void setFechaInicio(LocalDate fechaInicio) {
        this.fechaInicio = fechaInicio;
    }

    public LocalDate getFechaFin() {
        return fechaFin;
    }

    public void setFechaFin(LocalDate fechaFin) {
        this.fechaFin = fechaFin;
    }

    public int getCostoTotal() {
        return costoTotal;
    }

    public void setCostoTotal(int costoTotal) {
        this.costoTotal = costoTotal;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }
    
}
