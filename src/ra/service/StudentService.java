package ra.service;

import ra.model.Student;

import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class StudentService {
    File file;
    public StudentService() {
        File dataDir = new File("data");
        if(!dataDir.exists()){
            dataDir.mkdir();
        }
        File studentFile = new File("data/student.txt");

        if(!studentFile.exists()){
            try {
                studentFile.createNewFile();
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        }
        this.file = studentFile;
    }

    public void saveToFile(List<Student> list){

        try {
            FileOutputStream fileOutputStream = new FileOutputStream(this.file);
            ObjectOutputStream outputStream = new ObjectOutputStream(fileOutputStream);
            outputStream.writeObject(list);
        } catch (IOException exception){
            System.out.println("co loi khi them moi");
        }
    }
    // theem phuong thuc doc file và lấy về danh sách sinh viên
    public List<Student> getAllToFile(){
        List<Student> students = new ArrayList<>();
        try {
            FileInputStream fileInputStream = new FileInputStream(file);
            ObjectInputStream inputStream = new ObjectInputStream(fileInputStream);
            students = (List<Student>) inputStream.readObject();
        } catch (EOFException e) {

        } catch (IOException e) {
            System.err.println("Loi khi doc file");
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
        return students;
    }
    // them phuong thuc them moi sinh vien
    public void addStudent(){
        Scanner scanner = new Scanner(System.in);
        List<Student> students = getAllToFile(); // lay danh sach tu file student.txt
        do {
            System.out.println("Nhap vao thong tin sinh vien");
            // khoi tao doi tuong sinh
            Student student = new Student();
            student.inputData();
            students.add(student);
            System.out.println("Ban co muon nhap nua ko 1. Co 2.Khog");
            int choice = Integer.parseInt(scanner.nextLine());
            if(choice == 2){
               break;
            }
        } while (true);
        // nhap xong 1 hoac nhieu sinh vien
        saveToFile(students);
    }
    // show danh sach sinh vien
    public void showListStudent(){
        List<Student> students = getAllToFile();
        for (Student student : students) {
            student.displayData();
        }
    }
    // them phuong thuc sua sinh vien

    // them phuong thuc xoa sinh
}
