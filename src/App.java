public class App {
    public static void main(String[] args) {
        Jogador j1 = new Jogador("Jogador 1");
        Jogador j2 = new Jogador("Jogador 2");
        Jogo jogo = new Jogo(j1, j2);

        while (!jogo.alguemGanhou()) {
            UserInteract.mensagemEmbaralhando();
            jogo.distribuirCartas();

            UserInteract.exibirPlacar(j1.getNome(), j1.getPontos(), j2.getNome(), j2.getPontos());
            jogo.jogadores.forEach(Jogador::exibeCartas);

            jogo.primeiraRodada();
            jogo.segundaRodada();

            jogo.exibirResultadoFinal();

            System.out.println("Jogo continua...");
        }

        System.out.println("Fim do jogo!");
        jogo.exibirResultadoFinal();
    }
}
