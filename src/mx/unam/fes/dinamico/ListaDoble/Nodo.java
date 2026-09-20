package mx.unam.fes.dinamico;

public class NodoD<T> {
	private T dato;
	private NodoD<T> siguiente;
	private NodoD<T> anterior;
	
	public NodoD(T dato) {
		this(dato, null);
	}

	public NodoD(T dato, NodoD<T> siguiente) {
		this.dato = dato;
		this.siguiente = siguiente;
	}

	public T getDato() {
		return dato;
	}

	public void setDato(T dato) {
		this.dato = dato;
	}

	public NodoD<T> getSiguiente() {
		return siguiente;
	}
	
	

	public NodoD<T> getanterior() {
		return anterior;
	}

	public void setanterior(NodoD<T> anterior) {
		this.anterior = anterior;
	}

	public void setSiguiente(NodoD<T> siguiente) {
		this.siguiente = siguiente;
	}
}
