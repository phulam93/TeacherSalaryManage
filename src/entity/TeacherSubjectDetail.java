package entity;

public class TeacherSubjectDetail {
    private Subject subject;
    private int quantity;

    public TeacherSubjectDetail(Subject subject, int quantity) {
        this.subject = subject;
        this.quantity = quantity;
    }

    @Override
    public String toString() {
        return "TeacherSubjectDetail{" +
                "subject=" + subject +
                ", quantity=" + quantity +
                '}';
    }

    public Subject getSubject() {
        return subject;
    }

    public void setSubject(Subject subject) {
        this.subject = subject;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }
}
