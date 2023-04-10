
import java.util.Calendar;


/**
 * Class-fille de la class Date qui permet de manipuler des dates dans un calendrier avec le jour de la semaine.
 * @author 444chak
 * @version 1.0.0
 * @see java.util.Calendar
 * @see java.util.Date
 */
public class DateCalendrier extends Date implements ConstantesCalendrier, Comparable<Date>{
    private final int jourSemaine; // 1 = lundi, 2 = mardi, ...

    /**
     * Constructeur par défaut qui instancie un objet avec la date d'aujourd'hui.
     */
    public DateCalendrier(){
        Calendar today = Calendar.getInstance();
        chAnnee = today.get(Calendar.YEAR);
        chMois = today.get(Calendar.MONTH) + 1;
        chJour = today.get(Calendar.DAY_OF_MONTH);

        int dayOfWeek = today.get(Calendar.DAY_OF_WEEK);
        if(dayOfWeek == 1) {
            jourSemaine = 7;
        }
        else{
            jourSemaine = dayOfWeek -1;
        }
    }

    /**
     * Constructeur qui instancie une date selon son jour, son mois et son année
     *
     * @param jour  entier correspondant au jour du mois
     * @param mois  entier correspondant au moins dans l'année (1 à 12)
     * @param annee entier correspondant à l'année de la date
     */
    public DateCalendrier(int jour, int mois, int annee) {
        super(jour, mois, annee);
        mois -=1;
        Calendar date = Calendar.getInstance();
        date.set(annee, mois, jour);
        int dayOfWeek = date.get(Calendar.DAY_OF_WEEK);
        if(dayOfWeek == 1) {
            jourSemaine = 7;
        }
        else{
            jourSemaine = dayOfWeek -1;
        }
    }

    /**
     * Renvoie la date du lendemain de this
     *
     * @return Date le jour suivant this
     * @see Date#dateDuLendemain()
     */
    public DateCalendrier dateDuLendemain(){
        Date dateL = super.dateDuLendemain();
        return new DateCalendrier(dateL.chJour, dateL.chMois, dateL.chAnnee);
    }

    /**
     * Renvoie la date du lendemain de this
     *
     * @return Date le jour suivant this
     * @see Date#dateDeLaVeille()
     */
    public DateCalendrier dateDeLaVeille(){
        Date dateL = super.dateDeLaVeille();
        return new DateCalendrier(dateL.chJour, dateL.chMois, dateL.chAnnee);
    }

    /**
     * Affiche la date
     *
     * @return string   la date au format jour_de_la_semaine jour mois année
     * @see ConstantesCalendrier
     */
    public String toString(){
        return JOURS_SEMAINE[jourSemaine-1]+" "+chJour+" "+MOIS[chMois-1]+" "+chAnnee;
    }
    public int getJourSemaine() { return jourSemaine;}

    public int getMois() { return chMois;}

    public int getAnnee() { return chAnnee;}

    public boolean isToday(){
        return this.compareTo(new Date()) == 0;
    }

}
