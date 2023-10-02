package overload;

public class Hello {
    public Hello(String msg){
        System.out.println(msg);
    }

    public Hello(){
        this("Hello");
    };
    public Hello(int num){
        this("user");
        System.out.println(num);
    }
}
