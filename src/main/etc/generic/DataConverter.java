package main.etc.generic;

import java.util.Map;

@FunctionalInterface
public interface DataConverter<T> {
    T toModel(Map map);
}
