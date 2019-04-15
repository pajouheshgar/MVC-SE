package selab.mvc.models.entities;

import selab.mvc.models.DataContext;
import selab.mvc.models.DataSet;
import selab.mvc.models.Model;

import java.util.regex.Pattern;

public class Student implements Model {
    private String name;
    private String studentNo;

    @Override
    public String getPrimaryKey() {
        return this.studentNo;
    }

    public void setName(String value) { this.name = value; }
    public String getName() { return this.name; }

    public void setStudentNo(String value) {
        if (!validateStudentNo(value))
            throw new IllegalArgumentException("The format is not correct");

        this.studentNo = value;
    }
    public String getStudentNo() { return this.studentNo; }

    public float getAverage() {
        // TODO: Calculate and return the average of the points
        DataSet<StudentCourse> studentCourses = DataContext.getStudentCourses();
        int count= 0;
        float avg = 0.0f;
//        for (StudentCourse sc: studentCourses.getAll()){
//            if()
//        }
        return 0;
    }

    public String getCourses() {
        // TODO: Return a comma separated list of course names
        DataSet<StudentCourse> studentCourses = DataContext.getStudentCourses();
        String courses = "- ";
        for (StudentCourse sc: studentCourses.getAll()){
            if(sc.getStudent().getPrimaryKey().equals(this.getPrimaryKey())){
                courses += sc.getCourse().getTitle();
                courses += " -";
            }
        }
        return courses;
    }

    /**
     *
     * @param studentNo Student number to be checeked
     * @return true, if the format of the student number is correct
     */
    private boolean validateStudentNo(String studentNo) {
        Pattern pattern = Pattern.compile("^[8-9]\\d{7}$");
        return pattern.matcher(studentNo).find();
    }
}
