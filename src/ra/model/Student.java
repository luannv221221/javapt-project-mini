package ra.model;

import java.io.Serial;
import java.io.Serializable;
import java.util.Scanner;

public class Student implements Serializable,IStudent {
    @Serial
    private static final long serialVersionUID = 1L;
    private int studentCode;
    private String name;
    private int age;
    private boolean sex;

    public Student() {
    }

    public Student(int studentCode, String name, int age, boolean sex) {
        this.studentCode = studentCode;
        this.name = name;
        this.age = age;
        this.sex = sex;
    }

    public int getStudentCode() {
        return studentCode;
    }

    public void setStudentCode(int studentCode) {
        this.studentCode = studentCode;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public boolean isSex() {
        return sex;
    }

    public void setSex(boolean sex) {
        this.sex = sex;
    }

    @Override
    public String toString() {
        return "Student{" +
                "studentCode=" + studentCode +
                ", name='" + name + '\'' +
                ", age=" + age +
                ", sex=" + sex +
                '}';
    }

    @Override
    public void inputData() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Nhap vao ma sinh vien");
        studentCode = Integer.parseInt(scanner.nextLine());
        System.out.println("Nhap vafo ten sinh vien");
        name = scanner.nextLine();
        System.out.println("Nhap vao tuoi sinh vien");
        age = Integer.parseInt(scanner.nextLine());
        System.out.println("Nhap vao gioi tinh");
        sex = Boolean.parseBoolean(scanner.nextLine());
    }

    @Override
    public void displayData() {
        System.out.println(toString());
    }
}
