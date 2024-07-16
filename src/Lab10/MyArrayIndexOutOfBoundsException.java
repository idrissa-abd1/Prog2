package Lab10;

public class MyArrayIndexOutOfBoundsException extends Exception{
    public MyArrayIndexOutOfBoundsException(){
        super("That index does not exist");
    }
    public MyArrayIndexOutOfBoundsException(String msg){
        super(msg);
    }

    public MyArrayIndexOutOfBoundsException(int index){
        super("Index "+index+" does not exist");
    }
}
