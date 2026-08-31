package design_problems.ass.middleware_routing.path_paramter;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Router {

    private final RouteNode root = new RouteNode();

    public void addRoute(String path, String handler) {
        String [] parts = path.split("/");
        RouteNode cur =  root;

        for (String part : parts) {
            if (part.isEmpty()) continue;

            if (part.equals("*")) {
                if (cur.wildcardChild == null) {
                    cur.wildcardChild = new RouteNode();
                }
                cur = cur.wildcardChild;
            } else if (part.startsWith("{") && part.endsWith("}")) {
                if (cur.paramChild == null) {
                    cur.paramChild = new RouteNode();
                    cur.paramKey = part.substring(1, part.length() - 1);
                }
                cur = cur.paramChild;
            } else {
                cur.staticChildren.putIfAbsent(part, new RouteNode());
                cur = cur.staticChildren.get(part);
            }
        }

        // ✅ assign handler only at the end of the path
        cur.handler = handler;
    }


    public RouteResult callRoute(String path) {
        String[] parts = path.split("/");
        return resolveHelper(root, parts, 0, new ArrayList<>());
    }

    private RouteResult resolveHelper(RouteNode node, String[] parts, int index, List<String> params) {
        if(index == parts.length){
            if(node.handler != null){
                return new RouteResult(node.handler, params);
            }
            return new RouteResult("404 Not Found", Collections.emptyList());
        }
        // check for empty
        String part = parts[index];
        if (part.isEmpty()) return resolveHelper(node, parts, index + 1, params);

        // 1. Static match
        // dont return if found ,check in other pattern
        if (node.staticChildren.containsKey(part)) {
            RouteResult res = resolveHelper(node.staticChildren.get(part), parts, index + 1, new ArrayList<>(params));
            if (!res.handler.equals("404 Not Found")) return res;
        }


        // 2. Param match
        if (node.paramChild != null) {
            List<String> newParams = new ArrayList<>(params);
            newParams.add(node.paramKey+"="+ part);
            RouteResult res = resolveHelper(node.paramChild, parts, index + 1, newParams);
            if (!res.handler.equals("404 Not Found")) return res;
        }

        // 3. Wildcard match
        if (node.wildcardChild != null) {
            return resolveHelper(node.wildcardChild, parts, index + 1, params);
        }

        return new RouteResult("404 Not Found", Collections.emptyList());

    }

    public static void main(String[] args) {
        Router router = new Router();
        router.addRoute("/foo/{id}", "fooHandler");
        router.addRoute("/bar", "barHandler");
        router.addRoute("/bar/*/baz", "barWildcard");

        System.out.println(router.callRoute("/foo/123"));      // (fooHandler, [123])
        System.out.println(router.callRoute("/bar"));          // (barHandler, [])
        System.out.println(router.callRoute("/bar/xyz/baz"));  // (barWildcard, [])
        System.out.println(router.callRoute("/unknown"));      // (404 Not Found, [])
    }



}
