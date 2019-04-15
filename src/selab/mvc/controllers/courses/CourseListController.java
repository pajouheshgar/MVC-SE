package selab.mvc.controllers.courses;

import org.json.JSONArray;
import org.json.JSONObject;
import selab.mvc.controllers.Controller;
import selab.mvc.models.DataContext;
import selab.mvc.models.DataSet;
import selab.mvc.models.entities.Course;
import selab.mvc.views.JsonView;
import selab.mvc.views.View;

import java.io.IOException;
import java.io.InputStream;

public class CourseListController extends Controller {

    private DataSet<Course> courses;
    public CourseListController(DataContext dataContext) {
        super(dataContext);
        courses = dataContext.getCourses();
    }

    @Override
    public View exec(String method, InputStream body) throws IOException {
        JSONObject result = new JSONObject();
        result.put("courses", new JSONArray(courses.getAll()));
        return new JsonView(result);
    }
}
