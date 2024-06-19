import java.util.Scanner;

public class InterfaceUsuario {
    private Scanner scanner;

    public InterfaceUsuario() {
        this.scanner = new Scanner(System.in);
    }

    public String entrarNomeJogador(String ordem) {
        System.out.printf("Por favor, insira o nome do %s jogador: ", ordem);
        return scanner.nextLine();
    }

    public void exibirPlacar(String nome1, int pontos1, String nome2, int pontos2) {
        System.out.printf("%s: %d || %s: %d%n", nome1, pontos1, nome2, pontos2);
        divisor();
    }

    public void exibeCartas(Jogador jogador) {
        System.out.printf("%s tem as cartas: ", jogador.getNome());
        jogador.exibeCartas();
    }

    public boolean jogoContinua() {
        System.out.print("Deseja continuar jogando? (s/n): ");
        String resposta = scanner.nextLine().trim().toLowerCase();
        return resposta.equals("s") || resposta.equals("sim");
    }

    private void divisor() {
        System.out.println("=========================================");
    }
}
