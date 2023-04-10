/**
 * Class qui permet de manipuler des plannings en fonctions de réservations
 * @author 444chak
 * @version 1.0.0
 */

public class Planning {
    private final int NB_RES;
    private Reservation [] Reservations;

    public Planning(int NbRes) {
        NB_RES = NbRes;
        Reservations = new Reservation[NB_RES];
    }

    /**
     * Ajouter une réservation dans le planning
     * La réservation doit être valide
     * Le tableau de réservations ne doit pas être plein
     * Elle ne doit pas être déjà dans le tableau
     *
     * @param Res La réservation à ajouter
     * @throws ExceptionPlanning Si la réservation ne peut être ajouté
     */
    public void ajout(Reservation Res) throws ExceptionPlanning{
        if(Reservations[NB_RES-1] != null){
            throw new ExceptionPlanning(1);
        }
        for(int i=0; i<NB_RES; i++) {
            if (Reservations[i] == null) {
                Reservations[i] = Res;
                    return;
            }
            if(Reservations[i].compareTo(Res) == 0) {
                    throw new ExceptionPlanning(2);
            }

        }
    }

    /**
     * Affinche les réservations de this
     * @return String
     */
    public String toString() {
        String text = "";
        for (Reservation reservation : Reservations) {
            if (reservation == null) {
                return text;
            }
            text += reservation.toString() + "\n";
        }
        return text;
    }

    /**
     * Renvoie la première réservation du tableau ayant pour date parDate
     *
     * @param parDate   La date à laquelle on souhaite récupérer une reservation
     * @return          Reservation ou null si la date n'apparait pas
     */
    public Reservation getReservation(Date parDate) {
        for(int i=0; i < Reservations.length; i++) {
            if (Reservations[i] != null) {
                if (Reservations[i].getResDate().compareTo(parDate) == 0) {
                    return Reservations[i];
                }
            }
        }
        return null;
    }

    /**
     * Renvoie toutes les réservation à la date donnée
     *
     * @param parDate           La date à laquelle on souhaite récupérer les réservations
     * @return [] Reservation   Le tableau des réservations à la date parDate
     */
    public Reservation [] getReservations(Date parDate) {
        Reservation [] ReservationsDate = new Reservation[NB_RES];
        int i = 0;
        for(Reservation Res : Reservations) {
            if (Res != null) {
                if(Res.getResDate().compareTo(parDate) == 0) {
                    ReservationsDate[i] = Res;
                    i++;
                }
            }
        }
        return ReservationsDate;
    }

    /**
     * Renvoie la plus ancienne réservation des dates comprises entre deux indices
     * @param parDebut  Indice de début
     * @param parFin    Indice de fin
     * @return  La reservation la plus historique
     */
    public Reservation plusAncienneReservation(int parDebut, int parFin) {
        if(parFin > NB_RES) {
            parFin = NB_RES;
        }
        Reservation plusAncienneResa = Reservations[parDebut];

        for(int i = parDebut; i < parFin; i++){
            if (Reservations[i] == null) { return plusAncienneResa;}
            if(plusAncienneResa.compareTo(Reservations[i]) > 0) {plusAncienneResa = Reservations[i];}
        }
        return plusAncienneResa;
    }

    public void setReservations(Reservation [] parReservations) { Reservations = parReservations;}
}
