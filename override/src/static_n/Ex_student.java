package static_n;


import java.lang.reflect.Array;
import java.text.DecimalFormat;
import java.util.Arrays;

class Student {

    String name;
    String school;
    int[] score;
    double average;
    boolean isPass;

    Student(String name, String school) {
        this.name = name;
        this.school = school;
    }

    void doExam() {
        score = new int[3];
        for (int i = 0; i < score.length; i++) {
            score[i] = (int) (Math.random() * 101);
        }
        average = getAverage();
        isPass = getPass();
    }

    boolean getPass() {
        return average >= 50;
    }

    ;

    double getAverage() {
        int total = 0;
        for (int i = 0; i < score.length; i++) {
            total += score[i];
        }
        return (double) total / score.length;
    }

    void printStudent(){
        DecimalFormat df = new DecimalFormat("#.##");
        System.out.println("학생이름 : "+ name+"("+school+")");
        System.out.println("성적 : "+ Arrays.toString(score) +"평균 :"+df.format(average)+"("+(isPass?"합격":"불합격")+")");

    }
}

//Data class : Lecture
class Lecture{
    //Field
    String lectureName;
    Student[] students;
    int idx;
    //Constructor
    Lecture(String lectureName,int count){
        this.lectureName = lectureName;
        students = new Student[count];
    }
    void addStudent(Student stu){
        students[idx++]= stu; //idx:인덱스(추가된 학생수)
    }

    void doExam(){
        for(int i=0;i<idx;i++){
            students[i].doExam();
        }
    }
    double getLectureAverage(){
        double total = 0;
        for (int i =0; i< idx;i++){
            total += students[i].getAverage();
        }
        return total/idx;
    }
    void printLecture(){
        System.out.println("강의명"+lectureName);
        System.out.println("강의 평균 : " + new DecimalFormat("0.00").format(getLectureAverage())+"점");
        for (int i=0;i<idx;i++){
            System.out.println((i+1)+"번 학생================================");
            students[i].printStudent();
        }
    }
}

public class Ex_student {
    public static void main(String[] args) {
        final int CAPACITY = 3;
        Lecture lecture = new Lecture("자바2",CAPACITY);

        String[] name = {"안하정","주수진","하영규"};
        String[] school= {"서강","연세","홍익"};
        for (int i=0;i<CAPACITY;i++){
            lecture.addStudent(new Student(name[i],school[i]));
        }
        //학생 시험응시
        lecture.doExam();

        //강의 정보 출력
        lecture.printLecture();

    }
}
