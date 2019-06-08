

import java.util.Scanner;
public class MergeSort {

	public static void mergeSort(int[] input){
		// Write your code here
      int si = 0;
      int ei = input.length - 1;
      mergeSort(input,si,ei);
		
	}
  public static void mergeSort(int[] input, int si, int ei){
    int mid = (si + ei) / 2;
    //Base Case
    if(si>=ei){
      return;
    }
    
    //Function call to sort the array
    mergeSort(input, si,mid);
    mergeSort(input, mid+1,ei);
    
    //Function call to merge the array
    merge(input, si, mid, ei);
    
  }
  
  public static void merge(int[] input, int si, int mid, int ei){
//    int n = input.length; 
	int n = ei-si+1;
    int[] temp = new int[n];
    //int mid = (si+ei)/2;
      
    int i=si,j=mid+1,k=0;
    while(i<mid+1 && j<=ei){
      if(input[i] <= input[j]){
        temp[k] = input[i];
        i++;
      }else {
        temp[k] = input[j];
        j++;
      }
      k++;
    }
    //Left elements
    while(i<mid+1){
      temp[k]=input[i];
      i++;
      k++;
    }
    while(j<=ei){
      temp[k]=input[j];
      j++;
      k++;
    }
    
    //copying elements
    for(int a=si,b=0;a<=ei;a++,b++){
      input[a] = temp[b];
    }
  }
  public static int[] takeInput() {
    Scanner s = new Scanner(System.in);
    int size = s.nextInt();
    int arr[] = new int[size];
    for (int i = 0; i < size; i++) {
      arr[i] = s.nextInt();
    }
    return arr;
  }
  
  public static void printArray(int input[]) {
    for(int i = 0; i < input.length; i++) {
      System.out.print(input[i] + " ");
    }
  }
  
  public static void main(String[] args) {
    int[] input = takeInput();
    mergeSort(input);
    printArray(input);
  }
}
