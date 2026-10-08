package mx.unam.fes.dinamico.ListaDoble;

public class Nodo<T> {
	private T dato;
	private Nodo<T> siguiente;

	/**
	 * Mantengo la referencia o puntero hacia el nodo anterior en estructuras doblemente enlazadas.
	 */
	private Nodo<T> anterior;

	/**
	 * Genero este constructor para inicializar un nodo pasando únicamente el dato y dejando la referencia al siguiente nodo en null.
	 * 
	 * @param dato El valor que asigno al nodo.
	 */
	public Nodo(T dato) {
		this(dato, null);
	}

	/**
	 * Genero este constructor para inicializar el nodo con su dato y enlazarlo directamente con el siguiente nodo.
	 * 
	 * @param dato El valor que asigno al nodo.
	 * @param siguiente La referencia al nodo que estará a continuación.
	 */
	public Nodo(T dato, Nodo<T> siguiente) {
		this.dato = dato;
		this.siguiente = siguiente;
	}

	/**
	 * Obtengo el valor almacenado en este nodo.
	 * 
	 * @return El dato de tipo T contenido en el nodo.
	 */
	public T getDato() {
		return dato;
	}

	/**
	 * Actualizo o modifico el valor guardado dentro del nodo.
	 * 
	 * @param dato El nuevo valor que asigno al nodo.
	 */
	public void setDato(T dato) {
		this.dato = dato;
	}

	/**
	 * Obtengo la referencia al siguiente nodo en la secuencia.
	 * 
	 * @return El nodo enlazado a continuación.
	 */
	public Nodo<T> getSiguiente() {
		return siguiente;
	}

	/**
	 * Obtengo la referencia al nodo previo en la secuencia.
	 * 
	 * @return El nodo enlazado hacia atrás.
	 */
	public Nodo<T> getanterior() {
		return anterior;
	}

	/**
	 * Establezco o actualizo la referencia hacia el nodo anterior.
	 * 
	 * @param anterior El nodo que ubico como previo.
	 */
	public void setanterior(Nodo<T> anterior) {
		this.anterior = anterior;
	}

	/**
	 * Establezco o actualizo la referencia hacia el siguiente nodo.
	 * 
	 * @param siguiente El nodo que ubico a continuación.
	 */
	public void setSiguiente(Nodo<T> siguiente) {
		this.siguiente = siguiente;
	}
}