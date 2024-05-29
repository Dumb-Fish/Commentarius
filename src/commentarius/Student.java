package commentarius;

import java.util.HashMap;
import java.util.Scanner;

public class Student extends User{
    private final Scanner an = new Scanner(System.in);
    public String[] addStudents;

    Student(String[] addStudents, HashMap<String, String> listOfStudents){
        super(listOfStudents);
        this.addStudents = addStudents;
        StudentList info = new StudentList();
        info.setAll("Abdullayev", "Timur", "SonOfSomeone", 18, "sophomore", 31500);
        addStudents[0] = info.getStudInfo();
    }

    public void completingStudentProgram(int option) {
        switch (option) {
            case 1:
                System.out.println("""
                whats u gonna do?
                1. change username
                2. change password
                3. back""");
                editAccount(an.nextByte());
                break;
                case 2: System.exit(0);
        }
    }
    }

