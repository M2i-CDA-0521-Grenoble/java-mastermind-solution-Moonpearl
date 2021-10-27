import java.util.Scanner;

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
        
        // Crée une interface permettant de surveiller les saisies utilisateur dans la console
        Scanner scanner = new Scanner(System.in);
        // Attend une saisie utilisateur
        String userInput = scanner.nextLine();
        // Vérifie que la saisie utilisateur contient bien 4 caractères parmi les 6 couleurs existantes
        boolean valid = true;
        if (userInput.length() != 4) {
            valid = false;
        } else {
            for (int i = 0; i < 4; i++) {
                if (userInput.charAt(i) != 'R'
                    && userInput.charAt(i) != 'V'
                    && userInput.charAt(i) != 'B'
                    && userInput.charAt(i) != 'J'
                    && userInput.charAt(i) != 'C'
                    && userInput.charAt(i) != 'M'
                ) {
                    valid = false;
                    break;
                }
            }
        }
        if (valid) {
            System.out.println("Saisie correcte.");
        } else {
            System.out.println("Saisie incorrecte.");
        }
    }
}
