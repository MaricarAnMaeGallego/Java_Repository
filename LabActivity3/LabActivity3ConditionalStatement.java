import java.util.Scanner;

public class LabActivity3ConditionalStatement {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Getting the Employee's Information
        System.out.print("Enter your first name: ");
        String firstName = scanner.nextLine();

        System.out.print("Enter your last name: ");
        String lastName = scanner.nextLine();

        System.out.print("Enter your age: ");
        int age = scanner.nextInt();

        System.out.print("Enter hours worked per day: ");
        float hoursWorked = scanner.nextFloat();

        System.out.print("Enter hourly wage: ");
        float hourlyWage = scanner.nextFloat();

        System.out.print("Enter role code (1-Manager, 2-Supervisor, 3-Staff, 4-Intern): ");
        int roleCode = scanner.nextInt();

        // Years to retirement
        int yearsToRetirement = Math.abs(65 - age);

        // Age validity
        if (age < 18) {
            System.out.println("Minors are not allowed");
            return;
        } else if (age >= 65) {
            System.out.println("Senior Citizens are not allowed");
            return;
        }

        // Validate work hours
        if (hoursWorked > 24) {
            System.out.println("Number of hours worked cannot exceed 24 hours");
            return;
        } else if (hoursWorked <= 0) {
            System.out.println("Wrong input on daily work hours");
            return;
        }

        String role;
        switch (roleCode) {
            case 1: role = "Manager"; break;
            case 2: role = "Supervisor"; break;
            case 3: role = "Staff"; break;
            case 4: role = "Intern"; break;
            default: role = "Undefined"; break;
        }

        // Salary calculations
        double dailySalary = Math.round(hoursWorked * hourlyWage * 100.0) / 100.0;
        double weeklySalary = dailySalary * 5;
        double monthlySalary = weeklySalary * 4;
        double grossYearlySalary = monthlySalary * 12;

        // Tax and benefits deduction
        double netYearlySalary;
        if (grossYearlySalary > 250000) {
            netYearlySalary = grossYearlySalary - (grossYearlySalary * 0.32) - 1500;
        } else {
            netYearlySalary = grossYearlySalary - 1500;
        }

        // Output the information
        System.out.println("\nEmployee Information");
        System.out.println("--------------------");
        System.out.println("Full Name:                        " + lastName.toUpperCase() + ", " + firstName.toUpperCase());
        System.out.println("Age:                              " + age + " years old");
        System.out.println("Position:                         " + role);
        System.out.println("Years to Retirement:              " + yearsToRetirement + " years");
        System.out.printf("Daily Salary:                     Php %.2f%n", dailySalary);
        System.out.printf("Weekly Salary:                    Php %.2f%n", weeklySalary);
        System.out.printf("Monthly Salary:                   Php %.2f%n", monthlySalary);
        System.out.printf("Gross Yearly Salary:              Php %.2f%n", grossYearlySalary);
        System.out.printf("Net Yearly Salary:                Php %.2f%n", netYearlySalary);

        scanner. close();
    }
}