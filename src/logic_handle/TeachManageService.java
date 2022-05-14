package logic_handle;

import entity.Subject;
import entity.TeachManagement;
import entity.Teacher;
import entity.TeacherSubjectDetail;
import main.MainRun;

import java.util.Comparator;
import java.util.Scanner;

public class TeachManageService {
    public static void manageTeach() {

        if (TeacherService.isEmptyTeacher() || SubjectService.isEmptySubject()) {
            System.out.println("Cần phải nhập giáo viên và môn học trước.");
            return;
        }
        System.out.print("Nhập vào số lượng giáo viên được phân công giảng dạy: ");
        int teacherNumber = new Scanner(System.in).nextInt();
        for (int i = 0; i < teacherNumber; i++) {
            System.out.print("Nhập vào mã giáo viên thứ " + (i + 1) + " muốn phân công môn học: ");

            //nhập giáo viên muốn phân công
            Teacher teacher = inputTeacherInfo();

            //nhập danh sách các môn học
            TeacherSubjectDetail[] teacherSubjectDetails = inputTeacherSubjectDetail();

            //lượt khai giảng dạy
            TeachManagement teachManagement = new TeachManagement(teacher, teacherSubjectDetails);
            saveTeachManagement(teachManagement);

        }
    }

    private static void saveTeachManagement(TeachManagement teachManagement) {
        for (int j = 0; j < MainRun.TEACH_MANAGE.length; j++) {
            if (MainRun.TEACH_MANAGE[j] == null) {
                MainRun.TEACH_MANAGE[j] = teachManagement;
                break;
            }
        }
    }

    private static TeacherSubjectDetail[] inputTeacherSubjectDetail() {

        System.out.print("Nhập số lượng môn học mà giáo viên giảng dạy: ");
        int subjectQuantity = -1;
//        do {
////            subjectQuantity = new Scanner(System.in).nextInt();
////            if (subjectQuantity > 0 && subjectQuantity <= 5) {
////                break;
////            }
////            System.out.println("Giáo viên chỉ được dạy tối đa 5 môn, mờ nhập lại: ");
////
////        } while (subjectQuantity < 0 || subjectQuantity > 5);
        subjectQuantity = new Scanner(System.in).nextInt();

        TeacherSubjectDetail[] teacherSubjectDetails = new TeacherSubjectDetail[subjectQuantity];

        int numberMaxLesson = 200;
        int numberLesson;
        do {
            numberLesson = 0;
            for (int j = 0; j < subjectQuantity; j++) {
                System.out.print("Nhập mã môn học thứ " + (j + 1) + " mà giáo viên giảng dạy: ");
                int subjectID = -1;
                Subject subject = null;
                do {
                    subjectID = new Scanner(System.in).nextInt();
                    for (int k = 0; k < MainRun.SUBJECTS.length; k++) {
                        if (MainRun.SUBJECTS[k] != null && MainRun.SUBJECTS[k].getId() == subjectID) {
                            subject = MainRun.SUBJECTS[k];
                            break;
                        }
                    }
                    if (subject != null) {
                        break;
                    }
                    System.out.println("Không tìm thấy môn học mang mã vừa nhập, vui lòng nhập lại: ");
                } while (true);

                System.out.print("Số lớp mà giảng viên này dạy là: ");
                int quantity = -1;
                do {
                    quantity = new Scanner(System.in).nextInt();
                    if (quantity > 0 && quantity <= 3) {
                        break;
                    }
                    System.out.println("Giáo viên chỉ được dạy tối đa là 3 lớp, mờ nhập lại: ");

                } while (quantity < 0 || quantity > 3);
                numberLesson += quantity * subject.getSumOfLesson();
                // nhập từng môn và số lượng lớp tương ứng
                TeacherSubjectDetail teacherSubjectDetail = new TeacherSubjectDetail(subject, quantity);
                for (int k = 0; k < teacherSubjectDetails.length; k++) {
                    if (teacherSubjectDetails[k] == null) {
                        teacherSubjectDetails[k] = teacherSubjectDetail;
                        break;
                    }
                }
            }
            if (numberLesson <= 200) {
                break;
            } else {
                System.out.println("Giáo viên chỉ được giảng dạy tối đa là 200 tiết, xin mời nhập lại:");
            }
        } while (numberLesson > numberMaxLesson);


        return teacherSubjectDetails;
    }

    private static Teacher inputTeacherInfo() {
        Teacher teacher = null;
        do {
            int teacherID = new Scanner(System.in).nextInt();
            for (int j = 0; j < MainRun.TEACHERS.length; j++) {
                if (MainRun.TEACHERS[j] != null && MainRun.TEACHERS[j].getId() == teacherID) {
                    teacher = MainRun.TEACHERS[j];
                    break;
                }
            }
            if (teacher != null) {
                break;
            }
            System.out.println("Không tìm thấy giáo viên mang mã vừa nhập, vui lòng nhập lại: ");
        } while (true);
        return teacher;
    }

    public static void showManageTeach() {
        for (int i = 0; i < MainRun.TEACH_MANAGE.length; i++) {
            if (MainRun.TEACH_MANAGE[i] != null) {
                System.out.println(MainRun.TEACH_MANAGE[i]);
            }
        }
    }

