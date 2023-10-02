package vo;
//	customer_number int unsigned auto_increment primary key,
//            customer_id varchar(1000),
//            customer_password varchar(1000),
//            customer_name varchar(1000),
//            customer_age tinyint unsigned, /*int중에 작은 int 0~255 unsigned가 음수영역의 메모리를 양수영역으로 끌어다쓰는 것.*/
//            customer_phone_number varchar(1000),
//            customer_status customer_status char(2) default 0
public class CustomerVO {
    private int customerNumber;
    private String customerId;

    private String customerPassword;
    private String customerName;
    private int customerAge;
    private String customerPhoneNumber;
    private char customerStatus;

    public int getCustomerNumber() {
        return customerNumber;
    }

    public void setCustomerNumber(int customerNumber) {
        this.customerNumber = customerNumber;
    }

    public String getCustomerId() {
        return customerId;
    }

    public void setCustomerId(String customerId) {
        this.customerId = customerId;
    }

    public String getCustomerPassword() {
        return customerPassword;
    }

    public void setCustomerPassword(String customerPassword) {
        this.customerPassword = customerPassword;
    }

    public String getCustomerName() {
        return customerName;
    }

    public void setCustomerName(String customerName) {
        this.customerName = customerName;
    }

    public int getCustomerAge() {
        return customerAge;
    }

    public void setCustomerAge(int customerAge) {
        this.customerAge = customerAge;
    }

    public String getCustomerPhoneNumber() {
        return customerPhoneNumber;
    }

    public void setCustomerPhoneNumber(String customerPhoneNumber) {
        this.customerPhoneNumber = customerPhoneNumber;
    }

    public char getCustomerStatus() {
        return customerStatus;
    }

    public void setCustomerStatus(char customerStatus) {
        this.customerStatus = customerStatus;
    }

    public CustomerVO(){;}


}
