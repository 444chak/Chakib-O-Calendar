/**
 * Class qui permet de manipuler des horaires avec les heures et les quarts d'heures.
 * @author 444chak
 * @version 1.0.0
 */

public class Horaire {
    private int Heure;
    private int QuartHeure;

    /**
     * Constructeur d'objet avec l'heure et le quart d'heure
     *
     * @param pHeure        L'heure
     * @param pQuartHeure   Le quart d'heure
     */
    public Horaire(int pHeure, int pQuartHeure){
        Heure = pHeure;
        QuartHeure = pQuartHeure;
    }

    /**
     * Convertir l'horaire de this en minutes
     *
     * @return int  Le nombre de minutes de l'horaire
     */
    public int toMinute(){
        return Heure*60+QuartHeure;
    }

    /**
     * Accesseur du champ de l'heure de this
     *
     * @return int  L'heure
     */
    public int getHeure(){
        return Heure;
    }

    /**
     * Accesseur du champ du quart d'heure de this
     *
     * @return int  Le(s) quart(s) d'heure
     */
    public int getQuartHeure(){
        return QuartHeure;
    }

    /**
     * Modifieur du champ de l'heure de this
     *
     * @parameter int   La nouvelle heure
     */
    public void setHeure(int pHeure){
        Heure = pHeure;
    }

    /**
     * Modifieur du champ de quart d'heure de this
     *
     * @parameter int   Le(s) nouveau(x) quart(s) d'heure
     */
    public void setQuartHeure(int pQuartHeure){
        QuartHeure = pQuartHeure;
    }

    /**
     * Affiche l'horaire de this
     *
     * @return String   l'horaire au format heure h minutes
     */
    public String toString(){
        return Heure+"h"+QuartHeure;
    }
}
