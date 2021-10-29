package game;

import java.util.Arrays;
import java.util.Collections;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Représente une combinaison de couleurs
 */
public class ColorCombination
{
    /**
     * La liste des couleurs présentes dans la combinaison
     */
    private Color[] colors;

    /**
     * Génère une combinaison de couleurs de manière aléatoire
     * @return
     */
    static public ColorCombination generateRandomCombination()
    {
        // Initialise le tableau des couleurs générées
        Color[] generatedColors = new Color[4];
        // Répète 4 fois les opérations suivantes
        for (int i = 0; i < 4; i++) {
            // Ajoute cette couleur au tableau des couleurs générées
            generatedColors[i] = Color.findAtRandom();
        }
        // Renvoie une combinaison de couleurs construite à partir du tableau des couleurs générées
        return new ColorCombination(generatedColors);
    }

    /**
     * Crée une nouvelle combinaison de couleurs à partie d'un tableau de couleurs
     * @param colors La liste des couleurs présentes dans la combinaison 
     */
    public ColorCombination(Color[] colors)
    {
        this.colors = colors;
    }

    /**
     * Crée une nouvelle combinaison de couleurs à partir d'une chaîne de caractères
     * @param colorString La chaîne de caractères à analyser
     */
    public ColorCombination(String colorString)
    {
        // Vérifie que la chaîne fournie contient bien 4 caractères parmi les 6 couleurs existantes
        Pattern pattern = Pattern.compile("^[RVBJCM]{4}$");
        Matcher matcher = pattern.matcher(colorString);
        if (!matcher.matches()) {
            throw new RuntimeException("'" + colorString + "' is an illegal color combination.");
        }
        // Transforme la chaîne fournie en tableau de caractères pour faciliter son exploitation
        char[] chars = colorString.toCharArray();
        Color[] colors = new Color[colorString.length()];
        // Pour chaque caractère présent dans la chaîne fournie
        for (int i = 0; i < colorString.length(); i++) {
            colors[i] = Color.findColorByCharacter(chars[i]);
        }
        this.colors = colors;
    }

    /**
     * Compare la combinaison avec une autre combinaison
     * @param otherCombination L'autre combinaison avec laquelle comparer celle-ci
     * @return Le résultat de la comparaison
     */
    public ComparisonResult compareTo(ColorCombination otherCombination)
    {
        // Détermine les couleurs bien placées
        // Initialise le compte des couleurs bien placées à zéro
        int correctCount = 0;
        // Pour chaque couleur de la combinaison
        for (int i = 0; i < 4; i++) {
            // Si cette couleur est la même que celle de l'autre combinaison (à la même place)
            if (colors[i] == otherCombination.colors[i]) {
                // Augmente le compte des couleurs bien placées de 1
                correctCount += 1;
            }
        }
        
        // Détermine les couleurs absentes
        // Initialise le compte des couleurs absentes à zéro
        int absentCount = 0;
        // Pour chaque couleur possible
        for (Color color : Color.values()) {
            // Compte le nombre de cette couleur en trop dans la proposition de l'utilisateur
            // par rapport à la solution
            int colorCount = Collections.frequency(Arrays.asList(colors), color);
            int otherColorCount = Collections.frequency(Arrays.asList(otherCombination.colors), color);
            int excess = otherColorCount - colorCount;
            // Ajoute au compte des couleurs absentes ce nombre de couleurs excédentaires
            // (uniquement dans le cas où les couleurs sont exécendaites dans proposition de l'utilisateur)
            if (excess > 0) {
                absentCount += excess;
            }
        }

        // Déduit le nombre de couleurs mal placées
        int misplacedCount = 4 - correctCount - absentCount;

        return new ComparisonResult(correctCount, misplacedCount, absentCount);
    }
}
