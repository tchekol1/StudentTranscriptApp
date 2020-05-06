import java.util.ArrayList;
import java.util.Scanner;
public class TranscriptApp {
    public static void main(String[] args) {
        String enter="yes";
        String otherStudent="yes";
        Scanner scanner= new Scanner(System.in);
        ArrayList<Transcript>list= new ArrayList<>();
        System.out.println("Welcome to the transcript application.");

        while(otherStudent.equalsIgnoreCase("yes")){
            Transcript transcript= new Transcript();//create new transcript object for each student
            System.out.println("Enter student ID");
            transcript.setID(scanner.nextLine());
            System.out.println("Enter student's first name: ");
            transcript.setFirst_name(scanner.nextLine());
            System.out.println("Enter student last name: ");
            transcript.setLast_name(scanner.nextLine());
            list.add(transcript);
            while (enter.equalsIgnoreCase("yes")) {
                Validator validator= new Validator();
                CourseEnrollment enrollment = new CourseEnrollment();//create new course object
                System.out.println("Enter course Code: ");
                enrollment.setCourse_code(scanner.nextLine());

                System.out.println("Enter credits: ");
                int credits=scanner.nextInt();
                while (!(validator.courseCreditVali(credits))){
                    System.out.println("Invalid input.. Please enter value from{1,2,3,4}");
                    credits=scanner.nextInt();
                    validator.courseCreditVali(credits);
                }
                enrollment.setCredits(credits);
                scanner.nextLine();
                System.out.println("Enter grade: ");
                String grade=scanner.nextLine();
                while (!(validator.gradeValidator(grade.charAt(0)))){
                    System.out.println("Invalid input.. Please enter value from{A,B,C,D,F}");
                    grade=scanner.nextLine();
                    validator.gradeValidator(grade.charAt(0));
                }
                enrollment.setGrade(grade.charAt(0));
                transcript.addCourse(enrollment);
                System.out.println("Do you want to enter other course yes/no");
                enter = scanner.nextLine();

            }
            System.out.println("Do you want to enter for other student yes/no");
            otherStudent = scanner.nextLine();
            if (otherStudent.equalsIgnoreCase("yes")){
                enter="yes";
            }

        }
        for (Transcript e :list) {
            System.out.println("ID: "+ e.getID());
            System.out.println("First Name: "+e.getFirst_name());
            System.out.println("Last Name: "+e.getLast_name());
            System.out.println("Course \t\t Credits\t\t Grade\t\t Quality Points");
            System.out.println();
            for (CourseEnrollment C: e.getCourses()) {
                System.out.println(C.getCourse_code()+ "\t\t\t"+ C.getCredits()+ "\t\t\t\t"+  C.getGrade()+"\t\t\t\t"+ e.getGpaEqu(C.getGrade()));
            }
            System.out.println();
            System.out.println("GPA: "+ e.getFormattedGPA());
            System.out.println();
        }

    }


}


