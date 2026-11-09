import rw.ac.auca.university.lecturer.Lecturer;
import rw.ac.auca.university.student.Student;

public class Main {
    public static void main(String[] args) {
        System.out.printf("Hello and welcome!");


        Student student = new Student();
        Lecturer lecturer = new Lecturer();

        student.studentDetails();
        lecturer.lecturerDetails();
    }
}