    public static void sortManageTeach() {
        System.out.println("Nhập lựa chọn của bạn.");
        System.out.println("1. Sắp xếp theo tên giảng viên.");
        System.out.println("2. Sắp xếp theo số lượng tiết giảng dạy của giảng viên (giảm dần).");
        int choice = 0;
        do {
            choice = new Scanner(System.in).nextInt();
            if (choice >= 1 && choice <= 2) {
                break;
            }
            System.out.println("Lựa chọn của bạn không hợp lệ, vui lòng nhập lại:");
        } while (true);
        if (choice == 1) {
            //sắp xếp theo tên giảng viên
            for (int i = 0; i < MainRun.TEACH_MANAGE.length - 1; i++) {
                if (MainRun.TEACH_MANAGE[i] != null) {
                    for (int j = i + 1; j < MainRun.TEACH_MANAGE.length; j++) {
                        if (MainRun.TEACH_MANAGE[j] != null) {
                            if (MainRun.TEACH_MANAGE[i].getTeacher().getName().compareTo(MainRun.TEACH_MANAGE[j]
                                    .getTeacher().getName()) > 0) {
                                TeachManagement temp = MainRun.TEACH_MANAGE[i];
                                MainRun.TEACH_MANAGE[i] = MainRun.TEACH_MANAGE[j];
                                MainRun.TEACH_MANAGE[j] = temp;
                            }
                        }
                    }
                }
            }

        } else if (choice == 2) {
            //sắp xếp theo số lượng sách đã mượn
            for (int i = 0; i < MainRun.TEACH_MANAGE.length - 1; i++) {
                if (MainRun.TEACH_MANAGE[i] != null) {
                    for (int j = i + 1; j < MainRun.TEACH_MANAGE.length; j++) {
                        if (MainRun.TEACH_MANAGE[j] != null) {
                            if (MainRun.TEACH_MANAGE[i].sumOfLesson() > MainRun.TEACH_MANAGE[j].sumOfLesson()) {
                                TeachManagement temp = MainRun.TEACH_MANAGE[i];
                                MainRun.TEACH_MANAGE[i] = MainRun.TEACH_MANAGE[j];
                                MainRun.TEACH_MANAGE[j] = temp;
                            }
                        }
                    }
                }
            }
        }
        showManageTeach();
    }

    public static void caculateSalaryForTeacher() {
        if (isEmptyManageTeacher()) {
            System.out.println("Cần phải nhập kê khai môn học của giáo viên trước.");
            return;
        }
        System.out.println("Danh sách giáo viên và lương theo danh sách kê khai giảng dạy:");

        //tạo danh sách các giảng viên được kê khai
        Teacher[] tempTeachers = new Teacher[MainRun.TEACH_MANAGE.length];
        tempTeachers[0] = MainRun.TEACH_MANAGE[0].getTeacher();
        Comparator<Teacher> comparator = new Comparator<Teacher>() {
            @Override
            public int compare(Teacher o1, Teacher o2) {
                return o1.getId() - o2.getId();
            }

        };
        for (int i = 0; i < MainRun.TEACH_MANAGE.length; i++) {
            for (int j = 0; j < MainRun.TEACH_MANAGE.length; j++) {
                if (MainRun.TEACH_MANAGE[i] != null && tempTeachers[j] != null && comparator.compare(tempTeachers[j], MainRun.TEACH_MANAGE[i].getTeacher()) != 0) {
                    tempTeachers[j + 1] = MainRun.TEACH_MANAGE[i].getTeacher();
                    break;
                }
            }
        }

        //tính lương cho từng giáo viên
        for (int i = 0; i < tempTeachers.length; i++) {
            float salary = 0;
            for (int j = 0; j < MainRun.TEACH_MANAGE.length; j++) {

                if (MainRun.TEACH_MANAGE[i] != null && tempTeachers[j] != null && comparator.compare(tempTeachers[j], MainRun.TEACH_MANAGE[i].getTeacher()) == 0) {
                    for (int k = 0; k < MainRun.TEACH_MANAGE[j].getTeacherSubjectDetails().length; k++) {
                        int sumOfLesson = MainRun.TEACH_MANAGE[j].getTeacherSubjectDetails()[k].getSubject().getSumOfLesson();
                        int lessonTheory = MainRun.TEACH_MANAGE[j].getTeacherSubjectDetails()[k].getSubject().getLessonTheory();
                        int expense = MainRun.TEACH_MANAGE[j].getTeacherSubjectDetails()[k].getSubject().getExpense();
                        int quantity = MainRun.TEACH_MANAGE[j].getTeacherSubjectDetails()[k].getQuantity();
                        salary += quantity * (lessonTheory * expense + (sumOfLesson - lessonTheory) * expense * 0.7);
                    }
                }
            }
            System.out.println("Giáo viên " + tempTeachers[i].getName() + " có lương là " + salary);
            System.out.println("---------------------");

        }
    }

    private static boolean isEmptyManageTeacher() {
        for (int i = 0; i < MainRun.TEACH_MANAGE.length; i++) {
            if (MainRun.TEACH_MANAGE[i] != null) {
                return false;
            }
        }
        return true;
    }
}
