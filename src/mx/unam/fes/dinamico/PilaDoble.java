package mx.unam.fes.dinamico;

import mx.unam.fes.dinamico.ListaDoble.ListaDoblementeEnlazada;

/**
 * Pila (LIFO: el último en entrar es el primero en salir) implementada con una lista doblemente enlazada ({@link ListaDoble}).
 * <p>
 * La cima de la pila es la cabeza de la lista, así que {@link #apilar} y
 * {@link #desapilar} trabajan en el mismo extremo y cuestan O(1).
 * </p>
 *
 * @param <E> tipo de dato que almacena la pila
 */
public class PilaDoble<E> {
    /** Lista que guarda los elementos; su cabeza es la cima de la pila. */
    private ListaDoblementeEnlazada<E> lista;

    /**
     * Crea una pila vacía.
     */
    public PilaDoble() {
        lista = new ListaDoblementeEnlazada<>();
    }

    /**
     * Indica si la pila no tiene elementos.
     *
     * @return {@code true} si la pila está vacía, {@code false} en caso contrario
     */
    public boolean esVacia() {
        return lista.esVacia();
    }

    /**
     * Coloca un elemento en la cima de la pila (push). Complejidad O(1).
     *
     * @param dato elemento a apilar
     */
    public void apilar(E dato) {
        lista.agregarCabeza(dato);
    }

    /**
     * Quita y devuelve el elemento de la cima (pop). Complejidad O(1).
     *
     * @return elemento de la cima, o {@code null} si la pila está vacía
     */
    public E desapilar() {
        return lista.eliminarDeCabeza();
    }

    /**
     * Consulta el elemento de la cima sin quitarlo (peek). Complejidad O(1).
     *
     * @return elemento de la cima, o {@code null} si la pila está vacía
     */
    public E verCima() {
        return lista.obtenerNodo(0);
    }

    /**
     * Imprime los elementos de la cima hacia el fondo, uno por línea.
     */
    public void imprimir() {
    	lista.imprimir();
    }

    /**
     * Obtiene el número de elementos de la pila.
     *
     * @return cantidad de elementos
     */
    public int getLongitud() {
        return lista.getLongitud();
    }
}