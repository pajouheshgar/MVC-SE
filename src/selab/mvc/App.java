package selab.mvc;

import com.sun.net.httpserver.HttpServer;
import selab.mvc.controllers.Controller;

import java.net.InetSocketAddress;

public class App {
    private HttpServer server;

    public App(int port) throws Exception {
        this.server = HttpServer.create(new InetSocketAddress(port), 0);
        this.server.setExecutor(null);
    }

    public void start() {
        this.server.start();
    }

    public void addController(String route, Controller controller) {
        this.server.createContext(route, controller);
    }
}
