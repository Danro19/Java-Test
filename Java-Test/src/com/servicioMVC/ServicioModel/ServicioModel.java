/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.servicioMVC.ServicioModel;

/**
 *
 * @author camper
 */
public class ServicioModel {
    private int id;
    private String nombre;
    private String Descripcion;
    private int precioPorHora;
    private String categoria;

    public ServicioModel(int id, String nombre, String Descripcion, int precioPorHora, String categoria) {
        this.id = id;
        this.nombre = nombre;
        this.Descripcion = Descripcion;
        this.precioPorHora = precioPorHora;
        this.categoria = categoria;
    }
    

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getDescripcion() {
        return Descripcion;
    }

    public void setDescripcion(String Descripcion) {
        this.Descripcion = Descripcion;
    }

    public int getPrecioPorHora() {
        return precioPorHora;
    }

    public void setPrecioPorHora(int precioPorHora) {
        this.precioPorHora = precioPorHora;
    }

    public String getCategoria() {
        return categoria;
    }

    public void setCategoria(String categoria) {
        this.categoria = categoria;
    }
    
    
}
