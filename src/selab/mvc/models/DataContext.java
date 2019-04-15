package selab.mvc.models;

import selab.mvc.models.entities.Course;
import selab.mvc.models.entities.Student;
import selab.mvc.models.entities.Weekday;

public class DataContext {
    public DataContext() {
        seed();
    }

    private DataSet<Student> students = new DataSet<>();
    private DataSet<Course> courses = new DataSet<>();

    public DataSet<Student> getStudents() { return this.students; }
    public DataSet<Course> getCourses() { return this.courses; }

    /**
     * Adding some initial data to the context
     */
    public void seed() {
        Student student1 = new Student();
        student1.setName("Ahmadreza");
        student1.setStudentNo("96209547");
        students.add(student1);

        Student student2 = new Student();
        student2.setName("Alireza");
        student2.setStudentNo("96102345");
        students.add(student2);

        Student student3 = new Student();
        student3.setName("Mina");
        student3.setStudentNo("97456789");
        students.add(student3);

        Course course1 = new Course();
        course1.setTitle("SE Lab");
        course1.setCourseNo("40444-1");
        course1.setStartTime("16:30");
        course1.setEndTime("19:00");
        course1.setWeekday(Weekday.Sunday);
        courses.add(course1);

        Course course2 = new Course();
        course2.setTitle("Advanced Programming");
        course2.setCourseNo("40466-1");
        course2.setStartTime("14:30");
        course2.setEndTime("16:30");
        course2.setWeekday(Weekday.Monday);
        courses.add(course2);
    }
}
