package main;

import entity.Subject;
import entity.TeachManagement;
import entity.Teacher;
import logic_handle.SubjectService;
import logic_handle.TeachManageService;
import logic_handle.TeacherService;

import java.util.Scanner;

public class MainRun {

    public static Teacher[] TEACHERS = new Teacher[100];
    public static Subject[] SUBJECTS = new Subject[100];
    public static TeachManagement[] TEACH_MANAGE = new TeachManagement[100];

    public static void main(String[] args) {
        showmenu();
    }

    private static void showmenu() {
        boolean isExit = false;
        do {
            int functionChoice = functionChoice();
            switch (functionChoice) {
                case 1:
                    TeacherService.inputTeacher();
                    break;
                case 2:
                    TeacherService.showAllTeacher();
                    break;
                case 3:
                    SubjectService.inputSubject();
                    break;
                case 4:
                    SubjectService.showAllSubject();
                    break;
                case 5:
                    TeachManageService.manageTeach();
                    TeachManageService.showManageTeach();
                    break;
                case 6:
                    TeachManageService.sortManageTeach();
                    break;
                case 7:
                    TeachManageService.caculateSalaryForTeacher();
                    break;
                case 8:
                    System.out.println("Xin cảm ơn bạn đã sử dụng phần mềm của chúng tôi.");
                    isExit = true;
            }
        } while (!isExit);
    }

    private static int functionChoice() {
        System.out.println("\nPhần mền quản lý trả lương giáo viên!\n");
        System.out.println("++++++++++++++++++++++++++++++++++++");
        System.out.println("1. Nhập danh sách giáo viên mới.");
        System.out.println("2. In ra danh sách giáo viên đã có.");
        System.out.println("3. Nhập danh sách môn học mới.");
        System.out.println("4. In ra danh sách môn học.");
        System.out.println("5. Thực hiện kê khai giảng dạy cho giáo viên.");
        System.out.println("6. Sắp xếp danh sách giảng dạy của giáo viên.");
        System.out.println("7. Tính toán và lập bảng tính tiền công cho giáo viên.");
        System.out.println("8. Thoát chương trình.");
        System.out.println("++++++++++++++++++++++++++++++++++++");
        System.out.print("Xin mời nhập lựa chọn của bạn: ");
        int functionChoice = -1;
        do {
            functionChoice = new Scanner(System.in).nextInt();
            if (functionChoice >= 1 && functionChoice <= 8) {
                break;
            }
            System.out.print("Chức năng được chọn không hợp lệ vui lòng chọn lại: ");
        } while (functionChoice > 8 || functionChoice < 1);
        return functionChoice;
    }
}
