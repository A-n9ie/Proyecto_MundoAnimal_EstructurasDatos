/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Clases;

import java.util.HashMap;
import java.util.Map;

/**
 *
 * @author angie
 */
public class MapAnimales {
    private Map<String, Contenedor<String>> map;

    public MapAnimales() {
        map = new HashMap<>();
    }
    
    public void agregarMap(Nodo root, Contenedor<String> caracteristicas, boolean quitar) {
        if (root != null) {
            Contenedor<String> copia = new Contenedor<>(caracteristicas);  

            if(quitar) 
                copia.popFirst();    //quita la caracteristica anterior si no es necesaria

            if (root.getAnimal() != null && !root.esHoja()) {
                copia.agregarPrimero(root.getAnimal().getNombre());
            } else {
                if(!root.getCaracteristica().isEmpty())
                    copia.agregarPrimero(root.getCaracteristica());
            }

            if (root.esHoja()) {
                map.put(root.getAnimal().getNombre(), copia);  
            } else {
                agregarMap(root.getHijoDer(), copia, false);  
                agregarMap(root.getHijoIzq(), copia, true);
            }
        }
    }
    public void mostrarMap (){
        for (Map.Entry<String, Contenedor<String>> entry : map.entrySet()) {
            System.out.print(entry.getKey() + " -> ");
            for(int i = 0; i < entry.getValue().size(); i++){
                System.out.print(entry.getValue().get(i));
                if(i != entry.getValue().size() - 1)
                    System.out.print(", ");
            }
            System.out.println("");
        }
    }
    
    public void features(String nombre) {
        Contenedor<String> caracteristicas = map.get(nombre);

        if (caracteristicas == null || caracteristicas.isEmpty()) {
            System.out.println("No existe");
        } else {
            System.out.print("Características de " + nombre + ": ");
            for(int i = 0; i < caracteristicas.size(); i++){
                System.out.print(caracteristicas.get(i));
                if(i != caracteristicas.size() - 1)
                    System.out.print(", ");
            }
            System.out.println("");
        }
    }
    
}
