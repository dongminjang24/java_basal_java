package hiding;

public class Main04 {
    public static void main(String[] args) {
        Article article = new Article(3, "호밀밭의 파수꾼", "박정민과 이제훈이 나온다", "작자 미상", 109, "2015년3월22일");
//            public Article(int seq,String subject,String content,String writer,int hit,String regDate){
        System.out.println(article.getSeq());
        System.out.println(article.getSubject());
        System.out.println(article.getContent());
        System.out.println(article.getWriter());
        System.out.println(article.getHit());
        System.out.println(article.getRegDate());

    }
}
