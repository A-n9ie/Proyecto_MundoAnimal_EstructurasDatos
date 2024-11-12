/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Presentacion;

import Clases.Animal;
import javax.swing.JOptionPane;

/**
 *
 * @author sharo
 */
public class Vista {
   
     public String pedirRespuesta(String pregunta) {
        return JOptionPane.showInputDialog(pregunta);
    }

    public void mostrarMensaje(String mensaje) {
        JOptionPane.showMessageDialog(null, mensaje);
    }

    public void mostrarAnimal(Animal animal) {
        JOptionPane.showMessageDialog(null, "El animal que pensaste es: " + animal.getNombre());
    }

    public void mostrarNuevoAnimal(String nombre, String caracteristica) {
        JOptionPane.showMessageDialog(null, "Se ha agregado el animal " + nombre + " con la característica " + caracteristica);
    }
    
    public void mostrarLista(String mensaje) {
        JOptionPane.showMessageDialog(null, mensaje);
    }
    
    public int mostrarLista() {
        String[] opciones = {"Transformar", "Mostrar Lista", "Lista Ordenada", "Lista invertida", "Buscar caracteristicas", "Salir"};
        return JOptionPane.showOptionDialog(
        null,
        "Selecciona una opción:\n Recomendacion: Tranformar de arbol a lista",
        "Menú",
        JOptionPane.DEFAULT_OPTION,
        JOptionPane.INFORMATION_MESSAGE,
        null,
        opciones,
        opciones[0]
    );
    }
  
    public int mostrarMenuPrincipal() {
        String[] opciones = {"Arbol", "Lista", "Salir"};
        return JOptionPane.showOptionDialog(
        null,
        "Selecciona una opción:",
        "Menú",
        JOptionPane.DEFAULT_OPTION,
        JOptionPane.INFORMATION_MESSAGE,
        null,
        opciones,
        opciones[0]
    );
    }
    
}
