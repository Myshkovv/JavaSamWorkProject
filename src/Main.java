
public class Main {
    public static void main(String[] args) {
        AppConfig appConfig = new AppConfig();

        System.out.println(appConfig);
        
        try {
            System.out.println("какаято генерация");
            AppConfig config = ConfigLoader.load(AppConfig.class);
            System.out.println(config);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }


    }
}