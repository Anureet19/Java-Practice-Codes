import java.util.Scanner;

//Write a program to find x to the power n (i.e. x^n). 
//Take x and n from the user. 
//Do this recursively.

public class CalculatePower {

	static Scanner s = new Scanner(System.in);

	public static int power(int x, int n) {
		
      if(n == 0){
        return 1;
      }
      int ans = x * power(x,n-1);
      return ans;
		
	}

public static void main(String[] args) {
		int x = s.nextInt();
		int n = s.nextInt();
		
		System.out.println(power(x, n));
	}
}