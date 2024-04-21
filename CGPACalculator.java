import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class CGPACalculator {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Welcome to CGPA Calculator!");

        System.out.print("Enter the number of subjects: ");
        int numSubjects = scanner.nextInt();

        double totalCredits = 0.0;
        double totalGradePoints = 0.0;

        // Mapping of grades to grade points
        Map<String, Double> gradePoints = new HashMap<>();
        gradePoints.put("A", 10.0);
        gradePoints.put("B", 9.0);
        gradePoints.put("C", 8.0);
        gradePoints.put("D", 7.0);
        gradePoints.put("E", 6.0);
        gradePoints.put("F", 5.0);

        for (int i = 1; i <= numSubjects; i++) {
            System.out.println("\nEnter details for Subject " + i + ":");
            System.out.print("Enter the credits for Subject " + i + ": ");
            int credits = scanner.nextInt();
            totalCredits += credits;

            System.out.print("Enter the grade obtained (A, B, C, D, E, F): ");
            String grade = scanner.next().toUpperCase();

            // Check if the entered grade is valid
            if (!gradePoints.containsKey(grade)) {
                System.out.println("Invalid grade entered. Please enter a valid grade (A, B, C, D, E, F).");
                return;
            }

            totalGradePoints += (gradePoints.get(grade) * credits);
        }

        double cgpa = totalGradePoints / totalCredits;
        System.out.printf("\nYour CGPA is: %.2f\n", cgpa);

        scanner.close();
    }
}
