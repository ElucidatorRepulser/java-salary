
import java.text.DecimalFormat;
import java.util.Scanner;

public class App {

    public static void main(String[] args) throws Exception {
        int attempts = 0;
        final int MAX_ATTEMPTS = 3; // maximum number of attempts
        String username = "Admin";
        String password = "admin";

        Scanner scanner = new Scanner(System.in);
        String surname = "";
        int numberOfDaysWorked = 0;
        int numberOfMinutesLate = 0;

        while (attempts < MAX_ATTEMPTS) {
            System.out.print("Username: ");
            String enteredUsername = scanner.nextLine();

            System.out.print("Password: ");
            String enteredPassword = scanner.nextLine();

            if (enteredUsername.equals(username) && enteredPassword.equals(password)) {
                System.out.println("Login successful!\n");
                break; // terminate loop if login successful
            } else {
                attempts++;
                System.out.println("Incorrect username or password. Please try again.\n");
            }

        }
        if (attempts == MAX_ATTEMPTS) {
            System.out.println("Maximum login attempts exceeded. Program terminated.");
            return;
        }
        String choice;

        do {
            // Display menu
            System.out.println("Select an option:");
            System.out.println("1. View User Info");
            System.out.println("2. Display All");
            System.out.println("3. Multiply");
            System.out.println("4. Divide");
            System.out.println("0. Exit");

            // Prompt user for choice
            System.out.print("Enter your choice: ");
            choice = scanner.nextLine();

            // Execute code based on choice
            switch (choice) {
                case "1":
                    System.out.println("View User");
                    System.out.print("Enter a Surname: ");
                    surname = scanner.nextLine();
                    System.out.print("Enter the number of days worked: ");
                    numberOfDaysWorked = scanner.nextInt();
                    System.out.print("Enter the number of minutes late: ");
                    numberOfMinutesLate = scanner.nextInt();
                    System.out.println(getNetAndGrossSalary(surname, numberOfDaysWorked, numberOfMinutesLate));
//                    scanner.close();
                    break;
                case "2":
                    System.out.println("Subtraction selected");
                    // Code to execute for subtraction
                    break;
                case "0":
                    System.out.println("Exiting program");
                    break;
                default:
                    System.out.println("Invalid choice");
            }

            System.out.println(); // Print blank line for spacing

        } while (!choice.equals("0"));

    }

    public static String getNetAndGrossSalary(String surname, int numberOfDaysWorked, int numberOfMinutesLate) {
        TextFileParser textFileParser = new TextFileParser("res/data.txt");
        double netSalary = 0, grossSalary = 0, dailyRate = 0, sss = 0, pagibig = 0;
        String fullName = "";
        String address = "";
        String position = "";
        String office = "";
        int id = 0;
        Employee employee = textFileParser.getEmployee(surname);
        grossSalary = employee.getGrossSalary(numberOfDaysWorked);
        netSalary = employee.getNetSalary(numberOfMinutesLate);
        fullName = employee.getFullName();
        address = employee.getAddress();
        position = employee.getPostion();
        office = employee.getOffice();
        id = employee.getId();
        dailyRate = employee.getRate();
        sss = employee.getSSS();
        pagibig = employee.getPagibig();
//        deductionRate = employee.getDeductionRate();     

        DecimalFormat dFormat = new DecimalFormat("#,##0.00");

        return String.format("\nName: %s\nAddress: %s"
                + "\nId: %s\nPosition: %s; Office: %s \nGross Salary: Php %s; Rate per day: Php %s"
                + "\nSSS: Php %s; Pag-ibig: Php %s"
                + "\nNet Salary: Php %s", fullName, address, id, position, office, dFormat.format(grossSalary), dFormat.format(dailyRate), dFormat.format(sss), dFormat.format(pagibig), dFormat.format(netSalary));
    }
}
