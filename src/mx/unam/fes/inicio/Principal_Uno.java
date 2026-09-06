package mx.unam.fes.inicio;

import mx.unam.fes.estatico.Arreglo;
import mx.unam.fes.exepciones.IndicieFueraExeption;

public class Principal_Uno {
	public static void main(String[] args) {
		Arreglo<Integer> numeros = new Arreglo<Integer>(5);
		Arreglo<String> palabras = new Arreglo<String>(5);
		try {
			numeros.insertar(10);
			numeros.insertar(20);
			numeros.insertar(30);
			numeros.insertar(40);
			
			System.out.print("Imprime: ");
			numeros.imprimir();

			System.out.println("vacio? " + numeros.vacio() + "  lleno? " + numeros.lleno());

			numeros.insertar(99, 1);
			System.out.print("Insertar(99, 1): ");
			numeros.imprimir();

			System.out.println("Localiza(40): " + numeros.localizar(40));
			System.out.println("Localiza(777): " + numeros.localizar(777));

			System.out.println("Recupera(3): " + numeros.recuperar(3));
			System.out.println("Siguiente(3): " + numeros.siguiente(3));
			System.out.println("Anterior(3): " + numeros.anterior(3));
			System.out.println("Primero: " + numeros.primero());

			numeros.suprimir(1);
			System.out.print("Suprime(1): ");
			numeros.imprimir();

			numeros.asignar(100, 0);
			System.out.print("Asignar(100, 0): ");
			numeros.imprimir();

			palabras.insertar("hola");
			palabras.insertar("mundo");
			System.out.println("Localiza('mundo') en palabras: " + palabras.localizar("mundo"));

			numeros.limpiar();
			System.out.println("vacio despues de limpiar? " + numeros.vacio());
		} catch (IndicieFueraExeption e) {
			e.printStackTrace();
		}
	}

}
