/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package Principal;

import Business.ControllerPregunta;
import Clases.Animal;
import Clases.Arbol;

import com.google.gson.Gson;
import java.io.FileWriter;
import java.io.IOException;

/**
 *
 * @author ESCINF
 */
public class Main {

    public static void main(String[] args) {
        
        ControllerPregunta controller = new ControllerPregunta();
        controller.getController();
        
        Arbol arbolito;
        arbolito = new Arbol();
        
        arbolito.recorridoAmplitud();
        

        System.out.println(arbolito.getClass().getName());
        System.out.println(arbolito.getClass().getSimpleName());


    }
}
