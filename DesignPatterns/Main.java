import java.util.List;
import java.util.ArrayList;

public class Main {
    public static void main(String[] args) {

        Mediator mediator = Mediator.getInstance();
        mediator.setEmployeeList(getEmployeeList());

        Employee employee1 = mediator.getEmployeeList().get(0);
        Employee employee2 = mediator.getEmployeeList().get(1);
        Employee employee3 = mediator.getEmployeeList().get(2);

        new Customer().getALineNumber();
        employee1.acceptCustomer();

        new Customer().getALineNumber();
        employee2.acceptCustomer();

        new Customer().getALineNumber();
        employee3.acceptCustomer();

        new Customer().getALineNumber();
        new Customer().getALineNumber();

        employee1.pressAvailableButton();
        employee1.acceptCustomer();
    }

    private static List<Employee> getEmployeeList(){
        List<Employee> employeeList = new ArrayList<>();
        employeeList.add(new Employee(1,"Employee1"));
        employeeList.add(new Employee(2,"Employee2"));
        employeeList.add(new Employee(3,"Employee3"));
        return employeeList;
    }
}

// Output :

// — —
// Sıradaki Müşteri : 1
// Müsait Çalışanlar :
// Employee1 — Oda Numarası : 1
// Employee2 — Oda Numarası : 2
// Employee3 — Oda Numarası : 3
// — —
// Sıradaki Müşteri : 2
// Müsait Çalışanlar :
// Employee2 — Oda Numarası : 2
// Employee3 — Oda Numarası : 3
// — —
// Sıradaki Müşteri : 3
// Müsait Çalışanlar :
// Employee3 — Oda Numarası : 3
// — —
// Sıradaki Müşteri : 4
// Müsait Çalışanlar :
// Şu anda tüm çalışanlarımız diğer müşteriler ile ilgilenmektedir.
// — —
// Sıradaki Müşteri : 4
// Müsait Çalışanlar :
// Employee1 — Oda Numarası : 1
// — —
// Sıradaki Müşteri : 5
// Müsait Çalışanlar :
// Şu anda tüm çalışanlarımız diğer müşteriler ile ilgilenmektedir.