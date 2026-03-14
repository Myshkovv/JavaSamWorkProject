
public class Main {

    static Operation operation = (x, y) -> x.concat(y);
    static Operation operation2 = (x, y) -> x.concat(y);

    public static void main(String[] args) {

        Operation operation2 = (x, y) -> x.concat(y);

        printer("Hello", "World", operation);
        printer("Hello", "World", operation2);
        printer("Hello", "World", (x, y) -> x.concat(y));
        printer("Hello", "World", new SomeClass()::tipaPrint);

        OperationT<Integer> intOperation = Integer::sum;

        System.out.println(intOperation.operation(10, 20));

        example(intOperation.operation(10, 20), (x, y)->x/y, 10, 7);




    }

    static void printer(String str1, String str2, Operation oper){
        System.out.println(oper.print(str1, str2));
    }

    static void example(int a, OperationT<Integer> oper, int x, int y){

        System.out.println(a*oper.operation(x, y));
    }

    

}