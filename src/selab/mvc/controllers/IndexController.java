package selab.mvc.controllers;

import selab.mvc.views.StaticHtmlView;
import selab.mvc.views.View;

import java.io.IOException;
import java.io.InputStream;

public class IndexController extends Controller {

    public IndexController() {
        super(null);
    }

    @Override
    public View exec(String method, InputStream body) throws IOException {
        return new StaticHtmlView("static/index.html");
    }
}
