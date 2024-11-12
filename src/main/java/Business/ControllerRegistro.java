/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Business;

import Clases.Animal;
import Clases.Arbol;
import Clases.Nodo;
import java.util.Scanner;

/**
 *
 * @author angie
 */
public class ControllerRegistro {
    private Nodo root;
    private Arbol arbolito;
    private Scanner scanner;

    public ControllerRegistro() {
        this.scanner = new Scanner(System.in);
        this.root = null;
        this.arbolito = null;
    }

    public ControllerRegistro(Nodo root, Arbol arbolito) {
        this.root = root;
        this.arbolito = arbolito;
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
        System.out.println("Ingrese el nombre del animal");
        String nombre = scanner.nextLine();
        System.out.println("Ingrese la caracteristica del animal");
        String caracteristica = scanner.nextLine();
        
        if(nombre == null || nombre.isEmpty() || caracteristica == null || caracteristica.isEmpty()){
            System.out.println("Ingrese los datos completos");
        }else{
            Animal animal = new Animal(nombre, caracteristica);
            arbolito.agregar(root, animal);
            System.out.println("Animal registrado correctamente");
        }
    }
    
}
