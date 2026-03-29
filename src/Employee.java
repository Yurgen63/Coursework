import java.util.Objects;

public class Employee {
    private final String firstName;
    private final String name;
    private final String secondName;
    private int department;
    private int salary;

    private int id;
    private static int counter = 1;

    public Employee(String firstName, String name, String secondName, int department, int salary) {
        this.id = counter++;
        this.firstName = firstName;
        this.name = name;
        this.secondName = secondName;
        this.department = department;
        this.salary = salary;
    }

    public int getId() {
        return id;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getName() {
        return name;
    }

    public String getSecondName() {
        return secondName;
    }

    public int getDepartment() {
        return department;
    }

    public int getSalary() {
        return salary;
    }

    public void setDepartment(int department) {
        this.department = department;
    }

    public void setSalary(int salary) {
        this.salary = salary;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Employee other = (Employee) o;
        return this.salary == other.salary;
    }

    @Override
    public int hashCode() {
        return Objects.hash(firstName, name, secondName, department, salary);
    }

    @Override
    public String toString() {
        return id + ", Фамилия - " + this.firstName + ", Имя - " + this.name + ", Отчество - " + this.secondName + ", Отдел № " + this.department + ", Зарплата - " + this.salary;
    }

    public void printShortInfo() {
        System.out.println(" Фамилия - " + this.firstName + ", Имя - " + this.name + ", Отчество - " + this.secondName + ", Зарплата " + this.salary);

    }

}
