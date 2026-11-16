package mx.unam.fes.nolineal.arboles;

import mx.unam.fes.dinamico.Cola;
import mx.unam.fes.dinamico.Pila;

/**
 * Árbol binario de búsqueda (ordenado) de datos genéricos.
 * <p>
 * La inserción es iterativa: los datos menores que el nodo actual se colocan
 * en el subárbol derecho y los mayores o iguales en el izquierdo, según el
 * criterio de {@link Nodo#mayor(Object)}. La clase incluye recorridos de
 * amplitud y de profundidad, tanto recursivos como iterativos usando las
 * clases {@link Cola} y {@link Pila} del paquete {@code dinamico}.
 * </p>
 * <p>
 * <b>Nota:</b> el orden del árbol depende de {@link Nodo#mayor(Object)}, que
 * solo compara datos de tipo {@link Integer}. Con otros tipos la inserción y
 * la búsqueda no mantienen un orden significativo.
 * </p>
 *
 * @param <E> tipo de dato que almacena el árbol
 */
public class ArbolBinarioOrden<E> {

    /** Nodo raíz del árbol; {@code null} si el árbol está vacío. */
    protected Nodo<E> raiz;

    /**
     * Crea un árbol vacío.
     */
    public ArbolBinarioOrden() {
        raiz = null;
    }

    /**
     * Devuelve la raíz del árbol.
     *
     * @return nodo raíz, o {@code null} si el árbol está vacío
     */
    public Nodo<E> getRaiz() {
        return raiz;
    }

    // ---------------------------------------------------------
    // INSERTAR: el nodo nuevo se adjunta a un nodo existente
    // ---------------------------------------------------------
    /**
     * Inserta un dato en el árbol respetando el orden binario de búsqueda.
     * <p>
     * Recorre el árbol de forma iterativa hasta encontrar una posición libre.
     * Si el dato ya existe o es igual al de un nodo, se coloca en el subárbol
     * izquierdo.
     * </p>
     *
     * @param dato dato que se desea insertar
     */
    public void insertar(E dato) {
        Nodo<E> n = raiz;
        Nodo<E> previo = null;
        while (n != null) {
            previo = n;
            if (n.mayor(dato)) {
                n = n.derecho;
            } else {
                n = n.izquierdo;
            }
        }
        if (raiz == null) {
            raiz = new Nodo<E>(dato, "raiz");
        } else if (previo.mayor(dato)) {
            previo.derecho = new Nodo<E>(dato, "derecho,padre=" + previo.dato);
        } else {
            previo.izquierdo = new Nodo<E>(dato, "izquierdo,padre=" + previo.dato);
        }
    }

    /**
     * Imprime el dato y la etiqueta de un nodo.
     *
     * @param n nodo que se desea imprimir; no debe ser {@code null}
     */
    public void imprimir(Nodo<E> n) {
        System.out.println(n.dato + " " + n.etiqueta);
    }

    // ---------------------------------------------------------
    // RECORRIDO DE AMPLITUD (nivel por nivel, usa una cola)
    // ---------------------------------------------------------
    /**
     * Recorre el árbol por niveles (amplitud), de la raíz hacia las hojas.
     * <p>
     * Usa una {@link Cola} para visitar primero todos los nodos de un nivel
     * antes de pasar al siguiente. Complejidad O(n).
     * </p>
     *
     * @throws Exception si falla una operación de la cola
     */
    public void recorridoAmplitud() throws Exception {
        Nodo<E> n = raiz;
        Cola<Nodo<E>> cola = new Cola<>();
        if (n != null) {
            cola.agregar(n);
            while (!cola.esVacia()) {
                n = cola.sacar();
                imprimir(n);
                if (n.izquierdo != null) {
                    cola.agregar(n.izquierdo);
                }
                if (n.derecho != null) {
                    cola.agregar(n.derecho);
                }
            }
        }
    }

    // ---------------------------------------------------------
    // RECORRIDOS DE PROFUNDIDAD (recursivos)
    // V: visitar, L: subárbol izquierdo, R: subárbol derecho
    // ---------------------------------------------------------

    // VLR
    /**
     * Recorrido en preorden (raíz, izquierdo, derecho).
     *
     * @param n nodo desde el que comienza el recorrido
     */
    public void preorden(Nodo<E> n) {
        if (n != null) {
            imprimir(n);
            preorden(n.izquierdo);
            preorden(n.derecho);
        }
    }

    // LVR
    /**
     * Recorrido en orden (izquierdo, raíz, derecho); en un árbol de búsqueda
     * visita los datos de menor a mayor.
     *
     * @param n nodo desde el que comienza el recorrido
     */
    public void orden(Nodo<E> n) {
        if (n != null) {
            orden(n.izquierdo);
            imprimir(n);
            orden(n.derecho);
        }
    }

