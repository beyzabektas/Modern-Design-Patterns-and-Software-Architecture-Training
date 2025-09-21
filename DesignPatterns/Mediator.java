import java.util.List;
import java.util.ArrayList;

// Görüldüğü üzere Mediator sınıfı projedeki diğer tüm sınıflar ile aktif olarak iletişim halindedir. 
// Örneğin bir çalışan müsait olduğunu bildirdiği zaman Mediator hem ilgili çalışanın bilgilerini hem de bilgilendirme ekranını güncellemektedir. 
// Aynı şekilde bankaya gelen ilk müşteri ile birlikte ekranın açılma sorumluluğu da Mediator üzerindedir.

interface IMediator{
    public void giveCustomerTheNextLineNumber(Customer customer);
    public void updateEmployeeAvailabilityAndScreen(Integer roomNumber);
}

// Singleton olduğu için bankada tek bir tane “organizasyon sorumlusu” var.
// employeeList: Bankadaki tüm gişe görevlilerinin listesi.
// currentLineNumber: Şu anda hangi müşteri sırada onu tutuyor.

class Mediator implements IMediator{
    private static Mediator mediator;

    private List<Employee> employeeList = new ArrayList<>();
    private Integer currentLineNumber = 1;

    private Mediator(){

    }

// İlk çağrıldığında Mediator oluşturuluyor.
// Sonraki çağrılarda hep aynı Mediator geri dönüyor.

    public static Mediator getInstance(){
        if(mediator==null){
            mediator = new Mediator();
        }
        return mediator;
    }

// İlk müşteri gelince ekran açılır: “Sıradaki müşteri: 1, Boş gişeler: Ayşe (Gişe 2)”.

    @Override
    public void giveCustomerTheNextLineNumber(Customer customer){
        Integer nextLineNumber = LineNumberMachine.getInstance().getLineNumber();
        customer.setLineNumber(nextLineNumber);
        if(nextLineNumber==1){
            InfoScreen.getInstance().showInfo(currentLineNumber, employeeList);
        }
    }

// Ayşe (Gişe 2) boştu → müşteri geldi → Ayşe meşgule geçti → sıradaki müşteri 2 oldu → ekran güncellendi.

    @Override
    public void updateEmployeeAvailabilityAndScreen(Integer roomNumber){
        Employee employee = employeeList.get(roomNumber-1);
        if(Boolean.TRUE.equals(employee.getAvailable())){
            currentLineNumber++;
        }
        employee.setAvailable(!employee.getAvailable());
        InfoScreen.getInstance().showInfo(currentLineNumber, employeeList);
    }

// Ayşe (Gişe 2) boştu → müşteri geldi → Ayşe meşgule geçti → sıradaki müşteri 2 oldu → ekran güncellendi.

    public List<Employee> getEmployeeList() {
        return employeeList;
    }

    public void setEmployeeList(List<Employee> employeeList) {
        this.employeeList = employeeList;
    }
}