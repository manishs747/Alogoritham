package design_problems.ass.middleware_routing.wildcard;

public class Router {
    private final RouteNode root = new RouteNode();

    public void addRoute(String path, String handler) {
        String[] parts = path.split("/");
        RouteNode cur = root;

        for (String part : parts) {
            if (part.isEmpty()) continue;
            if (part.equals("*")) {
                if (cur.wildcardChild == null) {
                    cur.wildcardChild = new RouteNode();
                }
                cur = cur.wildcardChild;
            } else {
                cur.staticChildren.putIfAbsent(part, new RouteNode());
                cur = cur.staticChildren.get(part);
            }
        }
        cur.handler = handler;
    }

    public String resolve(String path) {
        String[] parts = path.split("/");
        return resolveHelper(root, parts, 0);
    }

    private String resolveHelper(RouteNode node, String[] parts, int index) {
        if (index == parts.length) {
            return node.hasHandler() ? node.handler : "404 Not Found";
        }
        //empty check
        String part = parts[index];

        if (part.isEmpty()) return resolveHelper(node, parts, index + 1);

        // 1. Try static match first (priority over wildcard)
        if (node.staticChildren.containsKey(part)) {
            String result = resolveHelper(node.staticChildren.get(part), parts, index + 1);
            if (!result.equals("404 Not Found")) return result;
        }

        if(node.wildcardChild != null){
            return resolveHelper(node.wildcardChild, parts, index + 1);
        }

        return "404 Not Found";
    }


    public static void main(String[] args) {
        Router router = new Router();

        router.addRoute("/foo", "fooHandler");
        router.addRoute("/bar/*/baz", "barHandler");
        router.addRoute("/foo/*", "fooWildcard");

        System.out.println(router.resolve("/foo"));          // fooHandler
        System.out.println(router.resolve("/bar/123/baz"));  // barHandler
        System.out.println(router.resolve("/foo/test"));     // fooWildcard
        System.out.println(router.resolve("/foo/baz"));      // fooWildcard
        System.out.println(router.resolve("/unknown"));      // 404 Not Found
    }
}
