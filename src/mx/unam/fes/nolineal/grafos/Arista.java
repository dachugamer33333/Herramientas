package mx.unam.fes.nolineal.grafos;

public class Arista<T> {
    private T destino;
    private double peso;

    public Arista(T destino, double peso) {
        this.destino = destino;
        this.peso = peso;
    }

    public T getDestino() {
        return destino;
    }

    public void setDestino(T destino) {
        this.destino = destino;
    }

    public double getPeso() {
        return peso;
    }

    public void setPeso(double peso) {
        this.peso = peso;
    }

    @Override
    public String toString() {
        return "Arista [destino=" + destino + ", peso=" + peso + "]";
    }
}