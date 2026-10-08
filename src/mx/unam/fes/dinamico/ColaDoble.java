package mx.unam.fes.dinamico;

import mx.unam.fes.dinamico.ListaDoble.ListaDoblementeEnlazada;

/**
 * Cola (FIFO: el primero en entrar es el primero en salir) implementada con una lista doblemente enlazada ({@link ListaDoble}).
 * <p>
 * Se encola por la cola de la lista y se desencola por su cabeza, como en una
 * fila de banco. Ambas operaciones cuestan O(1).
 * </p>
 *
 * @param <E> tipo de dato que almacena la cola
 */
public class ColaDoble<E> {
    /** Lista que guarda los elementos; su cabeza es el frente de la cola. */
    private ListaDoblementeEnlazada<E> lista;

    /**
     * Crea una cola vacía.
     */
    public ColaDoble() {
        lista = new ListaDoblementeEnlazada<>();
    }

    /**
     * Indica si la cola no tiene elementos.
     *
     * @return {@code true} si la cola está vacía, {@code false} en caso contrario
     */
    public boolean esVacia() {
        return lista.esVacia();
    }

    /**
     * Agrega un elemento al final de la cola (enqueue). Complejidad O(1).
     *
     * @param dato elemento a encolar
     */
    public void encolar(E dato) {
        lista.agregarCola(dato);
    }

    /**
     * Quita y devuelve el elemento del frente (dequeue). Complejidad O(1).
     *
     * @return elemento del frente, o {@code null} si la cola está vacía
     */
    public E desencolar() {
        return lista.eliminarDeCabeza();
    }

    /**
     * Consulta el elemento del frente sin quitarlo (peek). Complejidad O(1).
     *
     * @return elemento del frente, o {@code null} si la cola está vacía
     */
    public E verFrente() {
        return lista.obtenerNodo(0);
    }

    /**
     * Imprime los elementos del frente al final, uno por línea.
     */
    public void imprimir() {
        lista.imprimir();
    }

    /**
     * Obtiene el número de elementos de la cola.
     *
     * @return cantidad de elementos
     */
    public int getLongitud() {
        return lista.getLongitud();
    }
}