import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        int n = scanner.nextInt();
        int x = scanner.nextInt();
        int k = scanner.nextInt();

        int counter = 0;

        boolean[] array = new boolean[1000000000];

        for (int i = 0; i<n; i++) {
            int number = scanner.nextInt();
            array[number-1] = true;
        }

        int index = 0;

        while (counter!=k){
            if (array[index]){
                array[index+x] = true;
                counter++;
            }
            index++;
        }

        System.out.println(index);


    }
}