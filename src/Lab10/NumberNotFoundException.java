package Lab10;

public class NumberNotFoundException extends Exception{
    public NumberNotFoundException(){
        super("Number not found in array");
    }

    public NumberNotFoundException(String msg){
        super(msg);
    }
}
