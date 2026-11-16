package mx.unam.fes.nolineal.arboles;
import java.util.Objects;

/**
 * Nodo de un árbol binario.
 * <p>
 * Guarda un dato, las referencias a sus hijos izquierdo y derecho, y una
 * etiqueta descriptiva que suele indicar la posición del nodo dentro del
 * árbol (por ejemplo, {@code "raiz"} o {@code "izquierdo,padre=10"}).
 * </p>
 *
 * @param <E> tipo de dato que almacena el nodo
 */
public class Nodo<E> {

    /** Dato almacenado en el nodo. */
    protected E dato;
    /** Referencias a los hijos izquierdo y derecho; {@code null} si no existen. */
    protected Nodo<E> izquierdo, derecho;
    /** Texto descriptivo de la posición del nodo dentro del árbol. */
    protected String etiqueta;

    /**
     * Crea un nodo vacío, sin dato y sin hijos.
     */
    public Nodo() {
        izquierdo = derecho = null;
    }

    /**
     * Crea un nodo con un dato y una etiqueta, sin hijos.
     *
     * @param dato dato que almacena el nodo
     * @param etiqueta texto descriptivo de la posición del nodo
     */
    public Nodo(E dato, String etiqueta) {
        this(dato, null, null, etiqueta);
    }

    /**
     * Crea un nodo con su dato, sus dos hijos y una etiqueta.
     *
     * @param dato dato que almacena el nodo
     * @param izquierdo hijo izquierdo del nodo
     * @param derecho hijo derecho del nodo
     * @param etiqueta texto descriptivo de la posición del nodo
     */
    public Nodo(E dato, Nodo<E> izquierdo, Nodo<E> derecho, String etiqueta) {
        this.dato = dato;
        this.izquierdo = izquierdo;
        this.derecho = derecho;
        this.etiqueta = etiqueta;
    }

    /**
     * Calcula el código hash a partir del dato almacenado.
     *
     * @return código hash del dato
     */
    @Override
    public int hashCode() {
        return Objects.hash(dato);
    }

    /**
     * Indica si el dato del nodo es menor que el valor recibido.
     * <p>
     * Solo compara cuando ambos valores son {@link Integer}; con cualquier
     * otro tipo devuelve {@code false}.
     * </p>
     *
     * @param obj valor con el que se compara el dato del nodo
     * @return {@code true} si el dato del nodo es un {@code Integer} menor que {@code obj}
     */
    public boolean mayor(Object obj) {
        boolean resultado = false;
        if (obj instanceof Integer && this.dato instanceof Integer) {
            Integer dato1 = (Integer) this.dato;
            Integer dato2 = (Integer) obj;
            if (dato1 < dato2) {
                return true;
            }
        }
        return resultado;
    }

    /**
     * Compara este nodo con otro objeto.
     * <p>
     * Si ambos datos son {@link Integer}, compara sus valores. En caso
     * contrario intenta convertir el argumento a {@code Nodo} y compara los
     * datos con {@link Objects#equals(Object, Object)}; si el argumento no es
     * un {@code Nodo}, puede lanzar {@link ClassCastException}.
     * </p>
     *
     * @param obj objeto con el que se compara
     * @return {@code true} si los datos de ambos nodos son iguales
     * @throws ClassCastException si el argumento no es un nodo y los datos no son enteros
     */
    @Override
    public boolean equals(Object obj) {
        if (obj instanceof Integer && this.dato instanceof Integer) {
            Integer dato1 = (Integer) this.dato;
            Integer dato2 = (Integer) obj;
            if (dato1.equals(dato2)) {
                return true;
            } else {
                return false;
            }
        }
        Nodo other = (Nodo) obj;
        return Objects.equals(dato, other.dato);
    }

	/**
	 * Devuelve el dato almacenado en el nodo.
	 *
	 * @return dato del nodo
	 */
	public E getDato() {
		return dato;
	}

	/**
	 * Cambia el dato almacenado en el nodo.
	 *
	 * @param dato nuevo dato del nodo
	 */
	public void setDato(E dato) {
		this.dato = dato;
	}

	/**
	 * Devuelve el hijo izquierdo del nodo.
	 *
	 * @return hijo izquierdo, o {@code null} si no existe
	 */
	public Nodo<E> getIzquierdo() {
		return izquierdo;
	}

	/**
	 * Cambia el hijo izquierdo del nodo.
	 *
	 * @param izquierdo nuevo hijo izquierdo
	 */
	public void setIzquierdo(Nodo<E> izquierdo) {
		this.izquierdo = izquierdo;
	}

	/**
	 * Devuelve el hijo derecho del nodo.
	 *
	 * @return hijo derecho, o {@code null} si no existe
	 */
	public Nodo<E> getDerecho() {
		return derecho;
	}

	/**
	 * Cambia el hijo derecho del nodo.
	 *
	 * @param derecho nuevo hijo derecho
	 */
	public void setDerecho(Nodo<E> derecho) {
		this.derecho = derecho;
	}

	/**
	 * Devuelve la etiqueta descriptiva del nodo.
	 *
	 * @return etiqueta del nodo
	 */
	public String getEtiqueta() {
		return etiqueta;
	}

	/**
	 * Cambia la etiqueta descriptiva del nodo.
	 *
	 * @param etiqueta nueva etiqueta del nodo
	 */
	public void setEtiqueta(String etiqueta) {
		this.etiqueta = etiqueta;
	}
    
    
}