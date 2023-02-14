
import java.text.DecimalFormat;
import java.util.Scanner;

public class App {

    public static void main(String[] args) throws Exception {
        Scanner scanner = new Scanner(System.in);
        String surname = "";
        int numberOfDaysWorked = 0;
        int numberOfMinutesLate = 0;

        System.out.print("Enter a Surname: ");
        surname = scanner.nextLine();
        System.out.print("Enter the number of days worked: ");
        numberOfDaysWorked = scanner.nextInt();
         System.out.print("Enter the number of minutes late: ");
        numberOfMinutesLate = scanner.nextInt();
        System.out.println(getNetAndGrossSalary(surname, numberOfDaysWorked,numberOfMinutesLate));
        scanner.close();
    }

    public static String getNetAndGrossSalary(String surname, int numberOfDaysWorked, int numberOfMinutesLate) {
        TextFileParser textFileParser = new TextFileParser("res/data.txt");
        double netSalary = 0, grossSalary = 0, dailyRate = 0, sss=0, pagibig = 0;
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
        

        DecimalFormat dFormat = new DecimalFormat("#,##0.00");

        return String.format("\nName: %s\nAddress: %s\nId: %s\nPosition: %s\nOffice: %s \nGross Salary: Php %s\nRate: Php %s\nSSS: Php %s\nPag-ibig: Php %s\nNet Salary: Php %s", fullName, address,id, position, office,  dFormat.format(grossSalary),dFormat.format(dailyRate), dFormat.format(sss), dFormat.format(pagibig),  dFormat.format(netSalary));
    }
}
