package mx.unam.fes.dinamico.ListaDoble;

public class Nodo<T> {
	private T dato;
	private Nodo<T> siguiente;
	private Nodo<T> anterior;
	
	public Nodo(T dato) {
		this(dato, null);
	}

	public Nodo(T dato, Nodo<T> siguiente) {
		this.dato = dato;
		this.siguiente = siguiente;
	}

	public T getDato() {
		return dato;
	}

	public void setDato(T dato) {
		this.dato = dato;
	}

	public Nodo<T> getSiguiente() {
		return siguiente;
	}
	
	

	public Nodo<T> getanterior() {
		return anterior;
	}

	public void setanterior(Nodo<T> anterior) {
		this.anterior = anterior;
	}

	public void setSiguiente(Nodo<T> siguiente) {
		this.siguiente = siguiente;
	}
}
