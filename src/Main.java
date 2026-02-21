
public class Main {
    public static void main(String[] args) {

        for (Coffee coffee : Coffee.values()){
            System.out.println(coffee.getName() + " - " + coffee.getFeature());
        }
        System.out.println("---------------");
        for (Day day : Day.values()){
            System.out.println(day.getName() + " - " + day.getProverb());
        }

    }
}