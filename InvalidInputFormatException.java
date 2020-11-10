class InvalidInputFormatException extends Exception{
    private static String str;
    InvalidInputFormatException(String str){
       this.str=str;
    }
    public String toString(){
        return "Number " + str +" is less than zero";
    }
}