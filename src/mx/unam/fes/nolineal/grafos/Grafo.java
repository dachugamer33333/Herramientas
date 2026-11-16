package mx.unam.fes.nolineal.grafos;

import mx.unam.fes.dinamico.ListaSimple.ListaEnlazada;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;

/**
 * Grafo ponderado implementado con una lista de adyacencia.
 * <p>
 * Cada vértice se asocia con una {@link ListaEnlazada} de {@link Arista} que
 * contiene sus vecinos. El grafo puede ser dirigido o no dirigido: en el
 * segundo caso, cada llamada a {@link #agregarArista} crea también la arista
 * inversa.
 * </p>
 * <p>
 * Se permiten aristas paralelas (varias aristas entre el mismo par de
 * vértices) y bucles (una arista de un vértice a sí mismo). Los vértices deben
 * implementar correctamente {@code equals} y {@code hashCode}, porque se usan
 * como llaves de un {@link HashMap}.
 * </p>
 *
 * @param <T> tipo de dato que identifica a los vértices
 */
public class Grafo<T> {
    /** Asocia cada vértice con la lista enlazada de sus aristas salientes. */
    private Map<T, ListaEnlazada<Arista<T>>> listaAdyacencia;
    /** Indica si las aristas tienen dirección o son bidireccionales. */
    private boolean esDirigido;

    /**
     * Crea un grafo vacío.
     *
     * @param esDirigido {@code true} si el grafo es dirigido, {@code false} si es no dirigido
     */
    public Grafo(boolean esDirigido) {
        this.esDirigido = esDirigido;
        this.listaAdyacencia = new HashMap<>();
    }

    /**
     * Agrega un vértice al grafo si todavía no existe, con una lista de
     * adyacencia vacía. Si el vértice ya existe, no se modifica.
     *
     * @param dato vértice que se desea agregar
     */
    public void agregarVertice(T dato) {
        listaAdyacencia.putIfAbsent(dato, new ListaEnlazada<>());
    }

    /**
     * Agrega una arista ponderada entre dos vértices.
     * <p>
     * Si alguno de los dos vértices no existe, se crea automáticamente. La
     * arista se inserta al final de la lista de adyacencia del origen. Cuando
     * el grafo no es dirigido también se agrega la arista inversa con el mismo
     * peso.
     * </p>
     *
     * @param origen vértice de salida
     * @param destino vértice de llegada
     * @param peso costo asociado al recorrido
     */
    public void agregarArista(T origen, T destino, double peso) {
        agregarVertice(origen);
        agregarVertice(destino);
        
        // Usamos tu método personalizado agregarCola() de la ListaEnlazada
        listaAdyacencia.get(origen).agregarCola(new Arista<>(destino, peso));
        
        // Si el grafo no es dirigido, agregamos la conexión inversa
        if (!esDirigido) {
            listaAdyacencia.get(destino).agregarCola(new Arista<>(origen, peso));
        }
    }

    /**
     * Devuelve la lista de aristas adyacentes a un vértice.
     * <p>
     * Si el vértice no existe en el grafo, devuelve una lista vacía nueva en
     * lugar de {@code null}. Si existe, devuelve la lista interna del grafo,
     * por lo que modificarla altera el grafo.
     * </p>
     *
     * @param vertice vértice cuyas aristas se quieren consultar
     * @return lista enlazada con las aristas del vértice, nunca {@code null}
     */
    public ListaEnlazada<Arista<T>> obtenerAdyacentes(T vertice) {
        return listaAdyacencia.getOrDefault(vertice, new ListaEnlazada<>());
    }

    /**
     * Devuelve el conjunto de todos los vértices del grafo.
     * <p>
     * Es la vista viva del mapa interno: los cambios posteriores en el grafo
     * se reflejan en el conjunto devuelto.
     * </p>
     *
     * @return conjunto de vértices del grafo
     */
    public Set<T> obtenerVertices() {
        return listaAdyacencia.keySet();
    }

    /**
     * Indica si el grafo es dirigido.
     *
     * @return {@code true} si las aristas tienen dirección, {@code false} si son bidireccionales
     */
    public boolean esDirigido() {
        return esDirigido;
    }
}