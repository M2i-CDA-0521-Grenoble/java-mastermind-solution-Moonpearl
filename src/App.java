import java.util.Arrays;
import java.util.Collections;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

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

        char[] solution = new char[] { 'M', 'M', 'C', 'R' };
        
        // Crée une interface permettant de surveiller les saisies utilisateur dans la console
        Scanner scanner = new Scanner(System.in);
        // Attend une saisie utilisateur
        String userInput = scanner.nextLine();
        // Vérifie que la saisie utilisateur contient bien 4 caractères parmi les 6 couleurs existantes
        Pattern pattern = Pattern.compile("^[RVBJCM]{4}$");
        Matcher matcher = pattern.matcher(userInput);
        if (matcher.matches()) {

            // Transforme la saisie utilisateur en tableau de caractères pour faciliter son exploitation
            char[] proposition = userInput.toCharArray();

            // Détermine les couleurs bien placées
            // Initialise le compte des couleurs bien placées à zéro
            int correctCount = 0;
            // Pour chaque caractère de la proposition utilisateur
            for (int i = 0; i < 4; i++) {
                // Si ce caractère est le même que celui corrrespondant dans la solution
                if (proposition[i] == solution[i]) {
                    // Augmente le compte des couleurs bien placées de 1
                    correctCount += 1;
                }
            }
            System.out.println("Nombre de couleurs bien placées: " + correctCount);

            // Détermine les couleurs absentes
            // Initialise le compte des couleurs absentes à zéro
            int absentCount = 0;
            // Pour chaque couleur possible
            for (char colorCharacter : new char[] { 'R', 'V', 'B', 'J', 'C', 'M' }) {
                // Compte le nombre de cette couleur en trop dans la proposition de l'utilisateur
                // par rapport à la solution
                int solutionColorCount = 0;
                for (char character : solution) {
                    if (character == colorCharacter) {
                        solutionColorCount += 1;
                    }
                }
                int propositionColorCount = 0;
                for (char character : proposition) {
                    if (character == colorCharacter) {
                        propositionColorCount += 1;
                    }
                }
                int excess = propositionColorCount - solutionColorCount;
                // Ajoute au compte des couleurs absentes ce nombre de couleurs excédentaires
                if (excess > 0) {
                    absentCount += excess;
                }
            }

            System.out.println("Nombre de couleurs absentes: " + absentCount);

        } else {
            System.out.println("Saisie incorrecte.");
        }
    }
}
