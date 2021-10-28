package game;

/**
 * Représente une couleur possible dans les combinaisons du jeu
 */
public enum Color
{
    Red('R'),
    Green('V'),
    Blue('B'),
    Yellow('J'),
    Cyan('C'),
    Magenta('M');

    /**
     * Le caractère correspondant à la couleur
     */
    private char character;

    /**
     * Crée une nouvelle couleur
     * @param character Le caractère correspondant à la couleur
     */
    Color(char character)
    {
        this.character = character;
    }

    /**
     * Récupère le caractère correspondant à la couleur
     * @return
     */
    public char getCharacter()
    {
        return character;
    }

    /**
     * Cherche la couleur correspondant à un caractère donnée
     * @param character Le caractère correspondant à la couleur à rechercher
     */
    static public Color findColorByCharacter(char character)
    {
        // Pour chaque couleur parmi toutes les couleurs possibles
        for (Color color : Color.values()) {
            // Si le caractère associé à cette couleur correspond au caractère passé en paramètre, renvoie cette couleur
            if (color.getCharacter() == character) {
                return color;
            }
        }
        // Si aucune couleur n'a été trouvée, arrête l'application avec un message d'erreur
        // car ce n'est jamais censé arriver
        throw new RuntimeException("This color does not exist.");
    }
}
