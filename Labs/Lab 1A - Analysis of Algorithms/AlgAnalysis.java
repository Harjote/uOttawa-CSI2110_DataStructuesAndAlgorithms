import java.util.*;
public class AlgAnalysis {

 /**
  * Tests runtimes of Arrays.sort()
  * Runs experiments to find the average time taken to sort arrays of n elements
  * prints results directly
  *
  * @param  maxSize size of largest array to be tested
  * @param  count number of arrays tested.
  */
 public static void arraySortRuntime(int count, int maxSize){
  int interval = maxSize/count;
  if (interval==0) interval=1;
  for(int i = interval; i <= maxSize; i+=interval){
   long res = 0;
   for(int j =0; j<10; j++){
    int[] test = randomizeArray(genArray(i));
    long start = System.nanoTime();
    Arrays.sort(test);
    long end = System.nanoTime();
    long time = end - start;
    if(res < time) res = time;
   }
   
   double nSqr= ((double)res/(double)(i*i));
   double nLog = (double)res/((double)i*(Math.log(i)/Math.log(2)));
   System.out.println("N: "+i+", T(n): "+res+" nanosecs, T(n)/(n*n): "+nSqr+", T(n)/(nlogn): "+nLog);
  }
 }
 
 /**
  * creates an array of size n, then tests the runtime of findDups1 using that array
  *
  * @param  n size of array
  * @return time taken in nano seconds
  */
 public static long unique1Runtime(int n){
  int[] test = randomizeArray(genArray(n));
  long start = System.nanoTime();
  Unique1.unique1(test);
  long end = System.nanoTime();
  return end - start;
 }
 
 /**
  * creates an array of size n, then tests the runtime of findDups2 using that array
  *
  * @param  n size of array
  * @return time taken in nano seconds
  */
 public static long unique2Runtime(int n){
  int[] test = randomizeArray(genArray(n));
  long start = System.nanoTime();
  Unique2.unique2(test);
  long end = System.nanoTime();
  return end - start;
 }
 
 /**
  * Generates an array of ins of size n
  * Array contains values array[i]=i
  *
  * @param  n size of array
  * @return ordered array
  */
 private static int[] genArray(int n){
  int[] ret = new int[n];
  for(int i=0; i < ret.length; i++){
   ret[i] = i;
  }
  return ret;
 }
 
 /**
  * Randomly shuffles an array
  *
  * @param  array array of ints to be shuffled
  * @return      randomized array
  */
 private static int[] randomizeArray(int[] array){
  Random rng = new Random();    
 
  for (int i=array.length -1; i > 0; i--) {
   //rng.nextInt(N) returns random number between 0 and N-1 inclusive
   int randomPosition = rng.nextInt(i);
      int temp = array[i];
      array[i] = array[randomPosition];
      array[randomPosition] = temp;
  }
 
  return array;
 } 
 
 /**
  * Convert time in nanoseconds to seconds
  *
  * @param  time time in nanoseconds
  * @return      time in seconds as a double
  */
 private static double nanoToSeconds(long time){
  return (double)time / 1000000000.0;
 }

 /**
  * Main method
  * Provides prompts for all experiments
  */
 public static void main(String[] args){
  Scanner scanner = new Scanner(System.in);
  while(true){
   System.out.println("Enter 0 to test Arrays.sort(), 1 for unique, any other number to exit");
   int opt1 = scanner.nextInt();
   if(opt1 == 0){
    System.out.println("Enter number of arrays to test");
    int count = scanner.nextInt();
    System.out.println("Enter largest array size");
    int n = scanner.nextInt();
    AlgAnalysis.arraySortRuntime(count, n);   
    System.out.println();
   }
   else if(opt1 == 1){
    while(true){
     System.out.println("Enter 1 to test unique1, 2 for unique2, any other number to exit");
     int opt2 = scanner.nextInt();
     if(opt2 == 1){
      System.out.println("Enter n value");
      int n = scanner.nextInt();
      System.out.println("Time Elapsed: "+AlgAnalysis.nanoToSeconds(AlgAnalysis.unique1Runtime(n))+" secs");
      System.out.println();
     }
     else if(opt2 == 2){
      System.out.println("Enter n value");
      int n = scanner.nextInt();
      System.out.println("Time Elapsed: "+AlgAnalysis.nanoToSeconds(AlgAnalysis.unique2Runtime(n))+" secs");
      System.out.println();
     }
     else{
      System.out.println("End of Program!");
      return;
     }
    }
   }
   else {
    System.out.println("End of Program!");
    return;
   }
   
  }
 }

}