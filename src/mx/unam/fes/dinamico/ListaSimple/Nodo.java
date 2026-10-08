package mx.unam.fes.dinamico.ListaSimple;

public class Nodo<T> {
	private T dato;
	private Nodo<T> siguiente;

	/**
	 * Genero este constructor para inicializar un nodo asignándole solo su dato y dejando la referencia al siguiente nodo en null.
	 * 
	 * @param dato El valor que asigno al nodo.
	 */
	public Nodo(T dato) {
		this(dato, null);
	}

	/**
	 * Genero este constructor para inicializar el nodo con su dato y enlazarlo directamente al siguiente nodo de la estructura.
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
	 * Obtengo la referencia al siguiente nodo en la lista.
	 * 
	 * @return El nodo enlazado a continuación.
	 */
	public Nodo<T> getSiguiente() {
		return siguiente;
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