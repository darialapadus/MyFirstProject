package lab4.task3;

import java.util.HashMap;
import java.util.Map;

public class Student implements Cloneable {
    private String fullName;
    private Map<String, Double> courseInformation;

    public Student(String fullName) {
        this.fullName = fullName;
        this.courseInformation = new HashMap<>();
    }

    private Student(Student original) {
        this.fullName = original.fullName;
        this.courseInformation = new HashMap<>(original.courseInformation);
    }

    public void addCourseGrade(String course, double grade) {
        courseInformation.put(course, grade);
    }

    @Override
    public Student clone() {
        return new Student(this);
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("Student: ").append(fullName).append("\n");
        sb.append("Course Information:\n");
        for (Map.Entry<String, Double> entry : courseInformation.entrySet()) {
            sb.append("- ").append(entry.getKey()).append("-> ").append(entry.getValue()).append("\n");
        }
        return sb.toString();
    }
}
