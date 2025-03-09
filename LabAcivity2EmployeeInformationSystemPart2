import java.util.Scanner;

public class LabAcivity2EmployeeInformationSystemPart2 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Getting the Employee's Information
        System.out.print("Enter your first name: ");
        String firstName = scanner.nextLine();
        System.out.print("Enter your last name: ");
        String lastName = scanner.nextLine();
        System.out.print("Enter your age: ");
        int age = scanner.nextInt();
        System.out.print("Enter hours worked: ");
        float hoursWorked = scanner.nextFloat();
        System.out.print("Enter hourly wage: ");
        float hourlyWage = scanner.nextFloat();

        // Computing the details of the User or Employee
        String fullName = (lastName + ", " + firstName).toUpperCase();
        int yearsToRetirement = Math.abs(65 - age);
        double dailyWage = Math.round(hoursWorked * hourlyWage * 100.0) / 100.0;
        double weeklyWage = dailyWage * 5;
        double monthlyWage = weeklyWage * 4;
        double grossYearlyWage = monthlyWage * 12;
        double netYearlyWage = grossYearlyWage - (grossYearlyWage * 0.32) - 1500;

        // Display results
        System.out.println("\nEmployee Information");
        System.out.println("----------------------------");
        System.out.println("Full Name:               " + fullName);
        System.out.println("Age:                     " + age + " years old");
        System.out.println("Years to Retirement:     " + yearsToRetirement + " years");
        System.out.printf("Daily Salary:              Php %.2f%n", dailyWage);
        System.out.printf("Weekly Salary:             Php %.2f%n", weeklyWage);
        System.out.printf("Monthly Salary:            Php %.2f%n", monthlyWage);
        System.out.printf("Gross Yearly Salary:       Php %.2f%n", grossYearlyWage);
        System.out.printf("Net Yearly Salary:         Php %.2f%n", netYearlyWage);

        scanner.close();
    }
}
