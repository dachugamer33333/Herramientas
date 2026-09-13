package dinamico;

public class ListaEnlazada<T> {
	private Nodo<T> cola;
	private Nodo<T> cabeza;
	private int longitud = 0;

	public ListaEnlazada() {
		cabeza = cola = null;
	}

	public boolean esVacia() {
		return cabeza == null;
	}

	public void agregarCabeza(T dato) {
		cabeza = new Nodo<T>(dato, cabeza);
		if (cola == null) {
			cola = cabeza;
		}
		longitud++;
	}

	public void agregarCola(T dato) {
		if (!esVacia()) {
			cola.setSiguiente(new Nodo<T>(dato));
			cola = cola.getSiguiente();
		} else {
			cola = cabeza = new Nodo<T>(dato);
		}
		longitud++;
	}

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

public int getLongitud() {
return longitud;


}

	public T elimiarDeCola() {
		T dato = null;
		if (!esVacia()) {
			dato = cola.getDato();
			if (cabeza == cola) {
				cabeza = cola = null;
			} else {
				Nodo<T> temp;
				for (temp = cabeza; temp.getSiguiente() != cola; temp =

						temp.getSiguiente())
					;

				cola = temp;
				cola.setSiguiente(null);
			}
			longitud--;
		}
		return dato;
	}

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

	public void imprimir() {
		for (Nodo<T> temp = cabeza; temp != null; temp = temp.getSiguiente()) {
			System.out.println(temp.getDato() + " ");
		}
	}


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
}
