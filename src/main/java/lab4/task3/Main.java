package lab4.task3;

public class Main {
    public static void main(String[] args) {
        Student student1 = new Student("Daria Lapadus");
        student1.addCourseGrade("Math", 9.5);
        student1.addCourseGrade("Physics", 8.0);

        Student student2 = student1.clone();

        System.out.println("Student 1:");
        System.out.println(student1);
        System.out.println("Student 2 (clone of Student 1):");
        System.out.println(student2);

        student2.addCourseGrade("Chemistry", 7.5);

        System.out.println("Student 1 (after modification in clone):");
        System.out.println(student1);
        System.out.println("Student 2 (after modification in clone):");
        System.out.println(student2);
    }
}
