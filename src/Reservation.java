/**
 * Class qui permet de manipuler des réservation en fontion de leur date et de leur plage horaire
 * @author 444chak
 * @version 1.0.0
 */
public class Reservation implements Comparable<Reservation>{
    private String resIntitule;
    private Date resDate;
    private PlageHoraire resPlageHoraire;

    /**
     * Constructeur d'objet avec l'intitulé, la date, et la plage horaire
     *
     * @param parIntitule       l'intitulé de la réservation
     * @param parDate           La date de la réservation
     * @param parPlageHoraire   la plage horaire durant laquelle la réservation a lieu
     */
    public Reservation(String parIntitule, Date parDate, PlageHoraire parPlageHoraire) throws ExceptionReservation{
        if(parIntitule == ""){
            throw new ExceptionReservation(0);
        }
        resIntitule = parIntitule;
        resDate = parDate;
        resPlageHoraire = parPlageHoraire;
    }


    /**
     * Affiche la réservation this
     *
     * @return String   La réservation sous la forme intitulé, date, plage horaire, durée : durée.
     */
    public String toString() {
        return resIntitule+","+resDate+","+resPlageHoraire;
    }

    /**
     * Compare la réservation this à une autre réservation
     * Retourne 0 si les réservations sont en même temps
     * Retourne -1 si this est avant l'autre réservation
     * Retourne 1 si this est après l'autre réservation
     *
     * @param pReservation  L'autre réservation
     *
     * @return int
     */
    public int compareTo(Reservation pReservation){
        int compareDate = resDate.compareTo(pReservation.resDate);
        int comaprePlage = resPlageHoraire.compareTo(pReservation.resPlageHoraire);
        if(compareDate == 0){return comaprePlage;}
        else{return compareDate;}
    }

    /**
     * Vérifie que tous les élements de la réservation sont valides
     * @return boolean
     */
    public boolean estValide(){
        return resIntitule != "" && resDate.estValide() && resPlageHoraire.estValide();
    }

    public void setResIntitule(String intitule){
        resIntitule = intitule;
    }

    public String getResIntitule() {return resIntitule;}

    public void setResDate(Date pDate){
        resDate = pDate;
    }

    public void setResPlageHoraire(PlageHoraire pPlage){
        resPlageHoraire = pPlage;
    }

    public Date getResDate() {
        return resDate;
    }
}
