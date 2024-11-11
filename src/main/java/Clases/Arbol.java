/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Clases;

import java.util.LinkedList;
import java.util.Queue;

import com.google.gson.Gson;
import java.util.HashMap;
import java.util.Map;
import java.io.File;
import java.io.IOException;
import com.fasterxml.jackson.databind.ObjectMapper;
import java.io.BufferedReader;
import java.io.FileReader;


public class Arbol {    // ÁRBOL BINARIO
    private Nodo raiz; //root
    
    public Arbol() {
        this.cargarJson("arbol.json");
       /*
        raiz = new Nodo ("Reino animal");
        
        raiz.setHijoDer(new Nodo(new Animal("Ave")));
        raiz.getHijoDer().setHijoDer(new Nodo(new Animal("Aguila"))); //ave dere
        
        raiz.getHijoDer().setHijoIzq(new Nodo(new Animal("Reptil"))); //ave izq
        raiz.getHijoDer().getHijoIzq().setHijoDer(new Nodo(new Animal("Lagarto"))); //reptil dere
        
        raiz.getHijoDer().getHijoIzq().setHijoIzq(new Nodo(new Animal("Mamifero"))); //reptil izq
        raiz.getHijoDer().getHijoIzq().getHijoIzq().setHijoDer(new Nodo(new Animal("acuatico"))); //mamifero dere
        raiz.getHijoDer().getHijoIzq().getHijoIzq().getHijoDer().setHijoDer(new Nodo(new Animal("Ballena"))); //acuatico dere
        raiz.getHijoDer().getHijoIzq().getHijoIzq().getHijoDer().setHijoIzq(new Nodo(new Animal("maulla"))); //acuatico izq
        raiz.getHijoDer().getHijoIzq().getHijoIzq().getHijoDer().getHijoIzq().setHijoDer(new Nodo(new Animal("Gato"))); //maulla dere
        raiz.getHijoDer().getHijoIzq().getHijoIzq().getHijoDer().getHijoIzq().setHijoIzq(new Nodo(new Animal("Perro"))); //maulla izq
        
        raiz.getHijoDer().getHijoIzq().getHijoIzq().setHijoIzq(new Nodo(new Animal("Pez"))); //mamifero izqu
        raiz.getHijoDer().getHijoIzq().getHijoIzq().getHijoIzq().setHijoDer(new Nodo(new Animal("Beta"))); // pez dere
        
        raiz.getHijoDer().getHijoIzq().getHijoIzq().getHijoIzq().setHijoIzq(new Nodo(new Animal("Invertebrado"))); //pez izq
        raiz.getHijoDer().getHijoIzq().getHijoIzq().getHijoIzq().getHijoIzq().setHijoDer(new Nodo(new Animal("Araña"))); //inverte dere
        
        raiz.getHijoDer().getHijoIzq().getHijoIzq().getHijoIzq().getHijoIzq().setHijoIzq(new Nodo(new Animal("Anfibio"))); //inver izq
        raiz.getHijoDer().getHijoIzq().getHijoIzq().getHijoIzq().getHijoIzq().getHijoIzq().setHijoDer(new Nodo(new Animal("Rana"))); //anfibio dere
        
        raiz.getHijoDer().getHijoIzq().getHijoIzq().getHijoIzq().getHijoIzq().getHijoIzq().setHijoIzq(new Nodo(new Animal("Culebra"))); // anfibio izq
        */
    }

    public Nodo getRaiz() {
        return raiz;
    }
    
    public void agregar(Nodo root, Animal animal){
        Nodo caracteristica = new Nodo(animal.getCaracteristica());
        Nodo nuevoAnimal = new Nodo(animal);
        
        root.setHijoIzq(caracteristica);
        root.setHijoDer(nuevoAnimal);
        
        intercambio(root, caracteristica);
    }
    
    public void intercambio(Nodo a, Nodo b){
        Nodo aux = new Nodo(new Animal());
        aux.setAnimal(a.getAnimal());
        a.setAnimal(null);
        a.setCaracteristica(b.getCaracteristica());
        b.setAnimal(aux.getAnimal());
        b.setCaracteristica("");
    }
    
    public boolean hoja(Nodo root){
        return root.getHijoIzq() == null && root.getHijoDer() == null;
    }
    
    public Nodo recorrer(Nodo root, String respuesta){
        if("No".equals(respuesta))
            return root.getHijoIzq();
        else
            return root.getHijoDer();
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
                
                if (nodoActual.getAnimal() != null)
                    System.out.print(nodoActual.getAnimal() + ", ");
                else
                    System.out.print(nodoActual.getCaracteristica() + ", ");

                if (nodoActual.getHijoIzq() != null) 
                    cola.add(nodoActual.getHijoIzq());
                
                if (nodoActual.getHijoDer() != null) 
                    cola.add(nodoActual.getHijoDer());
            }
            
            nivel++;
            System.out.println();
        }
    }
    
    public void guardarJson(String rutaArchivo){
        try{
            ObjectMapper mapper = new ObjectMapper();
            mapper.writeValue(new File(rutaArchivo), nodoToMap(raiz));
        } catch(IOException e){
            System.out.println(e);
        }
    }

    private Map<String, Object> nodoToMap(Nodo nodo) {
        Map<String, Object> nodoMap = new HashMap<>();

        if (nodo.getAnimal() != null) {
            nodoMap.put("nombre", nodo.getAnimal().getNombre());
        } else {
            nodoMap.put("caracteristica", nodo.getCaracteristica());
        }

        if (nodo.getHijoIzq() != null) {
            nodoMap.put("hijoIzq", nodoToMap(nodo.getHijoIzq()));
        }
        if (nodo.getHijoDer() != null) {
            nodoMap.put("hijoDer", nodoToMap(nodo.getHijoDer()));
        }

        return nodoMap;
    }

    public void cargarJson(String rutaArchivo) {
        Gson gson = new Gson();
        try (BufferedReader br = new BufferedReader(new FileReader(rutaArchivo))) {
            
            Map<String, Object> data = gson.fromJson(br, Map.class);
            this.raiz = reconstruirArbol(data);
        } catch(IOException e){
            System.out.println(e);
        }
    }

    private Nodo reconstruirArbol(Map<String, Object> data) {
        if (data == null) {
            return null;
        }
        String caracteristica = (String) data.get("caracteristica");
        if (caracteristica != null && !caracteristica.isEmpty()) {
            Nodo nodo = new Nodo(caracteristica);
            nodo.setHijoIzq(reconstruirArbol((Map<String, Object>) data.get("hijoIzq")));
            nodo.setHijoDer(reconstruirArbol((Map<String, Object>) data.get("hijoDer")));
            return nodo;
        }

        String nombre = (String) data.get("nombre");
        Animal animal = new Animal(nombre);
        Nodo nodo = new Nodo(animal);
        nodo.setHijoIzq(reconstruirArbol((Map<String, Object>) data.get("hijoIzq")));
        nodo.setHijoDer(reconstruirArbol((Map<String, Object>) data.get("hijoDer")));

        return nodo;
    }


}
    