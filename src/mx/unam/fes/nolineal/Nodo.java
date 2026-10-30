package mx.unam.fes.nolineal;
import java.util.Objects;

public class Nodo<E> {

    // Izquierdo: almacena la referencia del nodo izquierdo.
    // Derecho: almacena la referencia del nodo derecho.
    protected E dato;
    protected Nodo<E> izquierdo, derecho;
    protected String etiqueta;

    public Nodo() {
        izquierdo = derecho = null;
    }

    public Nodo(E dato, String etiqueta) {
        this(dato, null, null, etiqueta);
    }

    public Nodo(E dato, Nodo<E> izquierdo, Nodo<E> derecho, String etiqueta) {
        this.dato = dato;
        this.izquierdo = izquierdo;
        this.derecho = derecho;
        this.etiqueta = etiqueta;
    }

    @Override
    public int hashCode() {
        return Objects.hash(dato);
    }

    public boolean mayor(Object obj) {
        boolean resultado = false;
        if (obj instanceof Integer && this.dato instanceof Integer) {
            Integer dato1 = (Integer) this.dato;
            Integer dato2 = (Integer) obj;
            if (dato1 < dato2) {
                return true;
            }
        }
        return resultado;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj instanceof Integer && this.dato instanceof Integer) {
            Integer dato1 = (Integer) this.dato;
            Integer dato2 = (Integer) obj;
            if (dato1.equals(dato2)) {
                return true;
            } else {
                return false;
            }
        }
        Nodo other = (Nodo) obj;
        return Objects.equals(dato, other.dato);
    }

	public E getDato() {
		return dato;
	}

	public void setDato(E dato) {
		this.dato = dato;
	}

	public Nodo<E> getIzquierdo() {
		return izquierdo;
	}

	public void setIzquierdo(Nodo<E> izquierdo) {
		this.izquierdo = izquierdo;
	}

	public Nodo<E> getDerecho() {
		return derecho;
	}

	public void setDerecho(Nodo<E> derecho) {
		this.derecho = derecho;
	}

	public String getEtiqueta() {
		return etiqueta;
	}

	public void setEtiqueta(String etiqueta) {
		this.etiqueta = etiqueta;
	}
    
    
}