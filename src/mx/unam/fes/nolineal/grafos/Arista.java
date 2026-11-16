package mx.unam.fes.nolineal.grafos;

/**
 * Arista ponderada que conecta un vértice origen con un vértice destino.
 * <p>
 * El origen no se guarda en la arista: queda implícito en el vértice del
 * grafo cuya lista de adyacencia contiene esta arista. Por eso una misma
 * instancia representa la relación "desde el vértice que la contiene hacia
 * {@link #getDestino() destino}".
 * </p>
 *
 * @param <T> tipo de dato que identifica a los vértices del grafo
 */
public class Arista<T> {
    /** Vértice al que llega la arista. */
    private T destino;
    /** Peso o costo asociado al recorrido de la arista. */
    private double peso;

    /**
     * Crea una arista dirigida hacia un destino con un peso determinado.
     *
     * @param destino vértice al que llega la arista
     * @param peso costo asociado al recorrido de la arista
     */
    public Arista(T destino, double peso) {
        this.destino = destino;
        this.peso = peso;
    }

    /**
     * Devuelve el vértice al que llega la arista.
     *
     * @return vértice destino
     */
    public T getDestino() {
        return destino;
    }

    /**
     * Cambia el vértice al que llega la arista.
     *
     * @param destino nuevo vértice destino
     */
    public void setDestino(T destino) {
        this.destino = destino;
    }

    /**
     * Devuelve el peso de la arista.
     *
     * @return peso asociado al recorrido
     */
    public double getPeso() {
        return peso;
    }

    /**
     * Cambia el peso de la arista.
     *
     * @param peso nuevo peso asociado al recorrido
     */
    public void setPeso(double peso) {
        this.peso = peso;
    }

    /**
     * Devuelve una representación textual de la arista con su destino y su peso.
     *
     * @return cadena con el destino y el peso de la arista
     */
    @Override
    public String toString() {
        return "Arista [destino=" + destino + ", peso=" + peso + "]";
    }
}