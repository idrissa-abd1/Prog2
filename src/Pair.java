public class Pair<T extends Comparable<T>> {

    private T item;
    private T number;

    public Pair(T item, T number) {
        this.item = item;
        this.number = number;
    }
    public Pair(T item) {
        this.item = item;
    }

    public T getItem() {
        return item;
    }

    public void setItem(T item) {
        this.item = item;
    }

    public T getNumber() {
        return number;
    }

    public void setNumber(T number) {
        this.number = number;
    }

    public boolean lessThan(Pair<T> other){
        return this.item.compareTo(other.item) > 0;
    }

    public static void main(String[] args) {
        Pair<String> p1 = new Pair("aaa");
        p1.setItem("bbb");
        System.out.println(p1.getItem());
        System.out.println(p1.getNumber());

        Pair<String> p2 = new Pair("ccc");
        System.out.println(p2.getItem());
        System.out.println(p2.getNumber());

        System.out.println(p1.lessThan(p2));

    }
}