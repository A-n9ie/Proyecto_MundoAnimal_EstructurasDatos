/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package Principal;

import Business.ControllerPregunta;
import Clases.Arbol;

/**
 *
 * @author ESCINF
 */
public class Main {

    public static void main(String[] args) {
        
        ControllerPregunta controller = new ControllerPregunta();
        controller.getController();
        /*
        Arbol arbolito = new Arbol();
        arbolito.recorridoAmplitud();
        
        System.out.println(arbolito.getClass().getName());
        System.out.println(arbolito.getClass().getSimpleName());
*/
    }
}
