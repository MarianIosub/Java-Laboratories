
import com.github.javafaker.Faker;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Random;
import java.util.stream.IntStream;


public class Main {

    public static void main(String[] args) {
        Faker faker = new Faker();
        Random random = new Random();
        Student[] students = IntStream.rangeClosed(0, 40)
                .mapToObj(i -> new Student(faker.name().fullName()))
                .toArray(Student[]::new);
        School[] schools = IntStream.rangeClosed(0, 10)
                .mapToObj(i -> new School(faker.university().name()))
                .toArray(School[]::new);
        Problem problem = new Problem();
        for (Student student : students) {
            problem.addStudent(student);
        }
        for (School school : schools) {
            school.setCapacity(random.nextInt(5) % 5 + 2);
            problem.addSchool(school);
        }
        for (Student student : students) {
            List<School> listOfSchool = new ArrayList<>();
            for (School school : schools) {
                if (random.nextInt(3) % 3 == 0) {
                    listOfSchool.add(school);
                }

            }
            problem.addSchoolPrefForStudent(student, listOfSchool);
        }
        for (School school : schools) {
            List<Student> listOfStudents = new ArrayList<>();
            for (Student student : students) {
                if (random.nextInt(3) % 3 == 0) {
                    listOfStudents.add(student);
                }

            }
            problem.addStudentPrefForSchool(school, listOfStudents);
        }
        problem.sortStudents();
        problem.studentsBySchools(Arrays.asList(schools[4], schools[2]));
        problem.studentTopPreference(students[4]);
        Solution solution = new Solution(problem);
        solution.generateSolution();
    }
}
