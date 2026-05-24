import java.io.*;
import java.lang.annotation.*;
import java.lang.reflect.Field;

@Target(ElementType.FIELD )
@Retention(RetentionPolicy.RUNTIME)
public @interface DefaultValue {
    String value();
}
