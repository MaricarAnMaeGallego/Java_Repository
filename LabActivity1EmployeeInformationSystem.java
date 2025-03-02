import java.util.Scanner;

public class LabActivity1EmployeeInformationSystem {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Getting the user's information 
        System.out.print("Enter your first name: ");
        String firstName = scanner.nextLine();
        System.out.print("Enter your last name: ");
        String lastName = scanner.nextLine();
        System.out.print("Enter your age: ");
        int age = scanner.nextInt();
        System.out.print("Enter hours worked: ");
        float hoursWorked = scanner.nextFloat();
        System.out.print("Enter hourly wage: ");
        float hourlyWage = scanner.nextFLoat();

        // Using the operation, hoursWorked and hourlyWage to compute the daily salary
        float dailySalary = hoursWorked * hourlyWage;

        // Output the Employee's Information
        System.out.println("\nEmployee Information");
        System.out.println("--------------------");
        System.out.println("Full Name    : " + firstName + " " + lastName);
        System.out.println("Age          : " + age + " years old");
        System.out.printf("Daily Salary : PHP %.2f%n", dailySalary);

        scanner.close();
    }
}
