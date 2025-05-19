import java.util.Scanner;

class Ticket {
    String description;
    String urgency;
    String status;

    Ticket(String description, String urgency) {
        this.description = description;
        this.urgency = urgency;
        this.status = "Pending";
    }
}

public class MyMidtermLabExam {
    static final int MAX_TICKETS = 5;
    static Ticket[] tickets = new Ticket[MAX_TICKETS];
    static int count = 0;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        boolean running = true;

        while (running) {
            // Show the main menu
            System.out.println("\n=== IT Ticket System ===");
            System.out.println("1. Add Ticket");
            System.out.println("2. Update Ticket Status");
            System.out.println("3. Show All Tickets");
            System.out.println("4. Generate Report");
            System.out.println("5. Exit");
            System.out.print("Enter your choice: ");
            String choice = scanner.nextLine();

            switch (choice) {
                case "1":
                    addTicket(scanner);
                    break;
                case "2":
                    updateTicketStatus(scanner);
                    break;
                case "3":
                    showTickets();
                    break;
                case "4":
                    generateReport();
                    break;
                case "5":
                    System.out.println("Thank you for using the system. Goodbye!");
                    running = false;
                    break;
                default:
                    System.out.println("Invalid option. Please enter 1 to 5.");
            }
        }

        scanner.close();
    }

    // Adding ticket
    public static void addTicket(Scanner scanner) {
        if (count >= MAX_TICKETS) {
            System.out.println("Maximum number of ticket reached.");
            return;
        }

        System.out.print("Enter issue description: ");
        String desc = scanner.nextLine();

        System.out.print("Enter urgency (Low / Medium / High): ");
        String urgency = scanner.nextLine();

        Ticket newTicket = new Ticket(desc, urgency);
        tickets[count] = newTicket;
        count++;

        System.out.println("Ticket successfully added!");
    }

    // Update ticket status
    public static void updateTicketStatus(Scanner scanner) {
        if (count == 0) {
            System.out.println("No tickets to update.");
            return;
        }

        showTickets();
        System.out.print("Enter ticket number to update (1 to " + count + "): ");
        int ticketNum = Integer.parseInt(scanner.nextLine()) - 1;

        if (ticketNum < 0 || ticketNum >= count) {
            System.out.println("Invalid ticket number.");
            return;
        }

        if (tickets[ticketNum].status.equals("Resolved")) {
            System.out.println("This ticket is already resolved.");
            return;
        }

        System.out.print("Enter new status (In Progress / Resolved): ");
        String newStatus = scanner.nextLine();

        if (newStatus.equals("In Progress") || newStatus.equals("Resolved")) {
            tickets[ticketNum].status = newStatus;
            System.out.println("Ticket status updated.");
        } else {
            System.out.println("Invalid status. Use 'In Progress' or 'Resolved'.");
        }
    }

    // Show all tickets
    public static void showTickets() {
        if (count == 0) {
            System.out.println("No tickets to show.");
            return;
        }

        System.out.println("\n--- All Tickets ---");
        for (int i = 0; i < count; i++) {
            Ticket t = tickets[i];
            System.out.println((i + 1)+ "."  + "[" + t.urgency + "]"+ " " + t.description + "-" + "Status:" + t.status);
            System.out.println();
        }
    }

    // Generate report
    public static void generateReport() {
        int resolved = 0;
        int pendingOrInProgress = 0;

        for (int i = 0; i < count; i++) {
            if (tickets[i].status.equals("Resolved")) {
                resolved++;
            } else {
                pendingOrInProgress++;
            }
        }

        System.out.println("\n--- Ticket Report ---");
        System.out.println("Total tickets: " + count);
        System.out.println("Pending/In Progress: " + pendingOrInProgress);
        System.out.println("Resolved: " + resolved);
    }
}
