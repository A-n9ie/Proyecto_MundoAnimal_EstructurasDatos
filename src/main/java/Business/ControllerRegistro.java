/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Business;

import Clases.Animal;
import Clases.Arbol;
import Clases.Nodo;
import Presentacion.Vista;

/**
 *
 * @author angie
 */
public class ControllerRegistro {
    private Nodo root;
    private Arbol arbolito;
    private Vista vista;

    public ControllerRegistro() {
        this.vista = new Vista();
        this.root = null;
        this.arbolito = null;
    }

    public ControllerRegistro(Vista vista, Nodo root, Arbol arbolito) {
        this.vista = vista;
        this.root = root;
        this.arbolito = arbolito;
    }

    public Vista getVista() {
        return vista;
    }

    public void setRoot(Nodo root) {
        this.root = root;
    }

    public void setArbolito(Arbol arbolito) {
        this.arbolito = arbolito;
    }
    
    public void getController(){
        registrar();
    }
    
    
    private void registrar(){
        String nombre = vista.pedirRespuesta("Ingrese el nombre del animal");
        String caracteristica = vista.pedirRespuesta("Ingrese la caracteristica del animal");
        
        if(nombre == null || nombre.isEmpty() || caracteristica == null || caracteristica.isEmpty()){
          vista.mostrarMensaje("Ingrese los datos completos");
        }else{
            Animal animal = new Animal(nombre, caracteristica);
            arbolito.agregar(root, animal);
            vista.mostrarMensaje("Animal registrado correctamente");
        }
    }
    
}
