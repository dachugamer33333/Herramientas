package mx.unam.fes.dinamico;

import mx.unam.fes.dinamico.ListaSimple.ListaEnlazada;


//Lo hice al reves sacar por cabeza y agregar por cola por los recursos dado que es una lista simple es mas dificl eliminar en cola
public class Cola<T> {
	private ListaEnlazada<T> cola;
	private int capacidad;

	public Cola() {
		this.cola= new ListaEnlazada<T>();
		this.capacidad=-1;
	}
	public Cola(int capacidad)
	{
		this.cola= new ListaEnlazada<T>();
		this.capacidad=capacidad;
	}
	
	public boolean agregar(T valor)
	{
	    if (capacidad >= 0 && cola.getLongitud() >= capacidad) {
	        return false;
	    }
	    cola.agregarCola(valor);
	    return true;
		
	}
	public T recuperar()
	{
		if(cola.esVacia())
		{
			return null;
		}
		return cola.getCabeza();
	}
	
	public T sacar()
	{
		
		if(cola.esVacia())
		{
			return null;
		}
		T valorCola = cola.getCabeza();
		cola.eliminarDeCabeza();
		return valorCola;
	}
	
	
	
}
