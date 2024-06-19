import java.util.ArrayList;
import java.util.List;

public class Jogo {
    public Baralho baralho;
    public List<Jogador> jogadores;
    public List<Rodada> rodadas;

    public Jogo(Jogador jogador1, Jogador jogador2) {
        this.baralho = new Baralho();
        this.jogadores = List.of(jogador1, jogador2);
        this.rodadas = new ArrayList<>();
    }

    public void distribuirCartas() {
        baralho.embaralhar();
        for (Jogador jogador : jogadores) {
            jogador.cartas.clear(); // Limpa as cartas anteriores do jogador
            jogador.adicionarCartas(baralho.distribuir(2)); // Distribui 2 cartas para cada jogador
        }
    }

    public void primeiraRodada() {
        Carta cartaJogador1 = jogadores.get(0).jogarPrimeiraRodada();
        Carta cartaJogador2 = jogadores.get(1).jogarPrimeiraRodada();

        Rodada rodada = new Rodada(cartaJogador1, cartaJogador2);
        rodadas.add(rodada);
        UserInteract.exibeCartaJogada(jogadores.get(0).getNome(), cartaJogador1);
        UserInteract.exibeCartaJogada(jogadores.get(1).getNome(), cartaJogador2);
        UserInteract.vencedorRodada(rodada.ganhador, jogadores.get(0), jogadores.get(1));

        if (rodada.ganhador == 1) {
            jogadores.get(0).adicionarPontos(1);
        } else if (rodada.ganhador == 2) {
            jogadores.get(1).adicionarPontos(1);
        }
    }

    public void segundaRodada() {
        Carta cartaJogador1 = jogadores.get(0).jogarSegundaRodada();
        Carta cartaJogador2 = jogadores.get(1).jogarSegundaRodada();

        Rodada rodada = new Rodada(cartaJogador1, cartaJogador2);
        rodadas.add(rodada);
        UserInteract.exibeCartaJogada(jogadores.get(0).getNome(), cartaJogador1);
        UserInteract.exibeCartaJogada(jogadores.get(1).getNome(), cartaJogador2);
        UserInteract.vencedorRodada(rodada.ganhador, jogadores.get(0), jogadores.get(1));

        if (rodada.ganhador == 1) {
            jogadores.get(0).adicionarPontos(1);
        } else if (rodada.ganhador == 2) {
            jogadores.get(1).adicionarPontos(1);
        }
    }

    public boolean alguemGanhou() {
        // Vamos assumir que o jogo termina após 2 rodadas completas
        return rodadas.size() >= 2;
    }

    public void exibirResultadoFinal() {
        System.out.println("Resultado Final:");
        for (int i = 0; i < rodadas.size(); i++) {
            Rodada rodada = rodadas.get(i);
            System.out.println("Rodada " + (i + 1) + ": " + rodada);
        }
    }
}
