public class Main {
    public static void printSeparator() {
        System.out.println("***************");
    }

    public static void main(String[] args) {
        EmployeeBook book = new EmployeeBook();

        Employee[] staff = {
                new Employee("Пеганов", "Юрий", "Викторович", 1, 450),
                new Employee("Вершинин", "Илья", "Алексеевич", 2, 330),
                new Employee("Бойко", "Сергей", "Александрович", 3, 290),
                new Employee("Баннов", "Алексей", "Александрович", 4, 160),
                new Employee("Киселев", "Кирилл", "Дмитриевич", 5, 90),
                new Employee("Биткин", "Анатолий", "Александрович", 1, 390),
                new Employee("Белоусов", "Александр", "Александрович", 2, 280),
                new Employee("Петрунин", "Евгений", "Александрович", 3, 180),
                new Employee("Пазухин", "Михаил", "Константинович", 4, 190),
                new Employee("Чичкин", "Сергей", "Александрович", 5, 450),
                new Employee(" Нестеров", "Сергей", "Николаевич", 3, 420),
        };
        printSeparator();
        for (Employee e : staff) {
            boolean added = book.addEmployee(e);
            System.out.println("Добавление сотрудника - " + e.getFirstName() + " " + e.getName() + " " + e.getSecondName() + " : " + added);
        }

        printSeparator();
        System.out.println(" Список сотрудников ");
        book.listAllEmployees();

        printSeparator();
        System.out.println(" Средняя зарплата : " + book.getAverageSalary());

        printSeparator();
        System.out.println(" Налоги (PROPORTIONAL) ");
        book.printTax("PROPORTIONAL");

        printSeparator();
        System.out.println(" Налоги (PROGRESSIVE) ");
        book.printTax("PROGRESSIVE");

        printSeparator();
        System.out.println(" Индексация зарплат отдела 2 на 15% ");
        book.indexSalary(2, 15);
        book.listAllEmployees();

        printSeparator();
        System.out.println(" Первый сотрудник отдела 3 с зарплатой > 90");
        book.findFirstEmployee(4, 180);

        printSeparator();
        System.out.println(" Первые 4 сотрудника с зарплатой < 290");
        book.findWageLimit(290, 4);

        printSeparator();
        System.out.println(" Проверка contains");
        Employee test = new Employee("Любой", "Любой", "Любой", 3, 160);
        System.out.println(" Есть ли сотрудник с такой же зарплатой - 160: " + book.contains(test));

        printSeparator();
        System.out.println(" Поиск по id ");
        Employee found = book.getById(5);
        if (found != null) found.printShortInfo();
        else System.out.println(" Сотрудник с id=5 не найден");

    }
}