package hiding;

public class Article {
    private int seq;
    private  String subject;
    private String content;
    private  String writer;
    private  int hit;
    private String regDate;

    public Article(int seq,String subject,String content,String writer,int hit,String regDate){
        this.seq  = seq;
        this.subject  = subject;
        this.content  = content;
        this.writer  = writer;
        this.hit = hit;
        this.regDate =regDate;
    }

    public String getWriter() {
        return writer;
    }

    public void setWriter(String writer) {
        this.writer = writer;
    }

    public int getHit() {
        return hit;
    }

    public void setHit(int hit) {
        this.hit = hit;
    }

    public String getRegDate() {
        return regDate;
    }

    public void setRegDate(String regDate) {
        this.regDate = regDate;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public String getSubject() {
        return subject;
    }

    public void setSubject(String subject) {
        this.subject = subject;
    }

    public int getSeq() {
        return seq;
    }

    public void setSeq(int seq) {
        this.seq = seq;
    }
}
