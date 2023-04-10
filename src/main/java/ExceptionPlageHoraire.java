

public class ExceptionPlageHoraire extends Exception implements ConstantesErreurs{
    private int codeErr;
    public ExceptionPlageHoraire(int codeErr){
        super(ERREURS_PLAGE_HORAIRE[codeErr]);
    }
}
