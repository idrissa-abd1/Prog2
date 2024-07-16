package Lab12;

import java.util.Arrays;

public class Part2 {
    public static void main(String[] args) {
        int[] X = {3, 4, 2, 5, 6, 1};
        int[] A = computePrefixSums(X, 0, new int[X.length], 0);
        System.out.println(Arrays.toString(A));
    }

    public static int[] computePrefixSums(int[] X, int i, int[] A, int sum) {
        if (i == X.length) {
            return A;
        }
        sum += X[i];
        A[i] = sum;
        return computePrefixSums(X, i + 1, A, sum);
    }


}

