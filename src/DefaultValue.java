import java.io.*;
import java.lang.annotation.*;
import java.lang.reflect.Field;

@Target(ElementType.FIELD )
public @interface DefaultValue {
    String value();
}
