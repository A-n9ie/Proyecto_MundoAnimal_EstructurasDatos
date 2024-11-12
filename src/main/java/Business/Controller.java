/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Business;

import Clases.Animal;
import Clases.Arbol;
import Clases.Contenedor;
import Clases.MapAnimales;
import Presentacion.Vista;

/**
 *
 * @author sharo
 */
public class Controller {
    private ControllerPregunta controllerPreg;
    private Arbol arbol;
    private Vista vista;
    private Contenedor<Animal> contenedor;
    private MapAnimales map;
    int eleccion;

    public Controller(Vista vista, Arbol arbol) {
        this.vista = vista;
        this.arbol = arbol;
        this.controllerPreg = new ControllerPregunta(vista, arbol);
        this.contenedor = new Contenedor<>();
        this.map = new MapAnimales();
    }
    
    public void getController(){
       mostrarOpcion();
    }
    
    public void menuLista(){
        //boolean continuar = true;
        
        while(true){
        eleccion = vista.mostrarLista();
         
         switch (eleccion) {
             case 0:
                 vista.mostrarMensaje("Transformando el arbol a lista");
                 contenedor.hojasDelArbol(arbol.getRaiz(), 0);
                 map.agregarMap(arbol.getRaiz().getHijoDer(), new Contenedor<>(), false);
                 break;
            case 1:
                vista.mostrarMensaje("Mostrar lista");
                contenedor.display();
                break;
            case 2:
                vista.mostrarMensaje("Mostrar lista ordenada");
                contenedor.InsertionSort();
                break;
            case 3:
                vista.mostrarMensaje("Mostrar lista invertida");
                contenedor.reverse();
                break;
            case 4:
                String nombreAnimal = vista.pedirRespuesta("Ingrese el nombre del animal");
                map.features(nombreAnimal);
                break;
            case 5:
               vista.mostrarMensaje("Saliendo...");
               System.exit(0);
               break;
            default:
                break;
            }
        }
    }
    
    public void mostrarOpcion(){
        eleccion = vista.mostrarMenuPrincipal();
            
        switch (eleccion) {
             case 0:
                controllerPreg.getController();
                break;
            case 1:
                menuLista();
                break;
            case 2:
                vista.mostrarMensaje("Saliendo...");
                System.exit(0);
                break;
            default: 
                break;
      }

    }
    
}
