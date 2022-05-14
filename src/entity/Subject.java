package entity;

import java.util.Scanner;

public class Subject implements InputTable {
    private static int count = 99;
    private int id;
    private String name;
    private int sumOfLesson;
    private int lessonTheory;
    private int expense;

    public Subject() {
        this.id = ++count;
    }

    public Subject(String name, int sumOfLesson, int lessonTheory, int expense) {

        this.name = name;
        this.sumOfLesson = sumOfLesson;
        this.lessonTheory = lessonTheory;
        this.expense = expense;
    }

    @Override
    public String toString() {
        return "Subject{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", sumOfLesson=" + sumOfLesson +
                ", lessonTheory=" + lessonTheory +
                ", expense=" + expense + " vnd " +
                '}';
    }

    public static int getCount() {
        return count;
    }

    public static void setCount(int count) {
        Subject.count = count;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getSumOfLesson() {
        return sumOfLesson;
    }

    public void setSumOfLesson(int sumOfLesson) {
        this.sumOfLesson = sumOfLesson;
    }

    public int getLessonTheory() {
        return lessonTheory;
    }

    public void setLessonTheory(int lessonTheory) {
        this.lessonTheory = lessonTheory;
    }

    public int getExpense() {
        return expense;
    }

    public void setExpense(int expense) {
        this.expense = expense;
    }

    @Override
    public void inputInfo() {
        // thực hiện nhập thông tin cho môn học
        System.out.println("Nhập tên cho môn học");
        this.setName(new Scanner(System.in).nextLine());
        System.out.println("Nhập tổng số tiết học của môn học:");
        this.setSumOfLesson(new Scanner(System.in).nextInt());
        System.out.println("Nhập số tiết lý thuyết của môn học:");
        this.setLessonTheory(new Scanner(System.in).nextInt());
        System.out.println("Nhập mức kinh phí cho mỗi tiết học của môn học:");
        this.setExpense(new Scanner(System.in).nextInt());
    }
}
