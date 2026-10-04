package exercise1_4;

public class Employee {
    private int id;
    private String firstName;
    private String lastName;
    private int salary;


    public Employee() {
        id = 0;
        firstName = "unknown";
        lastName = "unknown";
        salary = 0;
    }
    //another way you can use "this"
//    public Employee(int id){
//        this.id=id;
//    }
    public Employee(int id, String firstName, String lastName, int salary) {
        // this(id);   this is when we are using other way of "this"
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
        this.salary = salary;
    }

    public int getId() {
        return id;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public String getname() {
        return firstName + " " + lastName;
    }

    public int getSalary() {
        return salary;
    }

    public void setSalary(int salary) {
        this.salary = salary;
    }

    public int getAnnualSalary() {
        return salary * 12;
    }

    public int raiseSalary(int percent) {
        salary = salary + (salary * percent / 100);
        return salary;
    }

    public String toString() {
        return ("Employee: \n\tid=" + id + "\n\tname=" + getname() + "\n\tsalary=" + salary);
    }
}

class test {
    public static void main(String[] args) {
        Employee axmed = new Employee(1, "Axmed", "Cali", 500);
        System.out.println(axmed);
        System.out.println("Annual salary: " + axmed.getAnnualSalary());
        System.out.println("New salary after 10% raise: " + axmed.raiseSalary(10));
        System.out.println(axmed.getSalary());


    }
}





