import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Baralho {
    private List<Carta> cartas;

    public Baralho() {
        cartas = new ArrayList<>();
        inicializarBaralho();
    }

    private void inicializarBaralho() {
        for (Naipe naipe : Naipe.values()) {
            for (int numero = 1; numero <= 10; numero++) {
                cartas.add(new Carta(numero, naipe));
            }
        }
    }

    public void embaralhar() {
        Collections.shuffle(cartas);
    }

    public List<Carta> distribuir(int quantidade) {
        if (cartas.size() < quantidade) {
            throw new IllegalStateException("Não há cartas suficientes no baralho para distribuir.");
        }

        List<Carta> distribuidas = new ArrayList<>();
        for (int i = 0; i < quantidade; i++) {
            distribuidas.add(cartas.remove(cartas.size() - 1)); // Remove do topo da pilha
        }
        return distribuidas;
    }

    public boolean estaVazio() {
        return cartas.isEmpty();
    }
}
