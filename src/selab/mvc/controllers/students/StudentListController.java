package selab.mvc.controllers.students;

import org.json.JSONArray;
import org.json.JSONObject;
import selab.mvc.controllers.Controller;
import selab.mvc.models.DataContext;
import selab.mvc.models.DataSet;
import selab.mvc.models.entities.Student;
import selab.mvc.views.JsonView;
import selab.mvc.views.View;

import java.io.IOException;
import java.io.InputStream;

public class StudentListController extends Controller {

    private DataSet<Student> students;
    public StudentListController(DataContext dataContext) {
        super(dataContext);
        students = dataContext.getStudents();
    }

    @Override
    public View exec(String method, InputStream body) throws IOException {
        JSONObject result = new JSONObject();
        result.put("students", new JSONArray(students.getAll()));
        return new JsonView(result);
    }
}
