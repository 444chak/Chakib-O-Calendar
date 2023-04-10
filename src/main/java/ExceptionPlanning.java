

public class ExceptionPlanning extends Exception implements ConstantesErreurs{
    private int err;
    public ExceptionPlanning(int codeErreur) {
        super(ERREURS_PLANNING[codeErreur]);
    }
}
