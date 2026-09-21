package mx.unam.fes.dinamico;

import mx.unam.fes.dinamico.ListaSimple.ListaEnlazada;

public class Pila<T> {
	private ListaEnlazada<T> pila;
	private int capacidad;

	public Pila() {
		this.pila= new ListaEnlazada<T>();
		this.capacidad=-1;
	}
	public Pila(int capacidad)
	{
		this.pila= new ListaEnlazada<T>();
		this.capacidad=capacidad;
	}
	public int getLongitud() {
		return pila.getLongitud();
	}
	
	public boolean esVacia()
	{
		return pila.esVacia();
	}
	
	
	public boolean agregar(T valor)
	{
	    if (capacidad >= 0 && pila.getLongitud() >= capacidad) {
	        return false;
	    }
	    pila.agregarCabeza(valor);
	    return true;
		
	}
	public T recuperar()
	{
		if(pila.esVacia())
		{
			return null;
		}
		return pila.getCabeza();
	}
	
	public T sacar()
	{
		
		if(pila.esVacia())
		{
			return null;
		}
		T valorCabeza = pila.getCabeza();
		pila.eliminarDeCabeza();
		return valorCabeza;
	}
}
