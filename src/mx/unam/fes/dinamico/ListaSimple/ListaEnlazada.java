package mx.unam.fes.dinamico.ListaSimple;

public class ListaEnlazada<T> {
	private Nodo<T> cola;
	private Nodo<T> cabeza;
	private int longitud = 0;

	/**
	 * Genero el constructor por defecto indicando que la lista inicia vacía, asignando null a la cabeza y a la cola.
	 */
	public ListaEnlazada() {
		cabeza = cola = null;
	}

	/**
	 * Verifico si la lista se encuentra vacía evaluando la existencia de la cabeza.
	 * 
	 * @return true si la lista no contiene nodos, false en caso contrario.
	 */
	public boolean esVacia() {
		return cabeza == null;
	}

	/**
	 * Inserto un nuevo nodo al inicio de la lista y actualizo las referencias necesarias.
	 * 
	 * @param dato El valor que deseo agregar al principio.
	 */
	public void agregarCabeza(T dato) {
		cabeza = new Nodo<T>(dato, cabeza);
		if (cola == null) {
			cola = cabeza;
		}
		longitud++;
	}

	/**
	 * Inserto un nuevo nodo al final de la lista reconectando la cola actual.
	 * 
	 * @param dato El valor que deseo agregar al final.
	 */
	public void agregarCola(T dato) {
		if (!esVacia()) {
			cola.setSiguiente(new Nodo<T>(dato));
			cola = cola.getSiguiente();
		} else {
			cola = cabeza = new Nodo<T>(dato);
		}
		longitud++;
	}

	/**
	 * Elimino el nodo ubicado al inicio de la lista y desplazo la cabeza al siguiente elemento.
	 * 
	 * @return El dato del nodo eliminado o null si la lista estaba vacía.
	 */
	public T eliminarDeCabeza() {
		T dato = null;
		if (!esVacia()) {
			dato = cabeza.getDato();
			if (cabeza == cola) {
				cabeza = cola = null;
			} else {
				cabeza = cabeza.getSiguiente();
			}
			longitud--;
		}
		return dato;
	}

	/**
	 * Consulto la cantidad total de elementos almacenados en la lista.
	 * 
	 * @return La longitud actual de la lista.
	 */
	public int getLongitud() {
		return longitud;
	}

	/**
	 * Elimino el último nodo de la lista recorriéndola hasta encontrar el penúltimo elemento para reasignar la cola.
	 * 
	 * @return El dato del nodo eliminado o null si la lista estaba vacía.
	 */
	public T elimiarDeCola() {
		T dato = null;
		if (!esVacia()) {
			dato = cola.getDato();
			if (cabeza == cola) {
				cabeza = cola = null;
			} else {
				Nodo<T> temp;
				for (temp = cabeza; temp.getSiguiente() != cola; temp = temp.getSiguiente())
					;

				cola = temp;
				cola.setSiguiente(null);
			}
			longitud--;
		}
		return dato;
	}

	/**
	 * Recorro la lista de forma secuencial para obtener el dato guardado en una posición específica.
	 * 
	 * @param indice La posición del nodo que deseo recuperar.
	 * @return El dato del nodo en la posición indicada o null si el índice supera los límites.
	 */
	public T obtenerNodo(int indice) {
		Nodo<T> temp = cabeza;
		for (int contador = 0; contador < indice && temp != null; contador++, temp = temp.getSiguiente())
			;
		if (temp != null) {
			return (T) temp.getDato();
		} else {
			return null;
		}
	}

	/**
	 * Busco el nodo en la posición indicada y reemplazo el dato que almacena por un nuevo valor.
	 * 
	 * @param dato El nuevo valor que deseo asignar.
	 * @param indice La posición del nodo que deseo modificar.
	 * @return true si logré actualizar el valor, o false si el índice no existe.
	 */
	public boolean insertarEnIndice(T dato, int indice) {
		Nodo<T> temp = cabeza;
		for (int contador = 0; contador < indice && temp != null; contador++, temp = temp.getSiguiente())
			;
		if (temp != null) {
			temp.setDato(dato);
			return true;
		} else {
			return false;
		}
	}

	/**
	 * Recorro e imprimo en consola el contenido de cada nodo de la lista desde la cabeza hasta la cola.
	 */
	public void imprimir() {
		for (Nodo<T> temp = cabeza; temp != null; temp = temp.getSiguiente()) {
			System.out.println(temp.getDato() + " ");
		}
	}

	/**
	 * Busco la primera coincidencia de un elemento dentro de la lista y desvinculo su nodo reconectando el predecesor.
	 * 
	 * @param dato El valor que deseo buscar y remover de la lista.
	 */
	public void borrar(T dato) {
		if (!esVacia()) {
			if (cabeza == cola && dato.equals(cabeza.getDato())) {
				cabeza = cola = null;
				longitud--;
			} else if (dato.equals(cabeza.getDato())) {
				cabeza = cabeza.getSiguiente();
				longitud--;
			} else {
				Nodo<T> predesor, tmp;
				for (predesor = cabeza, tmp = cabeza.getSiguiente(); tmp != null
						&& !tmp.getDato().equals(dato); predesor = predesor.getSiguiente(), tmp = tmp.getSiguiente())
					;
				if (tmp != null) {
					predesor.setSiguiente(tmp.getSiguiente());
					if (tmp == cola) {
						cola = predesor;
					}
					longitud--;
				}
			}
		}
	}

	/**
	 * Elimino el nodo ubicado en una posición específica según el índice indicado y reconecto sus enlaces.
	 * 
	 * @param indice La posición del nodo que deseo eliminar.
	 */
	public void borrarEnIndice(int indice) {
		if (!esVacia()) {
			if (cabeza == cola && indice == 0) {
				cabeza = cola = null;
				longitud--;
			} else if (indice == 0) {
				cabeza = cabeza.getSiguiente();
				longitud--;
			} else {
				Nodo<T> predesor, tmp;
				int contador = 1;
				for (predesor = cabeza, tmp = cabeza.getSiguiente(); contador < indice;
						predesor = predesor.getSiguiente(), tmp = tmp.getSiguiente(), contador++)
					;

				if (tmp != null) {
					predesor.setSiguiente(tmp.getSiguiente());
					if (tmp == cola) {
						cola = predesor;
					}
					longitud--;
				}
			}
		}
	}

	/**
	 * Obtengo el valor almacenado en el nodo final de la lista.
	 * 
	 * @return El dato contenido en la cola.
	 */
	public T getCola() {
		return cola.getDato();
	}

	/**
	 * Obtengo el valor almacenado en el primer nodo de la lista.
	 * 
	 * @return El dato contenido en la cabeza.
	 */
	public T getCabeza() {
		return cabeza.getDato();
	}
}