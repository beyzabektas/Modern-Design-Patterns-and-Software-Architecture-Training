import java.util.ArrayList;
import java.util.List;

interface IMediator{
    public void giveCustomerTheNextLineNumber(Customer customer);
    public void updateEmployeeAvailabilityAndScreen(Integer roomNumber);
}

class Mediator implements IMediator{
    private static Mediator mediator;

    private List<Employee> employeeList = new ArrayList<>();
    private Integer currentLineNumber = 1;

    private Mediator(){

    }

    public static Mediator getInstance(){
        if(mediator==null){
            mediator = new Mediator();
        }
        return mediator;
    }


    @Override
    public void giveCustomerTheNextLineNumber(Customer customer){
        Integer nextLineNumber = LineNumberMachine.getInstance().getLineNumber();
        customer.setLineNumber(nextLineNumber);
        if(nextLineNumber==1){
            InfoScreen.getInstance().showInfo(currentLineNumber, employeeList);
        }
    }

    @Override
    public void updateEmployeeAvailabilityAndScreen(Integer roomNumber){
        Employee employee = employeeList.get(roomNumber-1);
        if(Boolean.TRUE.equals(employee.getAvailable())){
            currentLineNumber++;
        }
        employee.setAvailable(!employee.getAvailable());
        InfoScreen.getInstance().showInfo(currentLineNumber, employeeList);
    }

    public List<Employee> getEmployeeList() {
        return employeeList;
    }

    public void setEmployeeList(List<Employee> employeeList) {
        this.employeeList = employeeList;
    }
}

class Employee{
    private Mediator mediator = Mediator.getInstance();
    private Integer roomNumber;
    private String name;
    private Boolean isAvailable = Boolean.TRUE;

    public Employee(Integer roomNumber, String name){
        this.roomNumber = roomNumber;
        this.name = name;
    }

    public void acceptCustomer(){
        mediator.updateEmployeeAvailabilityAndScreen(roomNumber);
    }

    public void pressAvailableButton(){
        mediator.updateEmployeeAvailabilityAndScreen(roomNumber);
    }

    public String getName() {
        return name;
    }

    public Boolean getAvailable() {
        return isAvailable;
    }

    public void setAvailable(Boolean available) {
        isAvailable = available;
    }

    public Integer getRoomNumber() {
        return roomNumber;
    }
}

class Customer{
    private Mediator mediator = Mediator.getInstance();
    private Integer lineNumber;


    public void getALineNumber(){
        mediator.giveCustomerTheNextLineNumber(this);
    }

    public void setLineNumber(Integer lineNumber) {
        this.lineNumber = lineNumber;
    }
}

class InfoScreen{
    private static InfoScreen infoScreen;

    private InfoScreen(){

    }

    public static InfoScreen getInstance(){
        if(infoScreen ==null){
            infoScreen = new InfoScreen();
        }
        return infoScreen;
    }

    public void showInfo(Integer lineNumber, List<Employee> employeeList){
        System.out.println("----");
        System.out.println("Sıradaki Müşteri : "+lineNumber);
        System.out.println("Müsait Çalışanlar :");
        Boolean isThereAnyAvailableEmployee = Boolean.FALSE;
        for(Employee employee : employeeList){
            if(Boolean.TRUE.equals(employee.getAvailable())){
                System.out.println(employee.getName()+" - Oda Numarası : "+employee.getRoomNumber());
                isThereAnyAvailableEmployee = Boolean.TRUE;
            }
        }
        if(Boolean.FALSE.equals(isThereAnyAvailableEmployee)){
            System.out.println("Şu anda tüm çalışanlarımız diğer müşteriler ile ilgilenmektedir.");
        }
    }
}

class LineNumberMachine{
    private static LineNumberMachine lineNumberMachine;
    private Integer nextLineNumber = 1;
    private LineNumberMachine(){

    }

    public static LineNumberMachine getInstance(){
        if(lineNumberMachine==null){
            lineNumberMachine = new LineNumberMachine();
        }
        return lineNumberMachine;
    }

    public Integer getLineNumber(){
        return nextLineNumber++;
    }
}

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