package Lab12;

public class Part3 {
    public static void main(String[] args) {
        char[] cArray={'a','b','a','a'};
        System.out.println("Finding the # of a specific character in array");
        System.out.println(count(cArray,'a'));
    }

    private static int count(char[] chars, char ch) {
        return countAux( chars, ch, chars.length - 1);
    }
    public static int countAux(char[] chars, char ch, int high) {
        if (high < 0) {
            return 0;
        } else if (chars[high] == ch) {
            return 1 + countAux(chars, ch, high - 1);
        } else {
            return countAux(chars, ch, high - 1);
        }
    }
}
