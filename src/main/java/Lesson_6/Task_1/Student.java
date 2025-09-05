package Lesson_6.Task_1;

import java.util.Map;

public class Student {
    private final String name;
    private final int group;
    private final Map<String, Integer> grades;
    private int course;

    public Student(String name, Map<String, Integer> grades) {
        this.name = name;
        this.grades = grades;
        this.group = generateGroup();
        this.course = generateCourse();
    }

    public int getCourse() {
        return course;
    }

    public String getName(){
        return name;
    }

    public void setCourse(int course) {
        this.course = course;
    }

    public double getAverageGrade() {
        int sum = 0;

        for (int grade : grades.values()) {
            sum += grade;
        }

        return (double) sum / grades.size();
    }

    private int generateCourse() {
        int minValue = 1;
        int maxValue = 5;

        return (int) (Math.random() * (maxValue - minValue + 1)) + minValue;
    }

    private int generateGroup() {
        int minValue = 1;
        int maxValue = 3;

        return (int) (Math.random() * (maxValue - minValue + 1)) + minValue;
    }
}