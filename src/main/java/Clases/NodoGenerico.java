/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Clases;

/**
 *
 * @author sharo
 */
public class NodoGenerico<T> {
    
    private T contenido;
    private NodoGenerico<T> izquierda;
    private NodoGenerico<T> derecha;

    public NodoGenerico() {
        
    }

    public NodoGenerico(T contenido) {
        this.contenido = contenido;
        this.izquierda = izquierda;
        this.derecha = derecha;
    }

    public T getContenido() {
        return contenido;
    }

    public void setContenido(T contenido) {
        this.contenido = contenido;
    }

    public NodoGenerico<T> getIzquierda() {
        return izquierda;
    }

    public void setIzquierda(NodoGenerico<T> izquierda) {
        this.izquierda = izquierda;
    }

    public NodoGenerico<T> getDerecha() {
        return derecha;
    }

    public void setDerecha(NodoGenerico<T> derecha) {
        this.derecha = derecha;
    }
    
    
    
    
    
    
    
}
