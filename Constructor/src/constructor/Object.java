package constructor;

class Book{
    String subject;
    String content;

    Book(){
        System.out.println("생성자 실행됨.");
        this.subject = "java입문";
        this.content = "java객체 지향 언어이다.";
    }
    void read(){
        System.out.println("read실행됨");
        System.out.println(this.subject);
        System.out.println(this.content);

    }
}

public class Object {
    public static void main(String[] args) {
        Book book = new Book();
        System.out.println(book);
        book.read();
    }
}
