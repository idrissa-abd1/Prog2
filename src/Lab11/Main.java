package Lab11;

public class Main {
    public static void main(String[] args) {
//        System.out.println(fibonacci(5));
//        System.out.println(factorial(5));

        System.out.println(ackermann(3,13));
    }

    public static int fibonacci(int number) {
        if(number == 1){
            return 1;
        } else if (number == 0) {
            return 0;
        }
        return fibonacci(number - 1) + fibonacci(number - 2);
    }

    //part3
    public static long factorial(long n) {
        int i = 0;
        if (n == 0) {
            return 1;
        } else {
            return n * factorial(n - 1);
        }
    }

    public static long ackermann(long m, long n){
        if(m == 0){
            return n+1;
        } else if (n == 0) {
            return ackermann(m - 1, 1);
        }else {
            return ackermann(m - 1, ackermann(m, n -1));
        }
    }
}
