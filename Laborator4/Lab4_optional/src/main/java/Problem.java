

import java.util.*;

public class Problem {
    List<Student> studentList = new ArrayList<>();
    Set<School> schoolList = new TreeSet<>();
    Map<Student, List<School>> studentPrefMap = new HashMap<>();
    Map<School, List<Student>> schoolPrefMap = new TreeMap<>();

    private final Random random = new Random();

    public void addStudent(Student o) {
        studentList.add(o);
    }

    public List<Student> getStudentList() {
        return studentList;
    }

    public void sortStudents() {
        studentList.sort(Comparator.comparing(Student::getName));
    }

    public Set<School> getSchoolList() {
        return schoolList;
    }

    public void addSchool(School o) {
        schoolList.add(o);
    }

    public void addSchoolPrefForStudent(Student student, List listOfSchools) {
        studentPrefMap.put(student, listOfSchools);
    }

    public void addStudentPrefForSchool(School school, List listOfStudents) {
        schoolPrefMap.put(school, listOfStudents);
    }

    public void studentsBySchools(List<School> listOfSchools) {
        System.out.println("The list of schools:  " + listOfSchools + " is find acceptable by: ");
        studentList.stream()
                .filter(std -> studentPrefMap.get(std).containsAll(listOfSchools))
                .forEach(System.out::println);
        System.out.println();
    }

    public void studentTopPreference(Student student) {
        System.out.println("The list of schools which have the student: " + student.getName() + " as their top preference is: ");
        schoolList.stream()
                .filter(std -> schoolPrefMap.get(std).indexOf(student) == 0)
                .forEach(System.out::println);
        System.out.println();
    }

    public void setScores() {
        for (Student student : studentList) {
            student.setScore((random.nextDouble() % 10 + 10) % 10 * 10);
        }
    }

    public void getScores() {
        System.out.println("The scores of students are:\n");
        for (Student student : studentList) {
            System.out.println(student.getName() + " --> " + student.getScore());
        }
        System.out.println("\n");
    }

    public void printSchoolCapacity() {
        System.out.println("The capacities of your schools are:\n");
        for (School school : schoolList) {
            System.out.println(school.getName() + " --> " + school.getCapacity());
        }
        System.out.println("\n");
    }

    public Map<Student, List<School>> getStudentdPrefMap() {
        return studentPrefMap;
    }

    public Map<School, List<Student>> getSchoolPrefMap() {
        return schoolPrefMap;
    }
}
