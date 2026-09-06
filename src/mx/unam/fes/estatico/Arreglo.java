package mx.unam.fes.estatico;

import mx.unam.fes.exepciones.IndicieFueraExeption;

public class Arreglo<E> {
	private final Object[] arreglo;
	private int numElementos;

	public Arreglo(int longitud) {
		arreglo = new Object[longitud];
		numElementos = 0;
	}

	public boolean vacio() {
		return numElementos == 0;
	}

	public boolean lleno() {
		return numElementos == arreglo.length;
	}

	public int numElementos() {
		return numElementos;
	}

	public void insertar(E elemento) throws IndicieFueraExeption {
		insertar(elemento, numElementos);
	}

	public void insertar(E elemento, int posicion) throws IndicieFueraExeption {
		if (lleno()) {
			throw new IndicieFueraExeption("El arreglo esta lleno, no se puede insertar");
		}
		if (posicion < 0 || posicion > numElementos) {
			throw new IndicieFueraExeption("Posicion fuera del arreglo");
		}
		for (int i = numElementos; i > posicion; i--) {
			arreglo[i] = arreglo[i - 1];
		}
		arreglo[posicion] = elemento;
		numElementos++;
	}

	public void asignar(E elemento, int posicion) throws IndicieFueraExeption {
		validarPosicionOcupada(posicion);
		arreglo[posicion] = elemento;
	}

	public void suprimir(int posicion) throws IndicieFueraExeption {
		validarPosicionOcupada(posicion);
		for (int i = posicion; i < numElementos - 1; i++) {
			arreglo[i] = arreglo[i + 1];
		}
		arreglo[numElementos - 1] = null;
		numElementos--;
	}

	public E recuperar(int posicion) throws IndicieFueraExeption {
		validarPosicionOcupada(posicion);
		return (E) arreglo[posicion];
	}

	public int localizar(E elemento) {
		for (int i = 0; i < numElementos; i++) {
			if (elemento == null ? arreglo[i] == null : elemento.equals(arreglo[i])) {
				return i;
			}
		}
		return -1;
	}

	public E siguiente(int posicion) throws IndicieFueraExeption {
		validarPosicionOcupada(posicion);
		if (posicion + 1 >= numElementos) {
			throw new IndicieFueraExeption("No hay elemento siguiente");
		}
		return (E) arreglo[posicion + 1];
	}

	public E anterior(int posicion) throws IndicieFueraExeption {
		validarPosicionOcupada(posicion);
		if (posicion - 1 < 0) {
			throw new IndicieFueraExeption("No hay elemento anterior");
		}
		return (E) arreglo[posicion - 1];
	}

	public E primero() throws IndicieFueraExeption {
		if (vacio()) {
			throw new IndicieFueraExeption("El arreglo esta vacio");
		}
		return (E) arreglo[0];
	}

	public void limpiar() {
		for (int i = 0; i < arreglo.length; i++) {
			arreglo[i] = null;
		}
		numElementos = 0;
	}

	public void imprimir() {
		for (int i = 0; i < numElementos; i++) {
			System.out.print(arreglo[i]);
			if (i < numElementos - 1) {
				System.out.print(",");
			}
		}
		System.out.println();
	}

	private void validarPosicionOcupada(int posicion) throws IndicieFueraExeption {
		if (posicion < 0 || posicion >= numElementos) {
			throw new IndicieFueraExeption("Posicion fuera del arreglo");
		}
	}
}
