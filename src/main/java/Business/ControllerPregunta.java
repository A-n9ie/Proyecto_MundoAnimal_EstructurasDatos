/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Business;
import Clases.Arbol;
import Clases.Nodo;
import Presentacion.Vista;

/**
 *
 * @author angie
 */
public class ControllerPregunta {
    private Arbol arbolito;
    private Nodo root;
    private ControllerRegistro vRegistro;
    private Vista vista;

    public ControllerPregunta(Vista vista, Arbol arbolito) {
        this.vista = vista;
        this.arbolito = arbolito;
        this.root = arbolito.getRaiz().getHijoDer();
        this.vRegistro = new ControllerRegistro();
    }

    public void getController(){
        generarPregunta();
    }
    
    private void generarPregunta(){
        String pregunta = " ";
        if (root != null && root.getAnimal() != null){
            pregunta = vista.pedirRespuesta("El animal es un/a" + root.getAnimal() + "?");
        }else if(root != null && root.getCaracteristica() != null){
            pregunta = vista.pedirRespuesta("El animal " + root.getCaracteristica() + "?");
        }
        
        if(pregunta != null){
            pregunta = pregunta.toLowerCase();
            realizarPregunta(pregunta);
        }
    }
    
    private void realizarPregunta(String respuesta){
        if(arbolito != null && root != null && arbolito.hoja(root) && respuesta.equals("si")){
           vista.mostrarMensaje("Animal encontrado");
        }
        else if ((arbolito.hoja(root) && respuesta.equals("no")) || (root.getHijoIzq() == null && respuesta.equals("no"))){
            vista.mostrarMensaje("Animal NO Encontrado.\n Registre al nuevo animal");
            vRegistro.setRoot(root);
            vRegistro.setArbolito(arbolito);
            vRegistro.getController();
            reiniciar();
        }
        else{
            root = arbolito.recorrer(root, respuesta);
            generarPregunta();
        }
    }
    
    public void reiniciar(){
        this.root = arbolito.getRaiz().getHijoDer();
        generarPregunta();
    }
    
    public void salir(){
        this.arbolito.guardarJson("arbol.json");
    }
    
}
