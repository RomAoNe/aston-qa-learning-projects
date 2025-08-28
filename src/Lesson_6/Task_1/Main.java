package Lesson_6.Task_1;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Queue;
import java.util.Set;


public class Main {
    public static void main(String[] args) {
        int minPassingGrade = 3;
        int course = 3;
        List<Student> students = generateStudents();

        for (Student student : students) {
            promoteStudent(student, minPassingGrade);
        }

        removeFailingStudents(students, minPassingGrade);

        printStudents(new HashSet<>(students), course);
    }

    public static void printStudents(Set<Student> students, int course) {
        boolean isFound = false;

        System.out.println("Students of " + course + " course:");

        for (Student student : students) {
            if (student.getCourse() == course) {
                System.out.println(student.getName());
                isFound = true;
            }
        }

        if (isFound == false) {
            System.out.println("No students found on course.");
        }
    }

    public static void promoteStudent(Student student, int minPassingGrade) {
        if (student.getAverageGrade() >= minPassingGrade) {
            student.setCourse(student.getCourse() + 1);

            System.out.println(student.getName() + " has been promoted to " + student.getCourse() + " course");
        }
    }

    public static void removeFailingStudents(List<Student> students, int minPassingGrade) {
        for (int i = students.size() - 1; i >= 0; i--) {
            Student student = students.get(i);
            if (student.getAverageGrade() < minPassingGrade) {
                System.out.println(student.getName() + " has been expelled (average grade: " + student.getAverageGrade() + ")");
                students.remove(i);
            }
        }
    }

    public static int generateGrade() {
        int minGrade = 1;
        int maxGrade = 5;

        return (int) (Math.random() * (maxGrade - minGrade + 1)) + minGrade;
    }

    public static Map<String, Integer> createGrades() {

        Map<String, Integer> grades = new HashMap<>();
        grades.put("Math", generateGrade());
        grades.put("Science", generateGrade());
        grades.put("English", generateGrade());
        grades.put("History", generateGrade());
        grades.put("Art", generateGrade());
        grades.put("Music", generateGrade());
        grades.put("Geography", generateGrade());
        grades.put("Physical Education", generateGrade());
        return grades;
    }

    public static List<Student> generateStudents() {
        Queue<String> names = new ArrayDeque<>();
        List<Student> students = new ArrayList<>();

        Collections.addAll(names, "James", "Mary", "John", "Patricia", "Robert",
                "Jennifer", "Michael", "Linda", "William", "Elizabeth",
                "David", "Barbara", "Richard", "Susan", "Joseph",
                "Jessica", "Thomas", "Sarah", "Charles", "Karen");

        while (names.isEmpty() == false) {
            students.add(new Student(names.poll(), createGrades()));
        }

        return students;
    }
}