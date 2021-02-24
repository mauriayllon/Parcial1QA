package p1Test;

import org.junit.*;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import p1.Ej1UtilsNumeros;

import java.util.ArrayList;
import java.util.List;

@RunWith(value= Parameterized.class)
public class P1Test {
    Ej1UtilsNumeros ej1UtilsNumeros = new Ej1UtilsNumeros();
    private int expectedResult;
    private int numeroAInvertir;

    public P1Test(int numeroAInvertir,int expectedResult){
        this.numeroAInvertir=numeroAInvertir;
        this.expectedResult=expectedResult;
    }
    @Parameterized.Parameters
    public static Iterable<Object[]> getData(){
        List<Object[]> objects= new ArrayList<>();
        objects.add(new Object[]{43,34});
        objects.add(new Object[]{56,65});
        objects.add(new Object[]{989,989});
        return objects;
    }
    @BeforeClass
    public static void beforeClass(){
        System.out.println("-----> Before Class");
    }

    @AfterClass
    public static void afterClass(){
        System.out.println("-----> Before Class");
    }

    @Before
    public void before(){
        System.out.println("Before");
    }
    @After
    public void after(){
        System.out.println("After");
    }
    @Test
    public void verify_something(){
        int actualResult = ej1UtilsNumeros.invertirNumero(this.numeroAInvertir);
        Assert.assertEquals("ERROR! ",this.expectedResult,actualResult);
    }

}
