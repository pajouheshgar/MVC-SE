package selab.mvc.views;

import java.io.IOException;
import java.util.HashMap;
import org.json.*;
import selab.mvc.models.Model;

public class JsonView extends View {

    private JSONObject jsonObject;
    public JsonView(JSONObject jsonObject) {
        this.jsonObject = jsonObject;
    }

    @Override
    public String getBody() throws IOException {
        return this.jsonObject.toString();
    }

    @Override
    public HashMap<String, String> getResponseHeaders() {
        HashMap<String, String> headers = new HashMap<>();
        headers.put("Content-Type", "application/json");
        return headers;
    }
}
