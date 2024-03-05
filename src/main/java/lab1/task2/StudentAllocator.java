package lab1.task2;

public class StudentAllocator {
    public static Student[] createStudents() {
        Student[] students = new Student[5];

        students[0] = new Student("Daria", 4.5);
        students[1] = new Student("Ada", 7.9);
        students[2] = new Student("Maria", 3.3);
        students[3] = new Student("Patrisia", 9.2);
        students[4] = new Student("Stefi", 5.8);

        return students;
    }
}

