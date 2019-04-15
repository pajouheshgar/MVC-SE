package selab.mvc.controllers.courses;

import org.json.JSONObject;
import selab.mvc.controllers.Controller;
import selab.mvc.models.DataContext;
import selab.mvc.models.DataSet;
import selab.mvc.models.entities.Course;
import selab.mvc.models.entities.Weekday;
import selab.mvc.views.JsonView;
import selab.mvc.views.View;

import java.io.IOException;
import java.io.InputStream;
import java.util.HashMap;
import java.util.Map;

public class AddCourseController extends Controller {

    DataSet<Course> courses;
    public AddCourseController(DataContext dataContext) {
        super(dataContext);
        courses = dataContext.getCourses();
    }

    @Override
    public View exec(String method, InputStream body) throws IOException {
        if (!method.equals("POST"))
            throw new IOException("Method not supported");

        JSONObject input = readJson(body);
        Course course = new Course();
        course.setTitle(input.getString("title"));
        course.setCourseNo(input.getString("courseNo"));
        course.setStartTime(input.getString("startTime"));
        course.setEndTime(input.getString("endTime"));
        course.setWeekday(Weekday.valueOf(input.getString("weekday")));

        courses.add(course);

        Map<String, String> result = new HashMap<>();
        result.put("success", "true");
        return new JsonView(new JSONObject(result));
    }

    @Override
    protected View getExceptionView(Exception exception) {
        Map<String, String> result = new HashMap<>();
        result.put("message", exception.getMessage());
        return new JsonView(new JSONObject(result));
    }
}
