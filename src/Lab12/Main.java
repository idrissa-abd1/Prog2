package Lab12;

public class Main {
    public static void main(String[] args) {
        int[] array = {3, 4, 2, 5, 6, 1};
        printRecursive(array);
        System.out.println();
        printBackwardRecursive(array);
    }

    public static void printRecursive(int[] array){
        printArray(array, 0);
    }

    public static void printBackwardRecursive(int[] array){
        printReverse(array, array.length-1);
    }

    public static void printArray(int[] array, int i){
        if(i == array.length) return;

        System.out.print(array[i]+" ");
        printArray(array, i + 1);
    }

    public static void printReverse(int[] array, int i){
        if(i < 0) return;
        System.out.print(array[i]+" ");
        printReverse(array, i - 1);
    }
}
