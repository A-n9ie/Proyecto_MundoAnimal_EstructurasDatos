package Clases;


/**
 *
 * @author sharo
 * @param <T>
 */

public class Contenedor<T> {
    private NodoGenerico<T> dummy;
    private NodoGenerico<T> back;

    public Contenedor() {
        this.dummy = new NodoGenerico<>();
        this.back = new NodoGenerico<>();
        dummy.setDerecha(back);
        back.setIzquierda(dummy);   
    }
    
    public Contenedor(Contenedor<T> otroContenedor) {   //Contructor copia
        this.dummy = new NodoGenerico<>();
        this.back = new NodoGenerico<>();
        dummy.setDerecha(back);
        back.setIzquierda(dummy);

        if (otroContenedor.dummy.getDerecha() != otroContenedor.back) {
            NodoGenerico<T> temp = otroContenedor.dummy.getDerecha();
            while (temp != otroContenedor.back) {
                agregarPrimero(temp.getContenido());  
                temp = temp.getDerecha();
            }
        }
    }

    
    public boolean isEmpty() {
        return dummy.getDerecha() == back;  // La lista está vacía si el nodo después de dummy es back
    }
    
    public void hojasDelArbol(Nodo root, int nivel){
        if(root == null){
            return;
        }
        
        if(root.getHijoIzq() == null && root.getHijoDer() == null){
            Animal animal = root.getAnimal();
            animal.setCodigo(nivel);
           
            agregarPrimero((T) animal);
        }
        
        hojasDelArbol(root.getHijoIzq(), nivel+1);
        hojasDelArbol(root.getHijoDer(), nivel+1);
    }
    
    public void agregarPrimero(T contenido){
        NodoGenerico<T> nuevoNodo = new NodoGenerico<>(contenido);
        nuevoNodo.setDerecha(dummy.getDerecha());

        dummy.getDerecha().setIzquierda(nuevoNodo);

        
        dummy.setDerecha(nuevoNodo);
    }
    
    public T popFirst() {
        if (dummy.getDerecha() == back) {
            System.out.println("La lista está vacía.");
            return null;
        }

        NodoGenerico<T> nodoAEliminar = dummy.getDerecha();
        T contenido = nodoAEliminar.getContenido();

        dummy.setDerecha(nodoAEliminar.getDerecha());
        nodoAEliminar.getDerecha().setIzquierda(dummy);

        return contenido;
    }

    public void addLast(T contenido){
        NodoGenerico nuevoNodo = new NodoGenerico<>(contenido);
        //nuevoNodo.setDerecha(back);
        nuevoNodo.setIzquierda(back.getIzquierda());
        
         //if (back.getIzquierda()!= null) {
            back.getIzquierda().setDerecha(nuevoNodo);
       // }
        
        back.setIzquierda(nuevoNodo);
    }
    
    public T popLast() {
        if (dummy.getDerecha() == back) {
            System.out.println("La lista está vacía.");
            return null;
        }

        NodoGenerico<T> nodoAEliminar = back.getIzquierda();
        T contenido = nodoAEliminar.getContenido();

        back.setIzquierda(nodoAEliminar.getIzquierda());
        nodoAEliminar.getIzquierda().setDerecha(back);

        return contenido;
    }
    
    public T get(int index) {
        if (index < 0 || index >= size()) {
            throw new IndexOutOfBoundsException("Índice fuera de los límites del contenedor.");
        }

        NodoGenerico<T> temp = dummy.getDerecha();
        int cont = 0;

        while (temp != back && cont < index) {
            temp = temp.getDerecha();
            cont++;
        }

        return temp.getContenido();  
    }

    public int size() {
        int cont = 0;
        NodoGenerico<T> temp = dummy.getDerecha();

        while (temp != back) {
            cont++;
            temp = temp.getDerecha();
        }

        return cont;
    }

    
    public void display() {
        
        if (dummy.getDerecha() == back) {
        System.out.println("La lista está vacía.");
        return;
        }   
        
        NodoGenerico<T> temp = dummy.getDerecha();
        
        while (temp != back) {
            if (temp != null && temp.getContenido() != null) {
                Animal animal = (Animal) temp.getContenido();
                System.out.println(temp.getContenido().toString() + " codigo " + animal.getCodigo());
            }
            temp = temp.getDerecha();
        }
    }
    
    public void InsertionSort(){
        if(dummy.getDerecha() == back || dummy.getDerecha().getDerecha() == back){//si esta vacia o si solo tiene un elemento
            return;
        }
        
        NodoGenerico<T> nodoActual = dummy.getDerecha().getDerecha();
        
        while(nodoActual != back){
            
            NodoGenerico<T> siguiente = nodoActual.getDerecha();
            NodoGenerico<T> ordenado = nodoActual.getIzquierda();
           
            
            while(ordenado != dummy && ((Animal) ordenado.getContenido()).getCodigo() > ((Animal) nodoActual.getContenido()).getCodigo()){
                ordenado = ordenado.getIzquierda();
            }
            
            nodoActual.getIzquierda().setDerecha(nodoActual.getDerecha());
            nodoActual.getDerecha().setIzquierda(nodoActual.getIzquierda());
            
            
            //insertar ordenado
            
            nodoActual.setDerecha(ordenado.getDerecha());
            ordenado.getDerecha().setDerecha(nodoActual);
            ordenado.setDerecha(nodoActual);
            nodoActual.setIzquierda(ordenado);
            
            nodoActual = siguiente;
        }
    }
    
    public void reverse(){
       NodoGenerico<T> actual = dummy.getDerecha();
       NodoGenerico<T> temporal;
       
       while(actual != back){
           
           temporal = actual.getDerecha();
           
           actual.setDerecha(actual.getIzquierda());
           actual.setIzquierda(temporal);
           
           actual = temporal;
       }
       
       temporal = dummy;
       dummy = back;
       back = temporal;
    }
}
