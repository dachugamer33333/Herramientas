package mx.unam.fes.estatico;

import mx.unam.fes.exepciones.IndicieFueraExeption;

/**
 * Arreglo generico de capacidad fija que guarda elementos hasta llenarse.
 * Los elementos ocupados se guardan de la posicion 0 a numElementos-1.
 *
 * @param <E> tipo de los elementos que guarda el arreglo
 */
public class Arreglo<E> {
	private final Object[] arreglo;
	private int numElementos;

	/**
	 * Crea un arreglo con una capacidad fija.
	 *
	 * @param longitud capacidad maxima (numero de casillas) del arreglo
	 */
	public Arreglo(int longitud) {
		arreglo = new Object[longitud];
		numElementos = 0;
	}

	/**
	 * Indica si el arreglo no tiene elementos.
	 *
	 * @return true si no hay ningun elemento, false en caso contrario
	 */
	public boolean vacio() {
		return numElementos == 0;
	}

	/**
	 * Indica si el arreglo esta lleno.
	 *
	 * @return true si ya no caben mas elementos, false en caso contrario
	 */
	public boolean lleno() {
		return numElementos == arreglo.length;
	}

	/**
	 * Devuelve cuantos elementos hay guardados en el arreglo.
	 *
	 * @return el numero de elementos ocupados
	 */
	public int numElementos() {
		return numElementos;
	}

	/**
	 * Inserta un elemento al final del arreglo.
	 *
	 * @param elemento el elemento que se va a insertar
	 * @throws IndicieFueraExeption si el arreglo esta lleno
	 */
	public void insertar(E elemento) throws IndicieFueraExeption {
		insertar(elemento, numElementos);
	}

	/**
	 * Inserta un elemento en la posicion indicada y corre a la derecha
	 * los elementos que estan despues de esa posicion.
	 *
	 * @param elemento el elemento que se va a insertar
	 * @param posicion lugar donde se inserta (de 0 a numElementos)
	 * @throws IndicieFueraExeption si el arreglo esta lleno o la posicion no es valida
	 */
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

	/**
	 * Reemplaza el valor de una posicion ya ocupada.
	 *
	 * @param elemento el nuevo valor que se va a asignar
	 * @param posicion posicion ocupada que se va a modificar
	 * @throws IndicieFueraExeption si la posicion no esta ocupada
	 */
	public void asignar(E elemento, int posicion) throws IndicieFueraExeption {
		validarPosicionOcupada(posicion);
		arreglo[posicion] = elemento;
	}

	/**
	 * Elimina el elemento de una posicion y corre a la izquierda los que
	 * estan despues, de modo que no quedan huecos.
	 *
	 * @param posicion posicion del elemento que se va a eliminar
	 * @throws IndicieFueraExeption si la posicion no esta ocupada
	 */
	public void suprimir(int posicion) throws IndicieFueraExeption {
		validarPosicionOcupada(posicion);
		for (int i = posicion; i < numElementos - 1; i++) {
			arreglo[i] = arreglo[i + 1];
		}
		arreglo[numElementos - 1] = null;
		numElementos--;
	}

	/**
	 * Devuelve el elemento que esta en la posicion indicada.
	 *
	 * @param posicion indice del elemento buscado
	 * @return el elemento de esa posicion
	 * @throws IndicieFueraExeption si la posicion no esta ocupada
	 */
	public E recuperar(int posicion) throws IndicieFueraExeption {
		validarPosicionOcupada(posicion);
		return (E) arreglo[posicion];
	}

	/**
	 * Busca un elemento y devuelve la posicion donde aparece por primera vez.
	 *
	 * @param elemento el elemento que se quiere localizar
	 * @return la posicion del elemento o -1 si no se encuentra
	 */
	public int localizar(E elemento) {
		for (int i = 0; i < numElementos; i++) {
			if (elemento == null ? arreglo[i] == null : elemento.equals(arreglo[i])) {
				return i;
			}
		}
		return -1;
	}

	/**
	 * Devuelve el elemento que esta despues de la posicion indicada.
	 *
	 * @param posicion posicion ocupada cuyo siguiente se quiere conocer
	 * @return el elemento de la posicion posicion+1
	 * @throws IndicieFueraExeption si no hay elemento siguiente
	 */
	public E siguiente(int posicion) throws IndicieFueraExeption {
		validarPosicionOcupada(posicion);
		if (posicion + 1 >= numElementos) {
			throw new IndicieFueraExeption("No hay elemento siguiente");
		}
		return (E) arreglo[posicion + 1];
	}
	
	
	/**
	 * Devuelve el elemento que esta antes de la posicion indicada.
	 *
	 * @param posicion posicion ocupada cuyo anterior se quiere conocer
	 * @return el elemento de la posicion posicion-1
	 * @throws IndicieFueraExeption si no hay elemento anterior
	 */
	public E anterior(int posicion) throws IndicieFueraExeption {
		validarPosicionOcupada(posicion);
		if (posicion - 1 < 0) {
			throw new IndicieFueraExeption("No hay elemento anterior");
		}
		return (E) arreglo[posicion - 1];
	}

	/**
	 * Devuelve el primer elemento del arreglo.
	 *
	 * @return el elemento de la posicion 0
	 * @throws IndicieFueraExeption si el arreglo esta vacio
	 */
	public E primero() throws IndicieFueraExeption {
		if (vacio()) {
			throw new IndicieFueraExeption("El arreglo esta vacio");
		}
		return (E) arreglo[0];
	}

	/**
	 * Elimina todos los elementos del arreglo y lo deja vacio.
	 */
	public void limpiar() {
		for (int i = 0; i < arreglo.length; i++) {
			arreglo[i] = null;
		}
		numElementos = 0;
	}

	/**
	 * Imprime en consola los elementos ocupados separados por coma.
	 */
	public void imprimir() {
		for (int i = 0; i < numElementos; i++) {
			System.out.print(arreglo[i]);
			if (i < numElementos - 1) {
				System.out.print(",");
			}
		}
		System.out.println();
	}

	/**
	 * Valida que la posicion este ocupada y, si no, lanza una excepcion.
	 *
	 * @param posicion posicion que se quiere validar
	 * @throws IndicieFueraExeption si la posicion esta fuera de los elementos ocupados
	 */
	private void validarPosicionOcupada(int posicion) throws IndicieFueraExeption {
		if (posicion < 0 || posicion >= numElementos) {
			throw new IndicieFueraExeption("Posicion fuera del arreglo");
		}
	}
}
