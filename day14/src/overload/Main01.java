package overload;

public class Main01 {
    public static void main(String[] args) {
//        Member m1 = new Member();
//        Member m2 = new Member(20);
//        System.out.println(m1.toString());
//        System.out.println(m2.toString());
//        Hello h = new Hello(5);
        Article a1 = new Article(1);
        System.out.println(a1.toString());

        Article a2 = new Article(2,"테스트게시물");
        System.out.println(a2);

        Article a3 = new Article(3,"테스트게시물","자바학생");
        System.out.println(a3);
    }
}
