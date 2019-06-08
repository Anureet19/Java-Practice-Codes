
public class QuickSort {
  
  public static void quickSort(int[] input) {
      int si = 0;
      int ei = input.length - 1;
      quickSort(input,si,ei);
  }
  
  public static void quickSort(int[] input, int si, int ei){
    //Base Case
    if(si>=ei){
      return;
    }
    int pivotpos = partition(input,si,ei);
    
    quickSort(input,si,pivotpos-1);
    quickSort(input,pivotpos+1,ei);
  }
  
  public static int partition(int[] input, int si, int ei){
    //Assuming pivot
    int pivot = input[si];
    
    //Finding pivot position
    int a = si+1;
    int count =0;
    while(a<=ei){
      if(input[a] <= pivot){
        count ++;
      }
      a++;
    }
    
    //Placing pivot
    int pivotpos = si + count  ;
    int temp = input[si];
    input[si] = input[pivotpos];
    input[pivotpos] = temp;
    
    //Ensuring the right and left elements
    int i=si, j=ei;
    while(i<=j){
      if(input[i] <= pivot){
        i++;
      }else if(input[j] > pivot){
        j--;
      }else{
        temp = input[i];
        input[i] = input[j];
        input[j] = temp;
        i++;
        j--;
      }
    } 
    
    return pivotpos;
  }

  static Scanner s = new Scanner(System.in);
  
  public static int[] takeInput(){
    int size = s.nextInt();
    int[] input = new int[size];
    for(int i = 0; i < size; i++){
      input[i] = s.nextInt();
    }
    return input;
  }
  
  public static void main(String[] args) {
    int[] input = takeInput();
    Solution.quickSort(input);
    for(int i = 0; i < input.length; i++) {
      System.out.print(input[i] + " ");
    }
  }
  
}