    // LRV
    /**
     * Recorrido en postorden (izquierdo, derecho, raíz).
     *
     * @param n nodo desde el que comienza el recorrido
     */
    public void postorden(Nodo<E> n) {
        if (n != null) {
            postorden(n.izquierdo);
            postorden(n.derecho);
            imprimir(n);
        }
    }

    // ---------------------------------------------------------
    // RECORRIDOS DE PROFUNDIDAD (no recursivos, usan una pila)
    // ---------------------------------------------------------
    /**
     * Recorrido en orden sin recursión, usando una {@link Pila}.
     *
     * @throws Exception si falla una operación de la pila
     */
    public void noRecursivoOrden() throws Exception {
        Nodo<E> n = raiz;
        Pila<Nodo<E>> pila = new Pila<>();
        while (n != null) {
            while (n != null) {
                if (n.derecho != null) {
                    pila.agregar(n.derecho);
                }
                pila.agregar(n);
                n = n.izquierdo;
            }
            n = pila.sacar();
            while (!pila.esVacia() && n.derecho == null) {
                imprimir(n);
                n = pila.sacar();
            }
            imprimir(n);
            if (!pila.esVacia()) {
                n = pila.sacar();
            } else {
                n = null;
            }
        }
    }

    /**
     * Recorrido en preorden sin recursión, usando una {@link Pila}.
     *
     * @throws Exception si falla una operación de la pila
     */
    public void noRecursivoPreorden() throws Exception {
        Nodo<E> n = raiz;
        Pila<Nodo<E>> pila = new Pila<>();
        if (n != null) {
            pila.agregar(n);
            while (!pila.esVacia()) {
                n = pila.sacar();
                imprimir(n);
                if (n.derecho != null) {
                    pila.agregar(n.derecho);
                }
                if (n.izquierdo != null) {
                    pila.agregar(n.izquierdo);
                }
            }
        }
    }

    /**
     * Recorrido en postorden sin recursión, usando una {@link Pila}.
     *
     * @throws Exception si falla una operación de la pila
     */
    public void noRecursivoPostOrden() throws Exception {
        Nodo<E> n = raiz, p = raiz;
        Pila<Nodo<E>> pila = new Pila<>();
        while (n != null) {
            for (; n.izquierdo != null; n = n.izquierdo) {
                pila.agregar(n);
            }
            while (n != null && (n.derecho == null || n.derecho == p)) {
                imprimir(n);
                p = n;
                if (pila.esVacia()) {
                    return;
                }
                n = pila.sacar();
            }
            pila.agregar(n);
            n = n.derecho;
        }
    }

    // ---------------------------------------------------------
    // ELIMINAR un nodo
    // Caso 1: es hoja
    // Caso 2: tiene un hijo
    // Caso 3: tiene dos hijos
    // ---------------------------------------------------------
    /**
     * Elimina un nodo del árbol según el dato indicado.
     * <p>
     * Cubre los tres casos clásicos: nodo hoja, nodo con un solo hijo y nodo
     * con dos hijos. En el último caso se usa el mayor elemento del subárbol
     * izquierdo (predecesor en orden) para reemplazar al nodo eliminado.
     * </p>
     * <p>
     * Si el dato no existe, se imprime un aviso por consola y el árbol no se
     * modifica; si el árbol está vacío, se imprime {@code "Arbol vacio"}.
     * </p>
     *
     * @param dato dato del nodo que se desea eliminar
     */
    @SuppressWarnings("unused")
    public void eliminar(E dato) {
        Nodo<E> tmp;
        Nodo<E> nodo;
        Nodo<E> n = raiz;
        Nodo<E> previo = null;

        // Buscar el nodo y guardar su padre
        while (n != null && !n.equals(dato)) {
            previo = n;
            if (n.mayor(dato)) {
                n = n.derecho;
            } else {
                n = n.izquierdo;
            }
        }
        nodo = n;

        if (n != null && n.equals(dato)) {
            if (nodo.derecho == null) {
                nodo = nodo.izquierdo;
            } else if (nodo.izquierdo == null) {
                nodo = nodo.derecho;
            } else {
                tmp = nodo.izquierdo;               // 1
                while (tmp.derecho != null) {       // 2
                    tmp = tmp.derecho;
                }
                tmp.derecho = nodo.derecho;         // 3
                nodo = nodo.izquierdo;              // 4
            }

            if (n == raiz) {
                raiz = nodo;
            } else if (previo.izquierdo == n) {
                previo.izquierdo = nodo;
            } else {
                previo.derecho = nodo;              // 5
            }
        } else if (raiz != null) {
            System.out.println("No se encuentra el dato " + dato);
        } else {
            System.out.println("Arbol vacio");
        }
    }
}