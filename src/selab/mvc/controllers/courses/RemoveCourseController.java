package selab.mvc.controllers.courses;

import org.json.JSONObject;
import selab.mvc.controllers.Controller;
import selab.mvc.models.DataContext;
import selab.mvc.models.DataSet;
import selab.mvc.models.entities.Course;
import selab.mvc.models.entities.Student;
import selab.mvc.models.entities.StudentCourse;
import selab.mvc.views.JsonView;
import selab.mvc.views.View;

import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class RemoveCourseController extends Controller {

    DataSet<Course> courses;

    public RemoveCourseController(DataContext dataContext) {
        super(dataContext);
        courses = dataContext.getCourses();
    }

    @Override
    public View exec(String method, InputStream body) throws IOException {
        if (!method.equals("POST"))
            throw new IOException("Method not supported");

        JSONObject input = readJson(body);
        String courseNo = input.getString("courseNo");

        // TODO: Add codes for removing the course

        ArrayList<String> keys = new ArrayList<>();
        DataSet<StudentCourse> studentCourses = DataContext.getStudentCourses();
        for (StudentCourse sc : studentCourses.getAll()) {
            if (sc.getCourse().getPrimaryKey().equals(courseNo)) {
                keys.add(sc.getPrimaryKey());
            }
        }
        for (String s : keys) {
            DataContext.getStudentCourses().remove(s);
        }
        DataContext.getCourses().remove(courseNo);

        return new JsonView(new JSONObject());
    }

    @Override
    protected View getExceptionView(Exception exception) {
        Map<String, String> result = new HashMap<>();
        result.put("message", exception.getMessage());
        return new JsonView(new JSONObject(result));
    }
}
