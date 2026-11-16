package mx.unam.fes.nolineal.grafos;

import mx.unam.fes.dinamico.ListaSimple.ListaEnlazada;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;

public class Grafo<T> {
    // Mapa que asocia cada vértice con tu ListaEnlazada personalizada de aristas
    private Map<T, ListaEnlazada<Arista<T>>> listaAdyacencia;
    private boolean esDirigido;

    public Grafo(boolean esDirigido) {
        this.esDirigido = esDirigido;
        this.listaAdyacencia = new HashMap<>();
    }

    /**
     * Agrega un vértice al grafo si no existe, inicializando su lista enlazada vacía.
     */
    public void agregarVertice(T dato) {
        listaAdyacencia.putIfAbsent(dato, new ListaEnlazada<>());
    }

    /**
     * Agrega una arista ponderada entre el origen y el destino utilizando tu ListaEnlazada.
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
     * Obtiene la lista enlazada de aristas adyacentes a un vértice.
     */
    public ListaEnlazada<Arista<T>> obtenerAdyacentes(T vertice) {
        return listaAdyacencia.getOrDefault(vertice, new ListaEnlazada<>());
    }

    /**
     * Devuelve el conjunto de todos los vértices del grafo.
     */
    public Set<T> obtenerVertices() {
        return listaAdyacencia.keySet();
    }

    public boolean esDirigido() {
        return esDirigido;
    }
}