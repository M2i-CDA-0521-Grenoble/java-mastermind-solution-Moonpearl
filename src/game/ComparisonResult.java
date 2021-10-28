package game;

/**
 * Représente le résultat d'une comparaison entre deux combinaisons de couleurs
 */
public class ComparisonResult
{
    /**
     * Le nombre de couleurs bien placées dans la première combinaison par rapport à la deuxième
     */
    private int correctCount;
    /**
     * Le nombre de couleurs présentes mais mal placées dans la première combinaison par rapport à la deuxième
     */
    private int misplacedCount;
    /**
     * Le nombre de couleurs absentes dans la première combinaison par rapport à la deuxième
     */
    private int absentCount;

    /**
     * Crée un nouveau résultat de comparaison entre deux combinaisons de couleurs
     * @param correctCount Le nombre de couleurs bien placées dans la première combinaison par rapport à la deuxième
     * @param misplacedCount Le nombre de couleurs présentes mais mal placées dans la première combinaison par rapport à la deuxième
     * @param absentCount Le nombre de couleurs absentes dans la première combinaison par rapport à la deuxième
     */
    public ComparisonResult(int correctCount, int misplacedCount, int absentCount)
    {
        this.correctCount = correctCount;
        this.misplacedCount = misplacedCount;
        this.absentCount = absentCount;
    }

    /**
     * Génére un affichage permettant de connaître le résultat de la comparaison
     * @return
     */
    public String createDisplay()
    {
        String result = "";
        for (int i = 0; i < correctCount; i++) {
            result += "O ";
        }
        for (int i = 0; i < misplacedCount; i++) {
            result += "X ";
        }
        for (int i = 0; i < absentCount; i++) {
            result += "- ";
        }
        return result;
    }

    /**
     * Détermine si le résultat correspond à un résultat gagnant
     * (si les deux combinaisons se correspondent exactement)
     * @return
     */
    public boolean isWinning()
    {
        return correctCount == 4;
    }

    public int getCorrectCount() {
        return correctCount;
    }

    public int getMisplacedCount() {
        return misplacedCount;
    }

    public int getAbsentCount() {
        return absentCount;
    }
}
