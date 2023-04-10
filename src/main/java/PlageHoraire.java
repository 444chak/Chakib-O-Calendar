/**
 * Class qui permet de manipuler des plages horaires avec l'horaire de début et de fin
 * @author 444chak
 * @version 1.0.0
 */

public class PlageHoraire implements Comparable<PlageHoraire>{
    private final static int DUREE_MIN = 60;
    private Horaire horaireDebut;
    private  Horaire horaireFin;

    /**
     * Constructeur d'objet avec l'horaire de début et de fin
     *
     * @param parDebut  L'horaire de début
     * @param parFin  L'horaire de fin
     * @throws ExceptionPlageHoraire
     */
    public PlageHoraire(Horaire parDebut, Horaire parFin) throws ExceptionPlageHoraire {
        if(parFin.toMinute() <= parDebut.toMinute()) {
            throw new ExceptionPlageHoraire(0);
        }
        else if(parFin.toMinute()-parDebut.toMinute() < DUREE_MIN) {
            throw new ExceptionPlageHoraire(1);
        }
        horaireDebut = parDebut;
        horaireFin = parFin;
    }

    /**
     * Affiche la plage horaire de l'objet this
     *
     * @return String   la plage horaire de this
     */
    public String toString(){
        return horaireDebut+"-"+horaireFin+", duree : "+this.duree();
    }

    /**
     * Vérifie si la plage horaire this est valide
     *
     * @return boolean  true si l'horaire est valide, sinon false
     */
    public boolean estValide(){
        return (horaireFin.toMinute()-horaireDebut.toMinute()) >= DUREE_MIN;
    }

    /**
     * Renvoie la durée de this en minutes
     *
     * @return int  Durée de la plage horaire
     */
    public int duree() {
        return horaireFin.toMinute()-horaireDebut.toMinute();
    }

    /**
     * Compare this à une autre plage horaire
     *
     * @param pPlage    Plage à comparer
     *
     * @return int      Entier négatif si this est inférieur à pPlage, positif si pPlage précède this, nul sinon
     */
    public int compareTo(PlageHoraire pPlage){
        if(horaireDebut.toMinute() >= pPlage.horaireFin.toMinute()){return 1;}
        else if(horaireFin.toMinute() <= pPlage.horaireDebut.toMinute()){return -1;}
        else{return 0;}
    }

    public void setHoraireDebut(Horaire parHoraire) { horaireDebut = parHoraire; }
    public void setHoraireFin(Horaire parHoraire) { horaireFin = parHoraire; }
}
