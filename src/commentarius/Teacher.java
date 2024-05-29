package commentarius;

import java.util.HashMap;
import java.util.InputMismatchException;
import java.util.Scanner;

public class Teacher extends User {
    private final StudentList info = new StudentList();
    private final Scanner an = new Scanner(System.in);
    public String[] addStudents;
    private int arrIndex = 1;

    Teacher(String[]addStudents, HashMap<String, String> listOfTeachers) {
        super(listOfTeachers);
        this.addStudents = addStudents;
        info.setAll("Abdullayev", "Timur", "SonOfSomeone", 18, "sophomore", 31500);
        addStudents[0] = info.getStudInfo();
    }

    public void completingTeacherProgram(int option) {
        switch (option) {
            case 1:
                addStudent(this.addStudents);
                break;
            case 2:
                getStudInfo();
                break;
            case 3:
                editStudent();
                break;
            case 4:
                getStudList();
                break;
            case 5:
                System.out.println("""
                whats u gonna do?
                1. change username
                2. change password
                3. back""");
                editAccount(an.nextByte());
                        break;
            case 6:
                System.exit(0);
            default:
                System.out.println("incorrect input");
                System.out.println();
        }
    }

    private void addStudent(String[] temp) {
        boolean cycle = true;

        String[] savedStudents = new String[30];

        while (cycle) {

            if (arrIndex >= 29) {
                System.out.println("limit 29 has been achieved");
                break;
            } else {
                System.out.println("enter surname, name, patronymic, age, course, grant");
                while (true) {
                    try {
                        info.setAll(an.next().strip(), an.next().strip(), an.next().strip(), an.nextInt(), an.next().strip(),
                                an.nextInt());
                        break;
                    } catch (InputMismatchException e) {
                        System.out.println("Введены некореектные данные.");
                        System.out.println("enter surname, name, patronymic, age, course, grant");
                        an.nextLine();
                    }
                }
                savedStudents[arrIndex] = info.getStudInfo();
                arrIndex++;
                an.nextLine();
                System.out.println("""
                        Then?
                        1. Add another one
                        2. back""");
                switch (an.nextInt()) {
                    case 1:
                        continue;
                    case 2:
                        an.nextLine();
                        cycle = false;
                        break;
                    default:
                        System.out.println("incorrect input. Try next time!");
                        cycle = false;
                }
            }
        }
        for (int i = 0; i < 30; i++) {
            if (temp[i] == null) temp[i] = savedStudents[i];
        }
    }

    private void getStudInfo() {
        while (true) {
            try {
                System.out.println("enter student index");
                System.out.println("Student: " + this.addStudents[an.nextInt()]);
                System.out.println("enter any input to continue...");
                an.next();
                an.nextLine();
                break;
            } catch (InputMismatchException e) {
                System.out.println("Ты че за фигню сделал, вводи Integer: ");
                an.nextLine();
            }
        }
    }

    private void editStudent() {
        int studIndex;
        System.out.println("enter student index");
        try {
            studIndex = an.nextInt();
            String student = addStudents[studIndex];
            String[] words = student.split(" ");

            System.out.println(addStudents[studIndex] + "\n" + "which parameter do you want to change? (1-6)");

            int stringIndex = an.nextInt() - 1;

            String temp = addStudents[studIndex].split(" ")[stringIndex];

            System.out.println("Editing: " + temp + "\n" + "enter new information");
            words[stringIndex] = an.next();
            student = String.join(" ", words);
            addStudents[studIndex] = student;
            System.out.println(addStudents[studIndex]);
        } catch (NullPointerException | ArrayIndexOutOfBoundsException e) {
            System.out.println("incorrect input. " + e.getMessage());
        }
    }

    private void getStudList() {
        for (int i = 0; i < addStudents.length; i++) {
            if (addStudents[i] != null) {
                System.out.println(i + ". " + addStudents[i]);
            }
        }
        System.out.println("enter any input to continue...");
        an.next();
        an.nextLine();
    }
}