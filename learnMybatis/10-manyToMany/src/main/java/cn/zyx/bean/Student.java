package cn.zyx.bean;

import java.util.List;

public class Student {
    private int id;
    private String name;
    private int age;
    private double score;
    private List<Course> courses;

    @Override
    public String toString() {
        return "Student{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", age=" + age +
                ", score=" + score +
                ", courses=" + courses +
                '}';
    }

    public Student() {
    }

    public Student(int id, String name, int age, double score, List<Course> courses) {
        this.id = id;
        this.name = name;
        this.age = age;
        this.score = score;
        this.courses = courses;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public double getScore() {
        return score;
    }

    public void setScore(double score) {
        this.score = score;
    }

    public List<Course> getCourses() {
        return courses;
    }

    public void setCourses(List<Course> courses) {
        this.courses = courses;
    }
}
