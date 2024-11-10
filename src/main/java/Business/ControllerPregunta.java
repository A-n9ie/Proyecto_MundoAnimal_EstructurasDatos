/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Business;

import Clases.Animal;
import Clases.Arbol;
import Clases.Nodo;
import Presentacion.VistaPregunta;

/**
 *
 * @author angie
 */
public class ControllerPregunta {
    private Arbol arbolito;
    private Nodo root;
    private VistaPregunta vPregunta;
    private ControllerRegistro vRegistro;

    public ControllerPregunta() {
        this.arbolito = new Arbol();
        this.root = arbolito.getRaiz().getHijoDer();
        this.vPregunta = new VistaPregunta();
        this.vRegistro = new ControllerRegistro();
        //generarPregunta();
        vPregunta.setVisible(true);
        
    }

    public ControllerPregunta(Arbol arbolito, VistaPregunta vista) {
        this.arbolito = arbolito;
        this.vPregunta = vista;
        vista.setVisible(true);
    }
    
    public void getController(){
        vPregunta.addSi_btn(e -> realizarPregunta("Si"));
        vPregunta.addNo_btn(e -> realizarPregunta("No"));
        vPregunta.addReiniciar_btn(e -> reiniciar());
        vPregunta.addSalir_btn(e -> salir());
    }
    
    private void generarPregunta(){
        String pregunta = "¿El animal ";
        if (root.getAnimal() != null)
            pregunta += "es un/a " + root.getAnimal() + "?";
        else 
            pregunta += root.getCaracteristica() + "?";

        vPregunta.setPregunta_txt(pregunta);
    }
    
    private void realizarPregunta(String respuesta){
        if(arbolito.hoja(root) && respuesta.equals("Si")){
            vPregunta.notify("Animal Encontrado.");
        }
        else if (arbolito.hoja(root) && respuesta.equals("No") || root.getHijoIzq() == null && respuesta.equals("No")){
            vPregunta.notify("Animal NO Encontrado.\n Registre al nuevo animal");
            vRegistro.setRoot(root);
            vRegistro.setArbolito(arbolito);
            vRegistro.getVista().setVisible(true);
            vRegistro.getController();
            reiniciar();
        }
        else{
            root = arbolito.recorrer(root, respuesta);
            generarPregunta();
        }
    }
    
    public void reiniciar(){
        this.root = arbolito.getRaiz().getHijoDer();
        generarPregunta();
    }
    
    public void salir(){
        this.vPregunta.dispose();
        this.arbolito.guardarJson("arbol.json");
    }
    
}
