/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Clases;

import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class Arbol {    // ÁRBOL BINARIO
    private Nodo<Animal> raiz; //root
    
    public Arbol() {
        raiz = new Nodo ("Reino animal");
        
        raiz.setHijoDer(new Nodo(new Caracteristica("Ave")));
        raiz.getHijoDer().setHijoDer(new Nodo(new Animal("Aguila"))); //ave dere
        
        raiz.getHijoDer().setHijoIzq(new Nodo(new Caracteristica("Reptil"))); //ave izq
        raiz.getHijoDer().getHijoIzq().setHijoDer(new Nodo(new Animal("Lagarto"))); //reptil dere
        
        raiz.getHijoDer().getHijoIzq().setHijoIzq(new Nodo(new Caracteristica("Mamifero"))); //reptil izq
        raiz.getHijoDer().getHijoIzq().getHijoIzq().setHijoDer(new Nodo(new Caracteristica("acuatico"))); //mamifero dere
        raiz.getHijoDer().getHijoIzq().getHijoIzq().getHijoDer().setHijoDer(new Nodo(new Animal("Ballena"))); //acuatico dere
        raiz.getHijoDer().getHijoIzq().getHijoIzq().getHijoDer().setHijoIzq(new Nodo(new Caracteristica("maulla"))); //acuatico izq
        raiz.getHijoDer().getHijoIzq().getHijoIzq().getHijoDer().getHijoIzq().setHijoDer(new Nodo(new Animal("Gato"))); //maulla dere
        raiz.getHijoDer().getHijoIzq().getHijoIzq().getHijoDer().getHijoIzq().setHijoIzq(new Nodo(new Animal("Perro"))); //maulla izq
        
        raiz.getHijoDer().getHijoIzq().getHijoIzq().setHijoIzq(new Nodo(new Caracteristica("Pez"))); //mamifero izqu
        raiz.getHijoDer().getHijoIzq().getHijoIzq().getHijoIzq().setHijoDer(new Nodo(new Animal("Beta"))); // pez dere
        
        raiz.getHijoDer().getHijoIzq().getHijoIzq().getHijoIzq().setHijoIzq(new Nodo(new Caracteristica("Invertebrado"))); //pez izq
        raiz.getHijoDer().getHijoIzq().getHijoIzq().getHijoIzq().getHijoIzq().setHijoDer(new Nodo(new Animal("Araña"))); //inverte dere
        
        raiz.getHijoDer().getHijoIzq().getHijoIzq().getHijoIzq().getHijoIzq().setHijoIzq(new Nodo(new Caracteristica("Anfibio"))); //inver izq
        raiz.getHijoDer().getHijoIzq().getHijoIzq().getHijoIzq().getHijoIzq().getHijoIzq().setHijoDer(new Nodo(new Animal("Rana"))); //anfibio dere
        
        raiz.getHijoDer().getHijoIzq().getHijoIzq().getHijoIzq().getHijoIzq().getHijoIzq().setHijoIzq(new Nodo(new Animal("Culebra"))); // anfibio izq
    }

    public Nodo<Animal> getRaiz() {
        return raiz;
    }
    
    public void agregar(Nodo root, Animal animal){
        root.setHijoIzq(new Nodo(animal.getCaracteristica()));
        root.getHijoIzq().setHijoDer(new Nodo(animal));
    }
    
    public boolean hoja(Nodo root){
        return root.getHijoIzq() == null && root.getHijoDer() == null;
    }
    
    public Nodo recorrer(Nodo root, String respuesta){
        if(respuesta == "No")
            return root.getHijoIzq();
        else
            return root.getHijoDer();
    }
    
    //RECORRIDOS
    public void preOrden(){
        System.out.println("PreOrden:");
        this.preOrdenRecursivo(raiz);
        System.out.println("");
    }
    
    public void inOrden(){
        System.out.println("InOrden:");
        this.inOrdenRecursivo(raiz);
        System.out.println("");
    }
    
    public void posOrden(){
        System.out.println("PosOrden:");
        this.posOrdenRecursivo(raiz);
        System.out.println("");
    }
    
    public void recorridoAmplitud() {
        if (raiz == null) return;

        Queue<Nodo> cola = new LinkedList<>();
        cola.add(raiz);
        
        int nivel = 0;
        while (!cola.isEmpty()) {
            int nivelTamano = cola.size();

            System.out.print("Nivel " + nivel + ": " );
            for (int i = 0; i < nivelTamano; i++) {
                Nodo nodoActual = cola.poll();
                System.out.print(nodoActual.getDato() + ", ");

                if (nodoActual.getHijoIzq() != null) 
                    cola.add(nodoActual.getHijoIzq());
                
                if (nodoActual.getHijoDer() != null) 
                    cola.add(nodoActual.getHijoDer());
            }
            
            nivel++;
            System.out.println();
        }
    }
    
   /* public void amplitud(){
        System.out.println(raiz.getDato());
        amplitudRecursivo(raiz);
    }*/
    //ELIMINAR
    public void poda(){
        System.out.println("Podando...");
        raiz = this.podaRecursivo(raiz);
    }
    
    public void eliminarMenor(){
        System.out.println("Eliminando menor...");
        raiz = this.eliminarMenorRecursivo(raiz);
    }
    
    //RECURSIVIDAD
    
                //RECORRIDOS
    private void preOrdenRecursivo(Nodo root){
         if(root != null){
            System.out.print(root.getDato() + " ");
            preOrdenRecursivo(root.getHijoIzq());
            preOrdenRecursivo(root.getHijoDer());
        }
    }
    
    private void inOrdenRecursivo(Nodo root){
        if(root != null){
            inOrdenRecursivo(root.getHijoIzq());
            System.out.print(root.getDato() + " ");
            inOrdenRecursivo(root.getHijoDer());
        }
    }
    
    private void posOrdenRecursivo(Nodo root){
        if(root != null){
            posOrdenRecursivo(root.getHijoIzq());
            posOrdenRecursivo(root.getHijoDer());
            System.out.print(root.getDato() + " ");
        }
    }
    
   /* private void amplitudRecursivo(Nodo root){
        if(root != null){
            if(root.getHijoIzq() != null || root.getHijoDer() != null){
                List<Integer> cola = new LinkedList();
                if(root.getHijoIzq() != null)
                    cola.add(root.getHijoIzq().getDato());
                
                if(root.getHijoDer() != null)
                    cola.add(root.getHijoDer().getDato());
                for(int elemento : cola){
                    System.out.print(elemento + " - ");
                }
                System.out.println("");
                amplitudRecursivo(root.getHijoIzq());
                amplitudRecursivo(root.getHijoDer());
                
            }
        }
    }*/
    
                 //PODA
    private Nodo podaRecursivo(Nodo root){
        if(root != null){
            if(root.getHijoIzq() == null && root.getHijoDer() == null)
                return null;
            else{
                root.setHijoIzq(podaRecursivo(root.getHijoIzq()));
                root.setHijoDer(podaRecursivo(root.getHijoDer()));
            }
        }
        return root;
    }
    
                 //ELIMINAR MENOR
    private Nodo eliminarMenorRecursivo(Nodo root){
        if(root != null){
            if(root.getHijoIzq() == null)
                return null;
            else
                root.setHijoIzq(eliminarMenorRecursivo(root.getHijoIzq()));
        }
        return root;    
    }
    
     
     
}
