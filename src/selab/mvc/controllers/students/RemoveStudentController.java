package selab.mvc.controllers.students;

import org.json.JSONObject;
import selab.mvc.controllers.Controller;
import selab.mvc.models.DataContext;
import selab.mvc.models.DataSet;
import selab.mvc.models.entities.Student;
import selab.mvc.models.entities.StudentCourse;
import selab.mvc.views.JsonView;
import selab.mvc.views.View;

import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class RemoveStudentController extends Controller {

    DataSet<Student> students;

    public RemoveStudentController(DataContext dataContext) {
        super(dataContext);
        students = dataContext.getStudents();
    }

    @Override
    public View exec(String method, InputStream body) throws IOException {
        if (!method.equals("POST"))
            throw new IOException("Method not supported");

        JSONObject input = readJson(body);
        String studentNo = input.getString("studentNo");
        // TODO: Add codes for removing the student
        ArrayList<String> keys = new ArrayList<>();
        DataSet<StudentCourse> studentCourses = DataContext.getStudentCourses();
        for (StudentCourse sc : studentCourses.getAll()) {
            if (sc.getStudent().getPrimaryKey().equals(studentNo)) {
                keys.add(sc.getPrimaryKey());
            }
        }
        for (String s : keys) {
            DataContext.getStudentCourses().remove(s);
        }
        DataContext.getStudents().remove(studentNo);

        return new JsonView(new JSONObject());
    }

    @Override
    protected View getExceptionView(Exception exception) {
        Map<String, String> result = new HashMap<>();
        result.put("message", exception.getMessage());
        return new JsonView(new JSONObject(result));
    }
}
