import java.util.Scanner;
import java.util.*;

class StringCalculator{
	private static Scanner scanner = new Scanner(System.in);
	private static StringBuffer stringBuffer;
	private static StringTokenizer tokens;
	
	public int Add(String input){
		if(input.equals(" ")|| input.equals("")){
			System.out.print("No input found.");
		}
		String numbers = extractNumbers(input);
		
		return sum(numbers);
	}
	
	private static String extractNumbers(String input){
		String delimiter = ",";
		if(input.endsWith("n")){
			System.out.print("\nInvalid Input.");
			System.exit(0);
		}
		stringBuffer = new StringBuffer(input);
		do{
			int index = stringBuffer.indexOf("\\n");
			stringBuffer.replace(index,index+2,delimiter);
		}while(stringBuffer.indexOf("\\n")>0);
		return stringBuffer.toString();
	}

	private static int sum(String numbers){
		int sum=0;
		tokens=new StringTokenizer(numbers,",");
		
		while(tokens.hasMoreTokens()){
			int num = Integer.parseInt(tokens.nextToken());
			if(num > 1000) {
				num=0;
				sum += num;
			}else{
				sum += num;
			}
		}
		System.out.print("\nSum: "+sum);
		return sum;
	}
	
	public static void main(String args[]){
		StringCalculator strCalc = new StringCalculator();
		System.out.print("\nEnter String: ");
		String input=scanner.nextLine();
		strCalc.Add(input);
	}
}