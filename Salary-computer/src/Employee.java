
public class Employee {

    private String firstName, surname, address, postion, office;
    private int age, monthlyRate, sss, pagibig, id;
    private double grossSalary, netSalary,dailyRate, deductionRate;

    public Employee(String firstName, String surname, String address, String position, String office, int age, int monthlyRate, int sss, int pagibig, int id, double dailyRate, double deductionRate) {
        this.firstName = firstName;
        this.surname = surname;
        this.age = age;
        this.address = address;
        this.postion = position;
        this.office = office;
        this.monthlyRate = monthlyRate;
        this.sss = sss;
        this.pagibig = pagibig;
        this.id = id;
        this.dailyRate = dailyRate;   
        this.deductionRate = deductionRate;
    }

    public String getFirstname() {
        return firstName;
    }

    public String getSurname() {
        return surname;
    }

    public String getFullName() {
        return firstName + " " + surname;
    }

    public int getAge() {
        return age;
    }
    
    public int getId() {
        return id;
    }

    public String getAddress() {
        return address;
    }

    public String getPostion() {
        return postion;
    }

    public String getOffice() {
        return office;
    }
    
    public double getRate(){
        return dailyRate;
    }
    public double getPagibig(){
        return pagibig;
    }
    public double getSSS(){
        return sss;
    }
    
    public double getDeductionRate(){
        return deductionRate;
    } 
    

    public double getGrossSalary(int numberOfDaysWorked) {

        // Assuming that there are 24 days of work normally
        this.grossSalary = (monthlyRate / 24d * numberOfDaysWorked) ;

        return this.grossSalary;
    }

    public double getNetSalary(int numberOfMinutesLate) {
        this.netSalary = grossSalary - (sss + pagibig) - (numberOfMinutesLate * deductionRate);
        return netSalary;
    }
}
