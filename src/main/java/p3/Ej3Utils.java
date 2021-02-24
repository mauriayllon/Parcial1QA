package p3;

public class Ej3Utils {

    public boolean isCorrectCI(String ci) throws Exception {
        boolean isCorrect;
        if (ci.isEmpty())
            throw new Exception("ci no puede ser vacia");

        if (Integer.parseInt(ci) > 0 ) {
                Thread.sleep(1000);
                isCorrect = true;
                }else {
                isCorrect = false;
                }
                return isCorrect;
                }

                }