package mx.unam.fes.dinamico;

import mx.unam.fes.dinamico.ListaSimple.ListaEnlazada;


/**
 * Lo hice al reves sacar por cabeza y agregar por cola por los recursos dado que es una lista simple es mas dificl eliminar en cola
 * @param <T>
 */
public class Cola<T> {
	private ListaEnlazada<T> cola;
	/**
	 * Almaceno el límite de elementos de la cola. Si le asigno un valor menor a 0, asumo que es ilimitada.
	 */
	private int capacidad;

	/**
	 * Genero este constructor para inicializar la lista enlazada y asignarle una capacidad de -1 (sin límite).
	 */
	public Cola() {
		this.cola = new ListaEnlazada<T>();
		this.capacidad = -1;
	}

	/**
	 * Genero este constructor en el que inicializo la lista y además le asigno una capacidad máxima específica.
	 * 
	 * @param capacidad El tamaño máximo que le permito a la cola.
	 */
	public Cola(int capacidad) {
		this.cola = new ListaEnlazada<T>();
		this.capacidad = capacidad;
	}

	/**
	 * Consulto y retorno el número de elementos guardados actualmente en la cola.
	 * 
	 * @return La cantidad de elementos presentes en la lista.
	 */
	public int getLongitud() {
		return cola.getLongitud();
	}

	/**
	 * Verifico si la cola no contiene ningún elemento.
	 * 
	 * @return true si la cola está vacía, false en caso contrario.
	 */
	public boolean esVacia() {
		return cola.esVacia();
	}

	/**
	 * Intento agregar un nuevo valor al final de la cola, validando primero si no he superado la capacidad límite.
	 * 
	 * @param valor El elemento que deseo insertar.
	 * @return true si logré insertar el elemento, o false si la cola ya está llena.
	 */
	public boolean agregar(T valor) {
		if (capacidad >= 0 && cola.getLongitud() >= capacidad) {
			return false;
		}
		cola.agregarCola(valor);
		return true;
	}

	/**
	 * Consulto el valor ubicado en el frente de la cola sin eliminarlo de la lista.
	 * 
	 * @return El valor al frente de la cola o null si la cola está vacía.
	 */
	public T recuperar() {
		if (cola.esVacia()) {
			return null;
		}
		return cola.getCabeza();
	}

	/**
	 * Extraigo y elimino el valor ubicado en el frente de la cola.
	 * 
	 * @return El valor eliminado del frente o null si la cola se encuentra vacía.
	 */
	public T sacar() {
		if (cola.esVacia()) {
			return null;
		}
		T valorCola = cola.getCabeza();
		cola.eliminarDeCabeza();
		return valorCola;
	}
	
	public void imprimir()
	{
		cola.imprimir();
	}

	@Override
	public String toString() {
		return "Cola [cola=" + cola + ", capacidad=" + capacidad + "]";
	}
	
}