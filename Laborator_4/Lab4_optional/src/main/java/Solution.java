import java.util.Collections;
import java.util.Comparator;


public class Solution {
    protected Problem problem;

    Solution(Problem problem) {
        this.problem = problem;
    }

    public void generateSolution() {
        problem.setScores();
        problem.getStudentList().sort(Collections.reverseOrder(Comparator.comparing(Student::getScore)));
        System.out.println();
        problem.getScores();
        problem.printSchoolCapacity();
        System.out.println("The assignation of the students registered is: \n");
        for (Student student : problem.getStudentList()) {
            int ok = 0;
            for (School school : problem.getStudentdPrefMap().get(student)) {
                if (school.getCapacity() > 0) {
                    school.setCapacity(school.getCapacity() - 1);
                    ok = 1;
                    System.out.println("The student " + student.getName() + " is assigned at school: " + school.getName() + ".");
                    break;
                }

            }
            if (ok == 0) {
                System.out.println("The student " + student.getName() + " IS NOT ASSIGNED at any school.");
            }
        }
    }
}
