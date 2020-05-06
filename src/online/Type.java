package online;

import java.util.Collections;
import java.util.HashSet;
import java.util.Set;

public enum Type {

    DRAFT,PUBLISHED,ARCHIVED,UNPUBLISHED;

    private static Set<String> states;

    static {
        states = new HashSet<>();
        for (Type value : values()) {
            states.add(value.name());
        }
        states = Collections.unmodifiableSet(states);
    }

    public static Set<String> getStates(){
        return states;
    }
}
