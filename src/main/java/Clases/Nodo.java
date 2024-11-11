/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Clases;

/**
 *
 * @author ESCINF
 */
public class Nodo {
    private Nodo hijoIzq;
    private Nodo hijoDer;
    private Animal animal;
    private String caracteristica;
    
    public Nodo(Animal elemento){
        animal = elemento;
        this.caracteristica = "";
        this.hijoDer = null;
        this.hijoIzq = null;
    }

    public Nodo(String caracteristica) {
        this.caracteristica = caracteristica;
        animal = null;
        this.hijoDer = null;
        this.hijoIzq = null;
    }

    public Animal getAnimal() {
        return animal;
    }

    public void setAnimal(Animal animal) {
        this.animal = animal;
    }

    public String getCaracteristica() {
        return caracteristica;
    }

    public void setCaracteristica(String caracteristica) {
        this.caracteristica = caracteristica;
    }

    public Nodo getHijoIzq() {
        return hijoIzq;
    }

    public void setHijoIzq(Nodo hijoIzq) {
        this.hijoIzq = hijoIzq;
    }

    public Nodo getHijoDer() {
        return hijoDer;
    }

    public void setHijoDer(Nodo hijoDer) {
        this.hijoDer = hijoDer;
    }
    
    boolean esHoja(){
        return hijoDer == null && hijoIzq == null;
    }
    
}
