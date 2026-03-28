import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        int n = scanner.nextInt();
        int x = scanner.nextInt();
        int k = scanner.nextInt();

        int counter = 0;

        int[] array = new int[n];

        for (int i = 0; i<n; i++) {
            int number = scanner.nextInt();
            array[i] = number;
        }

        Map<Integer, Integer> goodNumbersMap = new HashMap<>();

        for (int num: array){
            int remains = num % x;

            if (goodNumbersMap.containsKey(remains)){
                if (remains < goodNumbersMap.get(remains)){
                    goodNumbersMap.put(remains, num);
                }
            }
            else {
                goodNumbersMap.put(remains, num);
            }

        }

        int[] goodNums = goodNumbersMap.values().stream().mapToInt(i -> i).toArray();

        int result1 = 0;
        int result2 = 1000000000;

        while (result1 != result2){
            int count = 0;

            for (int num : goodNums){
                count += ((result2 + result1)/2 - num) / x;
            }
            count += goodNums.length;

            if (count >= k){
                result2 -= (result2 - result1)/2;
            } else {
                result1 += (result2 - result1)/2 +1;
            }
        }

        System.out.println(result1);

    }
}