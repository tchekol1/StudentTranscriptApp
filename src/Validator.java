import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Validator {
    public Validator(){

    }

    public boolean gradeValidator(char grade){
        String expression="^[A-DF]$";
        String g= String.valueOf(grade);
        Pattern pattern= Pattern.compile(expression, Pattern.CASE_INSENSITIVE);
        Matcher matcher= pattern.matcher(g);
        boolean t= matcher.matches();
        if (t!=true){
           return false;
        }
        return true;
    }
    public boolean courseCreditVali(int credit){
        return credit==1||credit==2||credit==3||credit==4;
    }

}
