package net.ethernaught;

import java.lang.reflect.*;
import java.util.*;

public class DebugUtil {

    private static final Set<Object> visited = Collections.newSetFromMap(new IdentityHashMap<>());

    public static String debug(Object obj) {
        visited.clear();
        return debug(obj, 0);
    }

    private static String debug(Object obj, int indent) {
        if (obj == null) return "null";

        if (visited.contains(obj)) return "<circular>";

        visited.add(obj);

        Class<?> clazz = obj.getClass();
        StringBuilder sb = new StringBuilder();

        if (Enum.class.isAssignableFrom(clazz)) {
            return ((Enum<?>) obj).name();
        }

        // Primitives, strings, enums
        if (clazz.isPrimitive() || obj instanceof String || obj instanceof Number || obj instanceof Boolean) {
            return obj.toString();
        }

        // Arrays
        if (clazz.isArray()) {
            int len = Array.getLength(obj);
            sb.append("[");
            for (int i = 0; i < len; i++) {
                Object element = Array.get(obj, i);
                sb.append(debug(element, indent + 1));
                if (i < len - 1) sb.append(", ");
            }
            sb.append("]");
            return sb.toString();
        }

        // Collections
        if (obj instanceof Collection<?>) {
            sb.append("[");
            Iterator<?> iter = ((Collection<?>) obj).iterator();
            while (iter.hasNext()) {
                sb.append(debug(iter.next(), indent + 1));
                if (iter.hasNext()) sb.append(", ");
            }
            sb.append("]");
            return sb.toString();
        }

        // Maps
        if (obj instanceof Map<?, ?> map) {
            sb.append("{");
            Iterator<? extends Map.Entry<?, ?>> iter = map.entrySet().iterator();
            while (iter.hasNext()) {
                var entry = iter.next();
                sb.append(debug(entry.getKey(), indent + 1));
                sb.append(": ");
                sb.append(debug(entry.getValue(), indent + 1));
                if (iter.hasNext()) sb.append(", ");
            }
            sb.append("}");
            return sb.toString();
        }

        // Objects / Structs
        sb.append(clazz.getSimpleName()).append(" {\n");
        for (Field field : clazz.getDeclaredFields()) {
            field.setAccessible(true);
            try {
                Object value = field.get(obj);
                sb.append("  ".repeat(indent + 1))
                        .append(field.getName())
                        .append(" = ")
                        .append(debug(value, indent + 1))
                        .append("\n");
            } catch (IllegalAccessException e) {
                sb.append("  ".repeat(indent + 1))
                        .append(field.getName())
                        .append(" = <inaccessible>\n");
            }
        }
        sb.append("  ".repeat(indent)).append("}");
        return sb.toString();
    }
}
