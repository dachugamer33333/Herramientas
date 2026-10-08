package mx.unam.fes.inicio;

import mx.unam.fes.dinamico.Cola;
import mx.unam.fes.dinamico.Pila;
import mx.unam.fes.dinamico.ListaSimple.ListaEnlazada;
import mx.unam.fes.dinamico.ListaDoble.ListaDoblementeEnlazada;
import mx.unam.fes.estatico.Arreglo;
import mx.unam.fes.estatico.Elemento;
import mx.unam.fes.exepciones.IndicieFueraExeption;

public class Principal_Uno {
	public static void main(String[] args) throws IndicieFueraExeption {
		System.out.println("===== ARREGLO =====");
		testArreglo();

		System.out.println("\n===== ELEMENTO =====");
		testElemento();

		System.out.println("\n===== PILA =====");
		testPila();

		System.out.println("\n===== COLA =====");
		testCola();

		System.out.println("\n===== LISTA ENLAZADA (SIMPLE) =====");
		testListaEnlazada();

		System.out.println("\n===== LISTA DOBLEMENTE ENLAZADA =====");
		testListaDoblementeEnlazada();
	}

	private static void testArreglo() throws IndicieFueraExeption {
		Arreglo<String> arr = new Arreglo<String>(5);
		arr.insertar("A");
		arr.insertar("B");
		arr.insertar("C");
		System.out.print("Insertar A, B, C -> ");
		arr.imprimir();

		arr.insertar("X", 1);
		System.out.print("Insertar X en pos 1 -> ");
		arr.imprimir();

		System.out.println("Recuperar pos 2 -> " + arr.recuperar(2));
		System.out.println("Siguiente de pos 1 -> " + arr.siguiente(1));
		System.out.println("Anterior de pos 2 -> " + arr.anterior(2));
		System.out.println("Primero -> " + arr.primero());
		System.out.println("Localizar B -> " + arr.localizar("B"));
		System.out.println("Localizar Z -> " + arr.localizar("Z"));

		arr.asignar("Y", 0);
		System.out.print("Asignar Y en pos 0 -> ");
		arr.imprimir();

		arr.suprimir(2);
		System.out.print("Suprimir pos 2 -> ");
		arr.imprimir();

		System.out.println("Num elementos -> " + arr.numElementos());
		System.out.println("Vacio -> " + arr.vacio());
		System.out.println("Lleno -> " + arr.lleno());

		try {
			arr.insertar("fuera", 99);
		} catch (IndicieFueraExeption e) {
			System.out.println("Excepcion capturada: " + e.getMessage());
		}

		arr.limpiar();
		System.out.println("Despues de limpiar, vacio -> " + arr.vacio());
	}

	private static void testElemento() {
		Elemento<String> el = new Elemento<String>("manzana");
		System.out.println("toString -> " + el.toString());
		System.out.println("getValor -> " + el.getValor());
		System.out.println("cantidad inicial -> " + el.cantidadElementos());
		el.aumentarCantidad();
		el.aumentarCantidad();
		System.out.println("cantidad tras aumentar 2 -> " + el.cantidadElementos());
	}

	private static void testPila() {
		Pila<Integer> pila = new Pila<Integer>(3);
		System.out.println("Agregar 10 -> " + pila.agregar(10));
		System.out.println("Agregar 20 -> " + pila.agregar(20));
		System.out.println("Agregar 30 -> " + pila.agregar(30));
		System.out.println("Agregar 40 (llena, debe false) -> " + pila.agregar(40));

		System.out.println("Recuperar (tope) -> " + pila.recuperar());
		System.out.println("Sacar -> " + pila.sacar());
		System.out.println("Sacar -> " + pila.sacar());
		System.out.println("Sacar -> " + pila.sacar());
		System.out.println("Sacar (vacia, debe null) -> " + pila.sacar());
	}

	private static void testCola() {
		Cola<String> cola = new Cola<String>(3);
		System.out.println("Agregar A -> " + cola.agregar("A"));
		System.out.println("Agregar B -> " + cola.agregar("B"));
		System.out.println("Agregar C -> " + cola.agregar("C"));
		System.out.println("Agregar D (llena, debe false) -> " + cola.agregar("D"));

		System.out.println("Recuperar (frente) -> " + cola.recuperar());
		System.out.println("Sacar -> " + cola.sacar());
		System.out.println("Sacar -> " + cola.sacar());
		System.out.println("Sacar -> " + cola.sacar());
		System.out.println("Sacar (vacia, debe null) -> " + cola.sacar());
	}

	private static void testListaEnlazada() {
		ListaEnlazada<String> lista = new ListaEnlazada<String>();
		lista.agregarCabeza("uno");
		lista.agregarCabeza("dos");
		lista.agregarCola("tres");
		lista.agregarCola("cuatro");
		System.out.println("Lista tras agregarCabeza(x2) y agregarCola(x2):");
		lista.imprimir();

		System.out.println("Longitud -> " + lista.getLongitud());
		System.out.println("Cabeza -> " + lista.getCabeza());
		System.out.println("Cola -> " + lista.getCola());
		System.out.println("obtenerNodo(2) -> " + lista.obtenerNodo(2));

		System.out.println("eliminarDeCabeza -> " + lista.eliminarDeCabeza());
		System.out.println("elimiarDeCola -> " + lista.elimiarDeCola());
		System.out.println("Lista tras eliminar cabeza y cola:");
		lista.imprimir();

		System.out.println("borrar \"tres\" -> ");
		lista.borrar("tres");
		lista.imprimir();

		System.out.println("borrarEnIndice(0) -> ");
		lista.borrarEnIndice(0);
		lista.imprimir();
	}

	private static void testListaDoblementeEnlazada() {
		ListaDoblementeEnlazada<String> lista = new ListaDoblementeEnlazada<String>();
		lista.agregarCabeza("a");
		lista.agregarCabeza("b");
		lista.agregarCola("c");
		lista.agregarCola("d");
		System.out.println("Lista doble tras agregarCabeza(x2) y agregarCola(x2):");
		lista.imprimir();

		System.out.println("Longitud -> " + lista.getLongitud());
		System.out.println("insertarEnIndice \"z\" en 2 -> " + lista.insertarEnIndice("z", 2));
		lista.imprimir();

		System.out.println("eliminarDeCabeza -> " + lista.eliminarDeCabeza());
		System.out.println("elimiarDeCola -> " + lista.elimiarDeCola());
		System.out.println("Lista doble tras eliminar cabeza y cola:");
		lista.imprimir();

		System.out.println("borrar \"a\" -> ");
		lista.borrar("a");
		lista.imprimir();

		System.out.println("borrarEnIndice(1) -> ");
		lista.borrarEnIndice(1);
		lista.imprimir();

		System.out.println("imprimirTodo:");
		lista.imprimirTodo();
	}
}
