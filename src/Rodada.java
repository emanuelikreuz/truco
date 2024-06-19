public class Rodada {
    public Carta cartaJogadorUm;
    public Carta cartaJogadorDois;
    public int ganhador; // 0 para empate, 1 para Jogador 1, 2 para Jogador 2

    public Rodada(Carta cartaJogadorUm, Carta cartaJogadorDois) {
        this.cartaJogadorUm = cartaJogadorUm;
        this.cartaJogadorDois = cartaJogadorDois;
        this.ganhador = determinarGanhador();
    }

    private int determinarGanhador() {
        if (cartaJogadorUm.numero > cartaJogadorDois.numero) {
            return 1; // Jogador 1 ganha
        } else if (cartaJogadorUm.numero < cartaJogadorDois.numero) {
            return 2; // Jogador 2 ganha
        } else {
            // Se os valores são iguais, comparamos os valores dos naipes
            if (cartaJogadorUm.naipe.valor() > cartaJogadorDois.naipe.valor()) {
                return 1; // Jogador 1 ganha
            } else if (cartaJogadorUm.naipe.valor() < cartaJogadorDois.naipe.valor()) {
                return 2; // Jogador 2 ganha
            } else {
                return 0; // Empate
            }
        }
    }

    @Override
    public String toString() {
        String resultado;
        switch (ganhador) {
            case 1:
                resultado = "Jogador 1 vence a rodada";
                break;
            case 2:
                resultado = "Jogador 2 vence a rodada";
                break;
            default:
                resultado = "Rodada empatada";
        }
        return "Rodada: Jogador 1 jogou " + cartaJogadorUm + " vs Jogador 2 jogou " + cartaJogadorDois + " - " + resultado;
    }
}

