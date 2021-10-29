import java.util.Scanner;

import game.*;

public class App
{
    /**
     * Processus principal de l'application
     * @param args
     * @throws Exception
     */
    public static void main(String[] args) throws Exception {
        // Efface la console
        System.out.print("\033[H\033[2J");
        System.out.flush();

        // Crée une nouvelle partie du jeu
        Game game = new Game();
        // Initialise la partie (en générant une combinaison aléatoire)
        game.setup();

        // Tant que le jeu est encore en cours d'exécution
        while (game.isRunning()) {
            // Met le jeu à jour
            game.update();
        }
    }
}
