package logic_handle;

import entity.Subject;
import main.MainRun;

import java.util.Scanner;

public class SubjectService {
    public static void inputSubject() {
        // xử lý nhập môn học mới
        System.out.println("Nhập số lượng môn học mới muốn thêm: ");
        int newSubjectNumber = new Scanner(System.in).nextInt();
        for (int i = 0; i < newSubjectNumber; i++) {
            System.out.println("Nhập thông tin cho môn học thứ " + (i + 1));
            Subject subject = new Subject();
            subject.inputInfo();

            // lưu thông tin vào hệ thống  ==> lưu vào mảng môn học đã khai báo bên trên
            saveSubject(subject);
        }
    }

    private static void saveSubject(Subject subject) {
        for (int j = 0; j < MainRun.SUBJECTS.length; j++) {
            if (MainRun.SUBJECTS[j] == null) {
                MainRun.SUBJECTS[j] = subject;
                break;
            }
        }
    }

    public static void showAllSubject() {
        for (int i = 0; i < MainRun.SUBJECTS.length; i++) {
            if (MainRun.SUBJECTS[i] == null) {
                continue;
            }
            System.out.println(MainRun.SUBJECTS[i]);
        }
    }

    public static boolean isEmptySubject() {
        for (int i = 0; i < MainRun.SUBJECTS.length; i++) {
            if (MainRun.SUBJECTS[i] != null) {
                return false;
            }
        }
        return true;
    }
}
