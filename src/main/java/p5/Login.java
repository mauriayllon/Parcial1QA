package p5;

public class Login {

    String message;
    public String roleUser(String user, String pwd){
        if (Util2Static.isUserValid(user,pwd)){
            message="PERMISSION ROLE "+UtilStatic.getPermision(user,pwd);
        }else{
            message="Incorrect USER and PWD";
        }

        return message;
    }
}