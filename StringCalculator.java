import java.util.Scanner;

class StringCalculator{
	private static Scanner scanner = new Scanner(System.in);
	
	public int Add(String input){
		if(input.equals(" ")|| input.equals("")){
			System.out.print("No input found.");
		}
		String[] numbers = extractNumbers(input);
		
		return sum(numbers);
	}
	
	private static String[] extractNumbers(String input){
		String delimiter = ",";
		return input.replaceAll("\n", ",").replaceAll(",,", delimiter).split(delimiter);
	}
	
	private static int sum(String[] numbers){
		int sum=0;
		for(String eachNumber : numbers){
			sum += Integer.parseInt(eachNumber);
		}

		System.out.print("\nSum: "+sum);
		return sum;
	}
	
	public static void main(String args[]){
		StringCalculator strCalc = new StringCalculator();
		System.out.print("\nEnter String: ");
		String input=scanner.nextLine();
		System.out.print("\nInput: "+input);		
		strCalc.Add(input);
	}
}