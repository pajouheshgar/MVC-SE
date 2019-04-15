package selab.mvc.controllers;

import com.sun.net.httpserver.Headers;
import com.sun.net.httpserver.HttpExchange;
import com.sun.net.httpserver.HttpHandler;
import org.json.JSONObject;
import selab.mvc.models.DataContext;
import selab.mvc.views.PlainView;
import selab.mvc.views.View;

import java.io.*;
import java.util.HashMap;
import java.util.stream.Collectors;

public abstract class Controller implements HttpHandler {
    protected DataContext dataContext;

    public Controller(DataContext dataContext) { this.dataContext = dataContext; }

    @Override
    public void handle(HttpExchange httpExchange) throws IOException {
        String response;
        byte[] responseBytes;
        try {
            View responseView = exec(httpExchange.getRequestMethod(), httpExchange.getRequestBody());
            response = responseView.getBody();
            responseBytes = response.getBytes("UTF-8");
            Headers httpHeaders = httpExchange.getResponseHeaders();
            HashMap<String, String> headers = responseView.getResponseHeaders();
            for (String key: headers.keySet()) {
                httpHeaders.add(key, headers.get(key));
            }
            httpExchange.sendResponseHeaders(200, responseBytes.length);
        } catch (Exception ex) {
            response = getExceptionView(ex).getBody();
            responseBytes = response.getBytes("UTF-8");
            httpExchange.sendResponseHeaders(500, responseBytes.length);
        }
        OutputStream os = httpExchange.getResponseBody();
        os.write(responseBytes);
        os.close();
    }

    protected View getExceptionView(Exception exception) {
        return new PlainView(exception.getMessage());
    }

    protected JSONObject readJson(InputStream body) {
        return new JSONObject(new BufferedReader(new InputStreamReader(body)).lines().collect(Collectors.joining("\n")));
    }

    public abstract View exec(String method, InputStream body) throws IOException;
}
