package selab.mvc.views;

import selab.mvc.models.DataContext;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.HashMap;

public class StaticHtmlView extends View {

    private String filePath;

    public StaticHtmlView(String filePath) {
        this.filePath = filePath;
    }

    @Override
    public String getBody() throws IOException {
        File file = new File(this.filePath);

        BufferedReader br = new BufferedReader(new FileReader(file));

        String content = "";
        String st;
        while ((st = br.readLine()) != null)
            content = content.concat(st).concat("\n");

        return content;
    }

    @Override
    public HashMap<String, String> getResponseHeaders() {
        HashMap<String, String> headers = new HashMap<>();
        headers.put("Content-Type", "text/html");
        return headers;
    }
}
