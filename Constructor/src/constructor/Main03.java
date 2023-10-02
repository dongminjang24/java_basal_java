package constructor;
class Article{
    int seq;
    String subject;
    String writer;

     Article(int seq,String subject,String writer){
        this.seq = seq;
        this.subject = subject;
        this.writer = writer;
    }
    void print(){
        System.out.println(this.seq);
        System.out.println(this.subject);
        System.out.println(this.writer);
    }
}
public class Main03 {
    public static void main(String[] args) {
        Article article = new Article(10,"earth","Park Kyung-Ri");
        article.print();
    }
}
