package commentarius;

public class StudentList {
    private String surname;
    private String name;
    private String patronymic;
    private int age;
    private String course;
    //freshman, sophomore, junior, senior, dropout.
    private int grant; // стипендия

    void setAll(String surname, String name, String patronymic, int age, String course, int grant) {
        setSurname(surname);
        setName(name);
        setPatronymic(patronymic);
        setAge(age);
        setCourse(course);
        setGrant(grant);
    }

    String getStudInfo() {
        return surname + " " + name + " " + patronymic + " " + age + " " + course + " " + grant + " " + "KZT";
    }

    private void setSurname(String surname) {
        this.surname = surname;
    }

    private void setName(String name) {
        this.name = name;
    }

    private void setPatronymic(String patronymic) {
        this.patronymic = patronymic;
    }

    private void setAge(int age) {
        this.age = age;
    }

    private void setCourse(String course) {
        this.course = course;
    }

    private void setGrant(int grant) {
        this.grant = grant;
    }
}
