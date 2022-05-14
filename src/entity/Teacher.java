package entity;

import constant.Level;

import java.util.Scanner;

public class Teacher extends Person {

    private Level level;

    public Teacher() {
        this.id = ++count;
    }

    public Teacher(String name, String gender, String address, String phoneNumber, Level level) {
        this.name = name;
        this.gender = gender;
        this.address = address;
        this.phoneNumber = phoneNumber;
        this.level = level;
    }

    @Override
    public void inputInfo() {
        // thực hiện nhập thông tin cho giáo viên

        super.inputInfo();
        this.inputLevelTeacher();
    }

    private void inputLevelTeacher() {
        System.out.println("Nhập trình độ của giáo viên trong các lựa chọn dưới đây: ");
        System.out.println("1. Giáo sư - Tiến sỹ");
        System.out.println("2. Phó giáo sư - Tiến sỹ");
        System.out.println("3. Giáo viên chính");
        System.out.println("4. Thạc sỹ");
        int choice = -1;
        do {
            choice = new Scanner(System.in).nextInt();
            if (choice >= 1 && choice <= 4) {
                break;
            }
            System.out.print("Chuyên nghành sách được chọn không hợp lệ vui lòng chọn lại: ");
        } while (choice > 4 || choice < 1);
        switch (choice) {
            case 1:
                this.setLevel(Level.GS_TS);
                break;
            case 2:
                this.setLevel(Level.PGS_TS);
                break;
            case 3:
                this.setLevel(Level.GVC);
                break;
            case 4:
                this.setLevel(Level.TS);
                break;
        }
    }

    @Override
    public String toString() {
        return "Teacher{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", gender='" + gender + '\'' +
                ", address='" + address + '\'' +
                ", phoneNumber='" + phoneNumber + '\'' +
                ", level=" + level.toString() +
                '}';
    }


    public Level getLevel() {
        return level;
    }

    public void setLevel(Level level) {
        this.level = level;
    }
}
