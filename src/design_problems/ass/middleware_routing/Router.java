package design_problems.ass.middleware_routing;

import java.util.HashMap;
import java.util.Map;

public class Router implements IRouter{
    private final Map<String, String> routes;

    public Router() {
        this.routes = new HashMap<>();
    }

    @Override
    public void register(String path, String handler) {
        if (path == null || path.isEmpty() || handler == null || handler.isEmpty()) {
            throw new IllegalArgumentException("Path and handler must be non-empty");
        }
        if (routes.containsKey(path)) {
            System.out.println("[WARN] Overwriting existing route for path: " + path);
        }
        routes.put(path, handler);
    }

    @Override
    public String resolve(String path) {
        return routes.getOrDefault(path, "404 Not Found");
    }

}
