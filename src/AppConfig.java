import java.io.Serializable;

public class AppConfig implements Serializable {
    @DefaultValue("My app")
    private String name;
    @DefaultValue(value = "8000")
    @MaxValue(9000)
    private int part;
    @DefaultValue("4")
    @MaxValue(5)
    private int threads;


    @Override
    public String toString() {
        return "AppConfig{" +
                "name='" + name + '\'' +
                ", part=" + part +
                ", threads=" + threads +
                '}';
    }
}
