/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Clases;

/**
 *
 * @author angie
 */
public class Animal {
    private int codigo;
    private String nombre;
    private Caracteristica caracteristica;

    public Animal() {
        this.codigo = 0;
        this.nombre = "";
        this.caracteristica = new Caracteristica();
    }

    public Animal(String nombre) {
        this.nombre = nombre;
        this.codigo = 0;
        this.caracteristica = new Caracteristica();
    }

    public Animal(String nombre, Caracteristica caracteristica) {
        this.codigo = 0;
        this.nombre = nombre;
        this.caracteristica = caracteristica;
    }

    public Animal(int codigo, String nombre, Caracteristica caracteristica) {
        this.codigo = codigo;
        this.nombre = nombre;
        this.caracteristica = caracteristica;
    }

    public int getCodigo() {
        return codigo;
    }

    public void setCodigo(int codigo) {
        this.codigo = codigo;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public Caracteristica getCaracteristica() {
        return caracteristica;
    }

    public void setCaracteristica(Caracteristica caracteristica) {
        this.caracteristica = caracteristica;
    }

    @Override
    public String toString() {
        return nombre;
    }
    
    
}
