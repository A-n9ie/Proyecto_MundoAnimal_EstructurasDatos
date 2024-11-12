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
        System.out.println("\n-BIENVENIDO AL MUNDO DE LOS ANIMALES-");
       mostrarOpcion();
    }
    
    public void menuLista(){ 
        do{
            System.out.println("Menú de Opciones:");
            System.out.println("1. Mostrar lista");
            System.out.println("2. Ordenar lista");
            System.out.println("3. Invertir lista");
            System.out.println("4. Buscar características por nombre");
            System.out.println("5. Salir");
            System.out.print("Seleccione una opción: ");
            eleccion = scanner.nextInt();
         
            switch (eleccion) {
                case 1:
                    System.out.println("");
                    System.out.println("Lista:");
                    contenedor.display();
                    System.out.println("");
                    break;
                case 2:
                    System.out.println("");
                    System.out.println("Ordenar lista");
                    contenedor.InsertionSort();
                    System.out.println("");
                    break;
                case 3:
                    System.out.println("");
                    System.out.println("Invertir lista");
                    contenedor.reverse();
                    System.out.println("");
                    break;
                case 4:
                    System.out.println("");
                    System.out.println("Ingrese el nombre del animal");
                    String nombreAnimal = new Scanner(System.in).nextLine();
                    map.features(nombreAnimal);
                    System.out.println("");
                    break;
                case 5:
                    System.out.println("Saliendo...\n");
                   break;
                default:
                    System.out.println("Opcion no valida\n");
                    break;
            }
        }while (eleccion != 5);
    }
    
    public void mostrarOpcion(){
        do{
            System.out.println("\nMenú Principal:");
            System.out.println("1. Arbol");
            System.out.println("2. Lista");
            System.out.println("3. Salir");
            System.out.print("Seleccione una opción: ");
            eleccion = scanner.nextInt();

            switch (eleccion) {
                 case 1:
                    controllerPreg.getController();
                    break;
                case 2:
                    contenedor.clear();
                    System.out.println("\nTransformando el arbol a lista...\n\n");
                    contenedor.hojasDelArbol(arbol.getRaiz(), 0);
                    map.agregarMap(arbol.getRaiz().getHijoDer(), new Contenedor<>(), false);
                    menuLista();
                    break;
                case 3:
                    System.out.println("Saliendo...\n Gracias por usar el programa!");
                    break;
                default: 
                    System.out.println("opcion no valida\n");
                    break;
          }
      } while (eleccion != 3);
    }
    
}
