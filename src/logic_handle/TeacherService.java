package logic_handle;

import entity.Teacher;
import main.MainRun;

import java.util.Scanner;

public class TeacherService {
    public static void inputTeacher() {
        // xử lý nhập giáo viên mới
        System.out.println("Nhập số lượng giáo viên mới muốn thêm: ");
        int newTeacherNumber = new Scanner(System.in).nextInt();
        for (int i = 0; i < newTeacherNumber; i++) {
            System.out.println("Nhập thông tin cho đầu sách thứ " + (i + 1));
            Teacher teacher = new Teacher();
            teacher.inputInfo();

            // lưu thông tin vào hệ thống  ==> lưu vào mảng sach đã khai báo bên trên
            saveTeacher(teacher);
        }
    }

    private static void saveTeacher(Teacher teacher) {
        for (int j = 0; j < MainRun.TEACHERS.length; j++) {
            if (MainRun.TEACHERS[j] == null) {
                MainRun.TEACHERS[j] = teacher;
                break;
            }
        }
    }

    public static void showAllTeacher() {
        for (int i = 0; i < MainRun.TEACHERS.length; i++) {
            if (MainRun.TEACHERS[i] == null) {
                continue;
            }
            System.out.println(MainRun.TEACHERS[i]);
        }
    }

    public static boolean isEmptyTeacher() {
        for (int i = 0; i < MainRun.TEACHERS.length; i++) {
            if (MainRun.TEACHERS[i] != null) {
                return false;
            }
        }
        return true;
    }
}
