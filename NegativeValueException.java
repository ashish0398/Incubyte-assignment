public class NegativeValueException extends Exception{
    public NegativeValueException(){
        super("Negatives not allowed.");
    }
    public NegativeValueException(String message){
        super(message);
    }
}
