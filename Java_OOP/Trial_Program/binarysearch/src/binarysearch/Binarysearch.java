/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package binarysearch;
import java.io.*;
import java.*;
import java.util.Arrays;
/**
 *
 * @author charvik.pc
 */
public class Binarysearch {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws IOException {
       int i; 
       InputStreamReader x=new InputStreamReader(System.in); 
       BufferedReader y=new BufferedReader(x); 
       int a[]=new int[10]; 
       System.out.println("ENTER THE NUMBER TO BE SEARCHED"); 
       int n=Integer.parseInt(y.readLine()); 
       System.out.println("ENTER 10 NUMBERS FOR THE ARRAY"); 
       
       for(i=0;i<10;i++) 
       { 
         a[i]=Integer.parseInt(y.readLine()); 
       } 
       System.out.println("CONTENTS OF ARRAY ARE"); 
       for(i=0;i<10;i++) 
       { 
         System.out.println(a[i]); 
       } 
       System.out.println("NUMBER TO BE SEARCHED IS "+n); 
       int p=-1,mid,l=0,u=9; 
       while(l<=u) 
       { 
         mid=(l+u)/2; 
         if(a[mid]==n) 
         { 
           p=mid; 
           break; 
         } 
         else if(n> a[mid]) 
         { 
           l=mid+1; 
         } 
         else if(n < a[mid]) 
         { 
           u = mid-1; 
         } 
       } 
       if(p == -1) 
       { 
         System.out.println("NUMBER DOES NOT EXIST IN THE ARRAY"); 
       } 
       else 
       { 
         System.out.println("NUMBER EXISTS AT THE INDEX "+p); 
       }
       
       
       
       
       
       System.out.println("");
       System.out.println("");
       System.out.println("");
       System.out.println("");
       System.out.println("");
       System.out.println("the following program is of binary search of float value ");
       
       	float floatArray[] = {1.23f,2.10f,4.74f,5.34f}; 
       
       /* 
       To perform binary search on float array use 
       int binarySearch(float[] b, float value) of Arrays class. This method searches 
       the float array for specified float value using binary search algorithm. 
       
       Please note that the float array MUST BE SORTED before it can be searched 
       using binarySearch method. 
       
       This method returns the index of the value to be searched, if found in the 
       array. 
       Otherwise it returns (- (X) - 1) 
       where X is the index where the the search value would be inserted. 
       i.e. index of first element that is grater than the search value 
       or array.length, if all elements of an array are less than the 
       search value. 
       */ 
       
       //sort float array using Arrays.sort method 
       Arrays.sort(floatArray); 
       
       //value to search 
       float searchValue = 4.74f; 
       
       //since 4.74 is present in float array, index of it would be returned 
       int intResult = Arrays.binarySearch(floatArray,searchValue); 
       System.out.println("Result of binary search of 4.74 is : " + intResult); 
       
       //lets search something which is not in float array ! 
       searchValue = 3.33f; 
       intResult = Arrays.binarySearch(floatArray,searchValue); 
       System.out.println("Result of binary search of 3.33 is : " + intResult); 
       
       
       
       //bubble sorting
       System.out.println("");
       System.out.println("");
       System.out.println("");
       System.out.println("");
       System.out.println("following program is if bubble sorting ");
       //create an int array we want to sort using bubble sort algorithm 
       int intArray[] = new int[]{5,90,35,45,150,3}; 
       //print array before sorting using bubble sort algorithm 
       System.out.println("Array Before Bubble Sort"); 
       for(int k=0; i < intArray.length; k++) 
       { 
         System.out.print(intArray[k] + " "); 
       } 
       //sort an array using bubble sort algorithm 
        bubbleSort(intArray); 
       System.out.println(""); 
       //print array after sorting using bubble sort algorithm 
       System.out.println("Array After Bubble Sort"); 
       for(int k=0; k < intArray.length; k++) 
       { 
         System.out.print(intArray[k] + " "); 
       } 
     } 
     private static void bubbleSort(int[] intArray) 
     { 
       int n = intArray.length; 
       int temp = 0; 
       for(int k=0; k < n; k++) 
       { 
          for(int j=1; j < (n-k); j++) 
          { 
            if(intArray[j-1] > intArray[j]) 
            { 
              //swap the elements! 
               temp = intArray[j-1]; 
              intArray[j-1] = intArray[j]; 
              intArray[j] = temp; 
            } 
          } 
       } 
     } 
   } 
   
    
        // TODO code application logic here
    

