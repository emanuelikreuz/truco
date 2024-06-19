public class UserInteract {
    private static final String EMBARALHANDO = "Embaralhando...";
    private static final String PLACAR = "%s: %d || %s: %d%n";
    private static final String CARTA_JOGADA = "%s jogou %s%n";
    private static final String GANHADOR_RODADA = ">>>>>>>> %s venceu%n";
    private static final String EMBUCHOU = ">>>>>>>>>>> embuchou%n";
    private static final String DIVISOR = "=========================================";
    private static final String VIROU = "<< Virou %s >>%n";

    public static void mensagemEmbaralhando(){
        pausa(1000);
        System.out.println(EMBARALHANDO);
    }

    public static void exibirPlacar(String nome1, int pontos1, String nome2, int pontos2){
        pausa(1000);
        divisor();
        System.out.printf(PLACAR, nome1, pontos1, nome2, pontos2);
        divisor();
    }

    public static void exibeCartaJogada(String nome, Carta carta){
        pausa(2000);
        System.out.printf(CARTA_JOGADA, nome, carta);
    }

    public static void vencedorRodada(int ganhador, Jogador j1, Jogador j2){
        pausa(1000);
        String mensagem = (ganhador != 0) ? GANHADOR_RODADA : EMBUCHOU;
        String vencedor = (ganhador == 1) ? j1.getNome() : j2.getNome();
        System.out.printf(mensagem, vencedor);
    }

    public static void divisor(){
        System.out.println(DIVISOR);
    }

    public static void exibeCartaVirada(Carta carta) {
        pausa(500);
        System.out.printf(VIROU, carta);
    }

    private static void pausa(int milissegundos) {
        try {
            Thread.sleep(milissegundos);
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
            System.err.println("A execução foi interrompida.");
        }
    }
}
