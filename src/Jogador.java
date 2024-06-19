import java.util.ArrayList;
import java.util.List;

public class Jogador {
    private String nome;
    private int pontos;
    public List<Carta> cartas;

    public Jogador(String nome) {
        this.nome = nome;
        this.cartas = new ArrayList<>();
        this.pontos = 0;
    }

    public String getNome() {
        return nome;
    }

    public int getPontos() {
        return pontos;
    }

    public void adicionarPontos(int pontos) {
        this.pontos += pontos;
    }

    public Carta jogarPrimeiraRodada() {
        return cartas.isEmpty() ? null : cartas.remove(0);
    }

    public Carta jogarSegundaRodada() {
        return cartas.size() > 0 ? cartas.remove(0) : null;
    }

    public void exibeCartas() {
        cartas.forEach(c -> System.out.print(c + " "));
        System.out.println();
    }

    public void adicionarCartas(List<Carta> novasCartas) {
        cartas.addAll(novasCartas);
    }
}
