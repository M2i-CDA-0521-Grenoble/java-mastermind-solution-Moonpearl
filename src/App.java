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
        
        // Crée une interface permettant de surveiller les saisies utilisateur dans la console
        Scanner scanner = new Scanner(System.in);
        // Attend une saisie utilisateur
        String userInput = scanner.nextLine();
        // Vérifie que la saisie utilisateur contient bien 4 caractères parmi les 6 couleurs existantes
        Pattern pattern = Pattern.compile("^[RVBJCM]{4}$");
        Matcher matcher = pattern.matcher(userInput);
        if (matcher.matches()) {
            System.out.println("Saisie correcte.");
        } else {
            System.out.println("Saisie incorrecte.");
        }
    }
}
