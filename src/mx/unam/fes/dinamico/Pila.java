package mx.unam.fes.dinamico;

import mx.unam.fes.dinamico.ListaSimple.ListaEnlazada;
/**
 * Se crea una clase pila con valores genericos para que pueda recibir cualquier tipo de dato
 * @param <T>
 */
public class Pila<T> {
	private ListaEnlazada<T> pila;

	/**
	 * Almaceno el límite de elementos de la pila. Si le asigno un valor menor a 0, asumo que es ilimitada.
	 */
	private int capacidad;

	/**
	 * Genero este constructor para inicializar la lista enlazada y asignarle una capacidad de -1 (sin límite).
	 */
	public Pila() {
		this.pila = new ListaEnlazada<T>();
		this.capacidad = -1;
	}

	/**
	 * Genero este constructor en el que inicializo la lista y además le asigno una capacidad máxima específica.
	 * 
	 * @param capacidad El tamaño máximo que le permito a la pila.
	 */
	public Pila(int capacidad) {
		this.pila = new ListaEnlazada<T>();
		this.capacidad = capacidad;
	}

	/**
	 * Consulto y retorno el número de elementos guardados actualmente en la pila.
	 * 
	 * @return La cantidad de elementos presentes en la lista.
	 */
	public int getLongitud() {
		return pila.getLongitud();
	}

	/**
	 * Verifico si la pila no contiene ningún elemento.
	 * 
	 * @return true si la pila está vacía, false en caso contrario.
	 */
	public boolean esVacia() {
		return pila.esVacia();
	}

	/**
	 * Intento agregar un nuevo valor en la cima de la pila, validando primero si no he superado la capacidad límite.
	 * 
	 * @param valor El elemento que deseo insertar.
	 * @return true si logré insertar el elemento, o false si la pila ya está llena.
	 */
	public boolean agregar(T valor) {
		if (capacidad >= 0 && pila.getLongitud() >= capacidad) {
			return false;
		}
		pila.agregarCabeza(valor);
		return true;
	}

	/**
	 * Consulto el valor que se encuentra en la cima de la pila sin eliminarlo de la lista.
	 * 
	 * @return El valor de la cima o null si la pila está vacía.
	 */
	public T recuperar() {
		if (pila.esVacia()) {
			return null;
		}
		return pila.getCabeza();
	}

	/**
	 * Extraigo y elimino el valor ubicado en la cima de la pila.
	 * 
	 * @return El valor eliminado de la cima o null si la pila se encuentra vacía.
	 */
	public T sacar() {
		if (pila.esVacia()) {
			return null;
		}
		T valorCabeza = pila.getCabeza();
		pila.eliminarDeCabeza();
		return valorCabeza;
	}
}