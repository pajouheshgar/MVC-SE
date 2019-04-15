package selab.mvc.views;

import java.io.IOException;
import java.util.HashMap;

public class PlainView extends View {

    private String body;
    public PlainView(String body) {
        this.body = body;
    }

    @Override
    public String getBody() throws IOException {
        return this.body;
    }

    @Override
    public HashMap<String, String> getResponseHeaders() {
        HashMap<String, String> headers = new HashMap<>();
        headers.put("Content-Type", "text/plain");
        return headers;
    }
}
