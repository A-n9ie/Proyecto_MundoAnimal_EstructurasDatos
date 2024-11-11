package Clases;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 *
 * @author sharo
 * @param <T>
 */

public class Contenedor<T> {
    private NodoGenerico<T> dummy;
    private NodoGenerico<T> back;
    private Map<String, String> map;

    public Contenedor() {
        this.dummy = new NodoGenerico<>();
        this.back = new NodoGenerico<>();
        dummy.setDerecha(back);
        back.setIzquierda(dummy);    
        this.map = new HashMap<>();
    }
    
    
    public void hojasDelArbol(Nodo root, int nivel){
        
        if(root == null){
            return;
        }
        
        if(root.getHijoIzq() == null && root.getHijoDer() == null){
            Animal animal = root.getAnimal();
            animal.setCodigo(nivel);
           
            agregarPrimero((T) animal);
            llaveMap();
        }
        
        hojasDelArbol(root.getHijoIzq(), nivel+1);
        hojasDelArbol(root.getHijoDer(), nivel+1);
    }
    
    public void agregarPrimero(T contenido){
        NodoGenerico<T> nuevoNodo = new NodoGenerico<>(contenido);
        nuevoNodo.setDerecha(dummy.getDerecha());

        dummy.getDerecha().setIzquierda(nuevoNodo);

        
        dummy.setDerecha(nuevoNodo);
    }
    
    public void addLast(T contenido){
        NodoGenerico nuevoNodo = new NodoGenerico<>(contenido);
        //nuevoNodo.setDerecha(back);
        nuevoNodo.setIzquierda(back.getIzquierda());
        
         //if (back.getIzquierda()!= null) {
            back.getIzquierda().setDerecha(nuevoNodo);
       // }
        
        back.setIzquierda(nuevoNodo);
    }
    
    public void display() {
        
        if (dummy.getDerecha() == back) {
        System.out.println("La lista está vacía.");
        return;
        }   
        
        NodoGenerico<T> temp = dummy.getDerecha();
        
        while (temp != back) {
            if (temp != null && temp.getContenido() != null) {
                Animal animal = (Animal) temp.getContenido();
                System.out.println(temp.getContenido().toString() + " codigo " + animal.getCodigo());
            }
            temp = temp.getDerecha();
        }
    }
    
    public void InsertionSort(){
        if(dummy.getDerecha() == back || dummy.getDerecha().getDerecha() == back){//si esta vacia o si solo tiene un elemento
            return;
        }
        
        NodoGenerico<T> nodoActual = dummy.getDerecha().getDerecha();
        
        while(nodoActual != back){
            
            NodoGenerico<T> siguiente = nodoActual.getDerecha();
            NodoGenerico<T> ordenado = nodoActual.getIzquierda();
           
            
            while(ordenado != dummy && ((Animal) ordenado.getContenido()).getCodigo() > ((Animal) nodoActual.getContenido()).getCodigo()){
                ordenado = ordenado.getIzquierda();
            }
            
            nodoActual.getIzquierda().setDerecha(nodoActual.getDerecha());
            nodoActual.getDerecha().setIzquierda(nodoActual.getIzquierda());
            
            
            //insertar ordenado
            
            nodoActual.setDerecha(ordenado.getDerecha());
            ordenado.getDerecha().setDerecha(nodoActual);
            ordenado.setDerecha(nodoActual);
            nodoActual.setIzquierda(ordenado);
            
            nodoActual = siguiente;
        }
    }
    
    public void reverse(){
       NodoGenerico<T> actual = dummy.getDerecha();
       NodoGenerico<T> temporal;
       
       while(actual != back){
           
           temporal = actual.getDerecha();
           
           actual.setDerecha(actual.getIzquierda());
           actual.setIzquierda(temporal);
           
           actual = temporal;
       }
       
       temporal = dummy;
       dummy = back;
       back = temporal;
    }
    
    public void llaveMap(){
         NodoGenerico<T> temp = dummy.getDerecha();
         
        while (temp != back) {
        Animal animal = (Animal) temp.getContenido();  

        //List<String> caracteristicas = Arrays.asList(caracteristica);

        map.put(animal.getNombre(), animal.getCaracteristica());

        temp = temp.getDerecha(); 
        }
    }
    
    public void mostrarMap() {
    for (Map.Entry<String, String> entry : map.entrySet()) {
        String nombreAnimal = entry.getKey();  // Nombre del animal
        String caracteristicas = entry.getValue();  // Lista de características
        System.out.println("Animal: " + nombreAnimal + " --> Características: " + caracteristicas);
        }
    }
}
