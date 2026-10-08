package mx.unam.fes.dinamico.ListaDoble;

public class ListaDoblementeEnlazada<T> {
	private Nodo<T> cola;
	private Nodo<T> cabeza;
	private int longitud = 0;

	/**
	 * Genero el constructor por defecto indicando que la lista inicia vacía, asignando null a la cabeza y a la cola.
	 */
	public ListaDoblementeEnlazada() {
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
	 * Imprimo el valor de cada nodo iterando por sus índices desde cero hasta la longitud actual.
	 */
	public void imprimirTodo() {
		for (int i = 0; i < longitud; i++) {
			System.out.println(obtenerNodo(i));
		}
	}

	/**
	 * Inserto un nuevo nodo al inicio de la lista y actualizo las referencias dobles necesarias.
	 * 
	 * @param dato El valor que deseo agregar al principio.
	 */
	public void agregarCabeza(T dato) {
		Nodo<T> nuevo = new Nodo<T>(dato, cabeza);
		if (cabeza != null) {
			cabeza.setanterior(nuevo);
		} else {
			cola = nuevo;
		}
		cabeza = nuevo;
		longitud++;
	}

	/**
	 * Inserto un nuevo nodo al final de la lista y reconecto los punteros anterior y siguiente.
	 * 
	 * @param dato El valor que deseo agregar al final.
	 */
	public void agregarCola(T dato) {
		Nodo<T> nuevo = new Nodo<T>(dato);
		if (!esVacia()) {
			nuevo.setanterior(cola);
			cola.setSiguiente(nuevo);
			cola = nuevo;
		} else {
			cabeza = cola = nuevo;
		}
		longitud++;
	}

	/**
	 * Elimino el nodo ubicado al inicio de la lista y ajusto la nueva cabeza.
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
				cabeza.setanterior(null);
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
	 * Elimino el nodo ubicado al final de la lista y reasigno el puntero de la cola.
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
				cola = cola.getanterior();
				cola.setSiguiente(null);
			}
			longitud--;
		}
		return dato;
	}

	/**
	 * Recorro la lista secuencialmente para obtener el dato guardado en una posición específica.
	 * 
	 * @param indice La posición del nodo que deseo obtener.
	 * @return El dato del nodo en la posición indicada o null si no se encuentra.
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
	 * Inserto un nuevo nodo en una posición específica dentro de la lista reconectando los enlaces.
	 * 
	 * @param dato El valor que deseo insertar.
	 * @param indice La posición exacta donde deseo colocar el nuevo nodo.
	 * @return true si la inserción fue exitosa, o false si el índice resulta fuera de rango.
	 */
	public boolean insertarEnIndice(T dato, int indice) {
		if (indice < 0 || indice > longitud) {
			return false;
		}
		if (indice == 0) {
			agregarCabeza(dato);
			return true;
		}
		if (indice == longitud) {
			agregarCola(dato);
			return true;
		}
		Nodo<T> tmp = cabeza;
		for (int contador = 0; contador < indice; contador++) {
			tmp = tmp.getSiguiente();
		}
		Nodo<T> anterior = tmp.getanterior();
		Nodo<T> nuevo = new Nodo<T>(dato, tmp);
		nuevo.setanterior(anterior);
		anterior.setSiguiente(nuevo);
		tmp.setanterior(nuevo);
		longitud++;
		return true;
	}

	/**
	 * Recorro e imprimo en consola el contenido de la lista desde la cabeza hasta la cola.
	 */
	public void imprimir() {
		for (Nodo<T> temp = cabeza; temp != null; temp = temp.getSiguiente()) {
			System.out.println(temp.getDato() + " ");
		}
	}

	/**
	 * Busco la primera coincidencia de un dato dentro de la lista y elimino su nodo ajustando los enlaces.
	 * 
	 * @param dato El elemento que deseo buscar y borrar de la lista.
	 */
	public void borrar(T dato) {
		if (!esVacia()) {
			if (cabeza == cola && dato.equals(cabeza.getDato())) {
				cabeza = cola = null;
				longitud--;
			} else if (dato.equals(cabeza.getDato())) {
				cabeza = cabeza.getSiguiente();
				cabeza.setanterior(null);
				longitud--;
			} else {
				Nodo<T> tmp;
				for (tmp = cabeza.getSiguiente(); tmp != null
						&& !tmp.getDato().equals(dato); tmp = tmp.getSiguiente())
					;
				if (tmp != null) {
					tmp.getanterior().setSiguiente(tmp.getSiguiente());
					if (tmp == cola) {
						cola = tmp.getanterior();
					} else {
						tmp.getSiguiente().setanterior(tmp.getanterior());
					}
					longitud--;
				}
			}
		}
	}

	/**
	 * Elimino el nodo ubicado en una posición determinada según el índice proporcionado.
	 * 
	 * @param indice La posición del nodo que deseo remover.
	 */
	public void borrarEnIndice(int indice) {
		if (indice < 0 || indice >= longitud) {
			return;
		}
		if (indice == 0) {
			cabeza = cabeza.getSiguiente();
			if (cabeza != null) {
				cabeza.setanterior(null);
			} else {
				cola = null;
			}
			longitud--;
			return;
		}
		Nodo<T> tmp = cabeza;
		for (int contador = 0; contador < indice; contador++) {
			tmp = tmp.getSiguiente();
		}
		tmp.getanterior().setSiguiente(tmp.getSiguiente());
		if (tmp == cola) {
			cola = tmp.getanterior();
		} else {
			tmp.getSiguiente().setanterior(tmp.getanterior());
		}
		longitud--;
	}
}