import java.util.List;
import java.util.ArrayList;
// Öncelikle çalışan ve müşteri nesnelerini üretebileceğimiz Employee ve Customer sınıflarını oluşturduk.

class Employee{
    private Mediator mediator = Mediator.getInstance(); // Bankada calisan herkes sube yoneticisine bagli ve her gise gorevlisinin;
    private Integer roomNumber;                         // Gise numarasi
    private String name;                                // ismi
    private Boolean isAvailable = Boolean.TRUE;         // musaitlik durumu var

    public Employee(Integer roomNumber, String name){   // Yeni bir gise gorevlisi ise basladiginda ona bir gide numarasi ve isim ataniyor
        this.roomNumber = roomNumber;
        this.name = name;
    }

// Employee nesnesi, acceptCustomer() metodu ile içeriye bir müşteri kabul edebilir ve bu gisenin artik mesgul oldugu ekrana yansitilir

    public void acceptCustomer(){
        mediator.updateEmployeeAvailabilityAndScreen(roomNumber);
    }

// Ve müşteri çıktıktan sonra pressAvailableButton() metodu ile yeni müşteri alabileceğini belirtebilir. 

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

// Customer nesnesi ise getALineNumber() metodunu kullanarak bir sıra numarası alabilir. 

    public void getALineNumber(){
        mediator.giveCustomerTheNextLineNumber(this);
    }

// Musteri sira almak icin numaratorden sira fisi ceker.

    public void setLineNumber(Integer lineNumber) {
        this.lineNumber = lineNumber;
    }
}

// Bunlarla birlikte, ekrana bilgi vermek ile sorumlu InfoScreen sınıflarını tasarladık.

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

// Ekran hangi musteri cagriliyor ve hangi gise bosta onu gosterir.

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

// Müşterilerin sıra numarası almasından sorumlu LineNumberMachine sınıflarını tasarladık. 

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

// Her musteri yeni fis aldiginda numara bir artar.

    public Integer getLineNumber(){
        return nextLineNumber++;
    }
}


// Bu sınıflar için bize yalnızca bir nesne yeterli olacağından dolayı bu sınıfları Singleton olarak tasarladık. 
// Görüldüğü üzere, sınıflarda Mediator nesneleri bulunmaktadır. 
// Bu nesne sayesinde sınıflar birbirleri ile doğrudan iletişim kurmak yerine Memento ile iletişim kurmaktadırlar. 
// İlerleyen süreçte yeni sınıflar ve bağımlılıklar eklendiğinde yine bu süreç Mediator üzerinden yürütülebilir halde olacaktır.