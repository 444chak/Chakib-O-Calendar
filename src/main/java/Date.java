
import java.util.Calendar;
import java.util.Scanner;

/**
 * Class qui permet de manipuler des dates avec leurs jour, mois et année.
 * @author 444chak
 * @version 1.0.0
 * @see java.util.Scanner
 */
public class Date {
    protected int chJour;
    protected int chMois;
    protected int chAnnee;

    /**
     * Constructeur par défaut qui instancie un objet avec la date d'aujourd'hui.
     */
    public Date() {
        Calendar today = Calendar.getInstance();
        chAnnee = today.get(Calendar.YEAR);
        chMois = today.get(Calendar.MONTH) + 1;
        chJour = today.get(Calendar.DAY_OF_MONTH);
    }

    /**
     * Constructeur selon le jour, le mois et l'année
     *
     * @param parJour   Jour
     * @param parMois   Mois
     * @param parAnnee  Annee
     */
    public Date(int parJour, int parMois, int parAnnee){
        chJour = parJour;
        chMois = parMois;
        chAnnee = parAnnee;
    }
    /**
     * Constructeur définie la date au 1er Janvier de l'année donnée
     *
     * @param parAnnee  Annee
     */
    public Date(int parAnnee){
        chJour = 1;
        chMois = 1;
        chAnnee = parAnnee;
    }


    /**
     * Affiche la date
     *
     * @return string   la date au format jj/mm/aaaa
     */
    public String toString() {
        return chJour+"/"+chMois+"/"+chAnnee;
    }
    /**
     * Renvoie si l'année est bissextile ou non
     *
     * @param parAnnee  l'année à vérifier
     *
     * @return boolean  True si elle l'est, sinon False
     */
    static boolean estBissextile(int parAnnee){
        return (parAnnee % 4 == 0 && parAnnee % 100 != 0) || parAnnee % 400 == 0;
    }

    /**
     * Renvoie le dernier jour d'un mois et d'une année données
     *
     * @param parMois   Mois
     * @param parAnnee  Année
     * @see Date#estBissextile(int)
     */
    private static int dernierJourDuMois(int parMois, int parAnnee){
        switch(parMois){
            case 2:
                if(Date.estBissextile(parAnnee)){
                    return 29;
                }
                else{
                    return 28;
                }
            case 1: case 3: case 5: case 7: case 8: case 10: case 12:
                return 31;
            default:
                return 30;
        }
    }
    /**
     * Prends en entrée dans la console le jour, la date puis le mois puis le renvoie
     *
     * @return Date l'objet instancié selon les informations données dans la console
     */
    public static Date lireDate(){

        Scanner scanner = new Scanner(System.in);
        int jour = scanner.nextInt();
        int mois = scanner.nextInt();
        int annee = scanner.nextInt();
        scanner.close();
        return new Date(jour, mois, annee);
    }

    /**
     * Vérifie si this est valide (true) ou non (false)
     *
     * @return boolean  True si l'année est valide, sinon False
     * @see Date#dernierJourDuMois(int, int)
     */
    public boolean estValide() {
        if (chMois >= 1 && chMois <= 12) {
            return Date.dernierJourDuMois(chMois, chAnnee) >= chJour;
        } else {
            return false;
        }
    }
    /**
     * Compare this à une autre date en paramètre
     *
     * @param parDate   la date à comparer
     *
     * @return int      -1 si la date est antérieure, 0 si égale, 1 si postérieure
     */
    public int compareTo(Date parDate){
        if(parDate.chAnnee < chAnnee){return 1;} else if (parDate.chAnnee > chAnnee) {return -1;}
        else {
            if(parDate.chMois < chMois){return 1;} else if (parDate.chMois > chMois) {return -1;}
            else {
                return Integer.compare(chJour, parDate.chJour);
            }
        }

    }

    /**
     * Renvoie la date du lendemain de this
     *
     * @return Date le jour suivant this
     * @see Date#dernierJourDuMois(int, int)
     */
    public Date dateDuLendemain(){
        if(chJour == Date.dernierJourDuMois(chMois, chAnnee)){
            if(chMois == 12){return new Date(1, 1, chAnnee+1);}
            else{ return new Date(1, chMois+1, chAnnee);}
        }
        else{return new Date(chJour+1, chMois, chAnnee);}
    }

    /**
     * Renvoie la date de la veille de this
     *
     * @return Date le jour précédent this
     * @see Date#dernierJourDuMois(int, int)
     */
    public Date dateDeLaVeille(){
        if(chJour == 1){
            if(chMois == 1){return new Date(31, 12, chAnnee-1);}
            else{ return new Date(Date.dernierJourDuMois(chMois-1, chAnnee), chMois-1, chAnnee);}
        }
        else{return new Date(chJour-1, chMois, chAnnee);}
    }

    public int getChJour(){ return chJour; }
    public int getChMois(){ return chMois; }
    public int getChAnnee(){ return chAnnee; }

    public int getWeekOfYear(){
        Calendar  date = Calendar.getInstance();
        date.set(chAnnee, chMois-1, chJour);
        return Calendar.WEEK_OF_YEAR; }
}