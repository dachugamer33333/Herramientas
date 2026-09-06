package mx.unam.fes.estatico;

import mx.unam.fes.exepciones.IndicieFueraExeption;

public class Arreglo<E> {
	private int indice;
	private final Object[] arreglo;
	private int ultimaPosicion;
	public Arreglo(int longitud) {
		arreglo=new Object[longitud];
		ultimaPosicion=-1;
	}
	
	public void insertar(E elemento) throws IndicieFueraExeption {
		if(indice >=0 && indice < arreglo.length) {
			arreglo[indice]=elemento;	
			ultimaPosicion=indice;
			indice++;
			
		}else {
			 throw new IndicieFueraExeption("Indice fuera del arreglo");
		}
	}
	public boolean vacio() {
		if (indice < arreglo.length) {
			return false; 
		}
		return true; 
	}
	public void imprimir() {
		for(int i=0;i<arreglo.length;i++) {
			System.out.print(arreglo[i]+",");
		}
		System.out.println();
	}
	
	public boolean insertar(E elemento,int indice) throws IndicieFueraExeption
	{
		if(indice >=0 && indice < arreglo.length)
		{
			arreglo[indice]=elemento;
			ultimaPosicion=indice;
			return true;
		}
		else {
			throw new IndicieFueraExeption("Indice fuera del rango");
		}
	}
	
	public E recuperar(int indice)
	{
		return (E) arreglo[indice];
	}
	
	public void limpiar()
	{
		for (int i = 0; i < arreglo.length; i++) {
	        arreglo[i] = null; 
	    }
	    indice = 0;
	    ultimaPosicion = -1;
	}
	public int localizar(E elemento)
	{
		for(int i = 0; i< arreglo.length;i++)
		{
			if (arreglo[i]== elemento)
			{
				return i;
			}
			
		}
		return -1;
		
	}
	public boolean suprime(int indice)
	{
		if(indice >=0 && indice < arreglo.length)
		{
			arreglo[indice]=null;
			return true;
		}
		return false;
		
	}
	public E siguiente(int indice) {
		indice++;
		if(indice >=0 && indice < arreglo.length)
		{
			return (E) arreglo[indice];
		}
		return null;
	}
	
	public E anterior(int indice) {
		indice--;
		if(indice >=0 && indice < arreglo.length)
		{
			return (E) arreglo[indice];
		}
		return null;
	}
	
	public E primero()
	{
		return (E) arreglo[0];
	}
	
	public boolean asignar(E elemento, int indice)
	{
		if(indice >=0 && indice < arreglo.length)
		{
			arreglo[indice]=elemento;
			return true;
		}
		return false;
	}
	
	

}
