package Lab9;

import java.util.Arrays;
import java.util.Random;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int N = 0;
        while (true) {
            try {
                System.out.print("Enter the value for N: ");
                N = in.nextInt();
                if (N <= 0) {
                    throw new IllegalArgumentException("N must be positive.");
                }
                break;
            } catch (Exception e) {
                System.out.println(e.getMessage());
                in.nextLine();
            }
        }

        int sum = 0;
        for (int i = 0; i < N; i++) {
            while (true) {
                try {
                    System.out.print("Enter number " + (i+1) + ": ");
                    int number = in.nextInt();
                    sum += number;
                    break;
                } catch (Exception e) {
                    System.out.println("Invalid input. Please enter a number.");
                    in.nextLine();
                }
            }
        }
        double average = (double) sum/N;
        System.out.printf("the sum = %d and the average = %f",sum,average);

        sum();
        int[] arr = new int[10];
        random(arr);
    }

    public static void sum(){
        Scanner in = new Scanner(System.in);
        int sum = 0;
        while(true) {
            try {
                System.out.print("Enter n1: ");
                int n1 = in.nextInt();
                System.out.print("Enter n2: ");
                int n2 = in.nextInt();
                sum = n1 + n2;
                break;
            }
            catch(Exception e){
                System.out.println(e.getMessage());
                in.nextLine();
            }
        }
        System.out.println("sum = "+sum);
    }

    public static void random(int[] arr){
        Scanner in = new Scanner(System.in);
        Random random = new Random();
        for(int i = 0; i < arr.length; i++){
            arr[i] = random.nextInt(100);
        }
        System.out.println(Arrays.toString(arr));

        int n = 0;
            try {
                System.out.print("Enter n: ");
                n = in.nextInt();
                if(n >= arr.length || n < 0){
                    throw new ArrayIndexOutOfBoundsException("Out of Bounds");
                }
                System.out.println("the element value is : "+arr[n]);
            }catch (Exception e){
                System.out.println(e.getMessage());
            }
    }
}
