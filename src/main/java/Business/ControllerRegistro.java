/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Business;

import Clases.Animal;
import Clases.Arbol;
import Clases.Nodo;
import Presentacion.VistaRegistro;

/**
 *
 * @author angie
 */
public class ControllerRegistro {
    private VistaRegistro vista;
    private Nodo root;
    private Arbol arbolito;

    public ControllerRegistro() {
        this.vista = new VistaRegistro();
        this.root = null;
        this.arbolito = null;
    }

    public ControllerRegistro(VistaRegistro vista, Nodo root, Arbol arbolito) {
        this.vista = vista;
        this.root = root;
        this.arbolito = arbolito;
    }

    public VistaRegistro getVista() {
        return vista;
    }

    public void setRoot(Nodo root) {
        this.root = root;
    }

    public void setArbolito(Arbol arbolito) {
        this.arbolito = arbolito;
    }
    
    public void getController(){
        this.vista.addCancelar_btn(e -> cancelar());
        this.vista.addRegistrar_btn(e -> registrar());
    }
    
    private void cancelar(){
        this.vista.dispose();
    }
    
    private void registrar(){
        String nombre = vista.getNombre();
        String caracteristica = vista.getCaracteristica();
        
        if(nombre.isEmpty() || caracteristica.isEmpty()){
            vista.notify("Ingrese los datos completos");
        }else{
            Animal animal = new Animal(nombre, caracteristica);
            arbolito.agregar(root, animal);
            vista.notify("Animal registrado correctamente");
            cancelar();
        }
        
        vista.setNombre("");
        vista.setCaracteristica("");
    }
    
}
