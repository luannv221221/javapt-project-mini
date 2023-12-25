package ra.view;

import ra.service.StudentService;

import java.io.IOException;
import java.util.Scanner;

public class Menu {
    private static final StudentService  studentService = new StudentService();


    public static void showMenu(){
        Scanner scanner = new Scanner(System.in);
        do {
            System.out.println("===============MENU===========");
            System.out.println("1. Them moi sinh vien");
            System.out.println("2. Danh sach sv");
            System.out.println("3. Sua SV");
            System.out.println("4. Xóa SV");
            System.out.println("Lua chon cua ban 1-4");
            int choice = Integer.parseInt(scanner.nextLine());
            switch (choice){
                case 1:
                    studentService.addStudent();
                    break;
                case 2:
                    studentService.showListStudent();
                    break;
            }
        } while (true);
    }
}
