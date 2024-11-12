/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package Principal;

import Business.Controller;
import Clases.Arbol;

public class Main {

    public static void main(String[] args) {
        
        Arbol arbol = new Arbol();
        Controller controller = new Controller(arbol);
        controller.getController();
    }
}
