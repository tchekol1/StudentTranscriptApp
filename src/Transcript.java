import java.text.DecimalFormat;
import java.util.ArrayList;
public class Transcript {
    private String ID;
    private String first_name;
    private String last_name;
    private ArrayList<CourseEnrollment>list=  new ArrayList<>();
    public Transcript() {

    }

    public void setList(ArrayList<CourseEnrollment> list) {
        this.list = list;
    }

    public void addCourse(CourseEnrollment course){
        list.add(course);
    }
    public String getID() {
        return ID;
    }

    public void setID(String ID) {
        this.ID = ID;
    }

    public String getFirst_name() {
        return first_name;
    }

    public void setFirst_name(String first_name) {
        this.first_name = first_name;
    }

    public String getLast_name() {
        return last_name;
    }

    public void setLast_name(String last_name) {
        this.last_name = last_name;
    }

    public ArrayList<CourseEnrollment> getCourses(){
        return list;
    }
    double getOverallGPA(){
        double grCreTo=0;
        int totalCredits=0;
        double gpa=0;
        double total=0;
        int credits=0;
        for (int i = 0; i <list.size() ; i++) {
            char grade=list.get(i).getGrade();
            credits = list.get(i).getCredits();
            totalCredits += credits;
            double NumericGrade= getGpaEqu(grade);
            grCreTo= grCreTo+(credits*NumericGrade);
        }
        gpa=grCreTo/totalCredits;
        return gpa;
    }
    String getFormattedGPA(){
        DecimalFormat format= new DecimalFormat("##.##");
        return format.format(getOverallGPA());

    }
    //return numeric equvalent of character grade
    public double getGpaEqu(char grade){
        double gr=0;
        switch (grade){
            case 'A':
            case 'a':
                gr=4;
                break;
            case 'B':
            case 'b':
                gr=3;
                break;
            case 'C':
            case 'c':
                gr=2;
                break;
            case 'D':
            case 'd':
                gr=1;
                break;
            default:
                gr=0;
                break;
        }
        return  gr;
    }
}

