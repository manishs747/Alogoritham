package design_problems.ass.middleware_routing.wildcard;

import java.util.HashMap;
import java.util.Map;

public class RouteNode {
    Map<String, RouteNode> staticChildren = new HashMap<>();
    RouteNode wildcardChild = null;   // for *
    String handler = null;
    boolean hasHandler() { return handler != null; }
}
