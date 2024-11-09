/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Clases;

/**
 *
 * @author sharo
 * @param <T>
 */
public class Contenedor<T> {
    private NodoGenerico<T> dummy;
    private NodoGenerico<T> back;
    int size;

    public Contenedor(NodoGenerico<T> dummy, NodoGenerico<T> back) {
        this.dummy = new NodoGenerico<>();
        this.back = new NodoGenerico<>();
        dummy.setDerecha(back);
        back.setIzquierda(dummy);    
    }

    public Contenedor() {
    }
    
    public void hojasDelArbol(Nodo root, int nivel){
        
        if(root == null){
            return;
        }
        
        if(root.getHijoIzq() == null && root.getHijoDer() == null){
            Animal animal = root.getAnimal();
            animal.setCodigo(nivel);
            
            agregarPrimero((T) animal);
        }
        
        hojasDelArbol(root.getHijoIzq(), nivel+1);
        hojasDelArbol(root.getHijoDer(), nivel+1);
    }
    
    public void agregarPrimero(T contenido){
        NodoGenerico<T> nuevoNodo = new NodoGenerico<>(contenido);
        nuevoNodo.setDerecha(dummy.getDerecha());
        nuevoNodo.setIzquierda(dummy);
        
        if (dummy.getDerecha() != null) {
            dummy.getDerecha().setIzquierda(nuevoNodo);
        }
        
        dummy.setDerecha(nuevoNodo);
    }
    
    public void display() {
        NodoGenerico<T> temp = dummy.getDerecha();
        while (temp != back) {
            System.out.println(temp.getContenido());
            temp = temp.getDerecha();
        }
    }
    
    
    
    
}
