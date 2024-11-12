/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Business;
import Clases.Arbol;
import Clases.Nodo;
import java.util.Scanner;

/**
 *
 * @author angie
 */
public class ControllerPregunta {
    private Arbol arbolito;
    private Nodo root;
    private ControllerRegistro vRegistro;
    private Scanner scanner;

    public ControllerPregunta(Arbol arbolito) {
        this.arbolito = arbolito;
        this.root = arbolito.getRaiz().getHijoDer();
        this.vRegistro = new ControllerRegistro();
        this.scanner = new Scanner(System.in);
    }

    public void getController(){
        generarPregunta();
    }
    
    private void generarPregunta(){
        String pregunta = " ";
        if (root != null && root.getAnimal() != null){
            System.out.println("El animal es un/a" + root.getAnimal() + "?");
            pregunta = scanner.next();
        }else if(root != null && root.getCaracteristica() != null){
            System.out.println("El animal " + root.getCaracteristica() + "?");
            pregunta = scanner.next();
        }
        
        if(pregunta != null){
            pregunta = pregunta.toLowerCase();
            realizarPregunta(pregunta);
        }
    }
    
    private void realizarPregunta(String respuesta){
        if(arbolito != null && root != null && arbolito.hoja(root) && respuesta.equals("si")){
            System.out.println("Animal no encontrado");
        }
        else if ((arbolito.hoja(root) && respuesta.equals("no")) || (root.getHijoIzq() == null && respuesta.equals("no"))){
            System.out.println("Animal NO Encontrado.\n Registre al nuevo animal");
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
