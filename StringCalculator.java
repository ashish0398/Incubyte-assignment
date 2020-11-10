import sun.rmi.server.InactiveGroupException;

import java.util.*;

class StringCalculator {
    private static final Scanner scanner = new Scanner(System.in);
    private static StringBuffer stringBuffer;
    private static StringTokenizer tokens;

    public int Add(String input) throws NegativeValueException {
        String numbers = null;
        if (input.equals(" ") || input.equals("")) {
            System.out.print("No input inserted.");
            return 0;
        } else {
            try {
                numbers = extractNumbers(input);
            } catch (InvalidInputFormatException iife) {
                System.out.print(iife);
            } catch (NegativeValueException nve) {
                System.out.print(nve);
            }
        }

        return sum(numbers);
    }

    private static String extractNumbers(String input) throws InvalidInputFormatException, NegativeValueException {
        String delimiter = ",";
        if (input.endsWith("\n")) {
            System.exit(0);
        } else {
            stringBuffer = new StringBuffer(input);
            do {
                int index = stringBuffer.indexOf("\\n");
                stringBuffer.replace(index, index + 2, delimiter);
            } while (stringBuffer.indexOf("\\n") > 0);
        }
        return stringBuffer.toString();
    }

    private static int sum(String numbers) throws NegativeValueException {
        int sum = 0;
        tokens = new StringTokenizer(numbers, ",");

        while (tokens.hasMoreTokens()) {
            int num = Integer.parseInt(tokens.nextToken());
            if (num < 0) {
                throw new NegativeValueException("Negative value not allowed." + Integer.toString(num));
            } else if (num > 1000) {
                num = 0;
                sum += num;
            } else {
                sum += num;
            }
        }
        return sum;
    }


    public static void main(String args[]) throws NegativeValueException {
        StringCalculator strCalc = new StringCalculator();
        System.out.print("\nEnter String: ");
        String input = scanner.nextLine();
        int sum = strCalc.Add(input);
        System.out.print("\nSum: " + sum);
    }
}