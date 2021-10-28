import java.util.Scanner;

import game.Color;
import game.ColorCombination;
import game.ComparisonResult;

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

        // Génére une solution
        ColorCombination solution = new ColorCombination(new Color[] { Color.Magenta, Color.Magenta, Color.Cyan, Color.Red });
        
        // Crée une interface permettant de surveiller les saisies utilisateur dans la console
        Scanner scanner = new Scanner(System.in);

        // Exécute une boucle infinie
        while (true) {
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
                    // TODO: Réinitialiser le jeu en générant une nouvelle solution
                // Sinon, interrompt la boucle principale et arrête le jeu
                } else {
                    break;
                }
            }

            System.out.println("");
        }

        scanner.close();
    }
}
