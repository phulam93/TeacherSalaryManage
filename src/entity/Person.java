package entity;

import java.util.Scanner;

public abstract class Person implements InputTable {
    public static int count = 99;
    protected int id;
    protected String name;
    protected String gender;
    protected String address;
    protected String phoneNumber;

    public static int getCount() {
        return count;
    }

    public static void setCount(int count) {
        Person.count = count;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    @Override
    public void inputInfo() {
        System.out.println("Nhập tên cho giáo viên");
        this.setName(new Scanner(System.in).nextLine());
        System.out.println("Nhập giới tính cho giáo viên");
        this.setGender(new Scanner(System.in).nextLine());
        System.out.println("Nhập địa chỉ cho giáo viên");
        this.setAddress(new Scanner(System.in).nextLine());
        System.out.println("Nhập số điện thoại cho giáo viên");
        this.setPhoneNumber(new Scanner(System.in).nextLine());
    }

}
