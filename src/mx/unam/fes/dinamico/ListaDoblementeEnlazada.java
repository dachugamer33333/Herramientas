package mx.unam.fes.dinamico;

public class ListaDoblementeEnlazada<T> {
	private NodoD<T> cola;
	private NodoD<T> cabeza;
	private int longitud = 0;

	public ListaDoblementeEnlazada() {
		cabeza = cola = null;
	}

	public boolean esVacia() {
		return cabeza == null;
	}
	public void imprimirTodo()
	{
		for(int i=0;i<longitud; i++)
		{
			System.out.println(obtenerNodo(i));
		}
	}

	public void agregarCabeza(T dato) {
		  NodoD<T> nuevo = new NodoD<T>(dato, cabeza);
		    if (cabeza != null) {
		        cabeza.setanterior(nuevo);
		    } else {
		        cola = nuevo;
		    }
		    cabeza = nuevo;
		    longitud++;
	}

	public void agregarCola(T dato) {
		  NodoD<T> nuevo = new NodoD<T>(dato);
		    if (!esVacia()) {
		        nuevo.setanterior(cola);
		        cola.setSiguiente(nuevo);
		        cola = nuevo;
		    } else {
		        cabeza = cola = nuevo;
		    }
		    longitud++;	}

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
				cola=cola.getanterior();
				cola.setSiguiente(null);
			}
			longitud--;
		}
		return dato;
	}

	public T obtenerNodo(int indice) {
		NodoD<T> temp = cabeza;
		for (int contador = 0; contador < indice && temp != null; contador++, temp = temp.getSiguiente())
			;
		if (temp != null) {
			return (T) temp.getDato();
		} else {
			return null;
		}
	}

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
		    NodoD<T> tmp = cabeza;
		    for (int contador = 0; contador < indice; contador++) {
		        tmp = tmp.getSiguiente();
		    }
		    NodoD<T> anterior = tmp.getanterior();
		    NodoD<T> nuevo = new NodoD<T>(dato, tmp);
		    nuevo.setanterior(anterior);
		    anterior.setSiguiente(nuevo);
		    tmp.setanterior(nuevo);
		    longitud++;
		    return true;
	}

	public void imprimir() {
		for (NodoD<T> temp = cabeza; temp != null; temp = temp.getSiguiente()) {
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
				 cabeza.setanterior(null);
				longitud--;
			} else {
				NodoD<T> tmp;
				for (  tmp = cabeza.getSiguiente(); tmp != null
						&& !tmp.getDato().equals(dato);  tmp = tmp.getSiguiente())
					;
				if (tmp != null) {
					tmp.getanterior().setSiguiente(tmp.getSiguiente());
					if (tmp == cola) {
						cola = tmp.getanterior();
					}
					 else {
				            tmp.getSiguiente().setanterior(tmp.getanterior());
				        }
					longitud--;
				}
			}
		}
	}

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
		    NodoD<T> tmp = cabeza;
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
