

public class ExceptionReservation extends Exception implements ConstantesErreurs{
    public ExceptionReservation(int codeErreur){
        super(ERREURS_RESERVATION[codeErreur]);
    }
}
