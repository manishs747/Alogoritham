package design_problems.ass.middleware_routing.path_paramter;

import java.util.HashMap;
import java.util.Map;

public class RouteNode {
    Map<String,RouteNode> staticChildren = new HashMap<>();
    RouteNode wildcardChild;
    String handler = null;

    //for path parameter
    RouteNode paramChild = null;
    String paramKey = null;
}
