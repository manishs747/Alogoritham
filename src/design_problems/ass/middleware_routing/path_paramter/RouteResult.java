package design_problems.ass.middleware_routing.path_paramter;

import java.util.List;

public class RouteResult {
    String handler;
    List<String> params;

    public RouteResult(String handler, List<String> params) {
        this.handler = handler;
        this.params = params;
    }

    @Override
    public String toString() {
        return "(" + handler + ", " + params + ")";
    }
}
