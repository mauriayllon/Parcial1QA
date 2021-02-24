package p2;

public class Ej2Notas {

    String message;
    public String notasCualitativas(int notaFinal){
        if (notaFinal<0 || notaFinal>100)
            message="VALOR INCORRECTO";
        if (notaFinal>=0 && notaFinal <= 70)
            message="REGULAR";
        if (notaFinal>=70 && notaFinal <= 80)
            message="BUENO";
        if (notaFinal>=80 && notaFinal <= 90)
            message="MUY BUENO";
        if (notaFinal>=90 && notaFinal <= 100)
            message="EXCELENTE";
        return message;
    }
}