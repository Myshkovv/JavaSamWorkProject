import java.lang.reflect.Field;

public class ConfigLoader  {

    public static <T> T load(Class<T> clazz) throws Exception {

        T instance = clazz.getDeclaredConstructor().newInstance();

        for (Field field : clazz.getDeclaredFields()){
            field.setAccessible(true);

            if (field.isAnnotationPresent(DefaultValue.class)) {
                String rawValue = field.getAnnotation(DefaultValue.class).value();
                Object convertedValue = convertStringToObject(rawValue, field.getType());
                field.set(instance, convertedValue);
            }

            if (field.isAnnotationPresent(MaxValue.class)){
                int max = field.getAnnotation(MaxValue.class).value();
                Number current = (Number) field.get(instance);

                if (current != null && current.doubleValue() > max) {
                    throw new IllegalArgumentException("поле " + field.getName() + " превысило вот этот максимум " + max);
                }
            }
        }
        return instance;
    }

    private static Object convertStringToObject(String value, Class<?> type) {
        if (type == String.class) return value;
        if (type == int.class || type == Integer.class) return Integer.parseInt(value);
        if (type == double.class || type == Double.class) return Double.parseDouble(value);
        if (type == boolean.class || type == Boolean.class) return Boolean.parseBoolean(value);
        if (type == long.class || type == Long.class) return Long.parseLong(value);

        throw new UnsupportedOperationException("тип " + type.getSimpleName() + " пока не поддерживается");
    }
}
