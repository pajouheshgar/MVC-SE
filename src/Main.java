import selab.mvc.App;
import selab.mvc.controllers.AddStudentToCourseController;
import selab.mvc.controllers.courses.AddCourseController;
import selab.mvc.controllers.courses.CourseListController;
import selab.mvc.controllers.courses.RemoveCourseController;
import selab.mvc.controllers.students.AddStudentController;
import selab.mvc.controllers.IndexController;
import selab.mvc.controllers.students.RemoveStudentController;
import selab.mvc.controllers.students.StudentListController;
import selab.mvc.models.DataContext;

public class Main {

    public static void main(String[] args) throws Exception {
        App app = new App(8001);
        DataContext dataContext = new DataContext();

        app.addController("/", new IndexController());

        // Student controllers
        app.addController("/students/list", new StudentListController(dataContext));
        app.addController("/students/add", new AddStudentController(dataContext));
        app.addController("/students/remove", new RemoveStudentController(dataContext));

        // Course controllers
        app.addController("/courses/list", new CourseListController(dataContext));
        app.addController("/courses/add", new AddCourseController(dataContext));
        app.addController("/courses/remove", new RemoveCourseController(dataContext));

        app.addController("/students/courses/add", new AddStudentToCourseController(dataContext));

        app.start();
    }
}
