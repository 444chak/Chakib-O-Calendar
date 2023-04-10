import java.util.ArrayList;
import java.util.Calendar;
import java.util.TreeMap;
import java.util.TreeSet;


public class PlanningCollections {
    ArrayList<Reservation> listeRes;
    TreeSet<Reservation> TSRes;
    TreeMap<Integer,ArrayList<Reservation>> TMRes;


    public PlanningCollections(){
        listeRes = new ArrayList<>();
        TSRes = new TreeSet<>();
        TMRes = new TreeMap<>();
    }

    /**
     * Renvoie une chaine de cacractère de la taille et du contenu de chaque champs
     * @return string taille [contenu]  taille [contenu] taille [contenu]
     */
    public String toString(){
        return listeRes.size() + " " + listeRes + "\n\n" + TSRes.size() + " " + TSRes + "\n\n" + TMRes.size() + " " + TMRes;
    }

    /**
     * Ajoute la réservation res au planning this
     * @param res   La réservation à ajouter
     */
    public void ajout(Reservation res){
        TSRes.add(res);
        listeRes.add(res);
        Calendar date = Calendar.getInstance();
        date.set(res.getResDate().getChAnnee(), res.getResDate().getChMois()-1, res.getResDate().getChJour());


        if (TMRes.containsKey(date.get(Calendar.WEEK_OF_MONTH))) {
            TMRes.get(Calendar.WEEK_OF_MONTH).add(res);
        }
        else{
            ArrayList<Reservation> arrayTMap =  new ArrayList<>();
            arrayTMap.add(res);
            TMRes.put(date.get(Calendar.WEEK_OF_MONTH), arrayTMap);
        }

    }

    /**
     * Renvoie les réservations de this correspondant à la date à en paramètres
     * @param date  date des réservations à récupérer
     * @return TreeSet réservations récupérées
     */
    public TreeSet<Reservation> getTSRes(DateCalendrier date){
        TreeSet<Reservation> resParDate = new TreeSet<>();
        for (Reservation res:TSRes) {
            if (res.getResDate().compareTo(date) == 0){
                resParDate.add(res);
            }
        }

        if (resParDate.size() == 0){
            return null;
        }
        else{
            return resParDate;
        }
    }

    /**
     * Renvoie les réservations de this qui possèdent la même chaine de caractère dans l'intitulé
     * @param string    La chaîne de caractères à vérifier
     * @return TreeSet  réservations récupérées
     */
    public TreeSet<Reservation> getTSRes(String string){
        TreeSet<Reservation> resParInt = new TreeSet<>();
        for (Reservation res:TSRes) {
            if(res.getResIntitule().contains(string)) {
                resParInt.add(res);
            }
        }
        if (resParInt.size() == 0){
            return null;
        }
        else{
            return resParInt;
        }
    }

}
