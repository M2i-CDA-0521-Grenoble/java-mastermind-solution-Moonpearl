package game;

import java.util.Scanner;

/**
 * Représente une partie du jeu
 */
public class Game
{
    /**
     * Interface permettant de surveiller les saisies de l'utilisateur
     */
    private Scanner scanner;
    /**
     * La solution que le joueur doit deviner
     */
    private ColorCombination solution;
    /**
     * Le jeu est-il en cours d'exécution?
     */
    private boolean isRunning;

    /**
     * Crée une nouvelle partie du jeu
     */
    public Game()
    {
        scanner = new Scanner(System.in);
    }

    /**
     * Initialise la partie
     */
    public void setup()
    {
        // Génére une solution aléatoirement
        solution = ColorCombination.generateRandomCombination();
        // Indique que la partie est en cours d'exécution
        isRunning = true;
    }

    /**
     * Décrit un cycle d'exécution du jeu
     */
    public void update()
    {
        // Attend une saisie utilisateur
        String userInput = scanner.nextLine();

        // Crée une nouvelle combinaison de couleurs à partir de la saisie utilisateur
        ColorCombination proposition = new ColorCombination(userInput);

        // Demande à la proposition de l'utilisateur de se comparer avec la solution
        ComparisonResult comparisonResult = proposition.compareTo(solution);

        // Affiche la réponse de l'ordinateur
        System.out.println( comparisonResult.createDisplay() );

        // Si l'utilisateur a trouvé la bonne combinaison
        if (comparisonResult.isWinning()) {
            System.out.println("Bravo! Vous avez trouvé la bonne combinaison!");
            // Demande à l'utilisateur s'il veut rejouer
            System.out.println("Voulez-vous rejouer?");
            userInput = scanner.nextLine();

            // Si l'utilisateur souhaite jouer une nouvelle partie
            if ("O".equals(userInput)) {
                // Réinitialise le jeu en générant une nouvelle solution
                setup();
            // Sinon, arrête le jeu
            } else {
                terminate();
            }
        }

        System.out.println("");
    }

    /**
     * Arrête la partie
     */
    public void terminate()
    {
        // Indique que la partie n'est plus en cours d'exécution
        isRunning = false;
    }

    /**
     * Le jeu est-il en cours d'exécution?
     */
    public boolean isRunning()
    {
        return isRunning;
    }
}
