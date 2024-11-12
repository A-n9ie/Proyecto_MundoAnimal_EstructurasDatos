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
        String respuesta = "";
        while (true) {
            if (root != null && root.getAnimal() != null){
                System.out.println("¿El animal es un/a " + root.getAnimal() + "?");
            }else if(root != null && root.getCaracteristica() != null){
                System.out.println("¿El animal " + root.getCaracteristica() + "?");
            }
            respuesta = scanner.next();
            if (respuesta.equals("si") || respuesta.equals("no")) {
                break;  
            } else {
                System.out.println("Respuesta no válida.\nPor favor, responder solo con 'si' o 'no'.");
            }
        }
        
        if(respuesta != null){
            respuesta = respuesta.toLowerCase();
            realizarPregunta(respuesta);
        }
    }
    
    private void realizarPregunta(String respuesta){
        if(arbolito != null && root != null && arbolito.hoja(root) && respuesta.equals("si")){
            System.out.println("¡Animal encontrado!");
            reiniciar();
        }
        else if ((arbolito.hoja(root) && respuesta.equals("no")) || (root.getHijoIzq() == null && respuesta.equals("no"))){
            System.out.println("Animal NO Encontrado.\n Registre al nuevo animal");
            vRegistro.setRoot(root);
            vRegistro.setArbolito(arbolito);
            vRegistro.getController();
            salir();
            reiniciar();
        }
        else{
            root = arbolito.recorrer(root, respuesta);
            generarPregunta();
        }
    }
    
    public void reiniciar(){
        this.root = arbolito.getRaiz().getHijoDer();
    }
    
    public void salir(){
        this.arbolito.guardarJson("arbol.json");
    }
    
}
