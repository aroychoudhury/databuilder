/* Copyright 2016 Roychoudhury, Abhishek */

package org.abhishek.utilities.databuilder.build.ctx;

import java.util.HashMap;
import java.util.Map;

/**
 * @author abhishek
 * @since 1.0
 */
public class BuildContext {
    private final Map<String, ValueObject<?>> values = new HashMap<String, ValueObject<?>>();

    public <T> void put(String key, T value) {
        values.put(key, new ValueObject<T>(value, value.getClass()));
    }

    @SuppressWarnings("unchecked")
    public <T> T get(String key) {
        ValueObject<T> valueObject = (ValueObject<T>) values.get(key);
        return (T) valueObject.type.cast(valueObject.value);
    }

    public boolean containsKey(String key) {
        return values.containsKey(key);
    }

    @Override
    public String toString() {
        StringBuilder builder = new StringBuilder("[");
        int cnt = 0;
        for (String key : values.keySet()) {
            builder.append((cnt != 0) ? ", " : "").append(key);
            cnt++;
        }
        return builder.append("]").toString();
    }

    class ValueObject<T> {
        T value;
        Class<? extends Object> type;

        public ValueObject(T value, Class<? extends Object> type) {
            this.value = value;
            this.type = type;
        }
    }

    public static void main(String[] args) {
        BuildContext context = new BuildContext();
        context.put("Test 1", "Test 1");
        context.put("Test 2", 2);
        context.put("Test 3", 3L);

        int test2 = context.get("Test 2");
        long test3 = context.get("Test 3");
        System.out.println(test2 + " : " + test3);
    }
}
