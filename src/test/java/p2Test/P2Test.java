package p2Test;

import org.junit.*;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import p1.Ej1UtilsNumeros;
import p2.Ej2Notas;

import java.util.ArrayList;
import java.util.List;

@RunWith(value= Parameterized.class)
public class P2Test {
    Ej2Notas ej2Notas = new Ej2Notas();
    private String expectedResult;
    private int nota;

    public P2Test(int nota,String expectedResult){
        this.nota=nota;
        this.expectedResult=expectedResult;
    }
    @Parameterized.Parameters
    public static Iterable<Object[]> getData(){
        List<Object[]> objects= new ArrayList<>();
        objects.add(new Object[]{-1,"VALOR INCORRECTO"});
        objects.add(new Object[]{0,"REGULAR"});
        objects.add(new Object[]{1,"REGULAR"});
        objects.add(new Object[]{69,"REGULAR"});
        objects.add(new Object[]{70,"BUENO"});
        //4
        objects.add(new Object[]{71,"BUENO"});
        objects.add(new Object[]{79,"BUENO"});
        objects.add(new Object[]{80,"MUY BUENO"});
        objects.add(new Object[]{81,"MUY BUENO"});
        objects.add(new Object[]{89,"MUY BUENO"});
        objects.add(new Object[]{90,"EXCELENTE"});
        //10
        objects.add(new Object[]{91,"EXCELENTE"});
        objects.add(new Object[]{99,"EXCELENTE"});
        objects.add(new Object[]{100,"EXCELENTE"});
        objects.add(new Object[]{101,"VALOR INCORRECTO"});
        return objects;
    }

    @Test
    public void verify_something(){
        String actualResult = ej2Notas.notasCualitativas(this.nota);
        Assert.assertEquals("ERROR! ",this.expectedResult,actualResult);
    }

}
