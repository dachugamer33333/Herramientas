package mx.unam.fes.nolineal;

import mx.unam.fes.dinamico.Cola;
import mx.unam.fes.dinamico.Pila;

public class ArbolBinarioOrden<E> {

    protected Nodo<E> raiz;

    public ArbolBinarioOrden() {
        raiz = null;
    }

    public Nodo<E> getRaiz() {
        return raiz;
    }

    // ---------------------------------------------------------
    // INSERTAR: el nodo nuevo se adjunta a un nodo existente
    // ---------------------------------------------------------
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

    public void imprimir(Nodo<E> n) {
        System.out.println(n.dato + " " + n.etiqueta);
    }

    // ---------------------------------------------------------
    // RECORRIDO DE AMPLITUD (nivel por nivel, usa una cola)
    // ---------------------------------------------------------
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
    public void preorden(Nodo<E> n) {
        if (n != null) {
            imprimir(n);
            preorden(n.izquierdo);
            preorden(n.derecho);
        }
    }

    // LVR
    public void orden(Nodo<E> n) {
        if (n != null) {
            orden(n.izquierdo);
            imprimir(n);
            orden(n.derecho);
        }
    }

    // LRV
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