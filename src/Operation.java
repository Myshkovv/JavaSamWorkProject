@FunctionalInterface
public interface Operation {

    public String print(String str1, String str2);

    default void message(){
        System.out.println("всем привет");
    }

}
