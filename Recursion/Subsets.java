import java.util.Scanner;
public class Subsets {

	// Return a 2D array that contains all the subsets which sum to k
	public static int[][] subsetsSumK(int input[], int k) {
      return subsetsSumK(input,k,0);
	}
  public static int[][] subsetsSumK(int input[], int k, int startIndex){
    //Base Case
    if(startIndex == input.length){
      //int ans[][] ;
      if(k==0){
        int ans[][] = new int[1][0];
        return ans;
      }
      int ans[][] = new int[0][0];
      return ans;
    }
    
    //Dividing Problem
    int[][] smallans1 = subsetsSumK(input,k-input[startIndex],startIndex+1);
    int[][] smallans2 = subsetsSumK(input,k,startIndex+1);
    int[][] ans = new int[smallans1.length + smallans2.length][];
    
    //Column memory allocation
    for(int m=0,r=0;m<smallans1.length;m++,r++){
      int colmn = smallans1[r].length + 1;
      ans[m] = new int[colmn];
    }
    for(int m=smallans1.length,r=0;m<ans.length;m++,r++){
      int colmn = smallans2[r].length;
      ans[m] = new int[colmn];
    }
    
    
    
    //Processing
    for(int i=0,j=0;i<smallans1.length;i++){
      int colmn = 0;
      ans[i][colmn] = input[startIndex];
    }
    for(int i = 0; i < smallans1.length; i++){
      for(int j=0;j<smallans1[i].length;j++){
        ans[i][j+1] = smallans1[i][j];

      }

    }
			
    for(int i = 0; i < smallans2.length; i++){
      for(int j=0;j<smallans2[i].length;j++){
        ans[i + smallans1.length][j] = smallans2[i][j];

      }
    }
    return ans;
  }
  static Scanner s = new Scanner(System.in);
  public static int[] takeInput() {
    int size = s.nextInt();
    int arr[] = new int[size];
    for (int i = 0; i < size; i++) {
      arr[i] = s.nextInt();
    }
    return arr;
  }
  
  public static void main(String[] args) {
    int[] input = takeInput();
    int k = s.nextInt();
    int output[][] = subsetsSumK(input, k);
    for(int i = 0; i < output.length; i++) {
      for(int j = 0; j < output[i].length; j++) {
        System.out.print(output[i][j] + " ");
      }
      System.out.println();
    }
  }
  
}
