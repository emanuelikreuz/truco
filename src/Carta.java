public class Carta {
    public final Integer numero;
    public final Naipe naipe;

    public Carta(Integer numero, Naipe naipe) {
        this.numero = numero;
        this.naipe = naipe;
    }

    @Override
    public String toString() {
        return numero + " de " + naipe.toString();
    }
}
