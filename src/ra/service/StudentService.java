package ra.service;

import ra.model.Student;

import java.io.*;
import java.util.List;

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

    // theem phuong thuc doc file

    // them phuong thuc them moi sinh vien

    // them phuong thuc sua sinh vien

    // them phuong thuc xoa sinh
}
