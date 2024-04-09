package lab6.task1;

import java.util.*;

public class Main {
    public static void sortByTotalNota(List<Student> studentList) {
        Collections.sort(studentList, Comparator.comparingDouble(Student::getTotalNota).reversed());
        System.out.println("Sortare dupa cea mai mare nota totala");
        printStudentList(studentList);
    }

    public static void sortByNotaPartial(List<Student> studentList) {
        Collections.sort(studentList, Comparator.comparingDouble(Student::getNotaPartial).reversed());
        System.out.println("Sortare dupa cea mai mare nota la partial");
        printStudentList(studentList);
    }


    public static void sortByMedieNota(List<Student> studentList) {
        Collections.sort(studentList, Comparator.comparingDouble(Student::getMedieNota).reversed());
        System.out.println("Sortare dupa media notelor");
        printStudentList(studentList);
    }

    public static void printStudentList(List<Student> studentList) {
        int position = 1;
        for (Student student : studentList) {
            System.out.println(position + ". " + student);
            position++;
        }
    }

    public static void main(String[] args) {
        List<Student> students = new ArrayList<>();
        students.add(new Student("Aurel Vlaicu", 5.3, 7.8, 9.0));
        students.add(new Student("Liviu Teodorescu", 7.7, 5.2, 9.0));

        sortByTotalNota(students);
        sortByNotaPartial(students);
        sortByMedieNota(students);
    }
}
