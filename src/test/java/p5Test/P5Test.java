package p5Test;

import net.sf.cglib.asm.$Type;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.mockito.Mockito;
import org.powermock.api.mockito.PowerMockito;
import org.powermock.core.classloader.annotations.PrepareForTest;
import org.powermock.modules.junit4.PowerMockRunner;
import org.powermock.modules.junit4.PowerMockRunnerDelegate;
import p5.Login;
import p5.Util2Static;
import p5.UtilStatic;

import java.util.ArrayList;
import java.util.List;

//Paso 1 para metodos estaticos
@RunWith(PowerMockRunner.class)
//Paso 2 para metodos estaticos
@PowerMockRunnerDelegate(Parameterized.class)

@PrepareForTest({Util2Static.class, UtilStatic.class})

public class P5Test {


    @Parameterized.Parameter(0)
    public String user;
    @Parameterized.Parameter(1)
    public String pwd;
    @Parameterized.Parameter(2)
    public String expectedResult;
    @Parameterized.Parameter(3)
    public boolean expectedUtil2;
    @Parameterized.Parameter(4)
    public String expectedUtil;


    @Parameterized.Parameters
    public static Iterable<Object[]> getData(){
        List<Object[]> objects= new ArrayList<>();
        objects.add(new Object[]{"User","Pwd", "PERMISSION ROLE CR" , true, "CR"});
        objects.add(new Object[]{"User","Pwd","PERMISSION ROLE CU", true, "CU"});
        objects.add(new Object[]{"User","Pwd","PERMISSION ROLE CD", false, "CD"});
        objects.add(new Object[]{"User","Pwd"   , "PERMISSION ROLE UD",false,"UD"});
        objects.add(new Object[]{"User","Pwd"  , "PERMISSION ROLE RU", true,"RU"});
        objects.add(new Object[]{"User","Pwd" ,"PERMISSION ROLE RUD", true,"RUD"});
        objects.add(new Object[]{"User","Pwd"  ,"PERMISSION ROLE CUD" , true,"CUD"});
        objects.add(new Object[]{"User","Pwd"  ,"PERMISSION ROLE CRD" ,true,"CRD"});
        objects.add(new Object[]{"User","Pwd"  ,"PERMISSION ROLE CR" ,true,"CR"});
        //objects.add(new Object[]{12,"Pwd"  ,"Incorrect USER and PWD", "","RD"});
        return objects;
    }

    @Test
    public void verify_calculate_amount(){
        //Funcionaban las pruebas pero paso un error y no pude corregirlo
        // PASO 3
        PowerMockito.mockStatic(Util2Static.class);
        PowerMockito.mockStatic(UtilStatic.class);
        // PASO 4
        Mockito.when(Util2Static.isUserValid(this.user,this.pwd)).thenReturn(true);
        Mockito.when(Util2Static.isUserValid(null,this.pwd)).thenReturn(false);
        Mockito.when(Util2Static.isUserValid(this.user,null)).thenReturn(false);
        Mockito.when(UtilStatic.getPermision(this.user,this.pwd)).thenReturn(this.expectedUtil);
        Login login = new Login();
        String actualResult= login.roleUser(this.user,this.pwd);
        Assert.assertEquals("ERROR! ",this.expectedResult,actualResult);
    }

}