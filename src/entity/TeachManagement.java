package entity;

import java.util.Arrays;

public class TeachManagement {

    private Teacher teacher;
    private TeacherSubjectDetail[] teacherSubjectDetails;

    public TeachManagement(Teacher teacher, TeacherSubjectDetail[] teacherSubjectDetails) {
        this.teacher = teacher;
        this.teacherSubjectDetails = teacherSubjectDetails;
    }

    @Override
    public String toString() {
        return "TeachManagement{" +
                "teacher=" + teacher +
                ", teacherSubjectDetails=" + Arrays.toString(teacherSubjectDetails) +
                '}';
    }

    public int sumOfLesson() {
        int result = 0;
        for (int i = 0; i < teacherSubjectDetails.length; i++) {
            result += this.teacherSubjectDetails[i].getSubject().getSumOfLesson() * this.teacherSubjectDetails[i].getQuantity();
        }
        return result;
    }

    public Teacher getTeacher() {
        return teacher;
    }

    public void setTeacher(Teacher teacher) {
        this.teacher = teacher;
    }

    public TeacherSubjectDetail[] getTeacherSubjectDetails() {
        return teacherSubjectDetails;
    }

    public void setTeacherSubjectDetails(TeacherSubjectDetail[] teacherSubjectDetails) {
        this.teacherSubjectDetails = teacherSubjectDetails;
    }
}
