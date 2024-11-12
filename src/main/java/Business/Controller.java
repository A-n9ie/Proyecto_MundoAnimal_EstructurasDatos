/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Business;

import Clases.Animal;
import Clases.Arbol;
import Clases.Contenedor;
import Clases.MapAnimales;
import java.util.Scanner;

/**
 *
 * @author sharo
 */
public class Controller {
    private ControllerPregunta controllerPreg;
    private Arbol arbol;
    private Contenedor<Animal> contenedor;
    private MapAnimales map;
    int eleccion;
    Scanner scanner;

    public Controller(Arbol arbol) {
        this.arbol = arbol;
        this.controllerPreg = new ControllerPregunta(arbol);
        this.contenedor = new Contenedor<>();
        this.map = new MapAnimales();
        this.scanner = new Scanner(System.in);
    }
    
    public void getController(){
       mostrarOpcion();
    }
    
    public void menuLista(){
        boolean continuar = true;  
        while(continuar){
            System.out.println("Menú de Opciones:");
            System.out.println("0. Transformar el árbol a lista");
            System.out.println("1. Mostrar lista");
            System.out.println("2. Ordenar lista");
            System.out.println("3. Invertir lista");
            System.out.println("4. Buscar características por nombre");
            System.out.println("5. Salir");
            System.out.print("Seleccione una opción: ");
        eleccion = scanner.nextInt();
         
         switch (eleccion) {
             case 0:
                 System.out.println("Transformando el arbol a lista");
                 contenedor.hojasDelArbol(arbol.getRaiz(), 0);
                 map.agregarMap(arbol.getRaiz().getHijoDer(), new Contenedor<>(), false);
                 break;
            case 1:
                System.out.println("Lista");
                contenedor.display();
                break;
            case 2:
                System.out.println("Ordenar lista");
                contenedor.InsertionSort();
                break;
            case 3:
                System.out.println("Invertir lista");
                contenedor.reverse();
                break;
            case 4:
                System.out.println("Ingrese el nombre del animal");
                String nombreAnimal = scanner.next();
                map.features(nombreAnimal);
                break;
            case 5:
                System.out.println("Saliendo...");
                continuar = false;
               break;
            default:
                break;
            }
        }
    }
    
    public void mostrarOpcion(){
        System.out.println("\nMenú Principal:");
        System.out.println("0. Arbol");
        System.out.println("1. Lista");
        System.out.println("2. Salir");
        System.out.print("Seleccione una opción: ");
        eleccion = scanner.nextInt();
            
        switch (eleccion) {
             case 0:
                controllerPreg.getController();
                break;
            case 1:
                menuLista();
                break;
            case 2:
                System.out.println("Saliendo...");
                break;
            default: 
                break;
      }
    }
    
}
