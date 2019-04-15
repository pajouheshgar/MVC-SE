package selab.mvc.models.entities;

import selab.mvc.models.Model;

public class StudentCourse implements Model {

    private Course course;
    private Student student;
    private int grade;

    public StudentCourse(Course course, Student student, int grade) {
        this.course = course;
        this.student = student;
        this.grade = grade;
    }

    @Override
    public String getPrimaryKey() {
        return this.course.getPrimaryKey() + this.student.getPrimaryKey();
    }

    public Course getCourse() {
        return course;
    }

    public Student getStudent() {
        return student;
    }

    public int getGrade() {
        return grade;
    }

    public void setCourse(Course course) {
        this.course = course;
    }

    public void setStudent(Student student) {
        this.student = student;
    }

    public void setGrade(int grade) {
        this.grade = grade;
    }

}
