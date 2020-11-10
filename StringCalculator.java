import java.util.*;

class StringCalculator {
    private static final Scanner scanner = new Scanner(System.in);

    //Creating Add method it takes input and check whether it is null or not, If it is null then displays the message.
    public int Add(String input) throws NegativeValueException {
        String numbers = null;
        if (input.equals(" ") || input.equals("")) { //Checking whether string is empty or not.
            System.out.print("No input inserted.");
            return 0;
        } else {
            try {
                numbers = extractNumbers(input);
            } catch (InvalidInputFormatException iife) {
                System.out.print(iife);
            }
        }
        return sum(numbers); //passing string to sum methods to extract number from it.
    }

    private static String extractNumbers(String input) throws InvalidInputFormatException {
        String delimiter = ","; //initiating delimiter as ","
        StringBuffer stringBuffer = new StringBuffer(input); //object created to store input
        if (input.endsWith("\\n")) { //here checking whether the string ends with \n or not, it condition satisfies then exception will be thrown
            throw new InvalidInputFormatException("Invalid Input.");
        }else{
            if((input.lastIndexOf("\\n")+2)<=input.length() && (input.lastIndexOf("\\n")>0)){
                do {
                    int index = stringBuffer.indexOf("\\n"); //it will store the index of \n
                    stringBuffer.replace(index, index + 2, delimiter); //here it is replacing \n with ,
                } while (stringBuffer.indexOf("\\n") > 0);
            }
        }

        return stringBuffer.toString(); //returning the by  converting it into string
    }

    private static int sum(String numbers) throws NegativeValueException {
        int sum = 0; // initializing sum as 0;
        StringTokenizer tokens = new StringTokenizer(numbers, ",");  //tokenizing string to iterate.

        while (tokens.hasMoreTokens()) {  // iterating token with hasMoreTokens() method
            int num = Integer.parseInt(tokens.nextToken()); //parsing tokens into integer to check.
            if (num < 0) { // here checking whether num value is < 0 to satisfy negative value exception.
                throw new NegativeValueException("Negative value not allowed " + num);
            } else if (num > 1000) { // checking if number is > 1000 or not to satisfy test case.
                num = 0; //And if it is greater than 1000 then that num will be ignored.
                sum += num; //Addition of num will be stored in sum variable.
            } else {
                sum += num;
            }
        }
        return sum; // returning sum to print the value.
    }
    // Main method to execute the program.
    public static void main(String args[]) throws NegativeValueException {
        StringCalculator strCalc = new StringCalculator(); //object of class is created to access non static method from static method.
        System.out.print("\nEnter String: ");
        String input = scanner.nextLine(); //Taking input from user.
        int sum = strCalc.Add(input); //storing returned value in sum variable.
        System.out.print("\nSum: " + sum);
    }
}