package mx.unam.fes.estatico;

public class Elemento<E> {
	private E valor;
	private int cantidad;
	public Elemento(E valor) {
		super();
		this.valor = valor;
		
	}
	public void aumentarCantidad()
	{
		cantidad++;
	}
	public int cantidadElementos()
	{
		return cantidad;
	}
	
	@Override
	public String toString() {
		return "Elemento [valor=" + valor + ", cantidad=" + cantidad + "]";
	}
	public E getValor() {
		return valor;
	}
	
	
}
