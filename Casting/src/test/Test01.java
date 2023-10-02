package test;

class Employee{
    private String name;
    private String department;

    public Employee(String name, String department) {
        this.name = name;
        this.department = department;
    }

    public int getPay(){
        return 280;
    };

    public void empInfo(String department,String name,int Pay){
        System.out.println(department+"에서 일하는"+name + "의 월급은" + Pay + "만원 밖에 못 받는다.");
    }
}

class SalaryWorker extends Employee{

    private int salary;
    public SalaryWorker(String name, String department) {
        super(name, department);
    }

    @Override
    public int getPay() {
        this.salary = 300;
        return salary;
    }

    @Override
    public void empInfo(String department,String name, int Pay) {
        System.out.println(department+"에서 일하는"+name + "은 월급쟁이이고, 그런데도 불구하고" + Pay + "만원 밖에 못 받는다.");
    }
}
class PartTimeWorker extends Employee{

    private int workTime =0;
    private  int payPerHour;
    public PartTimeWorker(String name, String department) {
        super(name, department);
    }

    public void setWorkTime(int workTime){
        this.workTime= workTime;
    }
    @Override
    public int getPay() {
        this.payPerHour = 10000;
        return workTime* payPerHour;
    }

    @Override
    public void empInfo(String department,String name, int Pay) {
        System.out.println(department+"일하는"+name + "은 알바생인데, 그러니깐 돈을" + Pay + "만원 밖에 못 받는다.");
    }
}

class SalesWorker extends SalaryWorker{

    private int salesVolume;
    private double salesIncentive;

    private  int getSalesPay(){
        return  500;
    }
    public void setSalesVolume(int salesVolume){

    }
    public void setSalesIncentive(int salesIncentive){

    }
    public SalesWorker(String name, String department) {
        super(name, department);
    }

    @Override
    public int getPay() {
        return super.getPay();
    }

    @Override
    public void empInfo(String department, String name, int Pay) {
        super.empInfo(department, name, Pay);
    }
}
public class Test01 {
}
