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
		if(indice<arreglo.length) {
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
		if(indice >= 0 && indice < arreglo.length)
		{
			arreglo[indice]=elemento;
			ultimaPosicion=indice;
			return true;
		}
		else {
			throw new IndicieFueraExeption("Indice fuera del rango");
		}
	}
	
	public E recuperar()
	{
		return (E) arreglo[ultimaPosicion];
	}
	
	public void limpiar()
	{
		for (int i = 0; i < arreglo.length; i++) {
	        arreglo[i] = null; 
	    }
	    indice = 0;
	    ultimaPosicion = -1;
	}
	

}
