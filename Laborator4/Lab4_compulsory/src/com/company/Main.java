package com.company;


import java.util.Arrays;
import java.util.stream.IntStream;

public class Main {

    public static void main(String[] args) {
        Student[] students = IntStream.rangeClosed(0, 3)
                .mapToObj(i -> new Student("S" + i))
                .toArray(Student[]::new);
        School[] schools = IntStream.rangeClosed(0, 2)
                .mapToObj(i -> new School("H" + i))
                .toArray(School[]::new);
        Problem problem = new Problem();
        for (Student student : students)
            problem.addStudent(student);
        for (School school : schools)
            problem.addSchool(school);
        problem.addSchoolPrefForStudent(students[0], Arrays.asList(schools[0], schools[1], schools[2]));
        problem.addSchoolPrefForStudent(students[1], Arrays.asList(schools[0], schools[1], schools[2]));
        problem.addSchoolPrefForStudent(students[2], Arrays.asList(schools[0], schools[1]));
        problem.addSchoolPrefForStudent(students[3], Arrays.asList(schools[0], schools[2]));
        problem.addStudentPrefForSchool(schools[0], Arrays.asList(students[3], students[0], students[1], students[2]));
        problem.addStudentPrefForSchool(schools[1], Arrays.asList(students[0], students[2], students[1]));
        problem.addStudentPrefForSchool(schools[2], Arrays.asList(students[0], students[1], students[3]));
        problem.sortStudents();
        System.out.println(problem.getSchoolPrefMap());
        System.out.println(problem.getStudentdPrefMap());
    }
}
