package design_problems.ass.middleware_routing;

import design_problems.ass.middleware_routing.path_paramter.RouteResult;

import java.util.List;

public class HardcodedRouter {
    public RouteResult callRoute(String path) {
        switch (path) {
            case "/foo/123":
                return new RouteResult("fooHandler", List.of("123"));
            case "/bar":
                return new RouteResult("barHandler", List.of());
            default:
                return new RouteResult("404 Not Found", List.of());
        }
    }
}
