package commentarius;

//Программа создает студента, который будет прописывать ФИО, Курс обучения, Возраст, стипендия.
//записать 5 студентов чтоб можно было взять данные и вписать новых студентов
//$1oжNbiй 90RОлb НЕ УДАЛЯТЬ!!!!!!!!!!!
import java.util.HashMap;
import java.util.Scanner;

public class Main {
    public static void main() {
        String[] savedStudents = new String[30];
        Scanner an = new Scanner(System.in);
        HashMap<String, String> listTeachers = new HashMap<>();
        HashMap<String, String> listStudents = new HashMap<>();
        listTeachers.put("Jiger", "650fdb092abae2c2666fe2642d66a066a09ff0686c4939907519f64d79805cd8");
        System.out.println("""
        enter your position
        1. teacher
        2. student""");
        switch (an.nextInt()) {
            case 1:
                Teacher teacher = new Teacher(savedStudents, listTeachers);
                while (true){
                    System.out.println("""
                    What you gonna do?
                    1. Add new student (maximum 29)
                    2. Get student info
                    3. edit student
                    4. list of all students
                    5. my account
                    6. exit""");
                    teacher.completingTeacherProgram(an.nextByte());
                }
            case 2:
                Student student = new Student(savedStudents, listStudents);
                while (true){
                    System.out.println("""
                    What you gonna do?
                    1. my account
                    2. exit""");
                    student.completingStudentProgram(an.nextByte());
                }
            default:
                System.out.println("invalid choice");
        }
    }
}