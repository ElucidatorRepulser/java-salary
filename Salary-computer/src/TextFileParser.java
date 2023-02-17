
import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

public class TextFileParser {

    private File file;
    private ArrayList<Employee> employees;

    public TextFileParser(String fileName) {
        file = new File(fileName);
        try (Scanner scanner = new Scanner(file)) {

            // remove the first line from the file
            scanner.nextLine();

            // read all the employees
            employees = new ArrayList<>();
            while (scanner.hasNextLine()) {
                String[] line = scanner.nextLine().split(",");
                employees.add(new Employee(
                        line[0],
                        line[1],
                        line[2],
                        line[3],
                        line[4],
                        Integer.valueOf(line[5]),
                        Integer.valueOf(line[6]),
                        Integer.valueOf(line[7]),
                        Integer.valueOf(line[8]),
                        Integer.valueOf(line[9]),
                        Integer.valueOf(line[10]),
                        Double.valueOf(line[11])
                ));
            }
        } catch (FileNotFoundException e) {
            System.out.println("File not found: " + file.toString());
        }
    }

    public Employee getEmployee(String surname) {
        for (Employee employee : employees) {
            if (employee.getSurname().equals(surname)) {
                return employee;
            }
        }
        throw new IllegalArgumentException("Employee not found: " + surname);
    }

}
