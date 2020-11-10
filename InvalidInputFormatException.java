//Creating Custom Exception to handle the exception.
class InvalidInputFormatException extends Exception{
    private static String str;
    InvalidInputFormatException(String str){
       this.str=str;
    }
}