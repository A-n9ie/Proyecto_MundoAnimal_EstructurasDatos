/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package Principal;

import Business.ControllerPregunta;
import Clases.Animal;
import Clases.Arbol;
import Clases.Contenedor;
import java.util.ArrayList;
import javax.swing.JOptionPane;

public class Main {

    public static void main(String[] args) {
        /*
        ControllerPregunta controller = new ControllerPregunta();
        controller.getController();
        /*/
        Arbol arbol = new Arbol();

        Contenedor<Animal> contenedor = new Contenedor<>();
        
        
        contenedor.hojasDelArbol(arbol.getRaiz(), 0);
        contenedor.display();
        contenedor.mostrarMap();
        contenedor.agregarMap(arbol.getRaiz().getHijoDer(), new ArrayList<>(), false);
        contenedor.mostrarMap();
        /*//contenedor.InsertionSort();
        //contenedor.reverse();*/
        String nombreAnimal = JOptionPane.showInputDialog("Ingrese el nombre del animal a buscar");
        contenedor.features(nombreAnimal);
    }
}
