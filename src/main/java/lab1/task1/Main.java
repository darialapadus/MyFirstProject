package lab1.task1;

import lab1.task2.Course;
import lab1.task2.Student;
import lab1.task2.StudentAllocator;
import lab1.task4.DummyCalculator;

public class Main {
    public static void main(String[] args) {
        Student[] students = StudentAllocator.createStudents();

        Course course = new Course("PAO", 5.0, students);

        System.out.println("Toti studentii:");
        for (Student student : students) {
            System.out.println(student.getName() + " - " + student.getGrade());
        }

        System.out.println("Studentul ales aleatoriu:");
        Student randomStudent = course.chooseStudentRandomly();
        System.out.println(randomStudent.getName() + " - " + randomStudent.getGrade());

        System.out.println("Studentii promovați:");
        Student[] passingStudents = course.showAllPassingStudents();
        for (Student student : passingStudents) {
            System.out.println(student.getName() + " - " + student.getGrade());
        }

        System.out.println("Este Daria promovata? " + course.isStudentPassing(0));
        System.out.println("Este Ada promovata? " + course.isStudentPassing(students[1]));

        DummyCalculator calculator = new DummyCalculator();
        calculator.calculate();
    }
}
