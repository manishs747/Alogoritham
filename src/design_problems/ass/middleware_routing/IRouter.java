package design_problems.ass.middleware_routing;

public interface IRouter {
    void register(String path, String handler);
    String resolve(String path);
}
