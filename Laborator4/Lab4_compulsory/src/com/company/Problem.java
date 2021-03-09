package com.company;

import java.util.*;

public class Problem {
    List<Student> studentList = new ArrayList<>();
    TreeSet<School> schoolList = new TreeSet<>();
    Map<Student, List<School>> studentdPrefMap = new HashMap<>();
    TreeMap<School, List<Student>> schoolPrefMap = new TreeMap<>();

    public void addStudent(Student o) {
        studentList.add(o);
    }

    public List<Student> getStudentList() {
        return studentList;
    }

    public void sortStudents() {
        Collections.sort(studentList,Comparator.comparing(Student::getName));
    }

    public TreeSet<School> getSchoolList() {
        return schoolList;
    }

    public void addSchool(School o) {
        schoolList.add(o);
    }

    public void addSchoolPrefForStudent(Student student, List listOfSchools) {
        studentdPrefMap.put(student, listOfSchools);
    }

    public void addStudentPrefForSchool(School school, List listOfStudents) {
        schoolPrefMap.put(school, listOfStudents);
    }

    public Map<Student, List<School>> getStudentdPrefMap() {
        return studentdPrefMap;
    }

    public TreeMap<School, List<Student>> getSchoolPrefMap() {
        return schoolPrefMap;
    }
}
