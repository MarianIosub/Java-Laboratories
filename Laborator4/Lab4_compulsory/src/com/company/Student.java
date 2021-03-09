package com.company;

public class Student implements Comparable<Student> {
    private String name;

    Student(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    @Override
    public String toString() {
        return "Student{" +
                "name='" + name + '\'' +
                '}';
    }

    @Override
    public int compareTo(Student o) {
        if (o.getName() != null && this.getName() != null)
            return this.getName().compareTo(o.getName());
        return 0;
    }
}
