public class EmployeeBook {
    private final Employee[] employees = new Employee[10];

    public boolean addEmployee(Employee employee) {
        for (int i = 0; i < employees.length; i++) {
            if (employees[i] == null) {
                employees[i] = employee;
                return true;
            }
        }
        return false;
    }

    public void listAllEmployees() {
        for (Employee e : employees) {
            if (e != null) {
                System.out.println(e);
            }
        }
    }

    public double getAverageSalary() {
        int count = 0;
        int sum = 0;
        for (Employee e : employees) {
            if (e == null) break;
            sum += e.getSalary();
            count++;
        }
        return count == 0 ? 0 : (double) sum / count;
    }

    public void printTax(String type) {
        if (type == null) {
            type = "PROPORTIONAL";
        }
        final String t = type;

        for (Employee e : employees) {
            if (e == null) continue;
            double tax;
            switch (t) {
                case "PROGRESSIVE":
                    int s = e.getSalary();
                    if (s <= 150) tax = s * 0.13;
                    else if (s <= 350) tax = s * 0.17;
                    else tax = s * 0.21;
                    break;
                case "PROPORTIONAL":
                default:
                    tax = e.getSalary() * 0.13;
                    break;
            }
            System.out.println(e.getFirstName() + " " + e.getName() + " " + e.getSecondName() + " налог = " + (float) tax);
        }
    }

    public void indexSalary(int department, int percent) {
        for (Employee e : employees) {
            if (e == null) {
                continue;
            }
            if (percent == 0) {
                continue;
            }
            if (e.getDepartment() != department) {
                continue;
            }
            int current = e.getSalary();
            int change = (current * percent) / 100;
            e.setSalary(current + change);
        }
    }

    public void findFirstEmployee(int department, int minSalary) {
        for (int i = 0; i < employees.length; i++) {
            Employee e = employees[i];
            if (e != null && e.getDepartment() == department && e.getSalary() > minSalary) {
                System.out.print("Порядковый номер: " + (i + 1) + " — ");
                e.printShortInfo();
                break;
            }

        }
    }

    public void findWageLimit(int wage, int number) {
        int found = 0;
        int i = 0;
        while (i < employees.length) {
            if (found >= number) break;
            Employee e = employees[i];
            if (e != null && e.getSalary() < wage) {
                e.printShortInfo();
                found++;
            }
            i++;
        }
    }

    public boolean contains(Employee target) {
        for (Employee e : employees) {
            if (e != null && e.equals(target)) return true;
        }
        return false;
    }


    public Employee getById(int id) {
        for (Employee e : employees) {
            if (e != null && e.getId() == id) return e;
        }
        return null;
    }

}
