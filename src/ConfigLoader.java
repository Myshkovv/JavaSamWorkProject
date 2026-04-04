import java.lang.reflect.Field;

public class ConfigLoader  {

    public static <T> T load(Class<T> clazz) throws Exception {

        T instance = clazz.getDeclaredConstructor().newInstance();

        for (Field field : clazz.getDeclaredFields()){
            field.setAccessible(true);
            if (field.isAnnotationPresent(DefaultValue.class)){
                String defaultValue = field.getAnnotation(DefaultValue.class).value();
                if (field.getType() == String.class){
                    field.set(instance, defaultValue);
                } else if (field.getType() == int.class){
                    field.set(instance, Integer.parseInt(defaultValue));
                }
            }

            if (field.isAnnotationPresent(MaxValue.class)){
                int max = field.getAnnotation(MaxValue.class).value();
                int current = (int) field.get(instance);
                if (current>max){
                    throw new IllegalArgumentException();
                }
            }
        }
        return instance;
    }

}
