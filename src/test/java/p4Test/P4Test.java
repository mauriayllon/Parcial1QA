package p4Test;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.mockito.Mockito;
import p4.CambioMoneda;
import p4.Util;

import java.util.ArrayList;
import java.util.List;

@RunWith(value= Parameterized.class)
    public class P4Test {

        private int amount;
        private String monedaOriginal;
        private String monedaDestino;
        private double expectedMock;
        private String expectedResult;

        public P4Test(int amount, String monedaOriginal, String monedaDestino ,double expectedMock, String expectedResult){
            this.amount=amount;
            this.monedaOriginal = monedaOriginal;
            this.monedaDestino=monedaDestino;
            this.expectedMock= expectedMock;
            this.expectedResult=expectedResult;
        }

        @Parameterized.Parameters
        public static Iterable<Object[]> getData(){
            List<Object[]> objects= new ArrayList<>();
            objects.add(new Object[]{700,"Bolivianos","Dolares",100.0,"La cantidad convertida fue : [100] Dolares"});
            objects.add(new Object[]{-700,"Bolivianos","Dolares",100.0,"Cantidad incorrecta"});
            objects.add(new Object[]{100,"Dolares","Euros",120.0,"La cantidad convertida fue : [80] Euros"});
            objects.add(new Object[]{100,"Euros","Bolivianos",800.0,"La cantidad convertida fue : [800] Bolivianos"});
            objects.add(new Object[]{1000,"Dolares","Bolivianos",7000.0,"La cantidad convertida fue : [7000] Bolivianos"});
            //Falta la verificacion si el dato de las monedas es incorrecto
            //objects.add(new Object[]{1000,"lalalala","Bolivianos",7000,});
            return objects;
        }

        //PASO 2
        Util utillMocked = Mockito.mock(Util.class);
        @Test
        public void verify_change(){
            // Paso 3
            Mockito.when(utillMocked.obtenerTipoDeCambio("Bolivianos","Dolares")).thenReturn(this.amount/7.0);
            Mockito.when(utillMocked.obtenerTipoDeCambio("Dolares","Bolivianos")).thenReturn(this.amount*7.0);
            Mockito.when(utillMocked.obtenerTipoDeCambio("Euros","Bolivianos")).thenReturn(this.amount/8.0);
            Mockito.when(utillMocked.obtenerTipoDeCambio("Euros","Dolares")).thenReturn(this.amount/0.8);
            Mockito.when(utillMocked.obtenerTipoDeCambio("Dolares","Euros")).thenReturn(this.amount*1.2);

            // Paso 4
            CambioMoneda cambioMoneda = new CambioMoneda(utillMocked);
            String actualResult= cambioMoneda.saveInNewMoney(this.amount,this.monedaOriginal,this.monedaDestino);
            Assert.assertEquals("ERROR! ",this.expectedResult, actualResult);
        }
    }

