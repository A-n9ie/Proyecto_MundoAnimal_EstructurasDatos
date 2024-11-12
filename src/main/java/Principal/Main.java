/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package Principal;

import Business.Controller;
import Clases.Arbol;
import Presentacion.Vista;

public class Main {

    public static void main(String[] args) {
        
        Arbol arbol = new Arbol();
        Vista vista = new Vista();
        Controller controller = new Controller(vista, arbol);
        controller.getController();
    }
}
