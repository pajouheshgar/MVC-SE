package selab.mvc.views;

import java.io.IOException;
import java.util.HashMap;
import java.util.Hashtable;

public abstract class View {
    /*private HashMap<String, String> parameters;
    public View(HashMap<String, String> parameters) {
        this.parameters = parameters;
    }*/

    public abstract String getBody() throws IOException;
    public abstract HashMap<String, String> getResponseHeaders();
}
